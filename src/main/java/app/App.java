package app;

import daos.complaints.PostgresComplaintsDAO;
import handlers.ReportIshgardComplaintsHandler;
import io.javalin.Javalin;
import service.ComplaintsServices;
import service.ComplaintsServicesImpl;

public class App {
    public static ComplaintsServices complaintsServices = new ComplaintsServicesImpl( new PostgresComplaintsDAO());

    public static void main(String [] args) {
        Javalin app = Javalin.create(config->{
            config.enableDevLogging();
            config.enableCorsForAllOrigins();
        });

        //Routes for Ishgardians
        ReportIshgardComplaintsHandler reportIshgardComplaintsHandler = new ReportIshgardComplaintsHandler();
        app.post("/complaints ", reportIshgardComplaintsHandler);
        app.start();
    }


}
