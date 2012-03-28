package sowhoo.server.exception;

public class NoSuchUserException extends Exception{

	private static final long serialVersionUID = 7240520441932461948L;

	public NoSuchUserException(){
		super();
	}
	
	public NoSuchUserException(String message){
		super(message);
	}
}
