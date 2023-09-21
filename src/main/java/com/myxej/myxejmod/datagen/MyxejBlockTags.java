package com.myxej.myxejmod.datagen;

import com.myxej.myxejmod.MyxejMod;
import com.myxej.myxejmod.Registration;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class MyxejBlockTags extends BlockTagsProvider {

    public MyxejBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MyxejMod.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(Registration.COMPLEX_BLOCK.get(), Registration.SIMPLE_BLOCK.get());
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(Registration.COMPLEX_BLOCK.get(), Registration.SIMPLE_BLOCK.get());
    }
}