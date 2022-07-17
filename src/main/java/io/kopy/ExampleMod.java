package io.kopy;

import io.kopy.items.CustomItem;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.

	public static final String MOD_ID = "kopy-mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	// Create a new item group to hold items for my mod
	public static final ItemGroup MOD_ITEM_GROUP = FabricItemGroupBuilder.build(
			new Identifier(MOD_ID, "kopy-mod-item-group"),
			() -> new ItemStack(Items.FIREWORK_ROCKET));

	// a new instance of our item
	public static final Item CUSTOM_ITEM = new CustomItem(new FabricItemSettings().group(MOD_ITEM_GROUP).maxCount(16));




	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "custom_item"), CUSTOM_ITEM);
		FuelRegistry.INSTANCE.add(CUSTOM_ITEM, 300);
		CompostingChanceRegistry.INSTANCE.add(CUSTOM_ITEM, 0.5F);

		LOGGER.info("Hello Fabric world!");
	}
}
