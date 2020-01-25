package Model.Directions;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class DirectionFactory {

    private static Map<Directions.Dir, Directions> DirectionMap = new HashMap<>();

    static {
        DirectionMap.put(Directions.Dir.HORIZONTAL, new Horizontal());
        DirectionMap.put(Directions.Dir.VERTICAL, new Vertical());
        DirectionMap.put(Directions.Dir.DIAGONAL1, new Diagonal1());
        DirectionMap.put(Directions.Dir.DIAGONAL2, new Diagonal2());
    }

    public static Optional<Directions> getDir(Directions.Dir dir) { return Optional.ofNullable(DirectionMap.get(dir)); }
}