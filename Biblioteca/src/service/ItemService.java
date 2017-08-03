package service;

import java.util.ArrayList;

import bean.Item;
import dao.ItemDao;
import enums.AtributosItem;
import exception.ItemCamposObrigatoriosException;
import exception.ItemExcluirException;
import exception.ItemNullException;

public class ItemService {
	
	private ItemDao itemDao;

	public ItemService() {
		
		itemDao = new ItemDao();
	
	}
	// 1 Cadastrar Item
	public void add(Item item) throws ItemNullException, ItemCamposObrigatoriosException {
		
		if (item == null){
			throw new ItemNullException();
		}
		if (item.getTitulo().isEmpty() || item.getQuantidade().calculaQuantidade() <= 0 || item.getGrupo() == null){
			String mensagens[] = new String[AtributosItem.values().length];
			if (item.getTitulo().isEmpty() ) {
				mensagens[AtributosItem.TITULO.getAtributos()] = "O Título é obrigatório";
			}
			if (item.getGrupo() == null){
				mensagens[AtributosItem.GRUPO.getAtributos()] = "O Grupo é Obrigatótio";
			}
			if (item.getQuantidade().calculaQuantidade() <= 0 ){
				mensagens[AtributosItem.QUANTIDADE.getAtributos()] = "A Quantidade é obrigatório";
			}
			
			throw new ItemCamposObrigatoriosException("Os Campos Com * são de preenchimento Obrigatório.",mensagens);
		}
		
		itemDao.add(item);
	}
	
	// 2 pesquisar item
	public ArrayList<Item> pesquisar() {
		
		
		return itemDao.findAll();
	}
	
	// 3 retorna os itens disponiveis
	public ArrayList<Item> itensDisponiveis() {
		
		return itemDao.itensDisponiveis();
	}
	
	// 4 Pegar Emprestado
	public void pegarEmprestado(Item item) {
		
		itemDao.emprestar(item, 1);
		
		
	}
	
	// 5 Devolver Livros
	public void devolverEmprestimo(Item item){
		itemDao.emprestar(item, -1);
	}
	
	// 6 Excluir Itens
	public void excluirItens(Item item) throws ItemExcluirException{
		itemDao.removeItem(item);
	}
	
	// 7 Listar Item
	public ArrayList<Item> findAllItem() {
		return itemDao.findAll();
	}
	
	
	
}
