package enums;

public enum AtributosItem {
	TITULO(0),
	AUTOR(1),
	ANO(2),
	GRUPO(3),
	GENERO(4),
	QUANTIDADE(5),
	SINOPSE(6),
	IMAGEM(7);

	private int atributos;
	
	private AtributosItem(int atributosItem){
		this.atributos = atributosItem;
	}
	
	public int getAtributos(){
		return atributos;
	}
	
}
