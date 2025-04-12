package com.example.discordbot.config;

import com.example.discordbot.listener.MessageEventListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.security.auth.login.LoginException;

@Configuration
public class DiscordBotConfig {
    private final MessageEventListener messageEventListener;
    private final DiscordConfig discordConfig;

    public DiscordBotConfig(MessageEventListener messageEventListener, DiscordConfig discordConfig) {
        this.messageEventListener = messageEventListener;
        this.discordConfig = discordConfig;
    }

    @Bean
    public JDA jda() throws LoginException, InterruptedException {
        JDA jda = JDABuilder.createDefault(discordConfig.getDiscordBotToken())
                .setActivity(Activity.playing("메시지 기다리는 중!"))
                .enableIntents(GatewayIntent.MESSAGE_CONTENT, GatewayIntent.GUILD_MESSAGES)
                .addEventListeners(messageEventListener)
                .build();

        jda.awaitReady(); // 완전히 초기화될 때까지 대기
        return jda;
    }
}
