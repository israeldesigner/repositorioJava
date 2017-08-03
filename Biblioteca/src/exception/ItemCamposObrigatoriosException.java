package exception;

public class ItemCamposObrigatoriosException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] mensagens;
	
	public ItemCamposObrigatoriosException(String Message, String[] mensagens) {
		super(Message);
		this.mensagens = mensagens;
	}
	
	public String[] getMensagens (){
		return mensagens;
	}
}
