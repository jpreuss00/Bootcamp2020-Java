package Bootcamp2020.Java;

import java.util.Random;

public class RockPaperScissors {

    public String compareDecisions(String decisionPlayer1, String decisionPlayer2){

        if(decisionPlayer1.equals(decisionPlayer2)){
            return "Unentschieden";
        }

        switch(decisionPlayer1){
            case "Schere":
                if (decisionPlayer2.equals("Papier")){
                    return "Spieler 1";
                } else {
                    return "Spieler 2";
                }
            case "Stein":
                if (decisionPlayer2.equals("Schere")){
                    return "Spieler 1";
                } else {
                    return "Spieler 2";
                }
            case "Papier":
                if (decisionPlayer2.equals("Stein")){
                    return "Spieler 1";
                } else {
                    return "Spieler 2";
                }
            default:
                return "Unentschieden";
        }
    }

    public String randomAnswer(){
        Random random = new Random();

        String[] answers = new String[]{"Schere", "Stein", "Papier"};

        return answers[random.nextInt(3)];
    }
}
