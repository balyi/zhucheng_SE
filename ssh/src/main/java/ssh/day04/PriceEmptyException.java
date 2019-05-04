package ssh.day04;

public class PriceEmptyException extends RuntimeException {
	private static final long serialVersionUID = -3311374787260317306L;

	public PriceEmptyException() {
	}

	public PriceEmptyException(String message) {
		super(message);
	}

	public PriceEmptyException(Throwable cause) {
		super(cause);
	}

	public PriceEmptyException(String message, Throwable cause) {
		super(message, cause);
	}

	public PriceEmptyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
