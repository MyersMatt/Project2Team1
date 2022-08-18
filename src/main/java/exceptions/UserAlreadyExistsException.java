package exceptions;

public class UserAlreadyExistsException extends RuntimeException {
	public UserAlreadyExistsException() {
		super("The username or email you are using already exists");
	}

}
