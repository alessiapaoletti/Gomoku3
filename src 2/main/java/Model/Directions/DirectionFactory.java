package Model.Directions;

import java.util.HashMap;
import java.util.Map;

public class DirectionFactory {

    private  Map<Directions.Dir, Directions> DirectionMap = new HashMap<>();

    public DirectionFactory(){
        this.DirectionMap.put(Directions.Dir.HORIZONTAL, new Horizontal());
        this.DirectionMap.put(Directions.Dir.VERTICAL, new Vertical());
        this.DirectionMap.put(Directions.Dir.DIAGONAL1, new Diagonal1());
        this.DirectionMap.put(Directions.Dir.DIAGONAL2, new Diagonal2());
    }

    public Directions getDir(Directions.Dir dir) { return DirectionMap.get(dir); }
}