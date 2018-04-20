package bridge;

public class Triangle extends Shape{
	
	public Triangle(Colour colour) {
		super(colour);
	}

	@Override
	public void applyColour() {
		colour.applyColour();
		
	}

}
