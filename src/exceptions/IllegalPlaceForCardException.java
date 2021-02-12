package exceptions;

public class IllegalPlaceForCardException extends Exception {
	private static final long serialVersionUID = 1L;
	private String exceptionText;
	
	public IllegalPlaceForCardException(String exceptionText) {
		super();
		this.exceptionText = exceptionText;
	}
	@Override
	public void printStackTrace() {
		System.err.println(exceptionText);
	}
}
