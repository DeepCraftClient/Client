package me.deepcraft.utils;

import javax.security.auth.login.LoginException;
import javax.swing.*;

public class LoginUtil {

    public static void login() throws LoginException {

        String pw = "123123";


        String eingegebenesPasswort = JOptionPane.showInputDialog(null, "Passwort:");


        if (eingegebenesPasswort != null && eingegebenesPasswort.equals(pw)) {
        } else {

            JOptionPane.showMessageDialog(null, "Falsches Passwort oder Vorgang abgebrochen. Das Spiel wird nicht gestartet.");
            DiscordFailedUtils.webhook();
            System.exit(1337);

        }
    }

    private static void starteMinecraftClient() {
        // Hier kannst du den Code zum Starten des Minecraft-Clients einfügen
        System.out.println("Minecraft-Client wird gestartet...");


    closeClient();
}

    private static void closeClient() {

        System.out.println("Minecraft-Client wird geschlossen...");
        System.exit(0);
    }
}




