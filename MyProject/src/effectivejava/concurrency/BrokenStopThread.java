package effectivejava.concurrency;

import java.util.concurrent.TimeUnit;

// Broken! - How long would you expect this program to run? - Page 259


public class BrokenStopThread {
    private static boolean stopRequested;

    public static void main(String[] args)
            throws InterruptedException {
        Thread backgroundThread = new Thread(new Runnable() {			
			@Override
			public void run() {
			    int i = 0;
                while (!stopRequested)
                    System.out.println(i++);
			}
		});
        backgroundThread.start();
        TimeUnit.MILLISECONDS.sleep(5);
        stopRequested = true;
    }
}
