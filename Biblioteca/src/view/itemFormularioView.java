package view;

import bean.Item;
import bean.Quantidade;
import enums.AtributosItem;
import enums.Genero;
import enums.Grupo;
import enums.TypeForm;
import exception.ItemCamposObrigatoriosException;
import exception.ItemNullException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventDispatchChain;
import javafx.event.EventDispatcher;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import service.ItemService;
import viewComponentes.ComboBoxFX;
import viewComponentes.NumFieldFX;

public class itemFormularioView extends Application {

	private static Stage stage;
	private GridPane grid;
	private Group group;
	
	private Item item;
	private ItemService itemService;	
		
	private Text[] avisos;
		
	private Label labelTitulo;
	private Label labelAutor;
	private Label labelAno;
	private Label labelGrupo;
	private Label labelGenero;
	private Label labelQuantidade;
	private Label labelSinopse;
	private Label labelImagen;
	
	private TextField textFieldTitulo;
	private TextField textFieldAutor;
	private NumFieldFX textFieldAno;
	private ComboBoxFX<Grupo> cBoxGrupo;
	private ComboBoxFX<Genero> cBoxGenero;
	private NumFieldFX textFieldQuantidade;
	private TextField textFieldSinopse;
	private TextField textFieldImagen;
		
	public itemFormularioView() {
		
		itemService = new ItemService();
		
		grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		grid.setGridLinesVisible(false);
		
		group = new Group();
		group.getChildren().add(grid);
		
		instanciaLabels();
		instanciaCampos();
		instanciaMensagens();
		
	}
	
	private void instanciaLabels(){
		
		labelTitulo = new Label("Titulo");
		labelAutor = new Label("Autor");
		labelAno = new Label("Ano");
		labelGrupo = new Label("Grupo");
		labelGenero = new Label("Genero");
		labelQuantidade = new Label("Quantidade");
		labelSinopse = new Label("Sinopse");
		labelImagen = new Label("Imagen");
		
		grid.add(labelTitulo, 0, AtributosItem.TITULO.getAtributos());
		grid.add(labelAutor, 0, AtributosItem.AUTOR.getAtributos());
		grid.add(labelAno, 0, AtributosItem.ANO.getAtributos());
		grid.add(labelGrupo, 0, AtributosItem.GRUPO.getAtributos());
		grid.add(labelGenero, 0, AtributosItem.GENERO.getAtributos());
		grid.add(labelQuantidade, 0, AtributosItem.QUANTIDADE.getAtributos());
		grid.add(labelSinopse, 0, AtributosItem.SINOPSE.getAtributos());
		grid.add(labelImagen, 0, AtributosItem.IMAGEM.getAtributos());
		
	}
	
	private void instanciaCampos(){
		
		textFieldTitulo = new TextField();
		textFieldAutor = new TextField();
		textFieldAno = new NumFieldFX();
		cBoxGrupo = new ComboBoxFX<>();
			cBoxGrupo.getItems().setAll(Grupo.values());
		cBoxGenero = new ComboBoxFX<Genero>();
			cBoxGenero.getItems().setAll(Genero.values());
		textFieldQuantidade = new NumFieldFX();
		textFieldSinopse = new TextField();
		textFieldImagen = new TextField();
		
		grid.add(textFieldTitulo, 1, AtributosItem.TITULO.getAtributos());         
		grid.add(textFieldAutor, 1,  AtributosItem.AUTOR.getAtributos());           
		grid.add(textFieldAno, 1, AtributosItem.ANO.getAtributos());               
		grid.add(cBoxGrupo, 1, AtributosItem.GRUPO.getAtributos());           
		grid.add(cBoxGenero, 1, AtributosItem.GENERO.getAtributos());         
		grid.add(textFieldQuantidade, 1, AtributosItem.QUANTIDADE.getAtributos()); 
		grid.add(textFieldSinopse, 1, AtributosItem.SINOPSE.getAtributos());       
		grid.add(textFieldImagen, 1, AtributosItem.IMAGEM.getAtributos());         
	
	}

	private void preencheCampos() {
		
		textFieldTitulo.setText(item.getTitulo());
		textFieldAutor.setText(item.getAutor());
		textFieldAno.setText(item.getAno()+"");
		cBoxGrupo.setValue(item.getGrupo());
		cBoxGenero.setValue(item.getGenero());
		textFieldQuantidade.setText(item.getQuantidade().getQuantidade()+"");
		textFieldSinopse.setText(item.getSinopse());
		
	}
	
	private void limapaCampos(){
	
		textFieldTitulo.clear();
		textFieldAutor.clear();
		textFieldAno.clear();
		cBoxGrupo.getSelectionModel().clearSelection();
		cBoxGenero.getSelectionModel().clearSelection();
		textFieldQuantidade.clear();
		textFieldSinopse.clear();

	}
	
	private void desativaCampos() {
		textFieldTitulo.setDisable(true);
		textFieldTitulo.setDisable(true);
		textFieldAutor.setDisable(true);
		textFieldAno.setDisable(true);
		cBoxGrupo.setDisable(true);
		cBoxGenero.setDisable(true);
		textFieldQuantidade.setDisable(true);
		textFieldSinopse.setDisable(true);
		textFieldImagen.setDisable(true);
	}

