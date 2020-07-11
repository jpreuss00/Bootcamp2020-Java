package Bootcamp2020.Java.Web;

import Bootcamp2020.Java.Database.InsertInDB;
import Bootcamp2020.Java.RockPaperScissors;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;

public class Webserver {

    private final RockPaperScissors rockPaperScissors;
    private final InsertInDB insertInDB;
    private final CorsHandler corsHandler;

    public Webserver(RockPaperScissors rockPaperScissors, InsertInDB insertInDB, CorsHandler corsHandler) {
        this.rockPaperScissors = rockPaperScissors;
        this.insertInDB = insertInDB;
        this.corsHandler = corsHandler;
    }

    public void startJetty() throws Exception {

        final ContextHandler rps = new ContextHandler("/rps");

        rps.setAllowNullPathInfo(true);

        rps.setHandler(new RPSEndpoint(rockPaperScissors, insertInDB, corsHandler));

        ContextHandlerCollection contexts = new ContextHandlerCollection(rps);

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