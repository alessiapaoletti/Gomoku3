package Model;

import ControllerJF.GameStatusController;
import Model.Rules.Opening.OpeningType;


public class TurnManager {

    public static void turnManager(final OpeningType openingType, final int totalMoves){
        if(openingType.equals(OpeningType.Swap)){
            if (totalMoves > 3) GameStatusController.swapColorTurn();
        }
        else if (openingType.equals(OpeningType.Swap2)){
            if (totalMoves == 3) GameStatusController.swapColorTurn();
            else if (totalMoves > 4) GameStatusController.swapColorTurn();
        }
        else if (openingType.equals(OpeningType.Standard)) GameStatusController.swapColorTurn();
    }

}
