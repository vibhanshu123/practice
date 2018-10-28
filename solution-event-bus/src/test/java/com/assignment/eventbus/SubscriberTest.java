package com.assignment.eventbus;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;

/**
 * 
 * @author vibhanshu
 *
 */
public class SubscriberTest {
    private EventBus eventBus;

    @Before
    public void setUp() {
        eventBus = new EventBusImpl();
    }

    @Test
    public void testSubscription() {
        Subscriber subscriber = new Subscriber();
        eventBus.addSubscriber(subscriber);
        eventBus.publishEvent(new Event());

        assertEquals(subscriber.listen1Counter.intValue(), 1);

        eventBus.removeSubscriber(subscriber);
        eventBus.publishEvent(new Event());

        assertEquals(subscriber.listen1Counter.intValue(), 1);
    }

    @Test(expected = NullPointerException.class)
    public void testNullPosting() {
        Subscriber listener = new Subscriber();
        eventBus.addSubscriber(listener);
        eventBus.publishEvent(null);
    }

    @Test(expected = EventBusException.class)
    public void testVarargsRegistration() {
        VarargsListener listener = new VarargsListener();
        eventBus.addSubscriber(listener);
    }

    @Test(expected = EventBusException.class)
    public void testArrayRegistration() {
        ArrayListener listener = new ArrayListener();
        eventBus.addSubscriber(listener);
    }

    @Test(expected = EventBusException.class)
    public void testMultiParameterRegistration() {
        MultiParameterListener listener = new MultiParameterListener();
        eventBus.addSubscriber(listener);
    }

    @Test(expected = EventBusException.class)
    public void testMultipleRegister() {
        Subscriber listener = new Subscriber();
        eventBus.addSubscriber(listener);
        eventBus.addSubscriber(listener);
    }

    @Test
    public void testMultiplePost() {
        Subscriber listener = new Subscriber();
        eventBus.addSubscriber(listener);
        eventBus.publishEvent(new Event());

        assertEquals(listener.listen1Counter.intValue(), 1);

        eventBus.publishEvent(new Event());
        eventBus.publishEvent(new Event());

        assertEquals(listener.listen1Counter.intValue(), 3);

        eventBus.removeSubscriber(listener);
        eventBus.publishEvent(new Event());

        assertEquals(listener.listen1Counter.intValue(), 3);
    }

    @Test
    public void testConcurrentPost() throws InterruptedException {
        Subscriber listener = new Subscriber();
        eventBus.addSubscriber(listener);
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            executorService.submit(new Runnable() {
                public void run() {
                    eventBus.publishEvent(new Event());
                }
            });
        }

        // wait for all threads to complete
        Thread.sleep(1000);

        assertEquals(listener.listen1Counter.intValue(), 10);

        eventBus.removeSubscriber(listener);

        for (int i = 0; i < 10; i++) {
            executorService.submit(new Runnable() {
                public void run() {
                    eventBus.publishEvent(new Event());
                }
            });
        }
        // wait for all threads to complete
        Thread.sleep(1000);

        assertEquals(listener.listen1Counter.intValue(), 10);
    }

    @Test
    public void testMultiEvent() {
        MultiListener listener = new MultiListener();
        eventBus.addSubscriber(listener);

        eventBus.publishEvent(new Event());

        assertEquals(listener.eventListenerCalled, 1);
        assertEquals(listener.intListenerCalled, 0);

        eventBus.publishEvent(3);

        assertEquals(listener.eventListenerCalled, 1);
        assertEquals(listener.intListenerCalled, 1);

        eventBus.removeSubscriber(listener);

        eventBus.publishEvent(new Event());
        eventBus.publishEvent(4);

        assertEquals(listener.eventListenerCalled, 1);
        assertEquals(listener.intListenerCalled, 1);

        eventBus.addSubscriber(listener);

        eventBus.publishEvent(new Event());
        eventBus.publishEvent(4);

        assertEquals(listener.eventListenerCalled, 2);
        assertEquals(listener.intListenerCalled, 2);
    }

    @Test(expected = EventBusException.class)
    public void testNoArgListener() {
        NoArgListener listener = new NoArgListener();
        eventBus.addSubscriber(listener);
    }

    @Test(expected = EventBusException.class)
    public void testNoSubscriberListener() {
        NoSubscriberListener listener = new NoSubscriberListener();
        eventBus.addSubscriber(listener);
    }

    private class Event {}

    private class Subscriber {
        AtomicInteger listen1Counter = new AtomicInteger(0);

        @Subscribe
        public void listen1(Event event){
            listen1Counter.getAndIncrement();
        }

        public void listen2(Event event) {
            throw new RuntimeException("should not be called.");
        }

        @Subscribe
        public void listen3(Integer event) {
            throw new RuntimeException("should not be called.");
        }
    }

    private class VarargsListener {
        @Subscribe
        public void listen(Event... events) {

        }
    }

    private class ArrayListener {
        @Subscribe
        public void listen(Event[] events) {

        }
    }

    private class MultiParameterListener {
        @Subscribe
        public void listen(Event event, Integer integer) {

        }
    }

    private class MultiListener {
        int eventListenerCalled;
        int intListenerCalled;

        @Subscribe
        void listen(Event event) {
            eventListenerCalled++;
        }

        @Subscribe
        void listen(Integer integer) {
            intListenerCalled++;
        }
    }

    private class NoArgListener {
        @Subscribe
        private void listen(){
        }
    }

    private class NoSubscriberListener {
        private void listen(Event event) {
        }
    }
}
