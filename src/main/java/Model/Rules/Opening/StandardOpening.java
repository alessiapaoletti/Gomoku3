package Model.Rules.Opening;

public class StandardOpening extends Opening {

    StandardOpening(){
        this.openingType = OpeningType.Standard;
        this.numMoves = 2;
        this.numUserInteraction=0;
    }

    @Override
    public void openingBehaviour(){}
}
