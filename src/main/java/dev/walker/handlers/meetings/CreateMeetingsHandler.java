package dev.walker.handlers.meetings;

import dev.walker.app.App;
import com.google.gson.Gson;
import dev.walker.entities.Meetings;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class CreateMeetingsHandler implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        String json = ctx.body();
        Gson gson = new Gson();
        Meetings meetings = gson.fromJson(json, Meetings.class);
        Meetings newMeeting = App.meetingsService.registerMeeting(meetings);
        String meetSon = gson.toJson(newMeeting);
        ctx.status(201);
        ctx.result(meetSon);
    }


}
