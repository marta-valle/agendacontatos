package br.com.cotiinformatica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConsultaContatosController {
	@RequestMapping (value = "/admin/consulta-contato")
	public ModelAndView consultaContatos() {
		ModelAndView modelAndView = new ModelAndView("admin/consulta-contato");
		return modelAndView;
	}

}
