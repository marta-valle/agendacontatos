package br.com.cotiinformatica.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.github.javafaker.Faker;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.messages.EmailMessage;
import br.com.cotiinformatica.repositories.UsuarioRepository;

@Controller
public class PasswordController {

	@RequestMapping(value = "/esqueci-minha-senha") // como será exibido no navegador.
	public ModelAndView passoword() {
		ModelAndView modelAndView = new ModelAndView("password");
		return modelAndView;

	}

	@RequestMapping(value = "/recuperar-senha", method = RequestMethod.POST)
	public ModelAndView recuperarSenha(HttpServletRequest request) {
		// web-inf/views/password.jsp
		ModelAndView modelAndView = new ModelAndView("password");
		try {
			String email = request.getParameter("email");

			UsuarioRepository usuarioRepository = new UsuarioRepository();
			Usuario usuario = usuarioRepository.findByEmail(email);

			// VERIFICAR SE O USUARIO FOI ENCONTRADO
			if (usuario != null) {
				// GERANDO UMA NOVA SENHA, VIA BIBLIOTECA FAKE INSTALADA HJ: 02/05
				Faker faker = new Faker();
				usuario.setSenha(faker.internet().password(8, 20, true, true, true));

				// ESCREVENDO UM EMAIL QUE SERÁ ENVIADO PARA O USUARIO.
				String assunto = "Recuperação de senha de acesso - Agenda Contatos";
				String mensagem = "Olá," + usuario.getNome()
						+ "\nUma nova senha foi gerada com sucesso!"
						+ "\nAcesso o sistema usando a senha:" + usuario.getSenha()
						+ "\nDepois você poderá alterar esta senha para outra de sua preferência." 
						+ "\nAtt"
						+ "\nEquipe Agenda de Contatos";
				
				// ENVIANDO O EMAIL PARA O USUARIO
				EmailMessage emailMessage = new EmailMessage();
				emailMessage.sendMessage(usuario.getEmail(), assunto, mensagem);
				
				//atualizar a senha no bd
				usuarioRepository.update(usuario);

				modelAndView.addObject("mensagem_sucesso", "Foi enviado um email, para criação de nova senha");

			} else {
				modelAndView.addObject("mensagem_erro", "Usuario não encontrado.Verifique o email informado");

			}

		} catch (Exception e) {
			modelAndView.addObject("mensagem_erro", "Falha ao recuperar senha:" + e.getLocalizedMessage());
		}

		return modelAndView;
	}
}
