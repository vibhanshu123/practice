/*
 * Copyright (c) 2016 JBus author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.assignment.eventbus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 
 * To receive events  from event bus, an object must:
 * register itself with the event bus via {@link #register(Object)} or
 * have at least one method marked with {@link Subscribe} annotation in its class
 * hierarchy
 * subscribed method should accept only one parameter having the type of the event
 *
 * {@link #deregister(Object)} the object to stop receiving events. 
 *
 *To post an event to the event bus, simply call {@link #post(Object)}
 * passing the event object.
 *
 * Subscriber execution mode can be either synchronous  or asynchronous
 * depending on the {@link Subscribe} annotation.
 *
 *
 *
 * @see Subscribe
 */
public class EventBusImpl implements EventBus{
    private Logger logger = LoggerFactory.getLogger(getClass());
    private SubscribersRegistry subscribersRegistry;
    private EventDispatcher eventDispatcher;

    /**
     * Instantiates a new event bus.
     */
    public EventBusImpl() {
        subscribersRegistry = new SubscribersRegistry();
        eventDispatcher = new EventDispatcher(subscribersRegistry);
    }

    public void addSubscriber(Object subscriber) {
        if (subscriber == null) {
            logger.error("Null object can not be registered.");
            throw new NullPointerException("Null object can not be registered.");
        }
        logger.info("Registering listener " + subscriber);
        subscribersRegistry.susbscribe(subscriber);
    }


    public void removeSubscriber(Object subscriber) {
        if (subscriber == null) {
            logger.error("Null object can not be de-registered.");
            throw new NullPointerException("Null object can not be de-registered.");
        }
        logger.info("Un-Registering subscriber " + subscriber);
        subscribersRegistry.unssubscribe(subscriber);
    }


    
    public void publishEvent(Object event) {
        if (event == null) {
            logger.error("Null event posted.");
            throw new NullPointerException("Null event can not be posted.");
        }
        logger.info("Event " + event + " has been posted to the bus ");

        List<SubscriberMethod> subscribers = subscribersRegistry.getSubscribers(event);
        if (subscribers != null && !subscribers.isEmpty()) {
            if (logger.isDebugEnabled()) {
                logger.debug("Total subscribers found for event " + event + " is = " + subscribers.size());
                logger.debug("Dispatching event " + event);
            }
            DefaultHandlerChain handlerChain = new DefaultHandlerChain(subscribers);
            eventDispatcher.dispatch(event, handlerChain);
        }
    }


    public void addShutdownHook() {
        eventDispatcher.addShutdownHook();
    }

	public void addSubscriberForFilteredEvents(Object event, Object subscriber) {
		// TODO Auto-generated method stub
		
	}

	
}
