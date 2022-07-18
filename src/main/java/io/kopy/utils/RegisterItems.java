package io.kopy.utils;

import io.kopy.armor.FabricArmorMaterial;
import io.kopy.items.FabricItem;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static io.kopy.KopyMod.MOD_ID;

public class RegisterItems {

    // This is the item group that is going to hold everything the mod implements
    public static final ItemGroup KOPY_MOD_ITEM_GROUP = FabricItemGroupBuilder.build(
            new Identifier(MOD_ID, "kopy_mod_item_group"),
            () -> new ItemStack(Items.FIREWORK_ROCKET));

    // This is going to list all of the items from the mod that we are going to want to register
    public static final FabricArmorMaterial FABRIC_ARMOR_MATERIAL = new FabricArmorMaterial();
    public static final Item FABRIC_ITEM = new FabricItem(new FabricItemSettings().group(KOPY_MOD_ITEM_GROUP).maxCount(16));

    // Register all of the new armor
    public static final Item FABRIC_HEMLET = new ArmorItem(FABRIC_ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Settings().group(KOPY_MOD_ITEM_GROUP));
    public static final Item FABRIC_CHESTPLATE = new ArmorItem(FABRIC_ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Settings().group(KOPY_MOD_ITEM_GROUP));
    public static final Item FABRIC_LEGGINGS = new ArmorItem(FABRIC_ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Settings().group(KOPY_MOD_ITEM_GROUP));
    public static final Item FABRIC_BOOTS = new ArmorItem(FABRIC_ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Settings().group(KOPY_MOD_ITEM_GROUP));


    public static void register() {
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "fabric_item"), FABRIC_ITEM);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "fabric_helmet"), FABRIC_HEMLET);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "fabric_chestplate"), FABRIC_CHESTPLATE);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "fabric_leggings"), FABRIC_LEGGINGS);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "fabric_boots"), FABRIC_BOOTS);
    }


}
