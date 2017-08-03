package br.edu.evolucao.service;

import java.util.List;

import br.edu.evolucao.bean.Contato;
import br.edu.evolucao.dao.ContatoDao;

public class ContatoService {

	private ContatoDao dao;
	
	public ContatoService() {
		dao = new ContatoDao();
	}
	
	public void removerPorId(Long id) {
		dao.excluirPorId(id);
	}
	
	public Contato procurarPorId(Long id) {
		return dao.procurarPorId(id);
	}
	
	public void cadastrar(Contato contato) {
		dao.salvar(contato);
	}
	
	public List<Contato> listar() {
		return dao.listar();
	}
	
	public List<Contato> procurarPorNome(String nome) {
		return dao.findContatoPorNome(nome);
	}
	
	public void excluirPorNome(Contato contato) {
		dao.excluirPorNome(contato);
	}
	
	public void atualizar(Contato contato) {
		Contato contatoDoBanco = dao.procurarPorId(contato.getId());
		if (contatoDoBanco != null) {
			contatoDoBanco.setNome(contato.getNome());
			contatoDoBanco.setEmail(contato.getEmail());
			contatoDoBanco.setTelefone(contato.getTelefone());
			dao.atualizar(contatoDoBanco);
		}
	}
	
}
