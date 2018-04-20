
import java.io.*;
import java.net.*;

/**
 * This program measures response time and throughput for accessing a
 * single web page. The concurrency of the client (#threads) can be
 * configured in the NTHREADS field.
 */
public class Client extends Thread {

    private static final String TEST_URL = "http://localhost:8080/TestServletThreads/TestServlet";

    private static final int WARMUP_ITERATIONS = 10000;
    private static final int TIME_ITERATIONS = 1000;
    private static final int NTHREADS = 20;


    private static long totalTime;

    public static void main(String[] args) throws Exception {

        // Warmup to load classes / let JVM compile them etc on client & server
    	long start=System.currentTimeMillis();
//        for ( int i=0; i<WARMUP_ITERATIONS; i++ ) {
//            runTest();
//        }
        //long end=System.currentTimeMillis();

        // Create all client threads and start them
        Client[] clientThreads = new Client[NTHREADS];
        for ( int i=0; i<NTHREADS; i++ ) {
            clientThreads[i] = new Client();
           // System.out.println("Thread"+(i+1));
            clientThreads[i].start();
          //  clientThreads[i].join();
        }
        long end=System.currentTimeMillis();

        // Wait for all client threads to finish
//        for ( int i=0; i<NTHREADS; i++ ) {
//            clientThreads[i].join();
//        }

        // Print response time and throughput
        totalTime=(end-start);
//        double avgResponseTime = ((double)totalTime) / 
//        (WARMUP_ITERATIONS);
        double avgResponseTime = ((double)totalTime) / 
                                                (TIME_ITERATIONS * NTHREADS);
        System.out.println("Average response time (ms) = " + avgResponseTime);

        double throughPut = 1/avgResponseTime * 1000;
        System.out.println("Throughput (requests/sec) = " + throughPut);
    }

    public void run() {

        try {
            // Access web page in loop and time it
            //long start = System.currentTimeMillis();

            for ( int i=0; i<TIME_ITERATIONS; i++ ) {
            	//System.out.println("Run by "+Thread.currentThread().getName());
                runTest();
            }

          //  long end = System.currentTimeMillis();

//            synchronized ( Client.class ) {
//                totalTime += (end - start);
//            }
        } catch ( Exception ex ) {
            ex.printStackTrace();
        }
    }

    private static void runTest() throws Exception {
        // Open an HTTP Connection to Tomcat
        URL url = new URL(TEST_URL);
        HttpURLConnection httpConnection = 
                                (HttpURLConnection)url.openConnection();

        // Check response code
        int responseCode = httpConnection.getResponseCode();
        if ( responseCode != 200 )
            throw new RuntimeException("Bad response code: " + responseCode);

        // Read returned web page
        InputStream is = httpConnection.getInputStream();
        byte[] buf = new byte[httpConnection.getContentLength()];
        int nread = 0;
        while ( nread < buf.length ) {
            nread += is.read(buf, nread, buf.length - nread);
        }

        /*
        // Print response header
        String responseMsg = httpConnection.getResponseMessage();
        System.err.println("Response header from Tomcat:");
        System.err.println(responseCode + " " + responseMsg);         

        // Print content of page
        System.out.write(buf);
        */
    }
}
