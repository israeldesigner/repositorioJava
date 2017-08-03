package viewComponentes;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class NumFieldFX extends TextField {
	   
	public NumFieldFX() {
      this.addEventFilter(KeyEvent.KEY_TYPED, new EventHandler<KeyEvent>() {
         public void handle( KeyEvent t ) {
            char ar[] = t.getCharacter().toCharArray();
            char ch = ar[t.getCharacter().toCharArray().length - 1];
            if (!(ch >= '0' && ch <= '9')) {
               System.out.println("The char you entered is not a number");
               t.consume();
            }
         }
      });
   }
	
}