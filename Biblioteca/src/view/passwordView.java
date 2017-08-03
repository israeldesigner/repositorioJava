package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class passwordView {

	public Scene telaPassword(Stage primaryStage){
		
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		grid.setGridLinesVisible(false);
		
		Text scenetitle = new Text("Bem Vindo");
		scenetitle.setFont(Font.font("Tahoma",FontWeight.NORMAL,30));
		grid.add(scenetitle, 0, 0, 2, 1);
		
		Label userName = new Label("Usuário :");
		userName.setFont(Font.font("Tahoma",FontWeight.NORMAL,18));
		grid.add(userName, 0, 1);
		
		Label password = new Label("Senha :");
		password.setFont(Font.font("Tahoma",FontWeight.NORMAL,18));
		grid.add(password, 0, 2);
		
		TextField userTextField = new TextField();
		userTextField.setFont(Font.font("Tahoma",FontWeight.NORMAL,15));
		grid.add(userTextField, 1, 1);
		
		PasswordField pwTextField = new PasswordField();
		pwTextField.setFont(Font.font("Tahoma",FontWeight.NORMAL,15));
		grid.add(pwTextField, 1, 2);
		
		Button btnEntrar = new Button("Entrar");
	
		Button btnSair = new Button("Sair");
		
		HBox hbBtn = new HBox(10);
		
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btnSair);
		hbBtn.getChildren().add(btnEntrar);
		grid.add(hbBtn, 1, 3);
		
		final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);
        
        Scene scene;
        
		if (primaryStage.getScene() != null){
			scene = new Scene(grid, primaryStage.getScene().getWidth(), primaryStage.getScene().getHeight());
		}else{
			scene = new Scene(grid,800,600);
		}
		
		
		
		btnSair.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Alert alertEncerramento = new Alert(Alert.AlertType.CONFIRMATION);
				alertEncerramento.setTitle("Confirmação de Encerramento");
				alertEncerramento.setHeaderText("Comfirme se deseja Encerrar a Aplicação!");
				alertEncerramento.setContentText("Encerrar Aplicação?");
				alertEncerramento.showAndWait().ifPresent(t -> {
					if (t == ButtonType.OK) {
						actiontarget.setText("");
						primaryStage.close();
					}
				});			
				
			}
			
		});
		
		btnEntrar.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				actiontarget.setFill(Color.FIREBRICK);
				actiontarget.setText("Entrando ao pressionar o Butão");
				
				primaryStage.setScene(new menuView().telaMenu(primaryStage));

				
			}
		});

		
		return scene;
					
	}

}
