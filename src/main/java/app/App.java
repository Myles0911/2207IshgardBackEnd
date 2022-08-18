package app;

import daos.PostgresIshgardiansDAO;
import handlers.ReportIshgardComplaintsHandler;
import io.javalin.Javalin;
import service.IshgardiansService;
import service.IshgardiansServiceImpl;

public class App {
    public static IshgardiansService ishgardiansService = new IshgardiansServiceImpl( new PostgresIshgardiansDAO());

    public static void main(String [] args) {
        Javalin app = Javalin.create(config->{
            config.enableDevLogging();
            config.enableCorsForAllOrigins();
        });

        //Routes for Ishgardians
        ReportIshgardComplaintsHandler reportIshgardComplaintsHandler = new ReportIshgardComplaintsHandler();
        app.post("/ishgardians")
    }
}
