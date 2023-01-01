package application;

import boardgame.Piece;
import dama.Color;
import dama.DamaPiece;

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

	protected static void printMatch() {

	}

	protected static void printBoard(DamaPiece[][] pieces) {
		for (int l = 0; l < pieces.length; l++) {
			System.out.print(pieces.length - l + " ");
			
			for (int c = 0; c < pieces.length; c++) {
				printPiece(pieces[l][c], (c == pieces.length - 1) ? true : false);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}

	protected static void printPiece(DamaPiece piece, boolean lastColumn) {
		if (piece != null) {
			if (lastColumn) {
				System.out.print(piece.toString());
			} else {
				System.out.print(piece.toString() + " ");
			}
		} 
		else {
			if (lastColumn) {
				System.out.print("-");
			} else {
				System.out.print("- ");
			}
		}
	}
}
