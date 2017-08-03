package bean;

public class Quantidade {
	
	private int quantidade;
	private int quantidadeEmprestada;
	
	public Quantidade() {
		
		quantidade = 0;
		quantidadeEmprestada = 0;

	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade += quantidade;
	}
	
	public int getQuantidadeEmprestada() {
		return quantidadeEmprestada;
	}

	public void setQuantidadeEmprestada(int quantidadeEmprestada) {
		this.quantidadeEmprestada += quantidadeEmprestada;
	}
	
	public int calculaQuantidade() {
		return this.quantidade - this.quantidadeEmprestada;
	}
		
}
