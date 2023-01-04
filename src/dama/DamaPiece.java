package dama;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class DamaPiece extends Piece {
	private Color color;
	
	public DamaPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
	
	public boolean thereIsOpponentPiece(Position position) {
		DamaPiece  p = (DamaPiece) getBoard().piece(position);
		return p != null && p.getColor() != color;
	}
}
