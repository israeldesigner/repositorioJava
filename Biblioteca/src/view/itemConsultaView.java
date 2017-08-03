package view;


import java.util.ArrayList;


import bean.Item;
import enums.AtributosItem;
import enums.Genero;
import enums.Grupo;
import enums.Menu;
import enums.TypeForm;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;
import service.ItemService;

public class itemConsultaView {
	
	private Stage stage;
	private ItemService itemService;
	
	private TableView<Item> tabela;
	private Group telaConsulta;
	private TextField txtBusca;
	private ComboBox<AtributosItem> campoBusca;
	
	public itemConsultaView() {
		itemService = new ItemService();
		tabela = new TableView<>();
		tabela.setMinSize(750, 500);
		montarTableView();
	}
	
	public Group telaConsulta(Menu menu) {
		
		telaConsulta = new Group();
		
		switch (menu) {
			case LISTAR_TODOS:
				ListarTodosComFiltro();
				break;
			case ITENS_DISPONIVEIS:
				listarDisponiveisComFiltro();
				break;
			case EXCLUIR:
				ListarTodosComFiltro();
				adicionaEventoDeExclusao();
				break;
			case EMPRESTIMO:
				ListarTodosComFiltro();
				emprestimo();
				break;
		default:
			break;
			
		}
		
		montarPainelDeConsulta();
		return telaConsulta;
	}

	private void ListarTodosComFiltro () {
		
		iniciaTabelaComFiltro(itemService.findAllItem());
		
		
	}
	
	private void listarDisponiveisComFiltro(){
		
		iniciaTabelaComFiltro(itemService.itensDisponiveis());
	}
		
	private void montarTableView(){
		
		TableColumn<Item, Integer> idColumn = new TableColumn<>("Id");
		TableColumn<Item, String> tituloColumn = new TableColumn<>("Titulo");
		TableColumn<Item, String> autorColumn = new TableColumn<>("Autor");
		TableColumn<Item, Integer> anoColumn = new TableColumn<>("Ano");
		TableColumn<Item, Grupo> grupoColumn = new TableColumn<>("Grupo");
		TableColumn<Item, Genero> generoColumn = new TableColumn<>("Grupo");
		TableColumn<Item, String> quantidadeColumn = new TableColumn<>("Quantidade");
		TableColumn<Item, String> sinopseColumn = new TableColumn<>("Sinopse");
		
		idColumn.setCellValueFactory(new PropertyValueFactory<>("Id"));
		tituloColumn.setCellValueFactory(new PropertyValueFactory<>("Titulo"));
		autorColumn.setCellValueFactory(new PropertyValueFactory<>("Autor"));
		anoColumn.setCellValueFactory(new PropertyValueFactory<>("Ano"));
		grupoColumn.setCellValueFactory(new PropertyValueFactory<>("Grupo"));
		generoColumn.setCellValueFactory(new PropertyValueFactory<>("Genero"));
		quantidadeColumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures <Item, String>, ObservableValue<String> >() {
			@Override
			public ObservableValue<String> call(CellDataFeatures<Item, String> param) {
				return new ReadOnlyObjectWrapper<>(""+param.getValue().getQuantidade().calculaQuantidade());
			}
		});
		sinopseColumn.setCellValueFactory(new PropertyValueFactory<>("Sinopse"));
			
