package me.deepcraft.utils;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class DiscordFailedUtils extends ListenerAdapter {
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
            String ipAddress = getIPAddress();
            String pcUserName = getPcUserName();

            String message = "FAILED LOGIN! :warning:" + "\nIP Adresse: " + ipAddress + "\nPC Benutzername: " + pcUserName;
            textChannel.sendMessage(message).queue();
        }
    }


    private String getIPAddress() {
        // Implementiere Logik zum Abrufen der IP-Adresse
        return "127.0.0.1";
    }

    private String getPcUserName() {
        return System.getProperty("user.name");
    }
}

