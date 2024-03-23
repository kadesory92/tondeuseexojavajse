package exception;

public class EntityFileNotFound extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EntityFileNotFound(String message) {
		super(message);
	}

}
