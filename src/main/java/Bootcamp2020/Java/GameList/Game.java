package Bootcamp2020.Java.GameList;

public class Game {

    private int gameID;
    private String decisionP1;
    private String decisionP2;
    private boolean requestedP1 = false;
    private boolean requestedP2 = false;

    public Game(int gameID) {
        this.gameID = gameID;
    }

    public int getGameID() {
        return gameID;
    }

    public void setDecision(String decision, int playerID) {
        if (playerID == 1) {
            this.decisionP1 = decision;
        } else {
            this.decisionP2 = decision;
        }
    }

    public String getDecision(int playerID) {
        if (playerID == 1) {
            return decisionP1;
        }
        return decisionP2;
    }

    public void setRequested(boolean requested, int playerID) {
        if (playerID == 1) {
            this.requestedP1 = requested;
        } else {
            this.requestedP2 = requested;
        }
    }

    public boolean getRequested(int playerID) {
        if (playerID == 1) {
            return requestedP1;
        }
        return requestedP2;

    }
}