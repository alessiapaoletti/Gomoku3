package View.Alert;

import Model.GomokuGame.GomokuType;
import Model.Rules.Opening.OpeningType;
import java.util.ArrayList;
import java.util.List;

public class AlertLogin extends AlertGenerator {

    private List<GomokuType> gomokuTypes = new ArrayList<>();
    private List <OpeningType> openingTypes = new ArrayList<>();

    public AlertLogin(){
        this.fillGomokuTypes();
        this.fillOpeningTypes();
    }

    private void fillGomokuTypes(){
        this.gomokuTypes.add(GomokuType.Standard);
        this.gomokuTypes.add(GomokuType.Omok);
        this.gomokuTypes.add(GomokuType.Freestyle);
    }

    private void fillOpeningTypes(){
        this.openingTypes.add(OpeningType.Standard);
        this.openingTypes.add(OpeningType.Swap);
        this.openingTypes.add(OpeningType.Swap2);
    }

    public  void loginAlert(){
        System.out.println(ANSI_RED + "invalid selected type!" + ANSI_RESET);
    }

    public void welcomePrint(){
        System.out.println(ANSI_PURPLE + STAR +" WELCOME IN GOMOKU "+ STAR + ANSI_RESET);
        System.out.println(ANSI_PURPLE+STAR +"   Game Setting  "+ STAR + ANSI_RESET);
    }

    public void setBlackPlayer(){
        System.out.println("Black Player Name: ");
    }

    public void setWhitePlayer(){
        System.out.println("White Player Name: ");
    }

    public void setOpening(){
        System.out.println("Choose your favorite Opening Rule between: ");
        openingTypes.forEach(System.out::println);
    }

    public void setGame(){
        System.out.println("Choose your favorite version of Gomoku between: ");
        gomokuTypes.forEach(System.out::println);
    }

}
