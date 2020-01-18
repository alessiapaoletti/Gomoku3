package Model;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class GomokuFactory {

    private static Map<String, GomokuGame> gomokuMap = new HashMap<>();

    static {
        gomokuMap.put("Standard", new GomokuStd());
        gomokuMap.put("Free", new GomokuFree());
        gomokuMap.put("Omok", new GomokuOm());
    }

    public static Optional<GomokuGame> getGame(String game) { return Optional.ofNullable(gomokuMap.get(game)); }
}
