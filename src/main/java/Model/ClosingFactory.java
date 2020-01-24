package Model;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

class ClosingFactory {

//    private static BoardLogic board;
//
//    ClosingFactory(BoardLogic b){
//        board = b;
//    }

    private static Map<String, Closing> closingMap = new HashMap<>();

    static {
        closingMap.put("Standard", new NoOverlines());
        closingMap.put("Freestyle", new Overlines());
        closingMap.put("Omok", new NoOverlines());
    }

    //public static Consumer<BoardLogic> getClosing(String closing) { return closingMap.get(closing); }

    public static Optional<Closing> getClosing(String closing) {
        return Optional.ofNullable(closingMap.get(closing));
    }
}
