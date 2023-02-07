package dama;

import java.util.ArrayList;
import java.util.List;

import boardgame.Board;
import boardgame.Position;
import dama.pieces.Pawn;

public class DamaMatch {
	private Board board;
	private Color currentPlayer;
	private int turn;
	
	List<DamaPiece> piecesOnTheBoard = new ArrayList<>();
	List<DamaPiece> piecesCaptured = new ArrayList<>();
	
	public DamaMatch() {
		board = new Board(8, 8);
		initialSetup();
		currentPlayer = Color.WHITE;
		turn = 1;
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
	
	public Color getCurrentPlayer() {
		return currentPlayer;
	}

	public int getTurn() {
		return turn;
	}
	
	public void increaseTurn() {
		turn++;
	}
	
	public void makeMove(DamaPosition source, DamaPosition target) {
		Position pSource = source.toPosition();
		if(!board.positionExists(pSource)){
			throw new DamaException("A posicao de origem nao existe, intervalo permitido: a1 a h8.");
		}
		if(!board.thereIsAPiece(pSource)) {
			throw new DamaException("Nao existe uma peca na posicao digitada.");
		}
		if(!board.piece(pSource).isThereAnyPossibleMove()) {
			throw new DamaException("Nao existe movimento possivel para peca escolhida.");
		}
		if(currentPlayer != ((DamaPiece)board.piece(pSource)).getColor()){
			throw new DamaException("A peca escolhida nao e sua.");
		}
		Position pTarget = target.toPosition();
	}
	
	public Position[][] possibleMoves(DamaPosition sourcePosition){
		Position p = sourcePosition.toPosition();
		return board.piece(p).possibleMoves(1, new Position(0, 0));
	}
	
	public Position[][] opponentCaptured(DamaPosition sourcePosition, Position targetPosition){
		Position p = sourcePosition.toPosition();
		return board.piece(p).possibleMoves(2, targetPosition);
	}
	
	private void placeNewPieceDama(char column, int row, DamaPiece piece) {
		//DamaPosition dP = new DamaPosition(column, row);
		//if(!board.positionExists(dP.toPosition())){
		//	throw new DamaException("A posicao n�o existe no tabuleiro: " + dP);
		//}
		//board.placePieceBoard(piece, dP.toPosition());
		board.placePieceBoard(piece, new DamaPosition(column, row).toPosition());
		piecesOnTheBoard.add(piece);
	}
	
	private void initialSetup() {
		placeNewPieceDama('h', 2, new Pawn(board, Color.WHITE));
		//placeNewPieceDama('d', 4, new Pawn(board, Color.WHITE));
		placeNewPieceDama('a', 3, new Pawn(board, Color.WHITE));
		
		//placeNewPieceDama('f', 6, new Pawn(board, Color.WHITE));
		//placeNewPieceDama('b', 8, new Pawn(board, Color.BLACK));
		placeNewPieceDama('c', 5, new Pawn(board, Color.BLACK));
		placeNewPieceDama('e', 3, new Pawn(board, Color.BLACK));
		placeNewPieceDama('c', 3, new Pawn(board, Color.BLACK));
		placeNewPieceDama('e', 5, new Pawn(board, Color.BLACK));
		placeNewPieceDama('c', 7, new Pawn(board, Color.BLACK));
		placeNewPieceDama('g', 7, new Pawn(board, Color.BLACK));
		placeNewPieceDama('e', 7, new Pawn(board, Color.BLACK));
		placeNewPieceDama('g', 5, new Pawn(board, Color.BLACK));
		placeNewPieceDama('g', 3, new Pawn(board, Color.BLACK));
	}
}
