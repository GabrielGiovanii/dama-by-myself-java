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
		int columnOperator;
		
		if (getColor() == Color.WHITE) {
			columnOperator = 1;
		} else {
			columnOperator = -1;
		}
		if (getBoard().positionExists(position)) {
			if (!getBoard().thereIsAPiece(position)) {
				if (column == -2) {
					p.setValues(p.getRow() + columnOperator, p.getColumn() + 1);
					if (getBoard().positionExists(p)) {
						if (thereIsOpponentPiece(p)) {
							return true;
						}
					}
				} else {
					p.setValues(p.getRow() + columnOperator, p.getColumn() - 1);
					if (getBoard().positionExists(p)) {
						if (thereIsOpponentPiece(p)) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRow()][getBoard().getColumn()];
		Position pInitial = new Position(position.getRow(), position.getColumn());
		Position[][] neP = new Position[4][3];
		Position[][] nwP = new Position[4][3];
		int columnOperator;
		
		if (getColor() == Color.WHITE) {
			columnOperator = -2;
		} else {
			columnOperator = 2;
		}
		// Diagonal Right
		if (canMove(new Position(pInitial.getRow() + columnOperator, pInitial.getColumn() + 2), 2, getColor())) {
			Position levelOne = new Position(pInitial.getRow() + columnOperator, pInitial.getColumn() + 2);
			neP[0][0] = new Position(pInitial.getRow() + columnOperator, pInitial.getColumn() + 2);
			neP[1][0] = new Position(pInitial.getRow() + columnOperator, pInitial.getColumn() + 2);
			neP[2][0] = new Position(pInitial.getRow() + columnOperator, pInitial.getColumn() + 2);
			neP[3][0] = new Position(pInitial.getRow() + columnOperator, pInitial.getColumn() + 2);
			mat[pInitial.getRow() + columnOperator][pInitial.getColumn() + 2] = true;
			if (canMove(new Position(levelOne.getRow() + columnOperator, levelOne.getColumn() - 2), -2, getColor())) {
				neP[0][1] = new Position(levelOne.getRow() + columnOperator, levelOne.getColumn() - 2);
				neP[1][1] = new Position(levelOne.getRow() + columnOperator, levelOne.getColumn() - 2);
				mat[levelOne.getRow() + columnOperator][levelOne.getColumn() - 2] = true;
				Position levelTwo = new Position(levelOne.getRow() + columnOperator, levelOne.getColumn() - 2);
				if (canMove(new Position(levelTwo.getRow() + columnOperator, levelTwo.getColumn() - 2), -2,
						getColor())) {
					neP[0][2] = new Position(levelTwo.getRow() + columnOperator, levelTwo.getColumn() - 2);
					mat[levelTwo.getRow() + columnOperator][levelTwo.getColumn() - 2] = true;
				}
				if (canMove(new Position(levelTwo.getRow() + columnOperator, levelTwo.getColumn() + 2), 2,
						getColor())) {
					neP[1][2] = new Position(levelTwo.getRow() + columnOperator, levelTwo.getColumn() + 2);
					mat[levelTwo.getRow() + columnOperator][levelTwo.getColumn() + 2] = true;
				}
			}
			if (canMove(new Position(levelOne.getRow() + columnOperator, levelOne.getColumn() + 2), 2, getColor())) {
				neP[2][1] = new Position(levelOne.getRow() + columnOperator, levelOne.getColumn() + 2);
				neP[3][1] = new Position(levelOne.getRow() + columnOperator, levelOne.getColumn() + 2);
				mat[levelOne.getRow() + columnOperator][levelOne.getColumn() + 2] = true;
				Position levelTwo = new Position(levelOne.getRow() + columnOperator, levelOne.getColumn() + 2);
				if (canMove(new Position(levelTwo.getRow() + columnOperator, levelTwo.getColumn() - 2), -2,
						getColor())) {
					neP[2][2] = new Position(levelTwo.getRow() + columnOperator, levelTwo.getColumn() - 2);
					mat[levelTwo.getRow() + columnOperator][levelTwo.getColumn() - 2] = true;
				}
				if (canMove(new Position(levelTwo.getRow() + columnOperator, levelTwo.getColumn() + 2), 2,
						getColor())) {
					neP[3][2] = new Position(levelTwo.getRow() + columnOperator, levelTwo.getColumn() + 2);
					mat[levelTwo.getRow() + columnOperator][levelTwo.getColumn() + 2] = true;
				}
			}
		}
		// Diagonal Left
		if (canMove(new Position(pInitial.getRow() + columnOperator, pInitial.getColumn() - 2), -2, getColor())) {
			Position levelOne = new Position(pInitial.getRow() + columnOperator, pInitial.getColumn() - 2);
			nwP[0][0] = new Position(pInitial.getRow() + columnOperator, pInitial.getColumn() - 2);
			nwP[1][0] = new Position(pInitial.getRow() + columnOperator, pInitial.getColumn() - 2);
			nwP[2][0] = new Position(pInitial.getRow() + columnOperator, pInitial.getColumn() - 2);
			nwP[3][0] = new Position(pInitial.getRow() + columnOperator, pInitial.getColumn() - 2);
			mat[pInitial.getRow() + columnOperator][pInitial.getColumn() - 2] = true;
			if (canMove(new Position(levelOne.getRow() + columnOperator, levelOne.getColumn() - 2), -2, getColor())) {
				nwP[0][1] = new Position(levelOne.getRow() + columnOperator, levelOne.getColumn() - 2);
				nwP[1][1] = new Position(levelOne.getRow() + columnOperator, levelOne.getColumn() - 2);
				mat[levelOne.getRow() + columnOperator][levelOne.getColumn() - 2] = true;
				Position levelTwo = new Position(levelOne.getRow() + columnOperator, levelOne.getColumn() - 2);
				if (canMove(new Position(levelTwo.getRow() + columnOperator, levelTwo.getColumn() - 2), -2,
						getColor())) {
					nwP[0][2] = new Position(levelTwo.getRow() + columnOperator, levelTwo.getColumn() - 2);
					mat[levelTwo.getRow() + columnOperator][levelTwo.getColumn() - 2] = true;
				}
				if (canMove(new Position(levelTwo.getRow() + columnOperator, levelTwo.getColumn() + 2), 2,
						getColor())) {
					nwP[1][2] = new Position(levelTwo.getRow() + columnOperator, levelTwo.getColumn() + 2);
					mat[levelTwo.getRow() + columnOperator][levelTwo.getColumn() + 2] = true;
				}
			}
			if (canMove(new Position(levelOne.getRow() + columnOperator, levelOne.getColumn() + 2), 2, getColor())) {
				nwP[2][1] = new Position(levelOne.getRow() + columnOperator, levelOne.getColumn() + 2);
				nwP[3][1] = new Position(levelOne.getRow() + columnOperator, levelOne.getColumn() + 2);
				mat[levelOne.getRow() + columnOperator][levelOne.getColumn() + 2] = true;
				Position levelTwo = new Position(levelOne.getRow() + columnOperator, levelOne.getColumn() + 2);
				if (canMove(new Position(levelTwo.getRow() + columnOperator, levelTwo.getColumn() - 2), -2,
						getColor())) {
					nwP[2][2] = new Position(levelTwo.getRow() + columnOperator, levelTwo.getColumn() - 2);
					mat[levelTwo.getRow() + columnOperator][levelTwo.getColumn() - 2] = true;
				}
				if (canMove(new Position(levelTwo.getRow() + columnOperator, levelTwo.getColumn() + 2), 2,
						getColor())) {
					nwP[3][2] = new Position(levelTwo.getRow() + columnOperator, levelTwo.getColumn() + 2);
					mat[levelTwo.getRow() + columnOperator][levelTwo.getColumn() + 2] = true;
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
