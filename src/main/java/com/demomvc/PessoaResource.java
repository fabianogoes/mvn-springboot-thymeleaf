package com.demomvc;

import org.springframework.hateoas.ResourceSupport;

public class PessoaResource extends ResourceSupport {

	private String pessoaId;
	private String pessoaNome;

	public PessoaResource(String pessoaId, String pessoaNome) {
		this.pessoaId = pessoaId;
		this.pessoaNome = pessoaNome;
	}

	public PessoaResource() {
	}

	public String getPessoaId() {
		return pessoaId;
	}

	public void setPessoaId(String pessoaId) {
		this.pessoaId = pessoaId;
	}

	public String getPessoaNome() {
		return pessoaNome;
	}

	public void setPessoaNome(String pessoaNome) {
		this.pessoaNome = pessoaNome;
	}

}
