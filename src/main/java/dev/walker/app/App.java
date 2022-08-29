package dev.walker.app;

import com.google.gson.Gson;
import dev.walker.daos.complaints.PostgresComplaintsDAO;
import dev.walker.daos.ishgardian.IshgardiansDAOPostgres;
import dev.walker.daos.meetings.MeetingsDAOPostgres;
import dev.walker.dtos.LoginCredentials;
import dev.walker.entities.Ishgardians;
import dev.walker.handlers.Ishgardians.CreateIshgardiansHandler;
import dev.walker.handlers.Ishgardians.GetAllIshgardiansHandler;
import dev.walker.handlers.Ishgardians.UpdatedIshgardiansByRoleHandler;
import dev.walker.handlers.complaints.CreateComplaintByMeetingHandler;
import dev.walker.handlers.complaints.GetAllComplaintsHandler;
import dev.walker.handlers.complaints.GetSpecificComplaintHandler;
import dev.walker.handlers.complaints.ReportIshgardComplaintsHandler;
import dev.walker.handlers.meetings.CreateMeetingsHandler;
import dev.walker.handlers.meetings.GetAllMeetingsHandler;

import io.javalin.Javalin;
import dev.walker.service.complaints.ComplaintsServices;
import dev.walker.service.complaints.ComplaintsServicesImpl;
import dev.walker.service.ishgardian.IshgardiansService;
import dev.walker.service.ishgardian.IshgardiansServiceImpl;
import dev.walker.service.ishgardian.LoginService;
import dev.walker.service.ishgardian.LoginServiceImpl;
import dev.walker.service.meetings.MeetingsService;
import dev.walker.service.meetings.MeetingsServiceImpl;


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
        CreateComplaintByMeetingHandler createComplaintByMeetingHandler = new CreateComplaintByMeetingHandler();

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
        app.put("/complaints/{mid}", createComplaintByMeetingHandler);

        app.post("/meetings", createMeetingsHandler);
        app.get("/meetings", getAllMeetingsHandler);

        app.post("/ishgardians", createIshgardiansHandler);
        app.get("/ishgardians", getAllIshgardiansHandler);
        app.put("/ishgardians/{id}", updatedIshgardiansByRoleHandler);
        app.start();
    }


}
