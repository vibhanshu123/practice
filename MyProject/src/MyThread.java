
public class MyThread extends Thread{

StringBuffer x=null;	
public MyThread(StringBuffer a){
	this.x=a;
}
	
public void run(){
synchronized (x) {
	for(int i=1;i<=100;i++){
		System.out.println(x);
		System.out.println("run by"+Thread.currentThread().getName());
	}
	System.out.println();
		char temp=x.charAt(0);
		++temp;
		x.setCharAt(0, temp);
	}	
}


public static void main(String[] args){
	StringBuffer b=new StringBuffer("A");
	new MyThread(b).start();
	
	new MyThread(b).start();
	new MyThread(b).start();
}
}
