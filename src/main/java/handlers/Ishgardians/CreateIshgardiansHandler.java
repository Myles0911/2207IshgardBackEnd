package handlers.Ishgardians;

import app.App;
import com.google.gson.Gson;
import entities.Ishgardians;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class CreateIshgardiansHandler implements Handler {

    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        String json = ctx.body();
        Gson gson = new Gson();
        Ishgardians ishgardians = gson.fromJson(json, Ishgardians.class);
        Ishgardians newIshgardians = App.ishgardiansService.registerIshgardians(ishgardians);
        String ishSon = gson.toJson(newIshgardians);
        ctx.status(201);
        ctx.result(ishSon);
    }
}
