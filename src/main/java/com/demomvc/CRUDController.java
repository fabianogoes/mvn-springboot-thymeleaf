package com.demomvc;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CRUDController {

	private static List<Pessoa> lista = new ArrayList<>();
	
	static{
		lista.add(new Pessoa(1, UUID.randomUUID().toString()));
		lista.add(new Pessoa(2, UUID.randomUUID().toString()));
		lista.add(new Pessoa(3, UUID.randomUUID().toString()));
		lista.add(new Pessoa(4, UUID.randomUUID().toString()));
		lista.add(new Pessoa(5, UUID.randomUUID().toString()));
	}

	@RequestMapping("/cadastro")
	public ModelAndView cadastro(){
		ModelAndView mv = new ModelAndView();
		mv.addObject("titulo", "Cadastro");
		mv.setViewName("cadastro");
		mv.addObject("pessoa", new Pessoa());
		return mv;
	}
	
	@RequestMapping("/pesquisa")
	public ModelAndView pesquisa(){
		ModelAndView mv = new ModelAndView();
		mv.addObject("titulo", "Pesquisa");
		mv.addObject("lista", lista);
		mv.setViewName("pesquisa");
		return mv;
	}	
	
	@RequestMapping("/salvar")
	public String salvar(Pessoa pessoa){
		if(pessoa.getId() == 0){
			int nextId = lista.stream()
					.mapToInt(p -> p.getId())
					.max().orElse(0) + 1;
			pessoa.setId(nextId);
			lista.add(pessoa);
		} else{
			lista.forEach(p -> {
				if(p.getId() == pessoa.getId()){
					p.setNome(pessoa.getNome());
				}
			});
		}
		return "redirect:/pesquisa";
	}
	
	@RequestMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id") int id){
		ModelAndView mv = new ModelAndView();
		Pessoa pessoa = lista.stream()
			.filter(p -> p.getId() == id)
			.findAny()
			.orElse(null);
		mv.addObject("pessoa", pessoa);
		mv.setViewName("cadastro");
		mv.addObject("titulo", "Editar");
		return mv;
	}
	
	@RequestMapping("/deletar/{id}")
	public ModelAndView deletar(@PathVariable("id") int id){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("deletar");
		Pessoa pessoa = lista.stream()
				.filter(p -> p.getId() == id)
				.findAny()
				.orElse(null);
		mv.addObject("pessoa", pessoa);		
		return mv;
	}
	
	@RequestMapping("/confirmarDeletar/{id}")
	public String confirmarDeletar(@PathVariable("id") int id){
		lista.removeIf(p -> p.getId() == id);
		return "redirect:/pesquisa";
	}
	
}
