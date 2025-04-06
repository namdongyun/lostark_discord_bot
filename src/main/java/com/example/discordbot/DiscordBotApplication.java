package com.example.discordbot;

import com.example.discordbot.config.DiscordConfig;
import com.example.discordbot.listener.MessageEventListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.security.auth.login.LoginException;

@SpringBootApplication
public class DiscordBotApplication {

    public static void main(String[] args) throws LoginException {
        ApplicationContext context = SpringApplication.run(DiscordBotApplication.class, args);
        DiscordConfig discordConfig = context.getBean(DiscordConfig.class);
        String discordBotToken = discordConfig.getDiscordBotToken();

        JDA jda = JDABuilder.createDefault(discordBotToken)
                .setActivity(Activity.playing("메시지 기다리는 중!"))
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .addEventListeners(new MessageEventListener())
                .build();
    }
}
