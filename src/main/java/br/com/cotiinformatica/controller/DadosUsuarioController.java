package br.com.cotiinformatica.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.repositories.UsuarioRepository;

@Controller
public class DadosUsuarioController {
	@RequestMapping(value = "/admin/dados-usuario")
	public ModelAndView dadosUsuario() {
		ModelAndView modelAndView = new ModelAndView("/admin/dados-usuario");
		return modelAndView;
	}

	@RequestMapping(value = "/admin/alterar-senha", method = RequestMethod.POST)
	public ModelAndView alterarSenha(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("/admin/dados-usuario");

		try {
			// CAPTURAR O USUARIO AUTENTICADO NA SESSÃO
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");

			// CAPTURAR A SENHA QUE ESTA NA TELA
			usuario.setSenha(request.getParameter("novaSenha"));

			// ATUALIZAR O BANCO DE DADOS. INSTANCIANDO O USUARIOREPOSITORY
			UsuarioRepository usuarioRepository = new UsuarioRepository();
			usuarioRepository.update(usuario);

			modelAndView.addObject("mensagem_sucesso", "Senha atualizada com sucesso.");

		} catch (Exception e) {
			modelAndView.addObject("mensagem-erro", "Falha ao alterar senha:" + e.getMessage());
		}
		return modelAndView;
	}

}
