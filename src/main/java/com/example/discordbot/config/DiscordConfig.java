package com.example.discordbot.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class DiscordConfig {

    @Value("${discord.bot.token}")
    private String discordBotToken;
}
