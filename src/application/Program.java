package application;

import java.util.Scanner;

import boardgame.BoardException;
import boardgame.Position;
import dama.Color;
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
				
				Position[][] possibleMoves = match.possibleMoves(source);
				
				
				ui.clearScreen();
				ui.printBoard(match.getPieces(), possibleMoves);
	
				
				for(int i = 0; i < possibleMoves.length; i++) {
					for(int j = 0; j < possibleMoves.length; j++) {
						if(possibleMoves[i][j] != null) {
							Position targetTurn = new Position(i, j);
							Position[][] opponentCaptured = match.opponentCaptured(source, targetTurn);
							int contadorSequencia = 0;
							int contadorLinha = 0;
							for(int l = 0; l < opponentCaptured.length; l++) {
								contadorLinha = 0;
								for(int c = 0; c < opponentCaptured.length; c++) {
									if(opponentCaptured[l][c] != null)
										contadorLinha++;
								}
								if(contadorLinha > contadorSequencia)
									contadorSequencia = contadorLinha;
							}
							Position[][] imprimirOpponentCaptured = new Position[contadorSequencia][3];
							for(int nSequencias = 0; nSequencias < contadorSequencia; nSequencias++) {
								int numPositions = 0;
								for(int l = 0; l < opponentCaptured.length; l++) {
									int contadorPositionColuna = 0;
									for(int c = 0; c < opponentCaptured.length; c++) {
										int totalPositionLinha = 0;
										for(int position = 0; position < opponentCaptured.length; position++) {
											if(opponentCaptured[l][position] != null)
												totalPositionLinha++;
										}
										Position positionCaptured = new Position(l, c);
										if(opponentCaptured[l][c] != null) {
											contadorPositionColuna++;
											if(contadorPositionColuna == nSequencias + 1 || totalPositionLinha == 1) {
												imprimirOpponentCaptured[nSequencias][numPositions] = positionCaptured;
												numPositions++;
											}
										}
									}
								}	
								
								
								
								/*if(match.getCurrentPlayer() == Color.WHITE) {
									for(int l = opponentCaptured.length; l >= 0 ; l--) {
										for(int c = 0; c < opponentCaptured.length; c++) {
											if(imprimirOpponentCaptured[l][c] != null) {
												Position pieceCaptured = new Position(l, c);
											}
										}
									}	
								}
								else {
									for(int l = 0; l < opponentCaptured.length; l++) {
										for(int c = 0; c < opponentCaptured.length; c++) {
										}
									}									
								}*/
								
								
							}
							int teste = 0;
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
