package net.goblinmine.gmt.fabric;

import net.fabricmc.api.ModInitializer;

import net.goblinmine.gmt.fabriclike.ExampleModFabricLike;

public final class ExampleModFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        // Run the Fabric-like setup.
        ExampleModFabricLike.init();
    }
}
