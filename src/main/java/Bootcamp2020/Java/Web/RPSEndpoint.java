package Bootcamp2020.Java.Web;

import Bootcamp2020.Java.Database.InsertInDB;
import Bootcamp2020.Java.RockPaperScissors;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.json.JSONObject;

public class RPSEndpoint extends AbstractHandler {

    private RockPaperScissors rockPaperScissors;
    private InsertInDB insertInDB;
    private CorsHandler corsHandler;

    public RPSEndpoint(RockPaperScissors rockPaperScissors, InsertInDB insertInDB, CorsHandler corsHandler){
        this.insertInDB = insertInDB;
        this.rockPaperScissors = rockPaperScissors;
        this.corsHandler = corsHandler;
    }

    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException {
        corsHandler.handleCors(request, response);

        String decisionPlayer1 = null;
        String decisionPlayer2;
        String winner = null;
        String decision = null;
        int gameID = 0;
        int playerID = 0;
        int requestCheck = 0;

        if (request.getParameter("decisionPlayer1") != null) {
            decisionPlayer1 = request.getParameter("decisionPlayer1");
        }
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

        if(decision != null && gameID != 0 && playerID != 0){
            insertInDB.insertDecisionInDB(gameID, decision, playerID);
        } else if (decisionPlayer1 != null) {
            winner = rockPaperScissors.compareDecisions(decisionPlayer1, rockPaperScissors.randomAnswer());
        }

        if(requestCheck != 0){
            if(insertInDB.checkForDecisionAmount(gameID)){
                String[] decisions = insertInDB.getDecisions(gameID);
                decisionPlayer1 = decisions[0];
                decisionPlayer2 = decisions[1];
                winner = rockPaperScissors.compareDecisions(decisionPlayer1, decisionPlayer2);
                response.setStatus(200);
            } else {
                response.setStatus(400);
            }
        }

        JSONObject json = new JSONObject().put("Winner", winner);
        response.getWriter().print(json);

        baseRequest.setHandled(true);
    }
}