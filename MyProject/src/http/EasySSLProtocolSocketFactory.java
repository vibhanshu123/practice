package http;



import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.net.ssl.SSLSocketFactory;

import com.sun.net.ssl.SSLContext;
import com.sun.net.ssl.TrustManager;

import org.apache.commons.httpclient.ConnectTimeoutException;
import org.apache.commons.httpclient.params.HttpConnectionParams;
import org.apache.commons.httpclient.protocol.SecureProtocolSocketFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * <p>
 * EasySSLProtocolSocketFactory can be used to creats SSL {@link Socket}s
 * that accept self-signed certificates.
 * </p>
 * <p>
 * This socket factory SHOULD NOT be used for productive systems
 * due to security reasons, unless it is a concious decision and
 * you are perfectly aware of security implications of accepting
 * self-signed certificates
 * </p>
 *
 * @author <a href="mailto:oleg@ural.ru">Oleg Kalnichevski</a>
 *
 * DISCLAIMER: HttpClient developers DO NOT actively support this component.
 * The component is provided as a reference material, which may be inappropriate
 * to be used without additional customization.
 */

@SuppressWarnings("deprecation")
public class EasySSLProtocolSocketFactory implements SecureProtocolSocketFactory {

    /** Log object for this class. */
    private static final Log LOG = LogFactory.getLog(EasySSLProtocolSocketFactory.class);

    /**
     * Constructor for EasySSLProtocolSocketFactory.
     *
     * Code sample:
     *
     *     <blockquote>
     *     Protocol easyhttps = new Protocol(
     *         "https", new EasySSLProtocolSocketFactory(), 443);
     *
     *     HttpClient client = new HttpClient();
     *     client.getHostConfiguration().setHost("localhost", 443, easyhttps);
     *     </blockquote>
     */
    public EasySSLProtocolSocketFactory() {
        super();
    }

    private static SSLSocketFactory getEasySSLSocketFactory() {
        SSLContext context = null;
        try {
            context = SSLContext.getInstance("SSL");
            context.init(
              null,
              new TrustManager[] {new EasyX509TrustManager(null)},
              null);
        } catch (Exception e) {
           LOG.error(e.getMessage(), e);
            throw new RuntimeException(e.toString());
        }
        return context.getSocketFactory();
    }


    /**
     * @see SecureProtocolSocketFactory#createSocket(java.lang.String,int,java.net.InetAddress,int)
     */
    public Socket createSocket(
        String host,
        int port,
        InetAddress clientHost,
        int clientPort)
        throws IOException, UnknownHostException {

        Socket socket = getEasySSLSocketFactory().createSocket(
            host,
            port,
            clientHost,
            clientPort
        );
        return socket;
    }

    /**
     * @see SecureProtocolSocketFactory#createSocket(java.lang.String,int)
     */
    public Socket createSocket(String host, int port)
        throws IOException, UnknownHostException {
        return getEasySSLSocketFactory().createSocket(
            host,
            port
        );
    }

    /**
     * @see SecureProtocolSocketFactory#createSocket(java.net.Socket,java.lang.String,int,boolean)
     */
    public Socket createSocket(
        Socket socket,
        String host,
        int port,
        boolean autoClose)
        throws IOException, UnknownHostException {
        return getEasySSLSocketFactory().createSocket(
            socket,
            host,
            port,
            autoClose
        );
    }

	public Socket createSocket(String host, int port, InetAddress inetaddress, int localport, HttpConnectionParams params) throws IOException, UnknownHostException, ConnectTimeoutException {
		// TODO Auto-generated method stub
		//System.out.println("inetaddress  "+inetaddress+"\n"+"localport  "+localport+"\n"+"http con parameters  "+params+"\n");
		//System.out.println("timeout value is "+ params.getConnectionTimeout());
		//Thread.dumpStack();

		return getEasySSLSocketFactory().createSocket(host,port);
	}
}
