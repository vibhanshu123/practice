package com.assignment.eventbus;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 
 * @author vibhanshu
 *
 */
class DefaultHandlerChain extends CopyOnWriteArrayList<SubscriberMethod> {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	volatile boolean interrupt;

    DefaultHandlerChain(List<SubscriberMethod> subscribers) {
        super(subscribers);
    }

}
