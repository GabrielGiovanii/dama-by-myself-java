package dama.pieces;

import boardgame.Board;
import boardgame.Position;
import dama.Color;
import dama.DamaPiece;

public class Dama extends DamaPiece {

	public Dama(Board board, Color color) {
		super(board, color);
	}

	@Override
	public Position[][] possibleMoves(int value, Position possibleMove) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		return "D";
	}
}
