package com.demomvc;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;
	
	public List<PessoaResource> getAll(){
		List<PessoaResource> resources = new ArrayList<>();
		repository.findAll().forEach(p -> {
			resources.add(this.toPessoaResource(p));
		});
		return resources;
	}

	private PessoaResource toPessoaResource(Pessoa pessoa) {
		PessoaResource pessoaResource = new PessoaResource(String.valueOf(pessoa.getId()), pessoa.getNome());
		Link selfLink = linkTo(PessoaRestController.class).slash(pessoaResource.getPessoaId()).withSelfRel();
		pessoaResource.add(selfLink);
		return pessoaResource;
	}

	public PessoaResource getOne(int id) {
		PessoaResource pessoaResource = this.toPessoaResource(repository.findOne(id));
		return pessoaResource;
	}
	
}
