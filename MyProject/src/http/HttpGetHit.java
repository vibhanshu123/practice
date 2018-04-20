package http;

import java.io.IOException;
import java.net.URLEncoder;

import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.URIException;
import org.apache.commons.httpclient.methods.GetMethod;

public class HttpGetHit {

	/**
	 * @param args
	 * @throws NullPointerException 
	 * @throws IOException 
	 * @throws HttpException 
	 */
	public static void main(String[] args) throws NullPointerException, HttpException, IOException {
		String message = "म";
		message = URLEncoder.encode(message);
		/*String url = "http://localhost:7000/momtgw/httpMoListener?message=" + message + "&recipient=9886763205&sender=123&msgType=unicodeutf8"+
			"&username=onmobile&password=onmobile";*/
		String url = "http://172.16.29.242:8089/momtgw/httpMtListener?message=" + message + "&recipient=9886763205&sender=52120&msgType=unicodeutf8"+
		"&username=onmobile&password=onmobile";
		
		System.out.println(url);
		URI getURL = new URI(url,  //URL to connect
				true);	//Indicating that the URL is escaped.
		HttpMethod method = new GetMethod(url);
		int responseCode = -1;
		HttpClient httpClient = new HttpClient();
		HostConfiguration hostConfiguration = new HostConfiguration();
		hostConfiguration.setHost(getURL);
		httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(30000); //Connection time out of 30 secs
		httpClient.getParams().setSoTimeout(30000);
		method.setRequestHeader( "Content-Type", "application/x-www-form-urlencoded; charset=utf-8"); 
		System.out.println("Hitting.....");
		try {
			responseCode = httpClient.executeMethod(hostConfiguration, method);
		    
		}catch(java.io.InterruptedIOException iioe) {
			//SMS.exception(_moduleName, _className, methodName, iioe, Thread.currentThread().getName(), "");
			iioe.printStackTrace();
		}
		if (HttpStatus.SC_OK == responseCode) {
			System.out.println("SUCCESS");
		} else {
			//SMS.fatalError(_moduleName, _className, methodName, " Http Get Failure",Thread.currentThread().getName(),null);
			System.out.println(" Http Get Failure" + responseCode);
		}

	}

}
