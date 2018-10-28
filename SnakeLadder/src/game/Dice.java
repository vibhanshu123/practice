package game;

import java.util.Random;

public class Dice {
	
	private DiceListener diceListener;
	private int face;
	private Random random;
	private static final int MAX_DICE_POSSIBILITY=6;
	
	public Dice(DiceListener diceListener) {
		this.diceListener = diceListener;
		this.random= new Random();
		
	}
	
	public void roll() {
		face = random.nextInt(MAX_DICE_POSSIBILITY)+1;
		notifyDiceListener();
	}

	private void notifyDiceListener() {
		diceListener.onDiceRolled(face);
	}
}
