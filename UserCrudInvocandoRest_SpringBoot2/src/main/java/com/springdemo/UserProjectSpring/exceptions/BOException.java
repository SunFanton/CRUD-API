package com.springdemo.UserProjectSpring.exceptions;

public class BOException extends Exception {

	
    /**
	 * 
	 */
	private static final long serialVersionUID = -5460631909100687559L;

	public BOException() {
        super();
    }
	
    public BOException(String message) {
        super(message);
    }

    public BOException(String message, Throwable cause) {
        super(message, cause);
    }

    public BOException(Throwable cause) {
        super(cause);
    }
    
}
