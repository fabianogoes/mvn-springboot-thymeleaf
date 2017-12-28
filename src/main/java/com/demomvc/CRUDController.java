package com.demomvc;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CRUDController {

	@Autowired
	private PessoaRepository repository;
	
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
		mv.addObject("lista", repository.findAll());
		mv.setViewName("pesquisa");
		return mv;
	}	
	
	@RequestMapping("/salvar")
	public String salvar(Pessoa pessoa){
		repository.save(pessoa);
		return "redirect:/pesquisa";
	}
	
	@RequestMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id") int id){
		ModelAndView mv = new ModelAndView();
		Pessoa pessoa = repository.findOne(id);
		mv.addObject("pessoa", pessoa);
		mv.setViewName("cadastro");
		mv.addObject("titulo", "Editar");
		return mv;
	}
	
	@RequestMapping("/deletar/{id}")
	public ModelAndView deletar(@PathVariable("id") int id){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("deletar");
		Pessoa pessoa = repository.findOne(id);
		mv.addObject("pessoa", pessoa);		
		return mv;
	}
	
	@RequestMapping("/confirmarDeletar/{id}")
	public String confirmarDeletar(@PathVariable("id") int id){
		repository.delete(id);
		return "redirect:/pesquisa";
	}
	
}
