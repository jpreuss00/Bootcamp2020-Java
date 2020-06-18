package Bootcamp2020.Java.Web;

import Bootcamp2020.Java.RockPaperScissors;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.json.JSONObject;

public class RPSEndpoint extends AbstractHandler {

    private CorsHandler corsHandler;
    private RockPaperScissors rockPaperScissors;

    public RPSEndpoint(RockPaperScissors rockPaperScissors, CorsHandler corsHandler){
        this.corsHandler = corsHandler;
        this.rockPaperScissors = rockPaperScissors;
    }

    @Override
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException {
        corsHandler.handleCors(request, response);

        String decisionPlayer1 = null;
        String decisionPlayer2 = null;

        if (request.getParameter("decisionPlayer1") != null) {
            decisionPlayer1 = request.getParameter("decisionPlayer1");
        }
        if (request.getParameter("decisionPlayer2") != null) {
            decisionPlayer2 = request.getParameter("decisionPlayer2");
        }

        if(decisionPlayer1 != null && decisionPlayer2 != null){
            String winner = rockPaperScissors.compareDecisions(decisionPlayer1, decisionPlayer2);
            JSONObject json = new JSONObject().put("Winner", winner);
            response.getWriter().print(json);
        } else {
            return;
        }
        baseRequest.setHandled(true);
    }

}
