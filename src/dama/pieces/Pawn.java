package dama.pieces;

import boardgame.Board;
import boardgame.Position;
import dama.Color;
import dama.DamaPiece;

public class Pawn extends DamaPiece {

	public Pawn(Board board, Color color) {
		super(board, color);
	}

	public boolean canMove(Position position, int column, Color color) {
		Position p = new Position(position.getRow(), position.getColumn());
		
		if(color == Color.WHITE) {
			if (getBoard().positionExists(position) && !getBoard().thereIsAPiece(position)) {
				p.setValues(p.getRow() + 1, p.getColumn() - 1);
				if (thereIsOpponentPiece(p)) {
					return true;
				}
			}			
		}
		
		return false;
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRow()][getBoard().getColumn()];
		Position p = new Position(0, 0);

			if (getColor() == Color.WHITE) {
				boolean x = true;
				
				/*while (x) {
					p.setValues(position.getRow() - 2, position.getColumn() + 2);
					int column = -2;
					while (column <= 2) {
						if (column != 0) {
							
						}
						column = column + 2;
					}
				}*/
				
			}
		return mat;
	}

	@Override
	public String toString() {
		return "P";
	}
}
