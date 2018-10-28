package com.assignment.eventbus;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 
 * @author vibhanshu
 *
 */

public class ErrorHandlingTest {
    private EventBus eventBus;

    @Before
    public void setUp() {
        eventBus = new EventBusImpl();
    }

    @Test
    public void testErrorHandling() {
        Listener listener = new Listener();
        eventBus.addSubscriber(listener);

        eventBus.publishEvent(new Event());
        assertEquals(listener.listenerCalled, 1);

        RuntimeExceptionLister exceptionLister = new RuntimeExceptionLister();
        eventBus.addSubscriber(exceptionLister);

        assertFalse(exceptionLister.errorHandled);
        eventBus.publishEvent(new Event());

        assertEquals(listener.listenerCalled, 2);
        assertTrue(exceptionLister.errorHandled);
    }


    private class RuntimeExceptionLister {
        boolean errorHandled;

        @Subscribe
        public void listen(Event exceptionEvent) {
            assertNotNull(exceptionEvent);
            errorHandled = true;
        }
    }

    private class Listener {
        int listenerCalled;

        @Subscribe
        void listen(Event event) {
            listenerCalled++;
            throw new RuntimeException("generated error");
        }
    }

    private class Event {}
}
