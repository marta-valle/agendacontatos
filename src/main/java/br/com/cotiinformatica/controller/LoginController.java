package br.com.cotiinformatica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {	// para sinalizar que é a pagina Inicial =Raiz

	@RequestMapping(value = "/") // qnd tem @ é o que chamam de anotação
	public ModelAndView login() {// pode ser o nome que quiser.
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
}