	@SuppressWarnings("unused")
	private void ativaCampos() {
		textFieldTitulo.setDisable(true);
		textFieldTitulo.setDisable(true);
		textFieldAutor.setDisable(true);
		textFieldAno.setDisable(true);
		cBoxGrupo.setDisable(true);
		cBoxGenero.setDisable(true);
		textFieldQuantidade.setDisable(true);
		textFieldSinopse.setDisable(true);
		textFieldImagen.setDisable(true);
	}
	
	private void instanciaMensagens(){
		
		avisos = new Text[AtributosItem.values().length]; 
		
		for (int j = 0; j < avisos.length; j++) {
			avisos[j] = new Text();
			grid.add(avisos[j], 2, j);
		}
		
	}
	
	private void visualizaMensagens(String[] mensagens) {
		
		for (int j = 0; j < avisos.length; j++) {
			avisos[j].setText(mensagens[j]);
		}	

	}
	
	private void instanciaBotoesCadastro() {
		
		Button btnSalvar = new Button("Salvar");
		HBox linhaDeBotoes = new HBox(10);
		linhaDeBotoes.setAlignment(Pos.BOTTOM_RIGHT);
		linhaDeBotoes.getChildren().add(btnSalvar);
				
		btnSalvar.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {

				int ano;
				Quantidade quantidade = new Quantidade();
				
				try {
					quantidade.setQuantidade(Integer.parseInt(textFieldQuantidade.getText()));
				} catch (Exception e) {
					quantidade.setQuantidade(0);
				}

				try {
					ano = Integer.parseInt(textFieldAno.getText());
				} catch (Exception e) {
					ano = 0;
				}
				
				item.setTitulo(		textFieldTitulo.getText());
				item.setAutor(		textFieldAutor.getText());
				item.setGenero(		cBoxGenero.getValue());
				item.setAno(    	ano);
				item.setSinopse(	textFieldSinopse.getText());
				item.setGrupo(		cBoxGrupo.getValue());
				item.setQuantidade(	quantidade);
				
				try {
					itemService.add(item);
					confirmaCadastro();
					limapaCampos();
				} catch (ItemNullException e) {
					System.out.println(e.getMessage());
				} catch (ItemCamposObrigatoriosException e) {
					visualizaMensagens(e.getMensagens());
				}
							
			}			
		});
		
		grid.add(linhaDeBotoes, 1, 8);
	}
	
	private void instanciaBotoesExlusao() {
		Button btnExluir = new Button("Excluir");
		HBox linhaDeBotoes = new HBox(10);
		linhaDeBotoes.setAlignment(Pos.BOTTOM_RIGHT);
		linhaDeBotoes.getChildren().add(btnExluir);
		
		btnExluir.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Alert confirma = new Alert(Alert.AlertType.CONFIRMATION);
				confirma.setTitle("Confirmação de Exclusão");
				confirma.setHeaderText("Deseja Realmente Excluir o registro?");
				confirma.showAndWait().ifPresent(b -> {
					if (b == ButtonType.OK) {
						try {
							itemService.excluirItens(item);
						} catch (Exception e) {
							e.printStackTrace();
						}	
						confirmaExclusao();
						stage.close();
					}
				});
			}
		});
		grid.add(linhaDeBotoes, 1, 8);
	}
	
	private void inttanciaBotoesEmprestimo() {
		Button btnEmprestar = new Button("Emprestar");
		Button btnDevolver= new Button("Devolver");
		HBox linhaDeBotoes = new HBox(10);
		linhaDeBotoes.setAlignment(Pos.BOTTOM_RIGHT);
		linhaDeBotoes.getChildren().addAll(btnDevolver,btnEmprestar);
		
		btnEmprestar.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				itemService.pegarEmprestado(item);
				stage.close();
			}
		});

		btnDevolver.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				itemService.devolverEmprestimo(item);
				stage.close();
				
			}
		});
		grid.add(linhaDeBotoes, 1, 8);
	}
	
	public Group telaformulario(Item item, TypeForm typeForm) {
		
		if (item != null) {
			this.item = item;
		}else{
			this.item = new Item();
		}
		
		
		switch (typeForm) {
		case CADASTRO:
			instanciaBotoesCadastro();
			
			break;
		case EXCLUSAO:
			instanciaBotoesExlusao();
			preencheCampos();
			desativaCampos();
			break;
		case ALTERACAO:
			
			
			break;
		case EMPRESTIMO:
			inttanciaBotoesEmprestimo();
			preencheCampos();
			desativaCampos();
			break;
		default:
			break;
		}
				
		return group;
	}
	
	private void confirmaCadastro() {
		Alert confirma = new Alert(Alert.AlertType.INFORMATION);
		confirma.setTitle("Confirmação de Cadastro");
		confirma.setHeaderText("Cadastro Efetuado Com Sucesso!");
		confirma.show();
	}
	
	private void confirmaExclusao() {
		Alert confirma = new Alert(Alert.AlertType.INFORMATION);
		confirma.setTitle("Confirmação de Exclusão");
		confirma.setHeaderText("Registro excluido com sucesso");
		confirma.showAndWait();
	}

	@Override
	public void start(Stage arg0) throws Exception {
		stage = arg0;
		
		stage.setTitle("Item a Ser Excluido");

		stage.show();		
	}
}
