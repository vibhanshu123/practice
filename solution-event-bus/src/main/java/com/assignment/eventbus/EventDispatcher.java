package com.assignment.eventbus;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Internal class for dispatching event to its registered subscribers.
 * It registers itself to a JVM shutdown hook to shutdown gracefully.
 *
 */
class EventDispatcher {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private final ExecutorService executorService = Executors.newCachedThreadPool();
    private boolean isShutdownInitiated = false;

    EventDispatcher(SubscribersRegistry listenersRegistry) {
    }

    void dispatch(Object event, DefaultHandlerChain handlerChain) {
        for (SubscriberMethod subscribedMethod : handlerChain) {
            if (isShutdownInitiated) {
                logger.debug("Shutdown initiated. No more dispatching.");
                return;
            }

            if (!handlerChain.interrupt) {
                if (subscribedMethod.async) {
                    logger.debug("Executing listener asynchronously " + subscribedMethod);
                    dispatchSingleAsync(event, subscribedMethod);
                } else {
                    logger.debug("Executing listener " + subscribedMethod);
                    dispatchSingle(event, subscribedMethod);
                }
            }
        }
    }

    /**
     * Dispatches the subscriber and the event to the executor service for
     * asynchronous execution.
     * */
    private void dispatchSingleAsync(final Object event, final SubscriberMethod listenerMethod) {
        executorService.submit(new Runnable() {
            public void run() {
                dispatchSingle(event, listenerMethod);
            }
        });
    }

    /**
     * Executes the subscriber synchronously.
     * */
    private void dispatchSingle(Object event, SubscriberMethod listenerMethod) {
        try {
                listenerMethod.method.invoke(listenerMethod.target, event);
        } catch (Exception e) {
            if (e.getCause() != null) {
                logger.error("Error occurred while invoking " + listenerMethod, e.getCause());
            } else {
                logger.error("Error occurred while invoking " + listenerMethod, e);
            }
        }
    }

    /**
     * Creates a shutdown hook.
     * */
    private Runnable getShutdownHook() {
        return new Runnable() {
            public void run() {
                isShutdownInitiated = true;
                if (!executorService.isShutdown()) {
                    logger.debug("Shutting down executor, no more event will be dispatched.");
                    executorService.shutdown();
                    logger.debug("Executor has been shutdown gracefully.");
                }
            }
        };
    }

    /**
     * Registers a shutdown hook to the JVM for graceful shutdown of the event bus.
     * */
    void addShutdownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(getShutdownHook()));
    }
}
