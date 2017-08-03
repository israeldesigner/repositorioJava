package viewComponentes;

import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ComboBoxFX<T> extends ComboBox<T> {

	public ComboBoxFX() {
		this.addEventFilter(KeyEvent.KEY_PRESSED,new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent arg0) {
				if (arg0.getCode() == KeyCode.BACK_SPACE) {
					limpar();
				}					
			}
		});
	}
	
	private void limpar(){
		this.getSelectionModel().clearSelection();
	}
}
