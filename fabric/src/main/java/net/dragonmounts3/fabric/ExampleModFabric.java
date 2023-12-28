package net.dragonmounts3.fabric;

import net.dragonmounts3.DM3Mod;
import net.fabricmc.api.ModInitializer;

public class ExampleModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        DM3Mod.init();
    }
}
