package net.goblinmine.gmt;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GoblinminesMinecartTweaks implements ModInitializer {
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("Goblinmine's Minecart Tweaks");
    public static final String MOD_ID = "goblinmines_minecart_tweaks";

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        LOGGER.info("Hello Fabric world!");


        Identifier CopperRailID = new Identifier(MOD_ID, "copper_rail");
        Registry.register(Registries.BLOCK, CopperRailID, CopperRailBlock.BLOCK);
        Registry.register(Registries.ITEM, CopperRailID, CopperRailBlock.BLOCK_ITEM);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(content -> {
            content.addAfter(Items.RAIL, CopperRailBlock.BLOCK_ITEM);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
            content.addAfter(Items.RAIL, CopperRailBlock.BLOCK_ITEM);
        });
    }
}