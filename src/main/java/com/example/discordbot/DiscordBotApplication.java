package com.example.discordbot;

import com.example.discordbot.config.DiscordConfig;
import com.example.discordbot.listener.MessageEventListener;
import jakarta.annotation.PostConstruct;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.security.auth.login.LoginException;

@SpringBootApplication
public class DiscordBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscordBotApplication.class, args);
    }
}
