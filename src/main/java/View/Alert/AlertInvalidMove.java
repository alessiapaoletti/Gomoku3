package View.Alert;

public class AlertInvalidMove extends AlertGenerator {
    public  void invalidMoveAlert(){
        System.out.println(ANSI_RED+"ERROR -Invalid Move "+ANSI_RESET+new String(Character.toChars(0x1F6AB)));
    }
}
