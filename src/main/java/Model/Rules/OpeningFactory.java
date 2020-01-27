package Model.Rules;

import java.util.HashMap;
import java.util.Map;

public class OpeningFactory {
    private static Map<String, Opening> openingMap = new HashMap<>();

    static {
        openingMap.put("Standard", new StandardOpening());
        openingMap.put("Swap", new SwapOpening());
        openingMap.put("Swap2", new Swap2Opening());
    }

    public static Opening getOpening(String opening) { return openingMap.get(opening); }
}
