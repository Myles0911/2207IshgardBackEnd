package dev.walker.handlers.complaints;

import dev.walker.app.App;
import com.google.gson.Gson;
import dev.walker.entities.Complaints;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class GetSpecificComplaintHandler implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Complaints complaints = App.complaintsServices.getComplaintByID(id);
        Gson gson = new Gson();
        String json = gson.toJson(complaints);
        ctx.result(json);

    }}
