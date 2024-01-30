package me.deepcraft.utils;

import javax.security.auth.login.LoginException;
import javax.swing.JOptionPane;
import java.util.Objects;

public class LoginUtil {

    public static void login() throws LoginException {
        String hwid = HWIDGenerator.getHWID();
        if (Objects.equals(hwid, "88FE783FC26610DDBC9EFBF0AAF4A9BEAD77E52E49CC62D965EC6C5C399E1E79") || Objects.equals(hwid, "EEB116118CB1F497F4C6916FD0C06E6C47EC019CE2871C0534AA5C74668EB12F")) {
        } else {
            String pw = "1337";

            String enteredPassword = JOptionPane.showInputDialog(null, "Password:");

            if (enteredPassword != null && enteredPassword.equals(pw)) {

            } else {
                JOptionPane.showMessageDialog(null, "Incorrect password or operation cancelled. The game will not start.");
                System.exit(1337);
            }
        }
    }
}
