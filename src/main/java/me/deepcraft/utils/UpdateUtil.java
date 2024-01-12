package me.deepcraft.utils;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class UpdateUtil {
    static public JButton numberbutton = new JButton("0");

    public static void Updater() {
        try {


            String appdata = System.getenv("APPDATA");
            String versionsPath = appdata + "\\.minecraft\\versions\\DeepCraft\\";
            String outputPath = versionsPath + "DeepCraft.jar";

            String url = "http://durchlasten.world/deepcraft/DeepCraft.jar";

            System.out.println("Downloading file from " + url + " to " + outputPath);

            URL downloadUrl = new URL(url);
            Path outputFilePath = Paths.get(outputPath);

            Files.move(outputFilePath, Paths.get(versionsPath + "DeepCraftold" + (int) (Math.random() * 1000) + ".jar"));

            Files.copy(downloadUrl.openStream(), outputFilePath, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Download completed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

