package enums;

public enum Grupo {
	Livro("Livro"),
	Jornal("Jornal"),
	Revista("Revista"),
	Artigo("Artigo");
	
	private String referencia;
	
	private Grupo(String grupo) {
	
		referencia = grupo;
		
	}
}
