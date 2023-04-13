package br.com.cotiinformatica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PasswordController {

	@RequestMapping(value = "esqueci-minha-senha") // como será exibido no navegador.
	public ModelAndView passoword() {
		ModelAndView modelAndView = new ModelAndView("password");
		return modelAndView;

	}

}
