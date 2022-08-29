package dev.walker.handlers.complaints;

import dev.walker.app.App;
import com.google.gson.Gson;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class GetAllComplaintsHandler implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        Gson gson = new Gson();
        String json = gson.toJson(App.complaintsServices.getAllComplaints());
        ctx.result(json);

    }
}
