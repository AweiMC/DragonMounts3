package net.dragonmounts3;

import net.dragonmounts3.tools.DM3Item;
import net.dragonmounts3.util.DragonTypeManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DM3Mod {
    public static final String MOD_ID = "dragonmounts";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static void init() {
        DragonTypeManager.init();//
        DM3Item.ItemRegister();

    }
}
