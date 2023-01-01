package dama.pieces;

import boardgame.Board;
import dama.Color;
import dama.DamaPiece;

public class Pawn extends DamaPiece {

	public Pawn(Board board, Color color) {
		super(board, color);
	}

	@Override
	protected boolean[][] possibleMoves() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		return "P";
	}
}
