package Model;

public class Overlines extends Closing {

//    @Override
//    public boolean isWinning(Piece piece) {
//        return checkCount(horizontalCheck(piece)) ||
//                checkCount(verticalCheck(piece)) ||
//                checkCount(diagonalCheck(piece, false)) ||
//                checkCount(diagonalCheck(piece, true));
//    }

    @Override
    public boolean checkCount(int count) {
        return count >= 5;
    }
}
