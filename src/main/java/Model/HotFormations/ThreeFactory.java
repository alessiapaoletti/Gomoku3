package Model.HotFormations;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ThreeFactory {

    private  Map<Three.ThreeTypes, Three> TType = new HashMap<>();

    public ThreeFactory() {
        this.TType.put(Three.ThreeTypes.GAPTHREE, new GapThree());
        this.TType.put(Three.ThreeTypes.THREE, new SimpleThree());
    }

    public  Three getThree(Three.ThreeTypes three) { return TType.get(three); }
}