		tabela.getColumns().add(idColumn);
		tabela.getColumns().add(tituloColumn);
		tabela.getColumns().add(autorColumn);
		tabela.getColumns().add(anoColumn);
		tabela.getColumns().add(grupoColumn);
		tabela.getColumns().add(generoColumn);
		tabela.getColumns().add(quantidadeColumn);
		tabela.getColumns().add(sinopseColumn);
	
	}
	
	private void iniciaTabelaComFiltro(ArrayList<Item> listItem) {
		
		campoBusca = new ComboBox<AtributosItem>();
		campoBusca.getItems().add(AtributosItem.TITULO);
		campoBusca.getItems().add(AtributosItem.AUTOR);
		campoBusca.getItems().add(AtributosItem.ANO);
		campoBusca.setValue(AtributosItem.TITULO);
		
		txtBusca = new TextField();
		
		ObservableList<Item> listaDeItens = FXCollections.observableArrayList(listItem);
		
		FilteredList<Item> filteredData = new FilteredList<>(listaDeItens, p -> true);
		
		txtBusca.textProperty().addListener((observable, oldValue, newValue)->{
			filteredData.setPredicate(item -> {
				
				
				if (newValue == null || newValue.isEmpty()) {
	                    return true;
	              }
                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                switch (campoBusca.getValue()) {
				case TITULO:
					
	                if (item.getTitulo().toLowerCase().contains(lowerCaseFilter)) {
	                    return true; // Filter matches first name.
	                } else if (item.getTitulo().toLowerCase().contains(lowerCaseFilter)) {
	                    return true; // Filter matches last name.
	                }
	               					
					break;
				
				case AUTOR:
					
					if (item.getAutor().toLowerCase().contains(lowerCaseFilter)) {
	                    return true; // Filter matches first name.
	                } else if (item.getAutor().toLowerCase().contains(lowerCaseFilter)) {
	                    return true; // Filter matches last name.
	                }
					
					break;
					
				case ANO:
					String ano = item.getAno()+"";
					
					if (ano.toLowerCase().contains(lowerCaseFilter)) {
	                    return true; // Filter matches first name.
	                } else if (ano.toLowerCase().contains(lowerCaseFilter)) {
	                    return true; // Filter matches last name.
	                }
					
					break;
					
				default:
					break;
				}
                 
                return false; // Does not match.
					
			});
		});
		

        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<Item> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        sortedData.comparatorProperty().bind(tabela.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        tabela.setItems(sortedData);

	}
	
	@SuppressWarnings("unused")
	private void iniciaTabelaSemFiltro(ArrayList<Item> listItem) {
		
		tabela.setItems(FXCollections.observableArrayList(listItem));
	
	}

	private void montarPainelDeConsulta() {
		
		HBox painelDeBusca = new HBox(10);
		painelDeBusca.setPadding(new Insets(10,10,10,10));
		painelDeBusca.getChildren().add(campoBusca);
		painelDeBusca.getChildren().add(txtBusca);
		
		VBox painelDeConsulta = new VBox(10);
		painelDeConsulta.getChildren().add(painelDeBusca);
		painelDeConsulta.getChildren().add(tabela);
		telaConsulta.getChildren().add(painelDeConsulta);
	}
	
	private void adicionaEventoDeExclusao (){
		
		tabela.getSelectionModel().selectedItemProperty().addListener(
					(observable,oldValue,newValue) -> {
				
						if (newValue != null) {
							itemFormularioView ifv = new itemFormularioView();
					        stage = new Stage();
					        
							Scene scene = new Scene (ifv.telaformulario(newValue, TypeForm.EXCLUSAO));
							stage.setScene(scene);
							stage.setOnHiding(new EventHandler<WindowEvent>() {
								@Override
								public void handle(WindowEvent event) {
									System.out.println(event.getEventType());
									ListarTodosComFiltro();
								}
							});
//							stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
//								@Override
//								public void handle(WindowEvent event) {
//									System.out.println(event.getEventType());
//									
//								}
//							});
								
							try {
								ifv.start(stage);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
									
			});	

		
	}
	
	private void emprestimo() {
		
		tabela.getSelectionModel().selectedItemProperty().addListener(
				(observable,oldValue,newValue) -> {
			
					if (newValue != null) {
						itemFormularioView ifv = new itemFormularioView();
				        stage = new Stage();
				        
						Scene scene = new Scene (ifv.telaformulario(newValue, TypeForm.EMPRESTIMO));
						stage.setScene(scene);
						stage.setOnHiding(new EventHandler<WindowEvent>() {
							@Override
							public void handle(WindowEvent event) {
								System.out.println(event.getEventType());
								ListarTodosComFiltro();
								tabela.getSelectionModel().clearSelection();
							}
						});
							
						try {
							ifv.start(stage);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});	
		
	}
	
}