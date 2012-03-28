package sowhoo.server.exception;

public class UserAlreadyExistException extends Exception{

	private static final long serialVersionUID = 3198784535050328757L;

	public UserAlreadyExistException(){
		super();
	}
	
	public UserAlreadyExistException(String message){
		super(message);
	}
}
