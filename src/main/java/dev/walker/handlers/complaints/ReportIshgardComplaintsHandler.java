package dev.walker.handlers.complaints;

import dev.walker.app.App;
import com.google.gson.Gson;
import dev.walker.entities.Complaints;
import org.jetbrains.annotations.NotNull;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class ReportIshgardComplaintsHandler implements Handler {


    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        String json = ctx.body();
        Gson gson = new Gson();
        Complaints complaints = gson.fromJson(json, Complaints.class);
        Complaints newComplaints = App.complaintsServices.reportComplaint(complaints);
        String comSon = gson.toJson(newComplaints);
        ctx.status(201);
        ctx.result(comSon);


    }


}
