package test;

import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool {
	
    private final PoolWorker[] threads;
    private final LinkedBlockingQueue<Runnable> queue;

    public ThreadPool(int nThreads) {
        queue = new LinkedBlockingQueue<Runnable>();
        threads = new PoolWorker[nThreads];

        for (int i = 0; i < nThreads; i++) {
            threads[i] = new PoolWorker();
            threads[i].start();
        }
    }

    public void execute(Runnable task) {
//        synchronized (queue) {
//            queue.add(task);
//            queue.notify();
//        }
    	  try {
			queue.put(task);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private class PoolWorker extends Thread {
        public void run() {
            Runnable task = null;

            while (true) {
//                synchronized (queue) {
//                    while (queue.isEmpty()) {
//                        try {
//                            queue.wait();
//                        } catch (InterruptedException e) {
//                            System.out.println("An error occurred while queue is waiting: " + e.getMessage());
//                        }
//                    }
//                    task = queue.poll();
//                }
            	    try {
						task=queue.take();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

                // If we don't catch RuntimeException,
                // the pool could leak threads
                try {
                    task.run();
                } catch (RuntimeException e) {
                    System.out.println("Thread pool is interrupted due to an issue: " + e.getMessage());
                }
            }
        }
    }
}