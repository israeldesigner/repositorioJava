package bean;

import java.io.Serializable;

import enums.Genero;
import enums.Grupo;

public class Item implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int ano;
	private String titulo;
	private String autor;
	private Genero genero;
	private String sinopse;
	private Quantidade quantidade;
	private Grupo grupo;
	private byte[] imagen; 
	
	public Item() {
		this("","",null,0,"",null);
	}
	
	public Item(String titulo,String autor,Genero genero,int ano,String sinopse,Grupo grupo){
		
		this.titulo = titulo;
		this.ano = ano;
		this.sinopse = sinopse;
		this.autor= autor;
		this.grupo = grupo;
		this.genero = genero;
		this.quantidade = new Quantidade();
		
	}
	
	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	
	
	public String getDescricao() {
		return sinopse;
	}

	public void setDescricao(String descricao) {
		this.sinopse = descricao;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public int getAno() {
		return ano;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public Quantidade getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(Quantidade quantidade) {
		this.quantidade = quantidade;
	}
	
	public Grupo getGrupo() {
		return grupo;
	}
	
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public void imprimirDados() {
		System.out.println("Id: "+id+
				 		   " Titulo: "+titulo+
				 		   " Ano: "+ano+
				 		   " Genero: "+genero+
				 		   " Autor: "+autor+
				 		   " Grupo: "+grupo+
				 		   " Quantidade "+quantidade.getQuantidade()+
				 		   " Sinopse: "+sinopse+
				 		   " "
							);
	}
}
