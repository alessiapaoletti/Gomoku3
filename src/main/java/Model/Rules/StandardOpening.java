package Model.Rules;

import Model.Player;

public class StandardOpening extends Opening {

    public StandardOpening(){
        this.numMoves = 2;
    }

    @Override
    public void toDoOpening( int c){
        System.out.println("Standard");
        if (c == 2) checkError();
    }


}
