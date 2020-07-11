package Bootcamp2020.Java.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InsertInDB {

    private final Connection connection;

    public InsertInDB(Connection connection){
        this.connection = connection;
    }

    public void insertDecisionInDB(int gameID, String decision, int playerID){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO GameChecker(gameID, decision, playerID) VALUES(?, ?, ?) ");
            preparedStatement.setInt(1, gameID);
            preparedStatement.setString(2, decision);
            preparedStatement.setInt(3, playerID);
            preparedStatement.executeUpdate();
        } catch (Exception e){
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public String[] getDecisions(int gameID){
        try{
            String[] decisions = new String[2];

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT decision FROM GameChecker WHERE gameID = ? AND playerID = 1");
            preparedStatement.setInt(1, gameID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                decisions[0] = resultSet.getString("decision");
            } else {
                return null;
            }

            preparedStatement = connection.prepareStatement("SELECT decision FROM GameChecker WHERE gameID = ? AND playerID = 2");
            preparedStatement.setInt(1, gameID);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                decisions[1] = resultSet.getString("decision");
            } else {
                return null;
            }

            return decisions;
        } catch (Exception e){
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return null;
    }

    public boolean checkForDecisionAmount(int gameID){
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM GameChecker WHERE gameID = ?");
            preparedStatement.setInt(1, gameID);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                if(resultSet.getInt(1) == 2){
                    return true;
                } else {
                    return false;
                }
            }
            return true;
        } catch (Exception e){
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
            return false;
        }
    }
}
