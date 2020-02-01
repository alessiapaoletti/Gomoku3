package Model.HotFormations;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ThreeFactory {

    private static Map<Three.ThreeTypes, Three> TType = new HashMap<>();

    static {
        TType.put(Three.ThreeTypes.GAPTHREE, new GapThree());
        TType.put(Three.ThreeTypes.THREE, new SimpleThree());
    }

    public static Three getThree(Three.ThreeTypes three) { return TType.get(three); }
}
