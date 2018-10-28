package com.assignment.eventbus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * A reflection utility class to extract information about subscriber methods
 * from a registering listener object.
 *
 */
class ReflectionUtil {
    private final static Logger logger = LoggerFactory.getLogger(ReflectionUtil.class);

    /**
     * Finds all subscriber methods in the whole class hierarchy of {@code subscribedClass}.
     *
     * */
    static List<SubscriberMethod> findSubscribedMethods(Class<?> subscribedClass) {
        List<SubscriberMethod> listenerMethodList = new ArrayList<SubscriberMethod>();
        if (subscribedClass != null) {
            Method[] declaredMethods = subscribedClass.getDeclaredMethods();
            for (Method method : declaredMethods) {
                if (method.isAnnotationPresent(Subscribe.class) && !method.isBridge() && !method.isSynthetic()) {
                    if (method.getParameterTypes().length != 1) {
                        logger.error(method.getName() + " has @Subscribe annotation, " +
                                "but it should have exactly 1 parameter.");
                        throw new EventBusException(method.getName() + " has @Subscribe annotation, " +
                                "but it should have exactly 1 parameter.");
                    }

                    Class<?> parameterType = method.getParameterTypes()[0];
                    if (parameterType.isArray() || method.isVarArgs()) {
                        logger.error(method.getName() + " has @Subscribe annotation, " +
                                "but its parameter should not be an array or varargs.");
                        throw new EventBusException(method.getName() + " has @Subscribe annotation, " +
                                "but its parameter should not be an array or varargs.");
                    }

                    method.setAccessible(true);
                    Subscribe subscribe = method.getAnnotation(Subscribe.class);
                    boolean async = subscribe.async();

                    SubscriberMethod listenerMethod = new SubscriberMethod(method, method.getParameterTypes()[0]);
                    listenerMethod.async = async;
                    listenerMethodList.add(listenerMethod);
                }
            }

            if (subscribedClass.getSuperclass() != null && !subscribedClass.getSuperclass().equals(Object.class)) {
                if (logger.isDebugEnabled() && !subscribedClass.getSuperclass().equals(Object.class)) {
                    logger.debug("Super class found. searching for listener methods in super class "
                            + subscribedClass.getSuperclass().getName());
                }
                List<SubscriberMethod> subscribedMethods = findSubscribedMethods(subscribedClass.getSuperclass());
                listenerMethodList.addAll(subscribedMethods);
            }

            if (subscribedClass.getInterfaces() != null && subscribedClass.getInterfaces().length > 0) {
                if (logger.isDebugEnabled()) {
                    logger.debug("Interface found. searching for listener methods in interfaces.");
                }
                for (Class<?> interfaceClass : subscribedClass.getInterfaces()) {
                    List<SubscriberMethod> subscribedMethods = findSubscribedMethods(interfaceClass);
                    listenerMethodList.addAll(subscribedMethods);
                }
            }
        }
        return listenerMethodList;
    }
}
