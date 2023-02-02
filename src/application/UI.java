package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import boardgame.Piece;
import dama.Color;
import dama.DamaMatch;
import dama.DamaPiece;
import dama.DamaPosition;

public class UI {

	// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

	// https://stackoverflow.com/questions/2979383/java-clear-the-console
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	protected static void printMatch(DamaPiece[][] pieces) {
		printBoard(pieces);
	}
	
	public static DamaPosition readDamaPosition(Scanner sc) {
		try {
			String s = sc.nextLine();
			char Column = s.charAt(0);
			int row = Integer.parseInt(s.substring(1));
			return new DamaPosition(Column, row);
		} catch (RuntimeException e) {
			throw new InputMismatchException("Erro de leitura na posicao de dama. valores válidos sao de a1 a h8.");
		}
	}
	
	public static void printBoard(DamaPiece[][] pieces) {
		int t = 0;
		for (int l = 0; l < pieces.length; l++) {
			System.out.print(ANSI_GREEN);
			//System.out.print(pieces.length - l + " ");
			System.out.print(t + " ");
			t++;
			System.out.print(ANSI_RESET);
			for (int c = 0; c < pieces.length; c++) {
				printPiece(pieces[l][c], false);
			}
			System.out.println();
		}
		//System.out.println(ANSI_GREEN + "  a b c d e f g h" + ANSI_RESET);
		System.out.println(ANSI_GREEN + "  0 1 2 3 4 5 6 7" + ANSI_RESET);
	}
	
	public static void printBoard(DamaPiece[][] pieces, int[][] possibleMoves) {
		int t = 7;
		for (int l = 0; l < pieces.length; l++) {
			System.out.print(ANSI_GREEN);
			//System.out.print(pieces.length - l + " ");
			System.out.print(t + " ");
			t--;
			System.out.print(ANSI_RESET);
			for (int c = 0; c < pieces.length; c++) {
				printPiece(pieces[l][c], possibleMoves[l][c]==1);

			}
			System.out.println();
		}
		//System.out.println(ANSI_GREEN + "  a b c d e f g h" + ANSI_RESET);
		System.out.println(ANSI_GREEN + "  0 1 2 3 4 5 6 7" + ANSI_RESET);
	}

	protected static void printPiece(DamaPiece piece, boolean background) {
		if (background) {
			System.out.print(ANSI_BLUE_BACKGROUND);
		}
		if (piece != null) {
			if (piece.getColor() == Color.WHITE) {
				System.out.print(ANSI_WHITE + piece.toString() + ANSI_RESET);
			} else {
				System.out.print(ANSI_YELLOW + piece.toString() + ANSI_RESET);
			}
		}
		else {
			System.out.print("-");
		}
		System.out.print(ANSI_RESET);
		System.out.print(" ");
	}
}
