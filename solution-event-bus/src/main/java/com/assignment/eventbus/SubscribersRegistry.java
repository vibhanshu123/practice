package com.assignment.eventbus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.assignment.eventbus.ReflectionUtil.findSubscribedMethods;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * A class to hold the records of subscribers registered to the event bus runtime.
 *
 */
class SubscribersRegistry {
    private Logger logger = LoggerFactory.getLogger(getClass());

    private Map<Class<?>, List<SubscriberMethod>> registry =
            new ConcurrentHashMap<Class<?>, List<SubscriberMethod>>();
    private final List<Object> subscriberCache = new CopyOnWriteArrayList<Object>();
    private final Object lock = new Object();

    /**
     * Registers an object in the subscriber registry.
     *
     * */
    void susbscribe(Object subscriber) {
        synchronized (lock) {
                if (subscriberCache.contains(subscriber)) {
                    logger.error(subscriber + " has already been registered.");
                    throw new EventBusException(subscriber + " has already been registered.");
                }
                subscriberCache.add(subscriber);
                logger.debug(subscriber + " added to the subscriber cache.");
        }

        List<SubscriberMethod> subscribedMethods = findSubscribedMethods(subscriber.getClass());
        if (subscribedMethods == null || subscribedMethods.isEmpty()) {
            logger.error(subscriber + " does not have any method marked with @Subscribe.");
            throw new EventBusException(subscriber + " does not have any method marked with @Subscribe.");
        }

        for (SubscriberMethod listenerMethod : subscribedMethods) {
            listenerMethod.target = subscriber;

            Class<?> eventType = listenerMethod.eventType;
            if (registry.containsKey(eventType)) {
                List<SubscriberMethod> listenerMethods = registry.get(eventType);

                if (!listenerMethods.contains(listenerMethod)) {
                    listenerMethods.add(listenerMethod);
                    logger.debug(listenerMethod + " has been registered.");
                } else {
                    logger.debug(listenerMethod + " has already been registered.");
                }
            } else {
                List<SubscriberMethod> listenerMethods = new CopyOnWriteArrayList<SubscriberMethod>();
                listenerMethods.add(listenerMethod);
                registry.put(listenerMethod.eventType, listenerMethods);
                logger.debug(listenerMethod + " has been registered.");
            }
        }
    }

    /**
     * De-registers a subscriber object.
     * */
    void unssubscribe(Object subscriber) {
        synchronized (lock) {
            for (Object object : subscriberCache) {
                if (object.equals(subscriber)) {
                    if (subscriberCache.remove(subscriber)) {
                        logger.debug(subscriber + " removed from the subscriber cache.");
                    }
                    break;
                }
            }
        }
        removeFromRegistry(subscriber);
    }

    /**
     * Get all registered subscriber information for an event.
     * */
    List<SubscriberMethod> getSubscribers(Object event) {
        if (event != null) {
            Class<?> eventType = event.getClass();
            if (registry.containsKey(eventType)) {
                return registry.get(eventType);
            }
        }
        return null;
    }


    /**
     * Removes the subscriber from the registry.
     * */
    private void removeFromRegistry(Object subscriber) {
        for (Map.Entry<Class<?>, List<SubscriberMethod>> entry : registry.entrySet()) {
            List<SubscriberMethod> subscribedMethods = entry.getValue();
            for (SubscriberMethod listenerMethod : subscribedMethods) {
              
                    if (listenerMethod.target.equals(subscriber)) {
                        if (subscribedMethods.remove(listenerMethod)) {
                            logger.debug(listenerMethod + " has been un-registered.");
                        }
                    }
            }
        }
    }
}
