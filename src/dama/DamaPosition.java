package dama;

import boardgame.Position;

public class DamaPosition {
	private char column;
	private int row;
	
	protected DamaPosition(char column, int row) {
		this.column = column;
		this.row = row;
	}
	
	public int getRow() {
		return row;
	}
	public char getLetter() {
		return column;
	}
	
	public Position toPosition() {
		return new Position(8 - row, 'a' - column);
	}
	public DamaPosition fromPosition(Position position) {
		 return new DamaPosition((char)('a' + position.getColumn()), 8 - position.getRow());
	}
}
