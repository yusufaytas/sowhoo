package sowhoo.server.exception;

public class UnAuthorizedUserException extends Exception{

	private static final long serialVersionUID = -825854619329673697L;

	public UnAuthorizedUserException(){
		super();
	}
	
	public UnAuthorizedUserException(String message){
		super(message);
	}
}
