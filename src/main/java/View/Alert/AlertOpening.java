package View.Alert;

import Model.Rules.Opening.*;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.control.Alert;
import java.lang.reflect.Method;

public class AlertOpening extends AlertGenerator{

    public static void stdOpeningRulesAlert(){
        Alert alert = createInformationAlert("Standard opening - Rules", "Black player starts and insert 1 stones followed by white player. Stones can be placed anywhere.");
        alert.showAndWait();
    }

    public static void swapOpeningRulesAlert(){
        javafx.scene.control.Alert alert = createInformationAlert("Swap opening - Rules", "Black player places 3 stones: 2 black and 1 white. White player can decide to swap color or stay white.");
        alert.showAndWait();
    }

    public static void swap2OpeningRulesAlert(){
        Alert alert = createInformationAlert("Swap2 opening - Rules", "Black player places 3 stones: 2 black and 1 white. White player can decide to swap color, stay white, or place other 2 stones (1 black and 1 white) and let the black player decide the wanted color.");
        alert.setHeight(200);
        alert.showAndWait();
    }

    private static Map<OpeningType, Method> alertOpeningMap = new HashMap<>();

    static {
        try {
            alertOpeningMap.put(OpeningType.Standard, AlertOpening.class.getMethod("stdOpeningRulesAlert"));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            alertOpeningMap.put(OpeningType.Swap, AlertOpening.class.getMethod("swapOpeningRulesAlert"));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            alertOpeningMap.put(OpeningType.Swap2, AlertOpening.class.getMethod("swap2OpeningRulesAlert"));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static void getAlertOpening(OpeningType opening) throws InvocationTargetException, IllegalAccessException { alertOpeningMap.get(opening).invoke(null); }
}
