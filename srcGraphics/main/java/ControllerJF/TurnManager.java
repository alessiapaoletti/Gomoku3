package ControllerJF;

import Model.Rules.Opening.OpeningType;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

class TurnManager{

    private GameStatusController gameStatusController;

    TurnManager(GameStatusController gameStatusController){
        this.gameStatusController = gameStatusController;
    }

    private void turnManagerStd(final int totalMoves){ gameStatusController.swapColorTurn(); }

    private void turnManagerSwap(final int totalMoves){ if (totalMoves >= 3) gameStatusController.swapColorTurn(); }


    private static Map<OpeningType, Consumer<Integer>> turnManagerMap = new HashMap();

    {
        turnManagerMap.put(OpeningType.Standard, this::turnManagerStd);
        turnManagerMap.put(OpeningType.Swap, this::turnManagerSwap);
        turnManagerMap.put(OpeningType.Swap2, this::turnManagerSwap);
    }

    void getTurnManager(OpeningType openingType, final int totalMoves){
        turnManagerMap.get(openingType).accept(totalMoves);
    }

}
