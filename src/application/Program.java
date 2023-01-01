package application;

import dama.DamaMatch;

public class Program {

	public static void main(String[] args) {
		DamaMatch match = new DamaMatch();
		UI ui = new UI();
		
		ui.printBoard(match.getPieces());
	}

}
