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
	
	public Piece piece(Position position) {
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePieceBoard(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("Ja existe uma peca nessa posicao " + position.toString() + ".");
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	public Piece removedPieceBoard(Position position) {
		if(!thereIsAPiece(position)) {
			throw new BoardException("Nao existe uma peca nessa posicao " + position.toString() + ".");
		}
		Piece p = piece(position);
		p.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		return p;
	}
	
	public boolean positionExists(Position position) {
		if(position.getRow() >= 0 && position.getColumn() >= 0 &&
				position.getRow() < row && position.getColumn() < column) {
			return true;
		}
		return false;
	}
	
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("A posicao " + position.toString() + " nao existe no tabuleiro.");
		} 
		if(pieces[position.getRow()][position.getColumn()] == null) {
			return false;
		}
		return true;
	}
}
