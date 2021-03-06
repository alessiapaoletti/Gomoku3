package View.Alert;

import Controller.GameScanner;

import java.util.Scanner;

public class AlertSwap implements AlertGenerator {

    boolean checkYesNoAnswer(String answer){
        return (answer.equals("YES") || answer.equals("NO"));
    }

    boolean checkSwap2Answer(String answer){
        return (answer.equals("1") || answer.equals("2") || answer.equals("3")) ;
    }

    String generateYesNoAlert(String textContent){
        String answer;
        do {
            System.out.println(ANSI_RED + textContent+ ANSI_RESET);
            answer = GameScanner.scanner.next();
        } while(!this.checkYesNoAnswer(answer));
        return answer;
    }

    String generateSwapAlert(String textContent){
        String answer;
        do{
            System.out.println(ANSI_RED + textContent+ ANSI_RESET);
            answer = GameScanner.scanner.next();
        } while(!this.checkSwap2Answer(answer));
        return answer;
    }

    public  String swapAlert(String playerName){
        return this.generateYesNoAlert( playerName+ ", do you want to Swap ?" +
                "\nThe player will then proceed placing 1 stone each." + "\n(answer YES/NO)" );
    }

    public  String swap2Alert(String whitePlayer){
        return this.generateSwapAlert(whitePlayer + ", what do you want to do? \n \n " +
                "Option One: \n  Stay white and put the 4th stone \n \n" +
                "Option Two: \n  Swap and control the black stones \n \n" +
                "Option Three: \n  Put two more stones (one black and one white) and pass the opportunity to choose color to the opponent\n\n" +
                "(answer 1/2/3)");
    }
}
