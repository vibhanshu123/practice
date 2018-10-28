package com.assignment.eventbus;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Makes a method eligible to respond to an event.
 *
 * <p>It should be applied to a method (with any access modifier) which has
 * only one argument with the type of the event. If it is applied on a method
 * having no parameter or more than one parameters, during registration, event bus
 * runtime will throw a {@link EventBusException}.
 * </p>
 *
 * If a method in an interface or an abstract class is marked with this annotation,
 * all the overridden methods will be eligible for subscription.
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Subscribe {

    /**
     * Declares whether the subscribed method will be invoked asynchronously.
     * */
    boolean async() default false;
}
