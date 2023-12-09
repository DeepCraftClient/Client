package me.deepcraft.commands.list;

import me.deepcraft.commands.Command;
import me.deepcraft.utils.ChatUtil;

public class RegisterCommand extends Command {
    public RegisterCommand() {
        super("reg");
    }

    @Override
    public void execute(String[] args) {
        ChatUtil.clientMessage("§aRegister...");
        ChatUtil.publicMessage("/register HA7892374HIUHAFDIU HA7892374HIUHAFDIU");
    }
}
