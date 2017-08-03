package br.edu.evolucao.bean;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;

import java.io.Serializable;

//@Entity
//@Table(name="tb_contatos")
public class Contato implements Serializable {
	private static final long serialVersionUID = -2849560834534762075L;
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name="id")
	private Long id;
	
//	@Column(name="nome")
	private String nome;
	
//	@Column(name="email")
	private String email;
	
//	@Column(name="telefone")
	private String telefone;
	
	public Contato() {}
	
	public Contato(String nome) {
		this.nome = nome;
	}
	
	public Contato(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}
