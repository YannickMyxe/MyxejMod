package com.myxej.myxejmod.datagen;

import com.myxej.myxejmod.MyxejMod;
import com.myxej.myxejmod.Registration;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class MyxejItemModels extends ItemModelProvider {

    public MyxejItemModels(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MyxejMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent(Registration.SIMPLE_BLOCK.getId().getPath(), modLoc("block/simple_block"));
        withExistingParent(Registration.COMPLEX_BLOCK.getId().getPath(), modLoc("block/complex_block"));
    }
}