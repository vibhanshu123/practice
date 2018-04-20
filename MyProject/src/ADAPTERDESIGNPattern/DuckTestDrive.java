package ADAPTERDESIGNPattern;

public class DuckTestDrive {
	
	public static void main(String [] args){
		
		MallardDuck mallardDuck=new MallardDuck();
		WildTurkey wildTurkey=new WildTurkey();
		
		wildTurkey.fly();
		wildTurkey.gobble();
		
		Duck ta=new TurkeyAdapter(wildTurkey);
		
		testDuck(ta);
		testDuck(mallardDuck);
		
		
	}

	public static void testDuck(Duck duck) {
       duck.fly();
       duck.quack();
	}

}
