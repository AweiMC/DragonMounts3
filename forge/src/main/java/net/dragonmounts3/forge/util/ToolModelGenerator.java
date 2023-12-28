package net.dragonmounts3.forge.util;

import net.dragonmounts3.DM3Mod;
import net.dragonmounts3.util.DragonTypeManager;
import net.dragonmounts3.util.ToolType;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ItemModelProvider;


public class ToolModelGenerator extends ItemModelProvider {

    public ToolModelGenerator(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator.getPackOutput(), DM3Mod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        DM3Mod.LOGGER.info("Generating tool models...");
        for (String dragonType : DragonTypeManager.getDragonTypes()) {
            for (ToolType toolType : ToolType.values()) {
                generateToolModel(dragonType, toolType);
            }
        }
    }

    private void generateToolModel(String dragonType, ToolType toolType) {
        String modelName = dragonType + "_dragon_" + toolType.name().toLowerCase();
        DM3Mod.LOGGER.info("Generating model for: {}", modelName);

        getBuilder(modelName)
                .parent(new ModelFile.UncheckedModelFile("minecraft:item/handheld"))
                .texture("layer0", DM3Mod.MOD_ID+":items/tools/" + toolType.name().toLowerCase() + "/" + dragonType + "_dragon_" + toolType.name().toLowerCase());
    }
}
