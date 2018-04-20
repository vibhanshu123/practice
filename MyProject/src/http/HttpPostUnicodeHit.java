package http;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.methods.PostMethod;

public class HttpPostUnicodeHit {
	
	private static final String newLine = System.getProperty("line.separator");
	
	public static void main(String[] args) throws NullPointerException, HttpException, IOException {
		HttpClient httpClient = new HttpClient();
		String message = new String(readFileIntoString(new File("e:/unicode.txt")).trim());//"\u0D00\uFFFF\u0042";
		//String msg = "म";
		System.out.println(getHexString(message));
		//String httpUrl = "http://172.16.29.242:8089/momtgw/ideaAirgateDSRListner";
		
		String httpUrl = "http://172.16.29.242:8089/momtgw/httpMoListener";
		URI postURL = new URI(httpUrl,  //URL to connect
				true);	//Indicating that the URL is escaped.
		HostConfiguration hostConfiguration = new HostConfiguration();
		hostConfiguration.setHost(postURL);
		
		//System.out.println(URLEncoder.encode(message,"UTF-16"));
		
	
		httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(30000); //Connection time out of 30 secs		
		PostMethod method = new PostMethod(httpUrl);
		
		//method.setRequestHeader("Content-type", "charset=UTF-8");
		method.setRequestHeader( "Content-Type", "application/x-www-form-urlencoded; charset=utf-8");  
		method.addParameter("message", message);		
		method.addParameter("recipient", "56789");
		method.addParameter("sender", "9986314724");
		method.addParameter("msgType", "unicodeutf8");
		method.addParameter("username", "onmobile");
		method.addParameter("password", "onmobile");
		
		//method.addRequestHeader("Accept-Charset", "UTF-8");
				
		int responseCode = -1;
		try {
			responseCode = httpClient.executeMethod(hostConfiguration, method);
			
		}catch(java.io.InterruptedIOException iioe) {
			iioe.printStackTrace();			
		}
		System.out.println("Response Code =  " + responseCode);		
	}
	
	public static String readFileIntoString(File file) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader
                (new FileInputStream(file),"UTF8"));
        String line;
        
        StringBuilder result = new StringBuilder();
        while ((line = br.readLine()) != null) {
            result.append(line).append(newLine);
        }
        
        br.close();
        return result.toString();
    }
	
	public static String getHexString(String desimalString){
		String retHexString = new String();
		/*String tempString=null;
		int index = 0;*/
		
		for(int i=0;i<desimalString.length();i++){
			char a = desimalString.charAt(i);
			retHexString += prependZero(Integer.toHexString(Integer.valueOf(a)));
		}
		/*while(desimalString.indexOf("&#") != -1){			
			index = desimalString.indexOf("&#");
			desimalString = desimalString.substring(index+2,desimalString.length());
			Window.alert(desimalString);
			index = desimalString.indexOf("&#");
			if(index != -1)
				tempString = desimalString.substring(0,index-1);
			else
				tempString = desimalString.substring(0,desimalString.length()-1);;
			retHexString += toHex(tempString);
		}*/
		return retHexString.toUpperCase();
	}
	
	private static String prependZero(String retString) {
		//logger.debug("before prepending zero:" + retString);
		if(retString.length() == 3){
			retString = "0" + retString;
		}
		else if(retString.length() == 2){
			retString = "00" + retString;
		}
		else if(retString.length() == 1){
			retString = "000" + retString;
		}
		//logger.debug("after prepending zero:" + retString);
		return retString;
	}
}
