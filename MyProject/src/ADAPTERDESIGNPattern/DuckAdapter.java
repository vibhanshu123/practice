package ADAPTERDESIGNPattern;

public class DuckAdapter implements Turkey{

	Duck duck;
	
	public DuckAdapter(Duck duck) {
       this.duck=duck;
	 }
	
	@Override
	public void fly() {
       duck.fly();		
	}

	@Override
	public void gobble() {
       duck.quack();		
	}

}
