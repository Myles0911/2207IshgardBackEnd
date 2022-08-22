package app;

import daos.complaints.PostgresComplaintsDAO;
import handlers.GetAllComplaintsHandler;
import handlers.GetSpecificComplaintHandler;
import handlers.ReportIshgardComplaintsHandler;
import io.javalin.Javalin;
import service.complaints.ComplaintsServices;
import service.complaints.ComplaintsServicesImpl;

public class App {
    public static ComplaintsServices complaintsServices = new ComplaintsServicesImpl( new PostgresComplaintsDAO());

    public static void main(String [] args) {
        Javalin app = Javalin.create(config->{
            config.enableDevLogging();
            config.enableCorsForAllOrigins();
        });

        //Routes for Complaints
        ReportIshgardComplaintsHandler reportIshgardComplaintsHandler = new ReportIshgardComplaintsHandler();
        GetSpecificComplaintHandler getSpecificComplaintHandler = new GetSpecificComplaintHandler();
        GetAllComplaintsHandler getAllComplaintsHandler = new GetAllComplaintsHandler();




        app.post("/complaints ", reportIshgardComplaintsHandler);
        app.get("/complaints/{id}", getSpecificComplaintHandler);
        app.get("/complaints", getAllComplaintsHandler);
        app.start();
    }


}
