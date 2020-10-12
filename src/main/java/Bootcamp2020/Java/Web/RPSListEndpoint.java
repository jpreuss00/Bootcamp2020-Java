package Bootcamp2020.Java.Web;

import Bootcamp2020.Java.GameList.GameManager;
import Bootcamp2020.Java.RockPaperScissors;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.json.JSONObject;

public class RPSListEndpoint extends AbstractHandler {

    private RockPaperScissors rockPaperScissors;
    private GameManager gameManager;
    private CorsHandler corsHandler;

    public RPSListEndpoint(RockPaperScissors rockPaperScissors, GameManager gameManager, CorsHandler corsHandler){
        this.gameManager = gameManager;
        this.rockPaperScissors = rockPaperScissors;
        this.corsHandler = corsHandler;
    }

    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException {
        corsHandler.handleCors(request, response);

        String decisionPlayer1 = null;
        String decisionPlayer2 = null;
        String winner = null;
        String decision = null;
        int gameID = 0;
        int playerID = 0;
        int requestCheck = 0;

        if (request.getParameter("decision") != null) {
            decision = request.getParameter("decision");
        }
        if (request.getParameter("gameID") != null) {
            gameID = Integer.parseInt(request.getParameter("gameID"));
        }
        if (request.getParameter("playerID") != null) {
            playerID = Integer.parseInt(request.getParameter("playerID"));
        }
        if (request.getParameter("requestCheck") != null) {
            requestCheck = Integer.parseInt(request.getParameter("requestCheck"));
        }

        if(gameID != 0 && decision != null){
            if(!gameManager.isGameExisting(gameID)){
                gameManager.createGame(gameID);
            }
            gameManager.addDecision(gameID, decision, playerID);
        }

        if(requestCheck != 0){
            if(gameManager.checkDecisionAmount(gameID)){
                String[] decisions = gameManager.getDecisions(gameID);
                decisionPlayer1 = decisions[1];
                decisionPlayer2 = decisions[2];
                winner = rockPaperScissors.compareDecisions(decisionPlayer1, decisionPlayer2);
                if(!gameManager.checkForRequestedAmount(gameID)){
                    gameManager.changeRequestedState(gameID, playerID);
                }
                if(gameManager.checkForRequestedAmount(gameID)){
                    gameManager.deleteGame(gameID);
                }
                response.setStatus(200);
            } else {
                response.setStatus(400);
            }
        }

        JSONObject json = new JSONObject();
        json.put("Winner", winner);
        json.put("Spieler1", decisionPlayer1);
        json.put("Spieler2", decisionPlayer2);
        response.getWriter().print(json);

        baseRequest.setHandled(true);
    }
}