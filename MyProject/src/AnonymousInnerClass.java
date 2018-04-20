
interface AnonymousInnerClass {
	
	public void pop();
//		System.out.println("anonymous sizzling popcorn");
	
}

class Food{
	AnonymousInnerClass an=new AnonymousInnerClass(){
		public void pop(){
			System.out.println("anonymous food popcorn");
		}
		public void sizzle(){
			System.out.println("anonymous food sizzling popcorn");
		}
	};
	
	public void popIt(){
		an.pop();
		
		
	}
	
	public static void main(String [] args){
      Food f=new Food();
      System.out.println();
	}
}