
import java.util.Calendar;
import java.util.Date;

import javax.security.auth.login.LoginException;

import events.MessageEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import sensitive.Token;

import config.Settings;

public class App extends ListenerAdapter {
    private static Date date = new Date();
    private static Calendar calendar;

    public static void main(String[] args) throws LoginException {
        Token token = new Token();

        JDA jda = JDABuilder.createDefault(token.getToken()).build();
        jda.addEventListener(new MessageEvent());
        Settings.init();
        calendar = updateTime();
        System.out.println(Calendar.getInstance().getTime().getHours());
    }

    public static Calendar updateTime() {
        return Calendar.getInstance();
    }
}
