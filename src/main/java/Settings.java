import java.sql.Time;

import javax.management.relation.Role;

public class Settings {
    private Role roleNotify;
    private Time time;
    private int interval;
    private char prefix;
    private String remindText = "MARCA SAPORRA";

    public Settings(Role roleNotify, Time time, int interval, char prefix, String remindText) {
        this.roleNotify = roleNotify;
        this.time = time;
        this.interval = interval;
        this.prefix = prefix;
        this.remindText = remindText;
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public char getPrefix() {
        return prefix;
    }

    public void setPrefix(char prefix) {
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

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

}
