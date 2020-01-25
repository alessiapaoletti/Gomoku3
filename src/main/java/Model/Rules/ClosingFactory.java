package Model.Rules;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ClosingFactory {

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
