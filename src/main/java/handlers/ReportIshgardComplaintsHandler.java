package handlers;

import app.App;
import com.google.gson.Gson;
import entities.Ishgardians;

public class ReportIshgardComplaintsHandler {
    String json = ctx.body();
    Gson gson = new Gson();
    Ishgardians ishgardians = gson.fromJson(json, Ishgardians.class);
    Ishgardians newIshgardians = App

}
