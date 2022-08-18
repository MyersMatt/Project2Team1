package exceptions;

public class NotLoggedInException extends RuntimeException {
	public NotLoggedInException() {
		super("You must be logged in to perform this action");
	}

}
