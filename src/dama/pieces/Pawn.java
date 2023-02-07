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
	public Position[][] possibleMoves(int value, Position possibleMove) {
		Position[][] mat = new Position[getBoard().getRow()][getBoard().getColumn()];
		Position pPieceNow = new Position(position.getRow(), position.getColumn());
		Position[][] neP = new Position[4][3];
		Position[][] nwP = new Position[4][3];
		Position[][] neOpponent = new Position[4][3];
		Position[][] nwOpponent = new Position[4][3];
		int rowOperator, rowOpponent;

		if (getColor() == Color.WHITE) {
			rowOperator = -2;
			rowOpponent = -1;
		} else {
			rowOperator = 2;
			rowOpponent = 1;
		}
		// Diagonal Right
		if (canMove(new Position(pPieceNow.getRow() + rowOperator, pPieceNow.getColumn() + 2), 2, getColor())) {
			Position levelOne = new Position(pPieceNow.getRow() + rowOperator, pPieceNow.getColumn() + 2);
			neP[0][0] = new Position(pPieceNow.getRow() + rowOperator, pPieceNow.getColumn() + 2);
			neOpponent[0][0] = new Position(pPieceNow.getRow() + rowOpponent, pPieceNow.getColumn() + 1);
			neP[1][0] = new Position(pPieceNow.getRow() + rowOperator, pPieceNow.getColumn() + 2);
			neOpponent[1][0] = new Position(pPieceNow.getRow() + rowOpponent, pPieceNow.getColumn() + 1);
			neP[2][0] = new Position(pPieceNow.getRow() + rowOperator, pPieceNow.getColumn() + 2);
			neOpponent[2][0] = new Position(pPieceNow.getRow() + rowOpponent, pPieceNow.getColumn() + 1);
			neP[3][0] = new Position(pPieceNow.getRow() + rowOperator, pPieceNow.getColumn() + 2);
			neOpponent[3][0] = new Position(pPieceNow.getRow() + rowOpponent, pPieceNow.getColumn() + 1);
			//mat[pPieceNow.getRow() + rowOperator][pPieceNow.getColumn() + 2] = true;
			if (canMove(new Position(levelOne.getRow() + rowOperator, levelOne.getColumn() - 2), -2, getColor())) {
				neP[0][1] = new Position(levelOne.getRow() + rowOperator, levelOne.getColumn() - 2);
				neOpponent[0][1] = new Position(levelOne.getRow() + rowOpponent, levelOne.getColumn() - 1);
				neP[1][1] = new Position(levelOne.getRow() + rowOperator, levelOne.getColumn() - 2);
				neOpponent[1][1] = new Position(levelOne.getRow() + rowOpponent, levelOne.getColumn() - 1);
				//mat[levelOne.getRow() + rowOperator][levelOne.getColumn() - 2] = true;
				Position levelTwo = new Position(levelOne.getRow() + rowOperator, levelOne.getColumn() - 2);
				if (canMove(new Position(levelTwo.getRow() + rowOperator, levelTwo.getColumn() - 2), -2, getColor())) {
					neP[0][2] = new Position(levelTwo.getRow() + rowOperator, levelTwo.getColumn() - 2);
					neOpponent[0][2] = new Position(levelTwo.getRow() + rowOpponent, levelTwo.getColumn() - 1);
					//mat[levelTwo.getRow() + rowOperator][levelTwo.getColumn() - 2] = true;
				}
				if (canMove(new Position(levelTwo.getRow() + rowOperator, levelTwo.getColumn() + 2), 2, getColor())) {
					neP[1][2] = new Position(levelTwo.getRow() + rowOperator, levelTwo.getColumn() + 2);
					neOpponent[1][2] = new Position(levelTwo.getRow() + rowOpponent, levelTwo.getColumn() + 1);
					//mat[levelTwo.getRow() + rowOperator][levelTwo.getColumn() + 2] = true;
				}
			}
			if (canMove(new Position(levelOne.getRow() + rowOperator, levelOne.getColumn() + 2), 2, getColor())) {
				neP[2][1] = new Position(levelOne.getRow() + rowOperator, levelOne.getColumn() + 2);
				neOpponent[2][1] = new Position(levelOne.getRow() + rowOpponent, levelOne.getColumn() + 1);
				neP[3][1] = new Position(levelOne.getRow() + rowOperator, levelOne.getColumn() + 2);
				neOpponent[3][1] = new Position(levelOne.getRow() + rowOpponent, levelOne.getColumn() + 1);
				//mat[levelOne.getRow() + rowOperator][levelOne.getColumn() + 2] = true;
				Position levelTwo = new Position(levelOne.getRow() + rowOperator, levelOne.getColumn() + 2);
				if (canMove(new Position(levelTwo.getRow() + rowOperator, levelTwo.getColumn() - 2), -2, getColor())) {
					neP[2][2] = new Position(levelTwo.getRow() + rowOperator, levelTwo.getColumn() - 2);
					neOpponent[2][2] = new Position(levelTwo.getRow() + rowOpponent, levelTwo.getColumn() - 1);
					//mat[levelTwo.getRow() + rowOperator][levelTwo.getColumn() - 2] = true;
				}
				if (canMove(new Position(levelTwo.getRow() + rowOperator, levelTwo.getColumn() + 2), 2, getColor())) {
					neP[3][2] = new Position(levelTwo.getRow() + rowOperator, levelTwo.getColumn() + 2);
					neOpponent[3][2] = new Position(levelTwo.getRow() + rowOpponent, levelTwo.getColumn() + 1);
					//mat[levelTwo.getRow() + rowOperator][levelTwo.getColumn() + 2] = true;
				}
			}
		}
		// Diagonal Left
		if (canMove(new Position(pPieceNow.getRow() + rowOperator, pPieceNow.getColumn() - 2), -2, getColor())) {
			Position levelOne = new Position(pPieceNow.getRow() + rowOperator, pPieceNow.getColumn() - 2);
			nwP[0][0] = new Position(pPieceNow.getRow() + rowOperator, pPieceNow.getColumn() - 2);
			nwOpponent[0][0] = new Position(pPieceNow.getRow() + rowOpponent, pPieceNow.getColumn() - 1);
			nwP[1][0] = new Position(pPieceNow.getRow() + rowOperator, pPieceNow.getColumn() - 2);
			nwOpponent[1][0] = new Position(pPieceNow.getRow() + rowOpponent, pPieceNow.getColumn() - 1);
			nwP[2][0] = new Position(pPieceNow.getRow() + rowOperator, pPieceNow.getColumn() - 2);
			nwOpponent[2][0] = new Position(pPieceNow.getRow() + rowOpponent, pPieceNow.getColumn() - 1);
			nwP[3][0] = new Position(pPieceNow.getRow() + rowOperator, pPieceNow.getColumn() - 2);
			nwOpponent[3][0] = new Position(pPieceNow.getRow() + rowOpponent, pPieceNow.getColumn() - 1);
			//mat[pPieceNow.getRow() + rowOperator][pPieceNow.getColumn() - 2] = true;
			if (canMove(new Position(levelOne.getRow() + rowOperator, levelOne.getColumn() - 2), -2, getColor())) {
				nwP[0][1] = new Position(levelOne.getRow() + rowOperator, levelOne.getColumn() - 2);
				nwOpponent[0][1] = new Position(levelOne.getRow() + rowOpponent, levelOne.getColumn() - 1);
				nwP[1][1] = new Position(levelOne.getRow() + rowOperator, levelOne.getColumn() - 2);
				nwOpponent[1][1] = new Position(levelOne.getRow() + rowOpponent, levelOne.getColumn() - 1);
				//mat[levelOne.getRow() + rowOperator][levelOne.getColumn() - 2] = true;
				Position levelTwo = new Position(levelOne.getRow() + rowOperator, levelOne.getColumn() - 2);
				if (canMove(new Position(levelTwo.getRow() + rowOperator, levelTwo.getColumn() - 2), -2, getColor())) {
					nwP[0][2] = new Position(levelTwo.getRow() + rowOperator, levelTwo.getColumn() - 2);
					nwOpponent[0][2] = new Position(levelTwo.getRow() + rowOpponent, levelTwo.getColumn() - 1);
					//mat[levelTwo.getRow() + rowOperator][levelTwo.getColumn() - 2] = true;
				}
				if (canMove(new Position(levelTwo.getRow() + rowOperator, levelTwo.getColumn() + 2), 2, getColor())) {
					nwP[1][2] = new Position(levelTwo.getRow() + rowOperator, levelTwo.getColumn() + 2);
					nwOpponent[1][2] = new Position(levelTwo.getRow() + rowOpponent, levelTwo.getColumn() + 1);
					//mat[levelTwo.getRow() + rowOperator][levelTwo.getColumn() + 2] = true;
				}
			}
			if (canMove(new Position(levelOne.getRow() + rowOperator, levelOne.getColumn() + 2), 2, getColor())) {
				nwP[2][1] = new Position(levelOne.getRow() + rowOperator, levelOne.getColumn() + 2);
				nwOpponent[2][1] = new Position(levelOne.getRow() + rowOpponent, levelOne.getColumn() + 1);
				nwP[3][1] = new Position(levelOne.getRow() + rowOperator, levelOne.getColumn() + 2);
				nwOpponent[3][1] = new Position(levelOne.getRow() + rowOpponent, levelOne.getColumn() + 1);
				//mat[levelOne.getRow() + rowOperator][levelOne.getColumn() + 2] = true;
				Position levelTwo = new Position(levelOne.getRow() + rowOperator, levelOne.getColumn() + 2);
				if (canMove(new Position(levelTwo.getRow() + rowOperator, levelTwo.getColumn() - 2), -2, getColor())) {
					nwP[2][2] = new Position(levelTwo.getRow() + rowOperator, levelTwo.getColumn() - 2);
					nwOpponent[2][2] = new Position(levelTwo.getRow() + rowOpponent, levelTwo.getColumn() - 1);
					//mat[levelTwo.getRow() + rowOperator][levelTwo.getColumn() - 2] = true;
				}
				if (canMove(new Position(levelTwo.getRow() + rowOperator, levelTwo.getColumn() + 2), 2, getColor())) {
					nwP[3][2] = new Position(levelTwo.getRow() + rowOperator, levelTwo.getColumn() + 2);
					nwOpponent[3][2] = new Position(levelTwo.getRow() + rowOpponent, levelTwo.getColumn() + 1);
					//mat[levelTwo.getRow() + rowOperator][levelTwo.getColumn() + 2] = true;
				}
			}
		}
		//Retornar última posição possível de movimento dado uma sequência de Position
		int biggerCombination = 0;
		for (int column = 2; 0 <= column; column--) {
			for (int row = 0; row < 4; row++) {
				if (neP[row][column] != null) {
					if(biggerCombination < column) {
						biggerCombination = column;
					}
					if(biggerCombination == column) {
						mat[neP[row][column].getRow()][neP[row][column].getColumn()] = neP[row][column];
					}
				}			
			}
		}
		biggerCombination = 0;
		for (int column = 2; 0 <= column; column--) {
			for (int row = 0; row < 4; row++) {
				if (nwP[row][column] != null) {
					if(biggerCombination < column) {
						biggerCombination = column;
					}
					if(biggerCombination == column) {
						mat[nwP[row][column].getRow()][nwP[row][column].getColumn()] = nwP[row][column];
					}
				}			
			}
		}
		//Retornar sequência de Position de peças adversárias dada uma posição de movimento
		Position opponentCaptured[][] = new Position[getBoard().getRow()][getBoard().getColumn()];
		if(value == 2) {
			for(int j = 2; 0 <= j ;j--) {
				for (int i = 0; i < 4 ;i++) {
					if(neP[i][j] != null) {
						if(neP[i][j].getRow() == possibleMove.getRow() 
								&& neP[i][j].getColumn() == possibleMove.getColumn()) {
							for(int p = j; 0 <= p; p--) {
								opponentCaptured[neOpponent[i][p].getRow()][neOpponent[i][p].getColumn()] = neOpponent[i][p];
							}
						}
					}
					if(nwP[i][j] != null) {
						if(nwP[i][j].getRow() == possibleMove.getRow() 
								&& nwP[i][j].getColumn() == possibleMove.getColumn()) {
							for(int p = j; 0 <= p; p--) {
								opponentCaptured[nwOpponent[i][p].getRow()][nwOpponent[i][p].getColumn()] = nwOpponent[i][p];
							}
						}
					}
				}
			}
			return opponentCaptured;
		}

		return mat;
	}

	@Override
	public String toString() {
		return "P";
	}
}
