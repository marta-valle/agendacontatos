package br.com.cotiinformatica.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.cotiinformatica.entities.Contato;
import br.com.cotiinformatica.entities.Usuario;
import br.com.cotiinformatica.repositories.ContatoRepository;

@Controller
public class CadastroContatosController {
	@RequestMapping(value= "/admin/cadastro-contato")
	public ModelAndView cadastroContato() {
		ModelAndView modelAndView = new ModelAndView("admin/cadastro-contato");  
		return modelAndView;
		
	}
	@RequestMapping(value = "admin/cadastrar-contato", method = RequestMethod.POST) //nome de referencia do metodo no cadastro-contato
	public ModelAndView cadastrarContato(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView("admin/cadastro-contato"); //pagina
		
		try {
			//RESGATAR OS CAMPOS ENVIADOS PELO FORMULARIO
			Contato contato = new Contato();
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
			contato.setIdUsuario(usuario.getIdUsuario());  //REGISTRAR QUE EU QUERO O DADO DO IDUSUARIO. 12H
			
			contato.setNome(request.getParameter("nome"));
			contato.setEmail(request.getParameter("email"));
			contato.setTelefone(request.getParameter("telefone"));
			contato.setObservacoes(request.getParameter("observacoes"));
			
			//realizar o cadastro do contato no banco de dados
			
			ContatoRepository contatoRepository = new ContatoRepository();
			contatoRepository.create(contato);
			
			modelAndView.addObject("mensagem_sucesso", "Contato cadastrado com sucesso.");
		}
		catch(Exception e) {
			modelAndView.addObject("mensagem_erro", "Falha ao cadastrar contato: " + e.getMessage());
		}
		
		return modelAndView;
	}
}

