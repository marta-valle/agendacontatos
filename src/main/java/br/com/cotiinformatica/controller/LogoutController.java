package br.com.cotiinformatica.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {// dia 20/04- criado

	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpServletRequest request) {
		/*
		 * pode ser qlqr nome (logout) - estudar // hhtpservletrequest:metodo de
		 * sessao/capturar dados do objet para transitar dados do navegador
		 */
		request.getSession().removeAttribute("usuario"); 
		/* para salvar(esta no LoginController setAttribute) - para
		 * excluir a sessão "removeAttribute".
		 */
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}

}
