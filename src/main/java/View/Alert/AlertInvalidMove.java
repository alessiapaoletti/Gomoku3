package View.Alert;

public class AlertInvalidMove extends AlertGenerator {

    public  void invalidMoveAlert(){
        System.out.println(ANSI_RED+"ERROR -Invalid Move "+ANSI_RESET+new String(Character.toChars(0x1F6AB)));
    }

    public  void invalidCoordinateAlert(String dim){
        System.out.println(ANSI_RED+"ERROR -Invalid Coordinate "+"\n"+"(Insert a couple of numbers in range [0,"+dim+"],not already on the board)"+ANSI_RESET+new String(Character.toChars(0x1F6AB)));
    }

}
