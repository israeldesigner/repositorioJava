package enums;

public enum Genero {
	Aventura("Aventura"),
	Romance("Romance"),
	Ficcao("Ficcao"),
	Comedia("Comedia"),
	Informativo("Informativo");
	
	
	private String referencia;
	
	private Genero(String genero) {
		referencia = genero;
	}
	
}
