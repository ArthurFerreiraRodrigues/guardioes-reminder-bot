package events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.json.simple.*;
import org.json.simple.parser.*;

import config.Settings;

public class MessageEvent extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String messageReceived = event.getMessage().getContentRaw();
        char prefix = messageReceived.charAt(0);

        if (prefix == Settings.getPrefix(event.getGuild().getId())) {

            if (messageReceived.substring(1, 7).equals("prefix")) {
                Settings.setPrefix(event, messageReceived.substring(8, 9));

            } else if (messageReceived.substring(1, 7).equals("prefix")) {

            }
        }
        System.out.println(event.getGuild().getBotRole().getName());
        System.out
                .println(event.getAuthor().toString() + " : " + messageReceived + " @ " + event.getChannel().getName());
    }
}
