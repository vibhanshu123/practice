/**
 * 
 */
package com.javachess.player;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.javachess.game.Game;
import com.javachess.piece.Color;

/**
 * @author Vibs
 *
 */
public class ManualPlayer implements Player{


	@Override
	public String takeMove(Color color) {
		int playerNumber =0;
		playerNumber = color.equals(Color.WHITE)?1:2;
		System.out.println("ENTER YOUR MOVE : PLAYER "+playerNumber);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		try {
			s = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;	
		
	}
	
	

}
