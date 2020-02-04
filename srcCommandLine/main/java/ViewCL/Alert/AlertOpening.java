package ViewCL.Alert;

import Model.Rules.Opening.OpeningType;
import ViewCL.Alert.AlertGenerator;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import java.lang.reflect.Method;

public class AlertOpening extends AlertGenerator{

    public AlertOpening(){ this.add();};

    public  String stdOpeningRulesAlert(){
        String rule=ANSI_PURPLE+"* Standard opening - Rules *"+"\n"+ANSI_PURPLE1+"Black player starts and insert 1 stones followed by white player."+"\n"+"Stones can be placed anywhere."+ANSI_RESET;
        return rule;

    }

    public  String swapOpeningRulesAlert(){
        String alert = ANSI_PURPLE+"* Swap opening - Rules *"+"\n"+ANSI_PURPLE1+"Black player places 3 stones: 2 black and 1 white."+"\n"+"White player can decide to swap color or stay white."+ANSI_RESET;
        return alert;
    }

    public  String swap2OpeningRulesAlert(){
        String alert = ANSI_PURPLE+"* Swap2 opening - Rules *"+"\n"+ ANSI_PURPLE1+"Black player places 3 stones: 2 black and 1 white."+"\n"+"White player can decide to swap color, stay white, or place other 2 stones (1 black and 1 white) " +"\n"+
                "and let the black player decide the wanted color."+ANSI_RESET;
        return alert;
    }

    private  Map<OpeningType, String> alertOpeningMap = new HashMap<>();

    private void add(){
        this.alertOpeningMap.put(OpeningType.Standard,this.stdOpeningRulesAlert());
        this.alertOpeningMap.put(OpeningType.Swap,this.swapOpeningRulesAlert());
        this.alertOpeningMap.put(OpeningType.Swap2,this.swap2OpeningRulesAlert());
    };

    public void getAlertOpening(OpeningType opening) {
        try {
            System.out.println(this.alertOpeningMap.get(opening));
        }catch (NullPointerException e){
            System.out.println(e.getCause());
        }
    }

}
