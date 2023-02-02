package application;

import java.util.Scanner;

import boardgame.BoardException;
import boardgame.Position;
import dama.DamaException;
import dama.DamaMatch;
import dama.DamaPosition;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DamaMatch match = new DamaMatch();
		UI ui = new UI();
		
		while(true) {
			try {
				ui.clearScreen();
				ui.printMatch(match.getPieces());
				
				System.out.println("\nTurno: " + match.getTurn());
				System.out.println("Jogador: " + match.getCurrentPlayer());
				
				System.out.print("\nOrigem: ");
				DamaPosition source = UI.readDamaPosition(sc);
				
				int[][] possibleMoves = match.possibleMoves(source);
				ui.clearScreen();
				ui.printBoard(match.getPieces(), possibleMoves);
	
				
				for(int i=0; i < possibleMoves.length; i++) {
					for(int j=0; j < possibleMoves.length; j++) {
						if(possibleMoves[i][j] == 1) {
							Position targetTurn = new Position(i, j);
							int[][] opponentCaptured = match.opponentCaptured(source, targetTurn);
							int te = 1;
						}
					}
				}
				
				System.out.print("\nDestino: ");
				DamaPosition target = UI.readDamaPosition(sc);			
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

}
