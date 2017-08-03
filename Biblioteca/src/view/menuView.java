package view;

import enums.Menu;
import enums.TypeForm;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class menuView {
	
	private Menu menuAtivo;
	
	public Scene telaMenu(Stage primaryStage) {
		
		Button btnInicio = new Button("Inicio");
		Button btnCadastrar = new Button("Cadastrar");
		Button btnListarTodos = new Button("Acervo");
		Button btnItensDisponiveis = new Button("Itens Disponiveis");
		Button btnPesquisar = new Button("Pesquisar");
		Button btnExcluir = new Button("Excluir");
		Button btnEmprestimo = new Button("Emprestimo");
		Button btnDevolucao = new Button("Devolução");
		Button btnEncerrar = new Button("Encerrar");
		
		HBox menuBar = new HBox(2);
		menuBar.getChildren().addAll(btnInicio,
									 btnCadastrar,
									 btnListarTodos,
									 btnItensDisponiveis,
									 btnPesquisar,
									 btnExcluir,
									 btnEmprestimo,
									 btnDevolucao,
									 btnEncerrar);
		menuBar.setPadding(new Insets(2, 2, 2, 2));
		menuBar.setAlignment(Pos.TOP_LEFT);
		
		VBox telaPrincipal = new VBox();
		HBox painel = new HBox();
	
		Scene telaMenu ;
				
		telaPrincipal.getChildren().addAll(menuBar,painel);
		telaMenu = new Scene(telaPrincipal, primaryStage.getScene().getWidth(), primaryStage.getScene().getHeight());
				
		btnInicio.setOnAction(e->{
			if (menuAtivo != Menu.INICIO) {
				painel.getChildren().clear();
				menuAtivo = Menu.INICIO;
			}
		});
		btnCadastrar.setOnAction(e->{
			if (menuAtivo != Menu.CADASTRAR) {
				painel.getChildren().clear();
				painel.getChildren().addAll(new itemFormularioView().telaformulario(null, TypeForm.CADASTRO));
				menuAtivo = Menu.CADASTRAR;
				painel.setAlignment(Pos.TOP_LEFT);
			}
		});
		btnListarTodos.setOnAction(e->{
			if (menuAtivo != Menu.LISTAR_TODOS) {
				menuAtivo = Menu.LISTAR_TODOS;
				painel.getChildren().clear();
				painel.getChildren().add(new  itemConsultaView().telaConsulta(Menu.LISTAR_TODOS));
				painel.setAlignment(Pos.CENTER);
			}
		});
		btnItensDisponiveis.setOnAction(e->{
			if (menuAtivo != Menu.ITENS_DISPONIVEIS) {
				menuAtivo = Menu.ITENS_DISPONIVEIS;
				painel.getChildren().clear();
				painel.getChildren().add(new  itemConsultaView().telaConsulta(Menu.ITENS_DISPONIVEIS));
				painel.setAlignment(Pos.CENTER);
			}
		});
		btnPesquisar.setOnAction(e->{
			if (menuAtivo != Menu.PESQUISAR) {
				menuAtivo = Menu.PESQUISAR;
				painel.getChildren().clear();
				painel.getChildren().add(new Label(menuAtivo+" Menu ainda em construção"));
				painel.setAlignment(Pos.CENTER);
			}
		});
		btnEmprestimo.setOnAction(e->{
			if (menuAtivo != Menu.EMPRESTIMO) {
				menuAtivo = Menu.EMPRESTIMO;
				painel.getChildren().clear();
				painel.getChildren().add(new itemConsultaView().telaConsulta(Menu.EMPRESTIMO));
				painel.setAlignment(Pos.CENTER);
			}
		});
		btnDevolucao.setOnAction(e->{
			if (menuAtivo != Menu.DEVOLUCAO) {
				menuAtivo = Menu.DEVOLUCAO;
				painel.getChildren().clear();
				painel.getChildren().add(new  Label(menuAtivo+" Menu ainda em construção"));
				painel.setAlignment(Pos.CENTER);
			}
		});
		btnExcluir.setOnAction(e->{
			
			if (menuAtivo != Menu.EXCLUIR) {
				menuAtivo = Menu.EXCLUIR;
				painel.getChildren().clear();
				painel.getChildren().add(new itemConsultaView().telaConsulta(Menu.EXCLUIR));
				painel.setAlignment(Pos.CENTER);
			}
		});
		btnEncerrar.setOnAction(e->{
			Alert alertEncerramento = new Alert(Alert.AlertType.CONFIRMATION);
			alertEncerramento.setTitle("Confirmação de Encerramento");
			alertEncerramento.setHeaderText("Comfirme se deseja Encerrar a Sação!");
			alertEncerramento.setContentText("Encerrar Seção?");
			alertEncerramento.showAndWait().ifPresent(t -> {
				if (t == ButtonType.OK) {
					primaryStage.setScene(new passwordView().telaPassword(primaryStage));
				}
			});
		});
		
		
		return telaMenu;
	}
	
}
