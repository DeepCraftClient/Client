package me.deepcraft.commands.list;

import me.deepcraft.DeepCraft;
import me.deepcraft.commands.Command;
import me.deepcraft.utils.ChatUtil;
import me.deepcraft.utils.OtherUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class KillPotCommand extends Command {
    public KillPotCommand() {
        super("killpot");
    }

    @Override
    public void execute(String[] args) {
        if (Minecraft.getMinecraft().playerController.isInCreativeMode()) {
            ItemStack itm = new ItemStack(Items.potionitem);
            itm.setItemDamage(16385);
            NBTTagCompound base = new NBTTagCompound();
            base.setInteger("HideFlags", 63);
            NBTTagCompound display = new NBTTagCompound();
            display.setString("Name", "§4§lKill §4§lPotion");
            base.setTag("display", display);
            NBTTagList list = new NBTTagList();
            NBTTagCompound effect = new NBTTagCompound();
            effect.setInteger("Id", 6);
            effect.setInteger("Amplifier", 253);
            list.appendTag(effect);
            base.setTag("CustomPotionEffects", list);
            itm.setTagCompound(base);
            OtherUtils.giveItem(itm, DeepCraft.InventoryNormalSlot);
        } else {
            ChatUtil.clientMessage(OtherUtils.CreativeError);
        }
    }
}
