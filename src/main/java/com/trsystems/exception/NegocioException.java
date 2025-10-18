package com.trsystems.exception;

public class NegocioException extends RuntimeException {
	private static final long serialVersionUID = -4199890103247212276L;

	public NegocioException(Object o) {
		super("" + o);
	}
}
