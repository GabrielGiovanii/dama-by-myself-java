package application;

import java.util.Scanner;

import boardgame.BoardException;
import dama.DamaException;
import dama.DamaMatch;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {
			DamaMatch match = new DamaMatch();
			UI ui = new UI();
			
			ui.printBoard(match.getPieces());
		} 
		catch (BoardException e) {
			System.out.println(e.getMessage());
		}
		catch(DamaException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
