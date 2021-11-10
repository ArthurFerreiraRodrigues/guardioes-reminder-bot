package events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageEvent extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String messageReceived = event.getMessage().getContentRaw();
        System.out
                .println(event.getAuthor().toString() + " : " + messageReceived + " @ " + event.getChannel().getName());
    }
}
