package application;

import java.util.Scanner;

import boardgame.BoardException;
import dama.DamaException;
import dama.DamaMatch;
import dama.DamaPosition;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
			DamaMatch match = new DamaMatch();
			UI ui = new UI();
			
			DamaPosition test = new DamaPosition('b', 8);
			boolean[][] possibleMoves = match.possibleMoves(test);
			
			ui.clearScreen();
			ui.printBoard(match.getPieces(), possibleMoves);
		} 
		catch (BoardException e) {
			System.out.println(e.getMessage());
		}
		catch(DamaException e) {
			System.out.println(e.getMessage());
		}
		
		sc.next();
	}

}
