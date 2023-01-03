package dama;

import java.util.ArrayList;
import java.util.List;

import boardgame.Board;
import boardgame.Position;
import dama.pieces.Pawn;

public class DamaMatch {
	private Board board;
	
	List<DamaPiece> piecesOnTheBoard = new ArrayList<>();
	List<DamaPiece> piecesCaptured = new ArrayList<>();
	
	public DamaMatch() {
		board = new Board(8, 8);
		initialSetup();
	}
	
	public DamaPiece[][] getPieces(){
		DamaPiece[][] p = new DamaPiece[board.getRow()][board.getColumn()];
		for(int l=0; l<p.length; l++) {
			for(int c=0; c<p.length; c++) {
				p[l][c] = (DamaPiece) board.piece(l, c);
			}
		}
		return p;
	}
	
	private void placeNewPieceDama(char column, int row, DamaPiece piece) {
		//DamaPosition dP = new DamaPosition(column, row);
		//if(!board.positionExists(dP.toPosition())){
		//	throw new DamaException("A posicao não existe no tabuleiro: " + dP);
		//}
		//board.placePieceBoard(piece, dP.toPosition());
		board.placePieceBoard(piece, new DamaPosition(column, row).toPosition());
		piecesOnTheBoard.add(piece);
	}
	
	private void initialSetup() {
		placeNewPieceDama('f', 8, new Pawn(board, Color.WHITE));
		placeNewPieceDama('f', 7, new Pawn(board, Color.WHITE));
	}
}
