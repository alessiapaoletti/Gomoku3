package Model.GomokuGame;

import java.util.HashMap;
import java.util.Map;

public class GomokuFactory {

    private  Map<GomokuType, GomokuGame> gomokuMap = new HashMap<>();

    public GomokuFactory(){
        this.gomokuMap.put(GomokuType.Standard, new GomokuStd());
        this.gomokuMap.put(GomokuType.Freestyle, new GomokuFree());
        this.gomokuMap.put(GomokuType.Omok, new GomokuOm());
    }

    public  GomokuGame getGame(GomokuType game) { return gomokuMap.get(game); }
}
