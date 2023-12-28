package net.dragonmounts3.tools;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.dragonmounts3.DM3Mod;
import net.dragonmounts3.tools.DM3ToolMaterial.DM3Hoe;
import net.dragonmounts3.tools.DM3ToolMaterial.DM3Shovel;
import net.dragonmounts3.tools.DM3ToolMaterial.DM3Sword;
import net.dragonmounts3.tools.DM3ToolMaterial.DM3ToolMaterials;
import net.dragonmounts3.util.DragonTypeManager;
import net.dragonmounts3.util.ToolType;

import net.minecraft.item.*;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import java.util.function.Supplier;


public interface DM3Item {
    DeferredRegister<ItemGroup> ITEM_GROUPS = DeferredRegister.create(DM3Mod.MOD_ID, RegistryKeys.ITEM_GROUP);

    // 创建一个 DeferredRegister 来注册物品
     RegistrySupplier<ItemGroup> DM3_GROUP = ITEM_GROUPS.register(new Identifier("dragonmounts3.title.group"), () -> CreativeTabRegistry.create(
            Text.translatable("dragonmounts3.title.group"),
            () -> Items.DIAMOND.asItem().getDefaultStack()
    ));


    DeferredRegister<Item> ITEMS = DeferredRegister.create(DM3Mod.MOD_ID, RegistryKeys.ITEM);
    static void ItemRegister() {
        ITEM_GROUPS.register();
        ITEMS.register(); // 这里注册你的物品
        registerTools();
    }



    static Item.Settings ItemToGroup() {
        return new Item.Settings().arch$tab(DM3_GROUP);
    }

     static void register(String name, Supplier<Item> item) {
        ITEMS.register(new Identifier(DM3Mod.MOD_ID,(name)), item);
    }

    static void registerTools() {
        for (String dragonType : DragonTypeManager.getDragonTypes()) {
            String DG = "_dragon";
            register(dragonType + DG + "_sword", () -> createDM3Tool(dragonType, ToolType.SWORD)); // 注册对应类型的武器
            register(dragonType + DG + "_pickaxe", () -> createDM3Tool(dragonType, ToolType.PICKAXE)); // 注册对应类型的镐
            register(dragonType + DG + "_shovel", () -> createDM3Tool(dragonType, ToolType.SHOVEL)); // 注册对应类型的锹
            // 添加其他工具类型的注册
        }
    }

    static Item createDM3Tool(String dragonType, ToolType toolType) {
        // 根据传递的工具类型和DragonType创建对应的工具，并返回
        // 此处根据传递的 ToolType 参数决定创建的是哪种类型的工具
        return switch (toolType) {
            case SWORD -> new DM3Sword(getToolMaterialForDragonType(dragonType), 9, 2, ItemToGroup() /*其他参数*/);
            case PICKAXE -> new PickaxeItem(getToolMaterialForDragonType(dragonType), -1, -2.4F, ItemToGroup());
            case SHOVEL -> new DM3Shovel(getToolMaterialForDragonType(dragonType), 9, 2, ItemToGroup() /*其他参数*/);
            case HOE -> new DM3Hoe(getToolMaterialForDragonType(dragonType), 9, 2, ItemToGroup() /*其他参数*/);
        };
    }

    static ToolMaterial getToolMaterialForDragonType(String dragonType) {
        // 根据DragonType返回对应的工具材料（ToolMaterial）
        // 可以根据DragonType的不同返回不同的材料
        // 这个方法需要根据您的需求进行具体实现
        // 示例中使用了 DM3ToolMaterials.FOREST 作为默认材料，您需要根据DragonType返回合适的材料
        return switch (dragonType) {
            case "aether" -> DM3ToolMaterials.AETHER;
            case "enchant" -> DM3ToolMaterials.ENCHANT;
            // 添加其他DragonType对应的材料
            default -> DM3ToolMaterials.FOREST; // 默认材料
        };
    }



}
