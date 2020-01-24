package Model.Directions;

public class TandTRule {
//    //check gap
//    //il check gap non serve mi basta sapere la shape dell'intervallo che vado a considerare ha asse di simmetria
//    // nell'ultima pedina che vado a considerare
//    //due metodi che sovrascrivo uno col gap e uno senza (cambio il range di pedine che verifico per ogni direzione
//    //con gap ho range di 5, senza gap ho range di 5 o 6)
//    //per avere un tre ho bisogno di esattamente 2 nere e le altre libere ovviamente stando nella board
//    // devo settare le dimensioni massime della board in modo tale di evitare di uscirne
//    //questo metodo lo posso mettere nella board
//    private boolean inBounds(int index) {
//        return index >= 0 && index < size;
//    }
//
//    private int countConsecutiveStonesOfAColor(int row, int col, int rowIncrement,
//                                       int colIncrement,  Piece.PiceType p) {
//        int count = 0;
//        int color = board[row][col].getcolor();
//        for(int i = 1; i <= 4; i++) {
//            if(inBounds(row + (rowIncrement*i)) && inBounds(col +
//                    (colIncrement*i))) {
//                if(board[row + (rowIncrement*i)][col + (colIncrement*i)].getcolor() ==
//                        color) {
//                    count++;
//                } else {
//                    break;
//                }
//            }
//        }
//        return count;
//    }
//
//    //questo metodo lo posso anche usare per le closing rules settando il numero numcolgiocatore)
//    private int counter (int range, int playerIndex, int numcolgiocatore) {
//        if(moves.size() < range) return 0;
//        Move lastMove = getLastMove();
//        int row = lastMove.row;
//        int col = lastMove.col;
//        if(board[row][col] == black) {
//            // Diagonal from the bottom left to the top right
//            if(countConsecutiveStones(row, col, 1, -1,black) +
//                    countConsecutiveStones(row, col, -1, 1,black) == numcolgiocatore &&
//            ) {
//                return 1;
//            }
//            // Diagonal from the top left to the bottom right
//            if(countConsecutiveStones(row, col, -1, -1) +
//                    countConsecutiveStones(row, col, 1, 1) == numcolgiocatore) {
//                return true;
//            }
//            // Horizontal
//            if(countConsecutiveStones(row, col, 0, 1) +
//                    countConsecutiveStones(row, col, 0, -1) == numcolgiocatore) {
//                return true;
//            }
//            // Vertical
//            if(countConsecutiveStones(row, col, 1, 0) +
//                    countConsecutiveStones(row, col, -1, 0) == numcolgiocatore) {
//                return true;
//            }
//        }
//        return false;
//    }
}
