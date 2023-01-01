package boardgame;

public class Board {
	private int row;
	private int column;
	private Piece[][] pieces;
	
	public Board(int row, int column) {
		this.row = row;
		this.column = column;
		pieces = new Piece[row][column];
	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}
	
	public Piece piece(int row, int column) {
		return pieces[row][column];
	}
	
	public void placePieceBoard(Piece piece, Position position) {
		pieces[position.getRow()][position.getColumn()] = piece;
	}
}
