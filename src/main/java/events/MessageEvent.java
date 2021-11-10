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
        System.out.println(messageReceived.substring(1, 7).equals("prefix"));
        if (messageReceived.charAt(0) == Settings.getPrefix(event.getGuild().getId())) {
            if (messageReceived.substring(1, 7).equals("prefix")) {
                String roleNotify = "@everyone";
                Date time = Calendar.getInstance().getTime();
                String interval = "8";
                String prefix = messageReceived.substring(8, 9);
                String remindText = "Já marcou o Guardiões da Saúde hoje ?";
                String guildId = event.getGuild().getId();
                new Settings(roleNotify, time, interval, prefix, remindText, guildId);
            }
        }

        System.out.println(event.getGuild().getBotRole().getName());
        System.out
                .println(event.getAuthor().toString() + " : " + messageReceived + " @ " + event.getChannel().getName());
    }
}
