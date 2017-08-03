package core;



import bean.Item;
import bean.Quantidade;
import dao.ItemDao;
import enums.Genero;
import enums.Grupo;
import javafx.application.Application;
import javafx.stage.Stage;
import view.passwordView;

public class Run extends Application {
	
		
	public static void main(String[] args) {
		
		ItemDao lv = new ItemDao();
		Item i;
		i = new Item("Eragon","Christopher Paoline",Genero.Aventura,2001,"Livro de aventura do Eragon",Grupo.Livro);
		lv.add(i);
		i = new Item("Eldest","Christopher Paoline",Genero.Aventura,2005,"Livro de aventura do Eragon",Grupo.Livro);
		lv.add(i);
		i = new Item("Brising","Christopher Paoline",Genero.Aventura,2008,"Livro de aventura do Eragon",Grupo.Livro);
		lv.add(i);
		i = new Item("Herança","Christopher Paoline",Genero.Aventura,2000,"Livro de aventura do Eragon",Grupo.Livro);
		lv.add(i);
		i = new Item("Diario Do Nordeste","",Genero.Informativo,2015,"Jornal Diario do nordeste",Grupo.Jornal);
		lv.add(i);
		i = new Item("Diario Do Nordeste","",Genero.Informativo,2015,"Jornal Diario do nordeste",Grupo.Jornal);
		lv.add(i);
		i = new Item("O ladrão de Raios","Rick Riodan",Genero.Aventura,2005,"Percy Jackson e os Olimpianos",Grupo.Livro);
		lv.add(i);
		i = new Item("O Mar de Monstros","Rick Riodan",Genero.Aventura,2006,"Percy Jackson e os Olimpianos",Grupo.Livro);
		lv.add(i);
		i = new Item("A Maldição do Titã","Rick Riodan",Genero.Aventura,2007,"Percy Jackson e os Olimpianos",Grupo.Livro);
		lv.add(i);
		i = new Item("A batalha do Labirinto","Rick Riodan",Genero.Aventura,2008,"Percy Jackson e os Olimpianos",Grupo.Livro);
		lv.add(i);
		i = new Item("O Ultimo Olimpiano","Rick Riodan",Genero.Aventura,2009,"Percy Jackson e os Olimpianos",Grupo.Livro);
		lv.add(i);
		i = new Item("Eragon","Christopher Paoline",Genero.Aventura,2000,"Livro de aventura do Eragon",Grupo.Livro);
		lv.add(i);
		i = new Item("Eragon","Christopher Paoline",Genero.Aventura,2000,"Livro de aventura do Eragon",Grupo.Livro);
		lv.add(i);
		i = new Item("Eragon","Christopher Paoline",Genero.Aventura,2000,"Livro de aventura do Eragon",Grupo.Livro);
		lv.add(i);
		i = new Item("Eragon","Christopher Paoline",Genero.Aventura,2000,"Livro de aventura do Eragon",Grupo.Livro);
		lv.add(i);
		i = new Item("Eragon","Christopher Paoline",Genero.Aventura,2000,"Livro de aventura do Eragon",Grupo.Livro);
		lv.add(i);
		i = new Item("Eragon","Christopher Paoline",Genero.Aventura,2000,"Livro de aventura do Eragon",Grupo.Livro);
		lv.add(i);
		i = new Item("Eragon","Christopher Paoline",Genero.Aventura,2000,"Livro de aventura do Eragon",Grupo.Livro);
		lv.add(i);
		i = new Item("Eragon","Christopher Paoline",Genero.Aventura,2000,"Livro de aventura do Eragon",Grupo.Livro);
		lv.add(i);
		i = new Item("Eragon","Christopher Paoline",Genero.Aventura,2000,"Livro de aventura do Eragon",Grupo.Livro);
		lv.add(i);
		i = new Item("Eragon","Christopher Paoline",Genero.Aventura,2000,"Livro de aventura do Eragon",Grupo.Livro);
		lv.add(i);
		i = new Item("Eragon","Christopher Paoline",Genero.Aventura,2000,"Livro de aventura do Eragon",Grupo.Livro);
		lv.add(i);
		i = new Item("Eragon","Christopher Paoline",Genero.Aventura,2000,"Livro de aventura do Eragon",Grupo.Livro);
		lv.add(i);
		i = new Item("Eragon","Christopher Paoline",Genero.Aventura,2000,"Livro de aventura do Eragon",Grupo.Livro);
		lv.add(i);
		i = new Item("Eragon","Christopher Paoline",Genero.Aventura,2000,"Livro de aventura do Eragon",Grupo.Livro);
		lv.add(i);
		i = new Item("Eragon","Christopher Paoline",Genero.Aventura,2000,"Livro de aventura do Eragon",Grupo.Livro);
		lv.add(i);
		i = new Item("Eragon","Christopher Paoline",Genero.Aventura,2000,"Livro de aventura do Eragon",Grupo.Livro);
		lv.add(i);
		i = new Item("Eragon","Christopher Paoline",Genero.Aventura,2000,"Livro de aventura do Eragon",Grupo.Livro);
		lv.add(i);
		i = new Item("Eragon","Christopher Paoline",Genero.Aventura,2000,"Livro de aventura do Eragon",Grupo.Livro);
		lv.add(i);
		i = new Item("Eragon","Christopher Paoline",Genero.Aventura,2000,"Livro de aventura do Eragon",Grupo.Livro);
		lv.add(i);
		i = new Item("Eragon","Christopher Paoline",Genero.Aventura,2000,"Livro de aventura do Eragon",Grupo.Livro);
		lv.add(i);
		i = new Item("Eragon","Christopher Paoline",Genero.Aventura,2000,"Livro de aventura do Eragon",Grupo.Livro);
		lv.add(i);
		i = new Item("Eragon","Christopher Paoline",Genero.Aventura,2000,"Livro de aventura do Eragon",Grupo.Livro);
		lv.add(i);
		i = new Item("Eragon","Christopher Paoline",Genero.Aventura,2000,"Livro de aventura do Eragon",Grupo.Livro);
		lv.add(i);
		i = new Item("Eragon","Christopher Paoline",Genero.Aventura,2000,"Livro de aventura do Eragon",Grupo.Livro);
		lv.add(i);
		i = new Item("Eragon","Christopher Paoline",Genero.Aventura,2000,"Livro de aventura do Eragon",Grupo.Livro);
		lv.add(i);
		i = new Item("Eragon","Christopher Paoline",Genero.Aventura,2000,"Livro de aventura do Eragon",Grupo.Livro);
		lv.add(i);
		i = new Item("Eragon","Christopher Paoline",Genero.Aventura,2000,"Livro de aventura do Eragon",Grupo.Livro);
		lv.add(i);
		i = new Item("teste de exclusao","Christopher Paoline",Genero.Aventura,2000,"Livro de aventura do Eragon",Grupo.Livro);
		Quantidade q = new Quantidade();
		q.setQuantidade(1);
		i.setQuantidade(q);
		lv.add(i);
		
		launch();

	}
	
