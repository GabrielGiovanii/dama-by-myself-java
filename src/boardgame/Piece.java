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
	
	public  abstract boolean[][] possibleMoves();
	public boolean isThereAnyPossibleMove() {
		boolean[][] mat = possibleMoves();
		for(int r=0; r < mat.length; r++) {
			for(int c=0; c < mat.length; c++) {
				if(mat[r][c]) {
					return true;
				}
			}
		}
		return false;
	}
}
