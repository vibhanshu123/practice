package bridge;

public class Circle extends Shape{

	
	public Circle(Colour colour) {
		super(colour);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void applyColour() {
		colour.applyColour();
		
	}

}
