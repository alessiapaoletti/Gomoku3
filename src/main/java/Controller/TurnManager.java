package Controller;

import Model.Rules.Opening.OpeningType;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class TurnManager {

    GameStatusController gameStatusController;

    TurnManager(GameStatusController gameStatusController){
        this.gameStatusController = gameStatusController;
    }

    public void turnManagerSwap2(int totalMoves) {
        if(totalMoves >= 3) gameStatusController.swapColorTurn();
    }

    public void turnManagerStd(final int totalMoves) { gameStatusController.swapColorTurn(); }

    void turnManagerSwap(final int totalMoves){
        if (totalMoves >= 3) gameStatusController.swapColorTurn();
    }

    private static Map<OpeningType, Consumer<Integer>> turnManagerMap = new HashMap();

    {
        turnManagerMap.put(OpeningType.Standard, this::turnManagerStd);
        turnManagerMap.put(OpeningType.Swap, this::turnManagerSwap);
        turnManagerMap.put(OpeningType.Swap2, this::turnManagerSwap2);
    }

    public static void getTurnManager(OpeningType openingType, final int totalMoves){
        turnManagerMap.get(openingType).accept(totalMoves);
    }
}
