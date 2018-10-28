package com.assignment.eventbus;

import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * A class to hold all information of a subscriber method.
 *
 */
class SubscriberMethod {
    Object target;
    WeakReference<?> weakListener;

    Method method;
    Class<?> eventType;

    boolean async;


    SubscriberMethod(Method method, Class<?> eventType) {
        this.method = method;
        this.eventType = eventType;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SubscriberMethod other = (SubscriberMethod) obj;


        /*
        * Equality condition:
        *
        * 1. Method name should be equal.
        * 2. Method are not overridden. Overridden methods are ignored. It will only consider
        *    the method from the first child class. Overridden methods from super class are
        *    considered equal.
        *    private method can not be overridden, so it is considered as different method.
        *    private methods with same name are allowed in class hierarchy here.
        * 3. Method should have same argument type.
        * 4. Target class is a super class of the other.
        * 6. Target points to the same object.
        * 5. Listener should have same execution mode (sync/async)
        * */

            return other.method.getName().equals(method.getName())
                    && other.method.getModifiers() != Modifier.PRIVATE
                    && method.getModifiers() != Modifier.PRIVATE
                    && eventType.equals(other.eventType)
                    && async == other.async
                    && target != null
                    && other.target != null
                    && target.equals(other.target)
                    && (target.getClass().isAssignableFrom(other.target.getClass())
                    || other.target.getClass().isAssignableFrom(target.getClass()));
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(async)
                .append(method)
                .append(target)
                .append(eventType)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "[" +
                "method = " +
                method.getName() +
                ", async = " +
                async +
                ", target = " +
                (target) +
                ", event = " +
                eventType.getName() +
                "]";
    }
}
