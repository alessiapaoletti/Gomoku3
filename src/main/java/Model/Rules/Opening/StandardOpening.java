package Model.Rules.Opening;

public class StandardOpening extends Opening {

    StandardOpening(){
        this.openingType = OpeningType.Standard;
        this.numMoves = 2;
    }

    @Override
    public boolean userInteraction(){return false;};
    @Override
    public void openingBehaviour(){}
}
