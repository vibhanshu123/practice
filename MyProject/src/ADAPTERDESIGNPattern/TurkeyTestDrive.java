package ADAPTERDESIGNPattern;

public class TurkeyTestDrive {
	
	public static void main(String [] args){
		MallardDuck maDuck=new MallardDuck();
		WildTurkey wiTurkey=new WildTurkey();
		
		System.out.println("duck is here");
		maDuck.fly();
        maDuck.quack();
        
		Turkey turkey=new DuckAdapter(maDuck);
		testTurkey(wiTurkey);
		testTurkey(turkey);
	}

	public static void testTurkey(Turkey turkey) {
      turkey.gobble();
      turkey.fly();
	}

}
