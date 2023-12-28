package net.dragonmounts3.forge;

import dev.architectury.platform.forge.EventBuses;
import net.dragonmounts3.DM3Mod;
import net.dragonmounts3.forge.util.DataGen;
import net.dragonmounts3.forge.util.ToolModelGenerator;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(DM3Mod.MOD_ID)
public class DragonMounts3ModForge {
    public DragonMounts3ModForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(DM3Mod.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        DM3Mod.init();
    }
}
