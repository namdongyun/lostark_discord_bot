package com.example.discordbot.listener;

import com.example.discordbot.command.CommandManager;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MessageEventListener extends ListenerAdapter {

    private final CommandManager commandManager;

    public MessageEventListener(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        User user = event.getAuthor();
        TextChannel textChannel = event.getChannel().asTextChannel();
        Message message = event.getMessage();

        log.info("=============================================");
        log.info("user: {}", user);
        log.info("textChannel: {}", textChannel);
        log.info("Message received: {}", message.getContentRaw());
        log.info("=============================================");

        if (user.isBot()) return;

        String raw = event.getMessage().getContentRaw();
        if (raw.startsWith("!")) {
            commandManager.handle(event);
        }
    }
}

