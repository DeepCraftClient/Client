package me.deepcraft.commands.list;

import me.deepcraft.commands.Command;
import me.deepcraft.utils.ChatUtil;
import me.deepcraft.utils.OtherUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.nbt.NBTTagList;

public class TPSpawnerCommand extends Command {
    public TPSpawnerCommand() {
        super("tpspawner");
    }

    public static ItemStack CmdTeleportSpawner(String owner, double x, double y, double z) {
        ItemStack itm = new ItemStack(Blocks.mob_spawner);
        NBTTagCompound base = new NBTTagCompound();
        NBTTagCompound blockEntityTag = new NBTTagCompound();
        blockEntityTag.setString("EntityId", "ThrownEnderpearl");
        blockEntityTag.setInteger("SpawnCount", 1);
        blockEntityTag.setInteger("SpawnRange", 1);
        blockEntityTag.setInteger("RequiredPlayerRange", 20);
        blockEntityTag.setInteger("MinSpawnDelay", 5);
        blockEntityTag.setInteger("MaxSpawnDelay", 5);
        blockEntityTag.setInteger("MaxNearbyEntities", 20);
        NBTTagCompound spawnData = new NBTTagCompound();
        spawnData.setByte("shake", (byte) 0);
        spawnData.setString("ownerName", owner);
        NBTTagList pos = new NBTTagList();
        pos.appendTag(new NBTTagDouble(x));
        pos.appendTag(new NBTTagDouble(y));
        pos.appendTag(new NBTTagDouble(z));
        spawnData.setTag("Pos", pos);
        blockEntityTag.setTag("SpawnData", spawnData);
        base.setTag("BlockEntityTag", blockEntityTag);
        itm.setTagCompound(base);
        return itm;
    }

    @Override
    public void execute(String[] args) {
                if (Minecraft.getMinecraft().playerController.isInCreativeMode()) {
                    try {
                        double x = Double.parseDouble(args[2]);
                        double y = Double.parseDouble(args[3]);
                        double z = Double.parseDouble(args[4]);
                        String owner = args[1];
                        OtherUtils.giveItem(OtherUtils.AddToFurnance(CmdTeleportSpawner(owner, x, y, z), OtherUtils.MobSawner), OtherUtils.InventoryNormalSlot);
                    } catch (Exception e) {
                        ChatUtil.clientMessage("§c§lBitte §c§lverwende §c§l-TpSpawner §c§l<Name> §c§l<x> §c§l<y> §c§l<z>");
                    }
                } else {
                    ChatUtil.clientMessage(OtherUtils.CreativeError);
                }
            }
    }
