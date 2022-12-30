package boardgame;

public abstract class Piece {
	protected Position position;
	Board board;
	
	public Piece(Board board) {
		this.board = board;
	}

	public Board getBoard() {
		return board;
	}
	
	protected  abstract boolean[][] possibleMoves();
}
