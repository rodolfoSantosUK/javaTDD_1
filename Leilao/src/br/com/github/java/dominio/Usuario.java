package br.com.github.java.dominio;

import java.util.Objects;

public class Usuario {

	private int id;
	private String nome;
	
	public Usuario(String nome) {
		this(0, nome);
	}

	public Usuario(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}



	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Usuario usuario = (Usuario) o;
		return nome.equals(usuario.nome);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	
	
}
