package br.com.cotiinformatica.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Contato;
import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.repositories.ContatoRepository;

@Controller
public class ConsultaContatosController {
	@RequestMapping (value = "/admin/consulta-contato")
	public ModelAndView consultaContatos(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("admin/consulta-contato");
		//AULA 25/04: COLOCANDO PARA A PAGINA JA INICIAR COM INFORMAÇÃO
		
		try {
			//LER OS DADOS DO USUARIO GRAVADO NA SESSAO
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
			
			//acessar o repositorio
			ContatoRepository contatoRepository = new ContatoRepository();
			List<Contato> contato = contatoRepository.findByUsuario(usuario.getIdUsuario());
			
			//enviando a lista de contatos para a pagina
			modelAndView.addObject("contatos", contato);
			
			
			
		} catch (Exception e) {
			modelAndView.addObject("mensagem_erro", "Falha ao consultar contatos:" + e.getMessage());
			// TODO: handle exception
	
		} // vai para consuulta contatos 
		
		return modelAndView;
	}
	
	

}
