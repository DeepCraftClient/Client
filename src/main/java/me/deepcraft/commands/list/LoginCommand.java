package me.deepcraft.commands.list;

import me.deepcraft.commands.Command;
import me.deepcraft.utils.ChatUtil;

public class LoginCommand extends Command {
    public LoginCommand() {
        super("log");
    }

    @Override
    public void execute(String[] args) {
        ChatUtil.clientMessage("§alogin...");
        ChatUtil.publicMessage("/login HA7892374HIUHAFDIU");
    }
}
