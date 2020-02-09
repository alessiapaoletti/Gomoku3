package Model.Rules.Opening;

import java.util.HashMap;
import java.util.Map;

public class OpeningFactory {

    private  Map<OpeningType, Opening> openingMap = new HashMap<>();

    public OpeningFactory(){
        this.openingMap.put(OpeningType.Standard, new StandardOpening());
        this.openingMap.put(OpeningType.Swap, new SwapOpening());
        this.openingMap.put(OpeningType.Swap2, new Swap2Opening());
    }

    public  Opening getOpening(OpeningType opening) { return openingMap.get(opening); }
}
