package View.Alert;

import java.util.Scanner;

public class AlertSwap extends AlertGenerator {

    boolean checkYesNoAnswer(String answer){
        return (answer.equals("YES") || answer.equals("NO"));
    }

    boolean checkSwap2Answer(String answer){
        return (answer.equals("1") || answer.equals("2") || answer.equals("3")) ;
    }

    String generateYesNoAlert(String textContent){
        Scanner scanner = new Scanner(System.in);
        String answer;
        do {
            System.out.println(ANSI_RED + textContent+ ANSI_RESET);
            answer = scanner.next();
        } while(!this.checkYesNoAnswer(answer));
        return answer;
    }

    String generateSwapAlert(String textContent){
        Scanner scanner = new Scanner(System.in);
        String answer;
        do{
            System.out.println(ANSI_RED + textContent+ ANSI_RESET);
            answer = scanner.next();
        } while(!this.checkSwap2Answer(answer));
        return answer;
    }

    public  String swapAlert(){
        return this.generateYesNoAlert("White player, do you want to Swap ?" + "\n" + "(answer YES/NO)" );
    }

    public  String swapBlack(){
        return this.generateYesNoAlert("Black player, do you want to Swap ?" + "\n" + "(answer YES/NO)" );
    }

    public  String swap2Alert(){
        return this.generateSwapAlert("WHITE player, what do you want to do? \n \n " +
                "Option One: \n  Stay white and put the 4th stone \n \n" +
                "Option Two: \n  Swap and control the black stones \n \n" +
                "Option Three: \n  Put two more stones (one black and one white) and pass the opportunity to choose color to the opponent\n\n" +
                "(answer 1/2/3)");
    }
}
