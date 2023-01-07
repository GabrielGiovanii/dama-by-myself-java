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
		int rowOperator;
		
		if (getColor() == Color.WHITE) {
			rowOperator = 1;
		} else {
			rowOperator = -1;
		}
		if (getBoard().positionExists(position)) {
			if (!getBoard().thereIsAPiece(position)) {
				if (column == -2) {
					p.setValues(p.getRow() + rowOperator, p.getColumn() + 1);
					if (getBoard().positionExists(p)) {
						if (thereIsOpponentPiece(p)) {
							return true;
						}
					}
				} else {
					p.setValues(p.getRow() + rowOperator, p.getColumn() - 1);
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
		Position pPieceNow = new Position(position.getRow(), position.getColumn());
		Position[][] neP = new Position[4][3];
		Position[][] nwP = new Position[4][3];
		int rowOperator;
		
		if (getColor() == Color.WHITE) {
			rowOperator = -2;
		} else {
			rowOperator = 2;
		}
		// Diagonal Right
		if (canMove(new Position(pPieceNow.getRow() + rowOperator, pPieceNow.getColumn() + 2), 2, getColor())) {
			Position levelOne = new Position(pPieceNow.getRow() + rowOperator, pPieceNow.getColumn() + 2);
			neP[0][0] = new Position(pPieceNow.getRow() + rowOperator, pPieceNow.getColumn() + 2);
			neP[1][0] = new Position(pPieceNow.getRow() + rowOperator, pPieceNow.getColumn() + 2);
			neP[2][0] = new Position(pPieceNow.getRow() + rowOperator, pPieceNow.getColumn() + 2);
			neP[3][0] = new Position(pPieceNow.getRow() + rowOperator, pPieceNow.getColumn() + 2);
			mat[pPieceNow.getRow() + rowOperator][pPieceNow.getColumn() + 2] = true;
			if (canMove(new Position(levelOne.getRow() + rowOperator, levelOne.getColumn() - 2), -2, getColor())) {
				neP[0][1] = new Position(levelOne.getRow() + rowOperator, levelOne.getColumn() - 2);
				neP[1][1] = new Position(levelOne.getRow() + rowOperator, levelOne.getColumn() - 2);
				mat[levelOne.getRow() + rowOperator][levelOne.getColumn() - 2] = true;
				Position levelTwo = new Position(levelOne.getRow() + rowOperator, levelOne.getColumn() - 2);
				if (canMove(new Position(levelTwo.getRow() + rowOperator, levelTwo.getColumn() - 2), -2,
						getColor())) {
					neP[0][2] = new Position(levelTwo.getRow() + rowOperator, levelTwo.getColumn() - 2);
					mat[levelTwo.getRow() + rowOperator][levelTwo.getColumn() - 2] = true;
				}
				if (canMove(new Position(levelTwo.getRow() + rowOperator, levelTwo.getColumn() + 2), 2,
						getColor())) {
					neP[1][2] = new Position(levelTwo.getRow() + rowOperator, levelTwo.getColumn() + 2);
					mat[levelTwo.getRow() + rowOperator][levelTwo.getColumn() + 2] = true;
				}
			}
			if (canMove(new Position(levelOne.getRow() + rowOperator, levelOne.getColumn() + 2), 2, getColor())) {
				neP[2][1] = new Position(levelOne.getRow() + rowOperator, levelOne.getColumn() + 2);
				neP[3][1] = new Position(levelOne.getRow() + rowOperator, levelOne.getColumn() + 2);
				mat[levelOne.getRow() + rowOperator][levelOne.getColumn() + 2] = true;
				Position levelTwo = new Position(levelOne.getRow() + rowOperator, levelOne.getColumn() + 2);
				if (canMove(new Position(levelTwo.getRow() + rowOperator, levelTwo.getColumn() - 2), -2,
						getColor())) {
					neP[2][2] = new Position(levelTwo.getRow() + rowOperator, levelTwo.getColumn() - 2);
					mat[levelTwo.getRow() + rowOperator][levelTwo.getColumn() - 2] = true;
				}
				if (canMove(new Position(levelTwo.getRow() + rowOperator, levelTwo.getColumn() + 2), 2,
						getColor())) {
					neP[3][2] = new Position(levelTwo.getRow() + rowOperator, levelTwo.getColumn() + 2);
					mat[levelTwo.getRow() + rowOperator][levelTwo.getColumn() + 2] = true;
				}
			}
		}
		// Diagonal Left
		if (canMove(new Position(pPieceNow.getRow() + rowOperator, pPieceNow.getColumn() - 2), -2, getColor())) {
			Position levelOne = new Position(pPieceNow.getRow() + rowOperator, pPieceNow.getColumn() - 2);
			nwP[0][0] = new Position(pPieceNow.getRow() + rowOperator, pPieceNow.getColumn() - 2);
			nwP[1][0] = new Position(pPieceNow.getRow() + rowOperator, pPieceNow.getColumn() - 2);
			nwP[2][0] = new Position(pPieceNow.getRow() + rowOperator, pPieceNow.getColumn() - 2);
			nwP[3][0] = new Position(pPieceNow.getRow() + rowOperator, pPieceNow.getColumn() - 2);
			mat[pPieceNow.getRow() + rowOperator][pPieceNow.getColumn() - 2] = true;
			if (canMove(new Position(levelOne.getRow() + rowOperator, levelOne.getColumn() - 2), -2, getColor())) {
				nwP[0][1] = new Position(levelOne.getRow() + rowOperator, levelOne.getColumn() - 2);
				nwP[1][1] = new Position(levelOne.getRow() + rowOperator, levelOne.getColumn() - 2);
				mat[levelOne.getRow() + rowOperator][levelOne.getColumn() - 2] = true;
				Position levelTwo = new Position(levelOne.getRow() + rowOperator, levelOne.getColumn() - 2);
				if (canMove(new Position(levelTwo.getRow() + rowOperator, levelTwo.getColumn() - 2), -2,
						getColor())) {
					nwP[0][2] = new Position(levelTwo.getRow() + rowOperator, levelTwo.getColumn() - 2);
					mat[levelTwo.getRow() + rowOperator][levelTwo.getColumn() - 2] = true;
				}
				if (canMove(new Position(levelTwo.getRow() + rowOperator, levelTwo.getColumn() + 2), 2,
						getColor())) {
					nwP[1][2] = new Position(levelTwo.getRow() + rowOperator, levelTwo.getColumn() + 2);
					mat[levelTwo.getRow() + rowOperator][levelTwo.getColumn() + 2] = true;
				}
			}
			if (canMove(new Position(levelOne.getRow() + rowOperator, levelOne.getColumn() + 2), 2, getColor())) {
				nwP[2][1] = new Position(levelOne.getRow() + rowOperator, levelOne.getColumn() + 2);
				nwP[3][1] = new Position(levelOne.getRow() + rowOperator, levelOne.getColumn() + 2);
				mat[levelOne.getRow() + rowOperator][levelOne.getColumn() + 2] = true;
				Position levelTwo = new Position(levelOne.getRow() + rowOperator, levelOne.getColumn() + 2);
				if (canMove(new Position(levelTwo.getRow() + rowOperator, levelTwo.getColumn() - 2), -2,
						getColor())) {
					nwP[2][2] = new Position(levelTwo.getRow() + rowOperator, levelTwo.getColumn() - 2);
					mat[levelTwo.getRow() + rowOperator][levelTwo.getColumn() - 2] = true;
				}
				if (canMove(new Position(levelTwo.getRow() + rowOperator, levelTwo.getColumn() + 2), 2,
						getColor())) {
					nwP[3][2] = new Position(levelTwo.getRow() + rowOperator, levelTwo.getColumn() + 2);
					mat[levelTwo.getRow() + rowOperator][levelTwo.getColumn() + 2] = true;
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
