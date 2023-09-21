package com.myxej.myxejmod.datagen;

import com.myxej.myxejmod.MyxejMod;
import net.minecraftforge.common.data.LanguageProvider;

import com.myxej.myxejmod.Registration;
import net.minecraft.data.PackOutput;

public class MyxejLanguageProvider extends LanguageProvider {

    public MyxejLanguageProvider(PackOutput output, String locale) {
        super(output, MyxejMod.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        add(Registration.SIMPLE_BLOCK.get(), "Basic Block");
        add(Registration.COMPLEX_BLOCK.get(), "Complex Block");
    }
}
