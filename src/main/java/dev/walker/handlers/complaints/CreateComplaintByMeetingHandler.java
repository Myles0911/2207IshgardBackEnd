package dev.walker.handlers.complaints;

import com.google.gson.Gson;
import dev.walker.app.App;
import dev.walker.entities.Complaints;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class CreateComplaintByMeetingHandler implements Handler {

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        int mid = Integer.parseInt(ctx.pathParam("mid"));
        String json = ctx.body();
        Gson gson = new Gson();
        Complaints complaints = gson.fromJson(json, Complaints.class);
        Complaints newComplaints = App.complaintsServices.reportComplaint(complaints);
        String comSon = gson.toJson(newComplaints);
        ctx.status(201);
        ctx.result(comSon);

    }
}
