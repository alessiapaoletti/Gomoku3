package Model.GomokuGame;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GomokuFactory {

    private static Map<GomokuType, GomokuGame> gomokuMap = new HashMap<>();

    static {
        gomokuMap.put(GomokuType.Standard, new GomokuStd());
        gomokuMap.put(GomokuType.Freestyle, new GomokuFree());
        gomokuMap.put(GomokuType.Omok, new GomokuOm());
    }

    public static Optional<GomokuGame> getGame(GomokuType game) { return Optional.ofNullable(gomokuMap.get(game)); }
}
