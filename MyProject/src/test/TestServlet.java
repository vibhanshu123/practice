package test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.Buffer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class for Servlet: TestServlet
 *
 */
public class TestServlet extends javax.servlet.http.HttpServlet {
   
	private byte[] buf ;
	
    protected void doGet(HttpServletRequest request, 
                         HttpServletResponse response) 
            throws ServletException, IOException {
        processRequest(request, response);
    }          
        
    protected void doPost(HttpServletRequest request, 
                          HttpServletResponse response) 
            throws ServletException, IOException {
        processRequest(request, response);
    }            
       
   // public static StringBuffer buffer = new StringBuffer();
    
    public void init()throws ServletException{
    	try{
    		buf=readContent();
    		
    	}catch(IOException io){
    		io.printStackTrace();
    	}
    }
    
    private void processRequest(HttpServletRequest request,
                  							 HttpServletResponse response) 
        throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        OutputStream out = response.getOutputStream();
        //if(buf==null){readContent();}
        out.write(buf);
        out.close();
    }
    
    private byte[] readContent() throws IOException {
    	
    	
        InputStream is = getServletContext().getResourceAsStream("/content");
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int nread;
        while ((nread = is.read(buf)) != -1) {
        	baos.write(buf, 0, nread);   	
        }
      //  buffer.append(baos);
        return baos.toByteArray();
    }
}
