package ViewCL.Alert;

import ViewCL.Alert.AlertGenerator;

import java.util.Scanner;

public class AlertSwap extends AlertGenerator {

    private boolean checkAnswer(String answ){
        return (answ.equals("YES") || answ.equals("NO"));
    };

    private  String generateAlert(String textContent){
        Scanner scanner = new Scanner(System.in);
        String answer;
        do{
            System.out.println(ANSI_RED + textContent+ ANSI_RESET);
            answer = scanner.next();
        }
        while(!this.checkAnswer(answer));

        return answer;
    }

    public  String swapAlert(){
        return this.generateAlert("White player, do you want to Swap ?" + "\n" + "(answer YES/NO)" );
    }


    public  String swap2Alert(){
        return this.generateAlert("White player, do you want to stay white?"+"\n"+
                "If yes, put 4th stone, otherwise puts two more stones"+"\n"+ "and after that lets your opponent to choose the colour."
                +"\n"+ "(answer YES/NO)");
    }

    public  void swap2Alert2(){
        System.out.println(ANSI_RED+"white player insert 2 more stones (1 black and 1 white)"+ANSI_RESET);
    }

    public  String swap2_1Alert(){
        return this.generateAlert("Black player, you want to Swap ?"+"\n"+ "(answer YES/NO)");
    }


}
