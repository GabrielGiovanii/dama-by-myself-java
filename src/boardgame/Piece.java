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
	
	public abstract Position[][] possibleMoves(int value, Position possibleMove);
	public boolean isThereAnyPossibleMove() {
		Position[][] mat = possibleMoves(1, new Position(0, 0));
		for(int r=0; r < mat.length; r++) {
			for(int c=0; c < mat.length; c++) {
				if(mat[r][c] != null) {
					return true;
				}
			}
		}
		return false;
	}
}
