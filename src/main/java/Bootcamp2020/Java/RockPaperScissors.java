package Bootcamp2020.Java;

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
}
