package ViewCL.Alert;

import ViewCL.Alert.AlertGenerator;

import java.util.Scanner;

public class AlertSwap extends AlertGenerator {
/*
    private  Alert generateAlert(String title, String textContent){
        Alert alert = super.createConfirmationAlert(title, textContent);
        alert.showAndWait();
        return alert;
    }*/

    public  String swapAlert(){
        System.out.println(ANSI_RED+"White player, do you want to Swap ?"+"\n"+ "(answer YES/NO)"+ANSI_RESET);
        return new Scanner(System.in).next();
    }

    public  String swap2Alert(){
        System.out.println(ANSI_RED+"White player, do you want to stay white?"+"\n"+
                "If yes, put 4th stone, otherwise puts two more stones"+"\n"+ "and after that lets your opponent to choose the colour."
                +"\n"+ "(answer YES/NO)"+ANSI_RESET);
        return new Scanner(System.in).next();
    }

    public  void swap2Alert2(){
        System.out.println(ANSI_RED+"white player insert 2 more stones (1 black and 1 white)"+ANSI_RESET);
    }

    public  String swap2_1Alert(){
        System.out.println(ANSI_RED+"Black player, you want to Swap ?"+"\n"+ "(answer YES/NO)"+ANSI_RESET);
        return new Scanner(System.in).next();
    }


}
