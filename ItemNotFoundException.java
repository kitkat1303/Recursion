
public class ItemNotFoundException extends Exception{
	
	public ItemNotFoundException() {
		super("File or Directory could not be found.");
	}
	
	public ItemNotFoundException(String message) {
		super(message); }


}
