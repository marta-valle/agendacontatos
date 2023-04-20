package br.com.cotiinformatica.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.br.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.repositories.UsuarioRepository;

@Controller
public class LoginController { // para sinalizar que é a pagina Inicial =Raiz

	@RequestMapping(value = "/") // qnd tem @ é o que chamam de anotação
	public ModelAndView login() {// pode ser o nome que quiser.
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}

	@RequestMapping(value = "/autenticar-usuario", method = RequestMethod.POST)
	public ModelAndView autenticarUsuario(HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView("login");
		try {

			// capturar o email e senha enviados pelo formulário
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");

			// consultando o usuário no banco de dados
			UsuarioRepository usuarioRepository = new UsuarioRepository();
			Usuario usuario = usuarioRepository.findByEmailAndSenha(email, senha);

			// verificar se o usuário foi encontrado
			if (usuario != null) {
				//DATA 20/0: guardar os dados do usuário em uma sessão(Apaga qnd fecha o navegador)
				request.getSession().setAttribute("usuario", usuario);

				
				// redirecionar para a página inicial da agenda
				modelAndView.setViewName("redirect:/admin/home");
			} else {
				modelAndView.addObject("mensagem_erro", "Acesso negado. Usuário não encontrado.");
			}
		} catch (Exception e) {
			modelAndView.addObject("mensagem_erro", "Falha ao autenticar: " + e.getMessage());
		}

		return modelAndView;
	}
}
