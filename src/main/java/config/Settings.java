package config;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Date;
import java.util.Calendar;

import org.json.simple.*;
import org.json.simple.parser.*;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.Guild;

public class Settings {
    private Role roleNotify;
    private Date time;
    private String interval;
    private String prefix;
    private String remindText;

    public Settings(String roleNotify, Date date, String interval, String prefix, String remindText, String guildId) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("roleNotify", roleNotify);
        jsonObject.put("time", date.toString());
        jsonObject.put("interval", interval);
        jsonObject.put("prefix", prefix);
        jsonObject.put("remindText", remindText);

        try {
            FileWriter file = new FileWriter("settings/" + guildId + ".json");
            file.write(jsonObject.toString());
            file.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Settings init() {
        String roleNotify = "@everyone";
        Date time = Calendar.getInstance().getTime();
        String interval = "8";
        String prefix = "$";
        String remindText = "Já marcou o Guardiões da Saúde hoje ?";

        return new Settings(roleNotify, time, interval, prefix, remindText, "default");
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public static char getPrefix(String guildId) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("settings/" + guildId + ".json"));
            JSONObject jsonObject = (JSONObject) obj;

            return jsonObject.get("prefix").toString().charAt(0);

        } catch (IOException | ParseException e) {
            try {
                Object obj = parser.parse(new FileReader("settings/default.json"));
                JSONObject jsonObject = (JSONObject) obj;

                return jsonObject.get("prefix").toString().charAt(0);

            } catch (IOException | ParseException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();

                return 36;
            }
        }
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getRemindText() {
        return remindText;
    }

    public void setRemindText(String remindText) {
        this.remindText = remindText;
    }

    public Role getRole() {
        return roleNotify;
    }

    public void setRole(Role roleNotify) {
        this.roleNotify = roleNotify;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

}
