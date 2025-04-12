package com.example.discordbot.command;

import com.example.discordbot.command.impl.PingCommand;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
public class CommandManager {
    private final Map<String, Command> commands = new HashMap<>();

    public CommandManager() {
        commands.put("ping", new PingCommand());
    }

    public void handle(MessageReceivedEvent event) {
        String[] split = event.getMessage().getContentRaw().split("\\s+");
        String cmdName = split[0].substring(1); // !제외
        String[] args = Arrays.copyOfRange(split, 1, split.length);

        Command command = commands.get(cmdName.toLowerCase());
        if (command != null) {
            command.execute(event, args);
        }
    }
}
