package com.assignment.eventbus;

public interface EventBus {
	
	public void addSubscriber(Object subscriber) ;
	public void removeSubscriber(Object subscriber) ;
	public void publishEvent(Object event) ;
	public void addSubscriberForFilteredEvents(Object event,Object subscriber);
	

}
