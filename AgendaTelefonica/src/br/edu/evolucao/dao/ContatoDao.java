package br.edu.evolucao.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.edu.evolucao.bean.Contato;

public class ContatoDao {

	private static List<Contato> contatos;
	private static long id;
	static {
		contatos = new ArrayList<Contato>();
	}
	
	public ContatoDao() {}
	
	
	public void salvar(Contato contato) {
		contato.setId(++id);
		contatos.add(contato);
	}
	
	public void excluirPorNome(Contato contato) {
		Iterator<Contato> it = contatos.iterator();
		while (it.hasNext()) {
			Contato c = it.next();
			if (c.getNome() != null && contato.getNome() != null) {
				if (c.getNome().equalsIgnoreCase(contato.getNome())) {
					it.remove();
				}
			}
		}
	}
	
	public List<Contato> findContatoPorNome(String nome) {
		List<Contato> contatosEncontrados = new ArrayList<Contato>();
		for (Contato c : contatos) {
			if (c.getNome() != null && nome != null) {
				if (c.getNome().toLowerCase().contains(nome.toLowerCase())) {
					contatosEncontrados.add(c);
				}
			}
		} return contatosEncontrados;
	}
	
	public Contato procurarPorId(Long id) {
		for (Contato c : contatos) {
			if (c.getId() != null && id != null) {
				if (c.getId() == id) {
					return c;
				}
			}
		} return null;
	}
	
	public void excluirPorId(Long id) {
		Iterator<Contato> it = contatos.iterator();
		while (it.hasNext()) {
			Contato c = it.next();
			if (c.getId() != null && id != null) {
				if (c.getId() == id) {
					it.remove();
				}
			}
		}
	}
	
	public void atualizar(Contato contato) {
		for (int i = 0 ; i < contatos.size() ; i++) {
			Contato contatoDoBanco = contatos.get(i);
			if (contatoDoBanco.getId() == contato.getId()) {
				contatos.set(i, contato);
			}
		}
	}
	
	public List<Contato> listar() {
		return contatos;
	}
	
}
