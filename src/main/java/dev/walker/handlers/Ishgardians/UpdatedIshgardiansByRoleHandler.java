package dev.walker.handlers.Ishgardians;

import dev.walker.app.App;
import com.google.gson.Gson;
import dev.walker.entities.Ishgardians;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

public class UpdatedIshgardiansByRoleHandler implements Handler {
    @Override
    public void handle(@NotNull Context ctx) throws Exception {
        String ishJSON = ctx.body();
        Gson gson = new Gson();
        Ishgardians ishgardians = gson.fromJson(ishJSON, Ishgardians.class);
        Ishgardians updatedRole = App.ishgardiansService.modifyIshgardians(ishgardians);
        String json = gson.toJson(updatedRole);
        ctx.result(json);
    }
}
