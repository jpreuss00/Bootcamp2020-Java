package Bootcamp2020.Java.Web;

import Bootcamp2020.Java.Database.InsertInDB;
import Bootcamp2020.Java.GameList.GameManager;
import Bootcamp2020.Java.RockPaperScissors;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;

public class Webserver {

    private final RockPaperScissors rockPaperScissors;
    private final InsertInDB insertInDB;
    private final CorsHandler corsHandler;
    private final GameManager gameManager;

    public Webserver(RockPaperScissors rockPaperScissors, InsertInDB insertInDB, CorsHandler corsHandler, GameManager gameManager) {
        this.rockPaperScissors = rockPaperScissors;
        this.insertInDB = insertInDB;
        this.corsHandler = corsHandler;
        this.gameManager = gameManager;
    }

    public void startJetty() throws Exception {

        final ContextHandler rps = new ContextHandler("/rps");
        final ContextHandler rpsList = new ContextHandler("/rpsList");

        rps.setAllowNullPathInfo(true);
        rpsList.setAllowNullPathInfo(true);

        rps.setHandler(new RPSEndpoint(rockPaperScissors, insertInDB, corsHandler));
        rpsList.setHandler((new RPSListEndpoint(rockPaperScissors, gameManager, corsHandler)));

        ContextHandlerCollection contexts = new ContextHandlerCollection(rps, rpsList);

        String port = System.getenv("PORT");

        if (port == null) {
            port = "8080";
        }

        final Server server = new Server(Integer.parseInt(port));

        server.setHandler(contexts);
        server.start();
        server.join();
    }
}