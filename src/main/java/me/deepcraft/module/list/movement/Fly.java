package me.deepcraft.module.list.movement;

import me.deepcraft.module.Category;
import me.deepcraft.module.Module;
import org.lwjgl.input.Keyboard;

public class Fly extends Module {
    public Fly() {
        super("Fly", Keyboard.KEY_F, Category.MOVEMENT);
    }

    public static double flySpeed = 20.0F;

    private boolean wasFlying;
    private boolean canFly;

    @Override
    public void onUpdate() {
        mc.thePlayer.motionY = 0;
        mc.thePlayer.isAirBorne = false;
        if(mc.gameSettings.keyBindJump.isKeyDown()){
            mc.thePlayer.motionY += (flySpeed / 20);
        }
        if(mc.gameSettings.keyBindSneak.isKeyDown()){
            mc.thePlayer.motionY -= (flySpeed / 20);
        }
        mc.thePlayer.capabilities.setFlySpeed((float) (flySpeed/75));
        mc.thePlayer.jumpMovementFactor = ((float) (flySpeed/75));
    }

    @Override
    public void onEnable(){
        if(mc.inGameHasFocus){
            if(mc.thePlayer.capabilities.isFlying){
                wasFlying = true;
            }else{
                wasFlying = false;
            }
            if(mc.thePlayer.capabilities.allowFlying){
                canFly = true;
            }else{
                canFly = false;
            }
            mc.thePlayer.capabilities.setFlySpeed((float) (flySpeed/100));
        }
    }

    @Override
    public void onDisable() {
        if(mc.inGameHasFocus){
            if(wasFlying){
                if(!mc.thePlayer.isAirBorne){
                    mc.thePlayer.motionY = 0.05;
                }
                mc.thePlayer.capabilities.isFlying = true;
            }else{
                mc.thePlayer.capabilities.isFlying = false;
            }
            if(canFly){
                mc.thePlayer.capabilities.allowFlying = true;
            }else{
                mc.thePlayer.capabilities.allowFlying = false;
            }
            mc.thePlayer.capabilities.setFlySpeed(0.05F);
        }
    }
}
