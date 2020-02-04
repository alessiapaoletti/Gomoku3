package ViewCL.Alert;

import Model.GomokuGame.GomokuType;
import Model.Rules.Opening.OpeningType;
import ViewCL.Alert.AlertGenerator;
import java.util.ArrayList;
import java.util.List;

public class AlertLogin extends AlertGenerator {

    private List<GomokuType> gomokuTypes =new ArrayList<GomokuType>();
    private List <OpeningType> openingTypes = new ArrayList<OpeningType>();

    public AlertLogin(){
        this.FillGomokuTypes();
        this.FillOpeningTypes();
    };

    private void FillGomokuTypes(){
        this.gomokuTypes.add(GomokuType.Standard);
        this.gomokuTypes.add(GomokuType.Omok);
        this.gomokuTypes.add(GomokuType.Freestyle);
    };

    private void FillOpeningTypes(){
        this.openingTypes.add(OpeningType.Standard);
        this.openingTypes.add(OpeningType.Swap);
        this.openingTypes.add(OpeningType.Swap2);
    };

    public  void loginAlert(){
        System.out.println(ANSI_RED+"invalid selected type!"+ANSI_RESET);
    }

    public void Welcome(){
        System.out.println(ANSI_PURPLE+STAR+" WELCOME IN GOMOKU "+STAR+ANSI_RESET);
        System.out.println(ANSI_PURPLE+STAR+"   Game Setting  "+STAR+ANSI_RESET);
    }

    public void SetBlackPlayer(){
        System.out.println("Black Player Name: ");
    };

    public void SetWhitePlayer(){
        System.out.println("White Player Name: ");
    };

    public void SetOpening(){
        System.out.println("Choose your favorite Opening Rule between: ");
        openingTypes.forEach(i->System.out.println(i));
    };

    public void SetGame(){
        System.out.println("Choose your favorite version of Gomoku between: ");
        gomokuTypes.forEach(i->System.out.println(i));
    };

}
