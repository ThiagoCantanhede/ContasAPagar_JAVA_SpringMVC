package br.com.caelum.contas.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.caelum.contas.dao.ContaDAO;
import br.com.caelum.contas.modelo.Conta;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

@Controller
public class ContasController {
	@RequestMapping("/form")
	public String formulario(){
		return "conta/formulario";
	}
	@RequestMapping("/adicionaConta")
	public String adiciona(@Valid Conta conta, BindingResult result){
	    
		if (result.hasFieldErrors("descricao")){
			return "conta/formulario";
		}
		ContaDAO dao = new ContaDAO();
	    dao.adiciona(conta);
	    System.out.println(conta.getDescricao());
	    return "conta/conta-adicionada";
	}	
	
	@RequestMapping("/listaconta")
	public ModelAndView lista() {
		ContaDAO dao = new ContaDAO();
		List<Conta>contas = dao.lista();
		ModelAndView mv = new ModelAndView("conta/lista");
		  mv.addObject("contas", contas);
		  return mv;
	}
	
	@RequestMapping("/removeConta")
	public String remove(Long id){   
		System.out.println(id);
		ContaDAO dao = new ContaDAO();
		Conta conta = dao.buscaPorId(id);
		dao.remove(conta);
	    return "redirect:listaconta";
	}	
	
	@RequestMapping("/pagaConta")
	public void paga(Long id, HttpServletResponse response){   
		ContaDAO dao = new ContaDAO();
		dao.paga(id);
		response.setStatus(200);
	}	
	
	

	@RequestMapping("/alteraConta")
	public String altera(Conta conta){
	    ContaDAO dao = new ContaDAO();
	    dao.altera(conta);
	    return "redirect:listaconta";
	}		
	

	@RequestMapping("/mostraConta")
	public String mostra(Long id, Model model) {
	  ContaDAO dao = new ContaDAO();
	  model.addAttribute("conta", dao.buscaPorId(id));
	  return "conta/mostra";
	}
	
	
	
}