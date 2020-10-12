package Bootcamp2020.Java.GameList;

public class GameManager {

   GameList gameList = new GameList();

   public void createGame(int gameID){
      Game game = new Game(gameID);
      gameList.addToList(game);
   }

   public boolean isGameExisting(int gameID){
      return gameList.checkForGame(gameID);
   }

   public void addDecision(int gameID, String decision, int playerID){
      gameList.addDecision(gameID, decision, playerID);
   }

   public boolean deleteGame(int gameID){
      return gameList.removeFromList(gameID);
   }

   public boolean checkDecisionAmount(int gameID){
      return gameList.checkDecisionAmount(gameID);
   }

   public String[] getDecisions(int gameID){
      return gameList.getDecisions(gameID);
   }

   public boolean checkForRequestedAmount(int gameID){
      return gameList.checkRequestedAmount(gameID);
   }

   public void changeRequestedState(int gameID, int playerID){
      gameList.changeRequestedState(gameID, playerID);
   }

}
