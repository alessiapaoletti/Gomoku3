package Model.Directions;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DirectionFactory {

    private static Map<String, Directions> DirectionMap = new HashMap<>();

    static {
        DirectionMap.put("hor", new Horizontal());
        DirectionMap.put("horgap", new HorizontalGap());
        DirectionMap.put("ver", new Vertical());
        DirectionMap.put("vergap", new VerticalGap());
        DirectionMap.put("diag1", new Diagonal1());
        DirectionMap.put("diag1gap", new Diagonal1Gap());
        DirectionMap.put("diag2", new Diagonal2());
        DirectionMap.put("diag2gap", new Diagonal2Gap());
    }

    public static Optional<Directions> getDir(String dir) { return Optional.ofNullable(DirectionMap.get(dir)); }
}