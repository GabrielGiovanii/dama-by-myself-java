package dama.pieces;

import boardgame.Board;
import boardgame.Position;
import dama.Color;
import dama.DamaPiece;

public class Pawn extends DamaPiece {

	public Pawn(Board board, Color color) {
		super(board, color);
	}

	@Override
	protected boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRow()][getBoard().getColumn()];
		Position p = new Position(0, 0);

		// ne
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		if (getBoard().positionExists(p) && thereIsOpponentPiece(p)) {
			p.setValues(p.getRow() + 1, p.getColumn() + 1);
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				p.setValues(p.getRow() + 1, p.getColumn() + 1);
				if (getBoard().positionExists(p) && getBoard().thereIsAPiece(p) 
						|| getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
					mat[p.getRow() - 1][p.getColumn() - 1] = true;
				}
			}
		}
		
		
		return mat;
	}

	@Override
	public String toString() {
		return "P";
	}
}
