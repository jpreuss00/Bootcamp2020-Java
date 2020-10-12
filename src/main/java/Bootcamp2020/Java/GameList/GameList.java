package Bootcamp2020.Java.GameList;

import java.util.ArrayList;

public class GameList {

    ArrayList<Game> gameList = new ArrayList<>();

    public boolean addToList(Game game) {
        return gameList.add(game);
    }

    public boolean removeFromList(int gameID) {
        for (Game game : gameList) {
            if (game.getGameID() == gameID) {
                System.out.println(gameList);
                gameList.remove(game);
                System.out.println(gameList);
                return true;
            }
        }
        return false;
    }

    public boolean checkForGame(int gameID){
        for (Game game : gameList) {
            if (game.getGameID() == gameID) {
                return true;
            }
        }
        return false;
    }

    public void addDecision(int gameID, String decision, int playerID){
        for(Game game : gameList){
            if(game.getGameID() == gameID){
                game.setDecision(decision, playerID);
            }
        }
    }

    public boolean checkDecisionAmount(int gameID) {
        for(Game game : gameList){
            if(game.getGameID() == gameID){
                return (game.getDecision(1) != null && game.getDecision(2) != null);
            }
        }
        return false;
    }

    public String[] getDecisions(int gameID){
        for(Game game : gameList){
            if(game.getGameID() == gameID){
                return new String[] { game.getDecision(1), game.getDecision(2) };
            }
        }
        return null;
    }

    public boolean checkRequestedAmount(int gameID){
        for(Game game : gameList){
            if(game.getGameID() == gameID){
                return (game.getRequested(1) && game.getRequested(2));
            }
        }
        return false;
    }

    public void changeRequestedState(int gameID, int playerID){
        for(Game game : gameList){
            if(game.getGameID() == gameID){
                game.setRequested(true, playerID);
            }
        }
    }

}