	public void carregar() {
		ItemDao lv = new ItemDao();
		Item i;
		i = new Item("Eragon","Christopher Paoline",Genero.Aventura,2000,"Livro de aventura do Eragon",Grupo.Livro);
		lv.add(i);
		i = new Item("Eldest","Christopher Paoline",Genero.Aventura,2000,"Livro de aventura do Eragon",Grupo.Livro);
		lv.add(i);
		i = new Item("Diario Do Nordeste",null,Genero.Informativo,2015,"Jornal Diario do nordeste",Grupo.Jornal);
		lv.add(i);
		i = new Item("Eragon","Christopher Paoline",Genero.Aventura,2000,"Livro de aventura do Eragon",Grupo.Livro);
		lv.add(i);
		i = new Item("Eragon","Christopher Paoline",Genero.Aventura,2000,"Livro de aventura do Eragon",Grupo.Livro);
		lv.add(i);
		i = new Item("Eragon","Christopher Paoline",Genero.Aventura,2000,"Livro de aventura do Eragon",Grupo.Livro);
		lv.add(i);
		i = new Item("Eragon","Christopher Paoline",Genero.Aventura,2000,"Livro de aventura do Eragon",Grupo.Livro);
		lv.add(i);
		i = new Item("Eragon","Christopher Paoline",Genero.Aventura,2000,"Livro de aventura do Eragon",Grupo.Livro);
		lv.add(i);
		i = new Item("Eragon","Christopher Paoline",Genero.Aventura,2000,"Livro de aventura do Eragon",Grupo.Livro);
		lv.add(i);
		i = new Item("Eragon","Christopher Paoline",Genero.Aventura,2000,"Livro de aventura do Eragon",Grupo.Livro);
		lv.add(i);
		
		
		for (int j = 0; j < lv.findAll().size(); j++) {
			lv.findAll().get(j).imprimirDados();
		}
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Biblioteca");		
		primaryStage.setScene(new passwordView().telaPassword(primaryStage));
		primaryStage.show();
	}
	
 
}
