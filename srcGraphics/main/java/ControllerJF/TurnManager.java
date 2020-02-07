package ControllerJF;

import Model.Rules.Opening.OpeningType;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class TurnManager{

    GameStatusController gameStatusController;

    TurnManager(GameStatusController gameStatusController){
        this.gameStatusController = gameStatusController;
    }

    public void turnManagerStd(final int totalMoves){ gameStatusController.swapColorTurn(); }

    void turnManagerSwap(final int totalMoves){ if (totalMoves >= 3) gameStatusController.swapColorTurn(); }

    void turnManagerSwap2(final int totalMoves){
        if(totalMoves >= 3) gameStatusController.swapColorTurn();

    }

    private static Map<OpeningType, Consumer<Integer>> turnManagerMap = new HashMap();

    {
        turnManagerMap.put(OpeningType.Standard, c ->turnManagerStd(c));
        turnManagerMap.put(OpeningType.Swap, c ->turnManagerSwap(c));
        turnManagerMap.put(OpeningType.Swap2, c -> turnManagerSwap2(c));
    }

    public static void getTurnManager(OpeningType openingType, final int totalMoves){
        turnManagerMap.get(openingType).accept(totalMoves);
    }

}
