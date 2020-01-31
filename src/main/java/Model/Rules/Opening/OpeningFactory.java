package Model.Rules.Opening;

import java.util.HashMap;
import java.util.Map;

public class OpeningFactory {

    private static Map<OpeningType, Opening> openingMap = new HashMap<>();

    static {
        openingMap.put(OpeningType.Standard, new StandardOpening());
        openingMap.put(OpeningType.Swap, new SwapOpening());
        openingMap.put(OpeningType.Swap2, new Swap2Opening());
    }

    public static Opening getOpening(OpeningType opening) { return openingMap.get(opening); }
}
