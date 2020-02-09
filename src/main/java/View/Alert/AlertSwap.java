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
        do{
            System.out.println(ANSI_RED + textContent+ ANSI_RESET+"\r");
            answer = scanner.next();
        }
        while(!this.checkYesNoAnswer(answer));
        return answer;
    }

    String generateSwapAlert(String textContent){
        Scanner scanner = new Scanner(System.in);
        String answer;
        do{
            System.out.println(ANSI_RED + textContent+ ANSI_RESET+"\r");
            answer = scanner.next();
        }
        while(!this.checkSwap2Answer(answer));
        return answer;
    }

    public  String swapAlert(){
        return this.generateYesNoAlert("White player, do you want to Swap ?" + "\r\n" + "(answer YES/NO)" );
    }

    public  String swapBlack(){
        return this.generateYesNoAlert("Black player, do you want to Swap ?" + "\r\n" + "(answer YES/NO)" );
    }


//    public  String swap2Alert(){
//        return this.generateAlert("White player, do you want to stay white?"+"\n"+
//                "If yes, put 4th stone, otherwise puts two more stones"+"\n"+ "and after that lets your opponent to choose the colour."
//                +"\n"+ "(answer YES/NO)");
//    }

    public  String swap2Alert(){
        return this.generateSwapAlert("WHITE player, what do you want to do? \r\n \r\n " +
                "Option One: \r\n  Stay white and put the 4th stone \r\n \r\n" +
                "Option Two: \r\n  Swap and control the black stones \r\n \r\n" +
                "Option Three: \r\n  Put two more stones (one black and one white) and pass the opportunity to choose color to the opponent\r\n\r\n" +
                "(answer 1/2/3)");
        //System.out.println(ANSI_RED+"white player insert 2 more stones (1 black and 1 white)"+ANSI_RESET);
    }

//    public  String swap2_1Alert(){
//        return this.generateAlert("Black player, you want to Swap ?"+"\n"+ "(answer YES/NO)");
//    }


}
