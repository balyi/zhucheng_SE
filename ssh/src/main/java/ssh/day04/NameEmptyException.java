package ssh.day04;

public class NameEmptyException 
	extends RuntimeException {

	public NameEmptyException() {
	}

	public NameEmptyException(String message) {
		super(message);
	}

	public NameEmptyException(Throwable cause) {
		super(cause);
	}

	public NameEmptyException(String message, Throwable cause) {
		super(message, cause);
	}

	public NameEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
