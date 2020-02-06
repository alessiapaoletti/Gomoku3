package View.Alert;

import java.util.Scanner;

public class AlertSwap extends AlertGenerator {

    private boolean checkYesNoAnswer(String answ){
        return (answ.equals("YES") || answ.equals("NO"));
    }

    private boolean checkSwap2Answer(String answ){
        return (answ.equals("1") || answ.equals("2") || answ.equals("3")) ;
    }


    private  String generateYesNoAlert(String textContent){
        Scanner scanner = new Scanner(System.in);
        String answer;
        do{
            System.out.println(ANSI_RED + textContent+ ANSI_RESET);
            answer = scanner.next();
        }
        while(!this.checkYesNoAnswer(answer));
        return answer;
    }

    private  String generateSwapAlert(String textContent){
        Scanner scanner = new Scanner(System.in);
        String answer;
        do{
            System.out.println(ANSI_RED + textContent+ ANSI_RESET);
            answer = scanner.next();
        }
        while(!this.checkSwap2Answer(answer));
        return answer;
    }

    public  String swapAlert(){
        return this.generateYesNoAlert("White player, do you want to Swap ?" + "\n" + "(answer YES/NO)" );
    }

    public  String swapBlack(){
        return this.generateYesNoAlert("Black player, do you want to Swap ?" + "\n" + "(answer YES/NO)" );
    }


//    public  String swap2Alert(){
//        return this.generateAlert("White player, do you want to stay white?"+"\n"+
//                "If yes, put 4th stone, otherwise puts two more stones"+"\n"+ "and after that lets your opponent to choose the colour."
//                +"\n"+ "(answer YES/NO)");
//    }

    public  String swap2Alert(){
        return this.generateSwapAlert("WHITE player, what do you want to do? \n \n " +
                "Option One: \n  Stay white and put the 4th stone \n \n" +
                "Option Two: \n  Swap and control the black stones \n \n" +
                "Option Three: \n  Put two more stones (one black and one white) and pass the opportunity to choose color to the opponent\n\n" +
                "(answer 1/2/3)");
        //System.out.println(ANSI_RED+"white player insert 2 more stones (1 black and 1 white)"+ANSI_RESET);
    }

//    public  String swap2_1Alert(){
//        return this.generateAlert("Black player, you want to Swap ?"+"\n"+ "(answer YES/NO)");
//    }


}
