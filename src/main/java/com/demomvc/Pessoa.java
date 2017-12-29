package com.demomvc;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pessoa {

	public int getId() {
		return id;
	}

	@Id @GeneratedValue
	private int id;
	private String nome;

	public Pessoa() {
	}

	public Pessoa(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + "]";
	}

}
