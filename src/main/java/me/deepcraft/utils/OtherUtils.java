package me.deepcraft.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.play.client.C10PacketCreativeInventoryAction;

public class OtherUtils {
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

    public static void SetUserPlayerName(String UserPlayerName) {
        UserPlayerName = UserPlayerName.replace("&", "§");
        Minecraft.getMinecraft().session.username = UserPlayerName;
    }
    public static String MobSawner = "minecraft:mob_spawner";


    public static void giveItem(ItemStack itemStack, int slot) {
        Minecraft.getMinecraft().thePlayer.sendQueue.addToSendQueue(new C10PacketCreativeInventoryAction(slot, itemStack));
    }
    public static final int InventoryNormalSlot = 36;

    public static String CreativeError = "§c§lDu benötigst Creative um dir diese Potion geben zu können!";


}
