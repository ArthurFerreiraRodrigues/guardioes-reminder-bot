
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.security.auth.login.LoginException;

import events.MessageEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import sensitive.Token;

import config.Settings;

public class App extends ListenerAdapter {
    public static void main(String[] args) throws LoginException {
        Timer timer = new Timer();
        Token token = new Token();
        Date date;

        do {
            date = update();
            System.out.println(date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds());
        } while (date.getSeconds() != 29 && date.getSeconds() != 59);

        Settings.init();
        JDA jda = JDABuilder.createDefault(token.getToken()).build();
        jda.addEventListener(new MessageEvent());
        timer.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                Date date;

                date = update();
                System.out.println(date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds());

            }
        }, 0, 30000);

    }

    public static Date update() {
        return Calendar.getInstance().getTime();
    }
}
