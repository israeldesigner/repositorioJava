package dao;

import java.util.ArrayList;

import bean.Item;

public class ItemDao {

	private static ArrayList<Item> listaDeLivros;
	static{
		listaDeLivros = new ArrayList<>();
	}
	
	public ArrayList<Item> findAll() {
		return listaDeLivros;
	}

	public void add(Item Item) {
		int id = listaDeLivros.size();
		Item.setId(id+1);
		listaDeLivros.add(Item);
	}
	
	public ArrayList<Item> itensDisponiveis (){
		
		ArrayList<Item> disponiveis = new ArrayList<>();
		
		for (int i = 0; i < listaDeLivros.size(); i++) {
			if (listaDeLivros.get(i).getQuantidade().calculaQuantidade() > 0) {
				disponiveis.add(listaDeLivros.get(i));
			}
		}
		
		return disponiveis;
	}
	
	public boolean removeItem(Item item){
		
		if (listaDeLivros.remove(item)) {
			return true;
		}else{
			return false;
		}
		
	}
	
	public void emprestar(Item item,int q) {
		
		for (int i = 0; i < listaDeLivros.size(); i++) {
			
			if (listaDeLivros.get(i).getId() == item.getId()) {
				listaDeLivros.get(i).getQuantidade().setQuantidadeEmprestada(q);
			}
			
		}
		
	}
}
