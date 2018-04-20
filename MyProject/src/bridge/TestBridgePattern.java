package bridge;

public class TestBridgePattern {

	public static void main(String[] args) {
		Triangle tri = new Triangle(new RedColour());
		Circle circle = new Circle(new GreenColour());
		tri.applyColour();
		circle.applyColour();

	}

}
