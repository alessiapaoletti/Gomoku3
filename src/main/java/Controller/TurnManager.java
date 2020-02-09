package Controller;

import Model.Rules.Opening.OpeningType;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class TurnManager {

    GameStatusController gameStatusController;

    TurnManager(GameStatusController gameStatusController){ this.gameStatusController = gameStatusController; }

    public void turnManagerSwap2(int totalMoves) {
        if(totalMoves >= 3) gameStatusController.swapColorTurn();
    }

    public void turnManagerStd(final int totalMoves) { gameStatusController.swapColorTurn(); }

    void turnManagerSwap(final int totalMoves){
        if (totalMoves >= 3) gameStatusController.swapColorTurn();
    }

    private  Map<OpeningType, Consumer<Integer>> turnManagerMap = new HashMap();

    {
        this.turnManagerMap.put(OpeningType.Standard, this::turnManagerStd);
        this.turnManagerMap.put(OpeningType.Swap, this::turnManagerSwap);
        this.turnManagerMap.put(OpeningType.Swap2, this::turnManagerSwap2);
    }

    public void getTurnManager(OpeningType openingType, final int totalMoves){
        this.turnManagerMap.get(openingType).accept(totalMoves);
    }
}
