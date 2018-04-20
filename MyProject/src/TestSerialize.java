import java.io.Serializable;


public class TestSerialize implements Serializable{
	
	private int byteversion=100;
    private int byteCount=0;
    
    public TestSerialize(int byteversion,int byteCount) {
		this.byteversion=byteversion;
		this.byteCount=byteCount;
	}
}
