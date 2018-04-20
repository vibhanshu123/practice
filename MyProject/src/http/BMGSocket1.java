package http;



import java.io.*;

import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.HttpsURL;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.URIException;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.protocol.Protocol;

import org.apache.commons.codec.*;



public class BMGSocket1 extends Thread {

	String httpUrl;
	String postData;
	PostMethod method = null;
	int noOFtime = 1;

	public static String replace(String source, String find, String rep) {
        int i = 0,j = 0;
        if(source == null) 
        	return null;
        try{	
	        StringBuffer stringbuffer = new StringBuffer(source);
	        while((i = stringbuffer.toString().indexOf(find, j)) != -1) 
	        {
	            stringbuffer.replace(i, i + find.length(), rep);
	            j = i + rep.length ();
	        }
	        return stringbuffer.toString();
	    } catch(Exception e){
	    	//			
	    	return null;
	    }	
    }

	public void run() {
		String methodName = "run";
		long recipient = 900000000L;
		HttpClient client = new HttpClient(new MultiThreadedHttpConnectionManager());
		long starttime = System.currentTimeMillis();
		long totaltime = 0;
		for(int i = 0; i < this.noOFtime; i++) {
			try {
				recipient++;
				String rcpt = replace(postData, "$$$", ""+recipient);
				URI postURL = new URI(httpUrl, true);
				HostConfiguration hostConfiguration = new HostConfiguration();
				hostConfiguration.setHost(postURL);



				if ((httpUrl.startsWith("https") || httpUrl.startsWith("HTTPS"))) {
					// Creating a SocketFactory for the implementation of SSL
					// protocol
					String host = null;
					int port = 0;
					HttpsURL httpsoSrc = null;

					httpsoSrc = new HttpsURL(httpUrl);
					host = httpsoSrc.getHost();
					port = httpsoSrc.getPort();

					Protocol myhttps = new Protocol("https",
							new EasySSLProtocolSocketFactory(), port);
					Protocol.registerProtocol("https", myhttps);
					client.getHostConfiguration().setHost(host, port, myhttps);

				}
				client.getHttpConnectionManager().getParams().setConnectionTimeout(
						30000); // Connection time out of 30 secs
				method = new PostMethod(httpUrl);

				method.setRequestEntity(new StringRequestEntity(rcpt));
				//method.setRequestBody(postData);
				// method.setRequestEntity(new InputStreamRequestEntity());

				long requestTime = System.currentTimeMillis();
				int statusCode = client.executeMethod(hostConfiguration,method);
				long responseTime = System.currentTimeMillis() - requestTime;
				totaltime += responseTime;
				System.out.println("time for request to process=" + responseTime);
				if (statusCode != HttpStatus.SC_OK) {
					System.err.println("Method failed: " + method.getStatusLine());
				}

				// Read the response body.
				//byte[] responseBody = method.getResponseBody();
				BufferedReader br = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream ()));
				String line = "";
				StringBuffer sb = new StringBuffer();
				while((line = br.readLine()) != null) {
					sb.append (line);
					sb.append ("\n");

				}

				// Deal with the response.
				// Use caution: ensure correct character encoding and is not binary
				// data
				System.out.println(sb.toString ().trim());
				//Thread.sleep(1);


			} catch (URIException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NullPointerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (HttpException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				// Release the connection.
				method.releaseConnection();
			}
		}
		long timetaken = System.currentTimeMillis() - starttime;
		System.out.println("total time take to insert 1000 sms =" + totaltime + ",httpUrl =" + httpUrl);
	}

	private String readFile(String filename) {
		System.out.println("filename:" + filename);
		StringBuffer st = new StringBuffer();
		try {
			File file = new File(filename);
			FileReader fReader = new FileReader(file);
			BufferedReader bReader = new BufferedReader(fReader);

			String line = null;

			while ((line = bReader.readLine()) != null) {
				st.append(line + "\n");

			}

		} catch (Exception e) {
			e.printStackTrace();
			return "foolish";
		}
		return st.toString();

	}

	public static void main(String[] args){

		

		BMGSocket1 test = new BMGSocket1();
		//test.httpUrl = "http://www.google.com";
		test.httpUrl = "http://172.16.29.242:8089/momtgw/ideaAirgateMOListner";
		if(args.length < 2) {
			System.out.println ("usage: java BMGSocket1 <filename> <integer number of times to hit >");
			System.exit(0);
		}
		test.postData = test.readFile(args[0]);
		test.noOFtime = null!= args[1]?Integer.parseInt(args[1]):1;

		Thread t = new Thread(test);
		t.start();

	}

}
