package Model.Directions;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DirectionFactory {

    private static Map<String, Directions> DirectionMap = new HashMap<>();

    static {
        DirectionMap.put("Horizontal", new Horizontal());
        DirectionMap.put("HorizontalGap", new HorizontalGap());
        DirectionMap.put("Vertical", new Vertical());
        DirectionMap.put("VerticalGap", new VerticalGap());
        DirectionMap.put("Diagonal1", new Diagonal1());
        DirectionMap.put("Diagonal1Gap", new Diagonal1Gap());
        DirectionMap.put("Diagonal2", new Diagonal2());
        DirectionMap.put("Diagonal2Gap", new Diagonal2Gap());
    }

    public static Optional<Directions> getDir(String dir) { return Optional.ofNullable(DirectionMap.get(dir)); }
}