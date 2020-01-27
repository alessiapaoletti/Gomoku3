package Model.Rules.Opening;


public class StandardOpening extends Opening {

    StandardOpening(){
        this.numMoves = 2;
    }

    @Override
    public void toDoOpening( int numClicks){
        if (numClicks == 2) checkError();
    }


}
