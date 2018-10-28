package java8;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Java8ThreadAndExecutors {
	
	ExecutorService executor = Executors.newWorkStealingPool();

	List<Callable<String>> callables = Arrays.asList(
	        () -> "task1",
	        () -> "task2",
	        () -> "task3");

	public void process() throws InterruptedException {
	executor.invokeAll(callables)
	    .stream()
	    .map(future -> {
	        try {
	            return future.get();
	        }
	        catch (Exception e) {
	            throw new IllegalStateException(e);
	        }
	    })
	    .forEach(System.out::println);
	}
	
	
	public static void main(String [] args) {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

		Runnable task = () -> System.out.println("Scheduling: " + System.nanoTime());
		ScheduledFuture<?> future = executor.schedule(task, 3, TimeUnit.SECONDS);

		try {
			TimeUnit.MILLISECONDS.sleep(1337);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long remainingDelay = future.getDelay(TimeUnit.MILLISECONDS);
		System.out.printf("Remaining Delay: %sms", remainingDelay);
	}


}
