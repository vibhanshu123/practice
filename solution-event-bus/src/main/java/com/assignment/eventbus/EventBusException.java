package com.assignment.eventbus;

/**
 * Thrown if there are any exception in event bus runtime.
 */
public class EventBusException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EventBusException(String message) {
        super(message);
    }

    public EventBusException(String message, Throwable e) {
        super(message, e);
    }
}
