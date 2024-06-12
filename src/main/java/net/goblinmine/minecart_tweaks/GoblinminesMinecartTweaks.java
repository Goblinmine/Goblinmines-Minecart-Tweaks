package net.goblinmine.minecart_tweaks;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GoblinminesMinecartTweaks implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("Goblinmine`s Minecart Tweaks");
	public static final String MOD_ID = "goblinmines_minecart_tweaks";
	//public static final Block EXAMPLE_BLOCK = new ExampleBlock(FabricBlockSettings.create().strength(4.0f).requiresTool());

	private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
			.icon(() -> new ItemStack(ExampleBlock.ITEM))
			.displayName(Text.translatable("itemGroup.goblinmines_minecart_tweaks.main_group"))
			.entries((context, entries) ->{
				entries.add(ExampleBlock.ITEM);
				entries.add(CopperRailBlock.ITEM);
			})
			.build();



	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("Hello Fabric world!");

		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "example_block"), ExampleBlock.BLOCK);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "example_block"), ExampleBlock.ITEM);

		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "copper_rail"), CopperRailBlock.BLOCK);
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "copper_rail"), CopperRailBlock.ITEM);

		Registry.register(Registries.ITEM_GROUP, new Identifier(MOD_ID, "main_group"), ITEM_GROUP);

	}
}