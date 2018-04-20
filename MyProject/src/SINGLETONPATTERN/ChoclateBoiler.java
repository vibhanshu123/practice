package SINGLETONPATTERN;

public class ChoclateBoiler {
	
	private boolean empty;
	private boolean boiled;
	private volatile static ChoclateBoiler choclateBoiler;
	
	private ChoclateBoiler(){
		empty=true;
		boiled=false;
	}
	
	public static  ChoclateBoiler getInstance(){
		if(choclateBoiler==null){
		choclateBoiler=new ChoclateBoiler();	
		}
		return choclateBoiler; 
	}
	
	public void fill(){
		if(isEmpty()){
			empty=false;
			boiled=false;
			//fill the boiler with a milk/choclate mixture
		}
	}
	
	public void drain(){
		if(!isEmpty()&&isBoiled()){
			//drain the boiled milk and choclate
			empty=true;
			
		}
	}
	
	public void boil(){
		if(!isEmpty()&&!isBoiled()){
			//boil it
			boiled=true;
	 	}
	}
	
	public boolean isEmpty(){
		return empty;
	}
	
	public boolean isBoiled(){
		return boiled;
	}

}
