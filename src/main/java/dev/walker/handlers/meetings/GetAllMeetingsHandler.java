package dev.walker.handlers.meetings;

import dev.walker.app.App;
import com.google.gson.Gson;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class GetAllMeetingsHandler implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        Gson gson = new Gson();
        String json = gson.toJson(App.meetingsService.getAllMeetings());
        ctx.result(json);
    }
}
