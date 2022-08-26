package app;

import com.google.gson.Gson;
import daos.complaints.PostgresComplaintsDAO;
import daos.ishgardian.IshgardiansDAOPostgres;
import daos.meetings.MeetingsDAOPostgres;
import dtos.LoginCredentials;
import entities.Ishgardians;
import handlers.Ishgardians.CreateIshgardiansHandler;
import handlers.Ishgardians.GetAllIshgardiansHandler;
import handlers.Ishgardians.UpdatedIshgardiansByRoleHandler;
import handlers.complaints.GetAllComplaintsHandler;
import handlers.complaints.GetSpecificComplaintHandler;
import handlers.complaints.ReportIshgardComplaintsHandler;
import handlers.meetings.CreateMeetingsHandler;
import handlers.meetings.GetAllMeetingsHandler;

import io.javalin.Javalin;
import service.complaints.ComplaintsServices;
import service.complaints.ComplaintsServicesImpl;
import service.ishgardian.IshgardiansService;
import service.ishgardian.IshgardiansServiceImpl;
import service.ishgardian.LoginService;
import service.ishgardian.LoginServiceImpl;
import service.meetings.MeetingsService;
import service.meetings.MeetingsServiceImpl;


public class App {
    public static ComplaintsServices complaintsServices = new ComplaintsServicesImpl( new PostgresComplaintsDAO());
    public static LoginService loginService = new LoginServiceImpl(new IshgardiansDAOPostgres());
    public static MeetingsService meetingsService = new MeetingsServiceImpl((new MeetingsDAOPostgres()));

    public static IshgardiansService ishgardiansService = new IshgardiansServiceImpl((new IshgardiansDAOPostgres()));

    public static void main(String [] args) {
        Javalin app = Javalin.create(config->{
            config.enableDevLogging();
            config.enableCorsForAllOrigins();
        });

        //Routes for Ishgardians (Users)
        CreateIshgardiansHandler createIshgardiansHandler = new CreateIshgardiansHandler();
        GetAllIshgardiansHandler getAllIshgardiansHandler = new GetAllIshgardiansHandler();
        UpdatedIshgardiansByRoleHandler updatedIshgardiansByRoleHandler = new UpdatedIshgardiansByRoleHandler();





        //Routes for Complaints
        ReportIshgardComplaintsHandler reportIshgardComplaintsHandler = new ReportIshgardComplaintsHandler();
        GetSpecificComplaintHandler getSpecificComplaintHandler = new GetSpecificComplaintHandler();
        GetAllComplaintsHandler getAllComplaintsHandler = new GetAllComplaintsHandler();

        //Routes for Meetings
        CreateMeetingsHandler createMeetingsHandler = new CreateMeetingsHandler();
        GetAllMeetingsHandler getAllMeetingsHandler = new GetAllMeetingsHandler();


        //Routes for Ishgardian(Login)
        app.post("/login", ctx -> {
            String body = ctx.body();
            Gson gson = new Gson();
            LoginCredentials credentials = gson.fromJson(body, LoginCredentials.class);

            Ishgardians ishgardians = loginService.validateUser(credentials.getName(), credentials.getPassword());
            String ishgardianJSON = gson.toJson(ishgardians);
            ctx.result(ishgardianJSON);
        });





        app.post("/complaints", reportIshgardComplaintsHandler);
        app.get("/complaints/{id}", getSpecificComplaintHandler);
        app.get("/complaints", getAllComplaintsHandler);
        app.post("/meetings", createMeetingsHandler);
        app.get("/meetings", getAllMeetingsHandler);
        app.post("/ishgardians", createIshgardiansHandler);
        app.get("/ishgardians", getAllIshgardiansHandler);
        app.put("/ishgardians/{id}", updatedIshgardiansByRoleHandler);
        app.start();
    }


}
