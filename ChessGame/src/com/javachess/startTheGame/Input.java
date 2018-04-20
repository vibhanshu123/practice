/**
 * 
 */
package com.javachess.startTheGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.javachess.board.Board;
import com.javachess.board.Square;
import com.javachess.converter.NotationConverter;
import com.javachess.converter.StandardConverter;
import com.javachess.game.Game;
import com.javachess.piece.Piece;
import com.javachess.player.ManualPlayer;
import com.javachess.player.Player;

/**
 * @author Vibs
 *
 */
public class Input {
	
	public static void main(String [] args){
		howToPlayThisGame();		
		NotationConverter converter= new StandardConverter();
		Board board=new Board();
	    Player player1=new ManualPlayer();
	    initializePlayerPlace(converter, 1, board);	
		Player player2=new ManualPlayer();
		initializePlayerPlace(converter, 2, board);	
		Game game =new Game(player1, player2, converter,board);
		game.start();
	}

	public static void initializePlayerPlace(NotationConverter converter,int playerNumber,Board board) {
		System.out.println("HELLO PLAYER "+playerNumber+": WHERE DO YOU WANT TO PUT YOUR KNIGHT IN ");
		System.out.println("ENTER ROW AND COLUMN COLUMN BETWEN (1,1) TO (8,8)");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = null;
		try {
			s = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Square srcSquare = converter.getSrc(s);
		int row = srcSquare.getRow();
		int column = srcSquare.getCol();
		if(row==7&&column==7){
			 System.out.println("Please restart the game");
			 throw new IllegalArgumentException("Cant start the game by directly putting Knight to 8th row 8th column");
		}
		if(playerNumber==1)
		  board.setPieceAt(Square.at(row, column), Piece.WHITE_KNIGHT);			
		else
		 board.setPieceAt(Square.at(row, column), Piece.BLACK_KNIGHT);
	}
	
	
	private static void howToPlayThisGame() {
		
		System.out.println("WELCOME TO A DIFFERENT KIND OF CHESS GAME");
		System.out.println("Please go through the rules of this game");
		System.out.println(" ");
		
		System.out.println("1.If the user is entering his position for the 1st time ");
		System.out.println("He just needs to give the row number and column number as input");
		System.out.println("For example if he has to set his knight at 2nd row 3rd column then");
		System.out.println("His input must be 23(2 for row and 3 for column)");
		System.out.println("  ");
		
		System.out.println("2.For all the subsequesnt entries the player will enter both the current position and destination position as input :");
		System.out.println("The position parameters will be from (1,1) to (8,8)");
		System.out.println("If the players current position is 2nd row 3rd colum it means that current position is 23");
		System.out.println("And if the player wants to make a move to lets say 4th row 4th column then destination position is 44");
		System.out.println("So the input string will be in the format like 2344(23 as currentposition and 44 as destination position)");
		System.out.println("");
		
	}

}
