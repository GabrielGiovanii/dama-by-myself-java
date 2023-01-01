package dama;

import java.util.ArrayList;
import java.util.List;

import boardgame.Board;
import boardgame.Position;
import dama.pieces.Pawn;

public class DamaMatch {
	private Board board;
	
	List<DamaPiece> piecesOnTheBoard = new ArrayList<>();
	
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
	
	private void placeNewPieceDama(DamaPiece piece, Position position) {
		board.placePieceBoard(piece, position);
		piecesOnTheBoard.add(piece);
	}
	
	private void initialSetup() {
		placeNewPieceDama(new Pawn(board,Color.WHITE), new Position(0, 7));
	}
}
