package interview;


class AClone implements Cloneable{
	private int x;
	private int y;

public AClone(){
	x=5;
	y=10;
}

public void memeberSetter(int x, int y){
	this.x=x;
	this.y=y;
}

public boolean equals(Object o){
	if(o==null)
	return false;
	if ((o instanceof AClone) && ((AClone)o).getX()==this.getX()){
		return true;
	}
	else
		return false;
	}

public Object clone() throws CloneNotSupportedException{
	return super.clone();
}


public int getX(){
	return x;
}

public int getY(){
	return y;
}

public static void main(String [] args) throws CloneNotSupportedException{
	
	AClone a =new AClone();
	AClone b=(AClone)a.clone();
	System.out.println(a==b);
	
	System.out.println(a.equals(b));
	System.out.println(a.getX()+""+a.getY());
	System.out.println(b.getX()+""+b.getY());
	
     }
	
  }






