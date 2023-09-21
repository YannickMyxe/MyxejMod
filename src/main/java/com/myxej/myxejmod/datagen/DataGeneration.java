package com.myxej.myxejmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class DataGeneration {
    public static void generate(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();


        // Client side Generators
        generator.addProvider(event.includeClient(), new MyxejBlockStates(packOutput, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new MyxejItemModels(packOutput, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new MyxejLanguageProvider(packOutput, "en_us"));


        // Server side Generators
        MyxejBlockTags blockTags = new MyxejBlockTags(packOutput, lookupProvider, event.getExistingFileHelper());
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new MyxejItemTags(packOutput, lookupProvider, blockTags, event.getExistingFileHelper()));
        generator.addProvider(event.includeServer(), new MyxejRecipes(packOutput));
        generator.addProvider(event.includeServer(), new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(MyxejLootTables::new, LootContextParamSets.BLOCK))));
    }
}
