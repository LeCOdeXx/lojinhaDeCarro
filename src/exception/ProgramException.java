package exception;

public class ProgramException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ProgramException(String s) {
		super(s);
	}

}
