package com.myxej.myxejmod.datagen;

import com.myxej.myxejmod.MyxejMod;
import com.myxej.myxejmod.Registration;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class MyxejBlockStates extends BlockStateProvider {

    public MyxejBlockStates(PackOutput output, ExistingFileHelper exFileHelper) {
            super(output, MyxejMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(Registration.SIMPLE_BLOCK.get());
        simpleBlock(Registration.COMPLEX_BLOCK.get());
    }
}