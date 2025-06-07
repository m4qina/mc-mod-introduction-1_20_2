package com.github.m4qina.mc.mod.introduction.datagen;

import com.github.m4qina.mc.mod.introduction.IntroductionMod;
import com.github.m4qina.mc.mod.introduction.block.IntroductionBlocks;
import com.github.m4qina.mc.mod.introduction.item.IntroductionItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

import java.util.Locale;

public class ENUSLanguageProvider extends LanguageProvider {
    public ENUSLanguageProvider(PackOutput output) {
        super(output, IntroductionMod.MOD_ID, Locale.US.toString().toLowerCase());
    }

    @Override
    protected void addTranslations() {
        addItem(IntroductionItems.RAW_ORIHALCON, "Raw Orihalcon");
        addItem(IntroductionItems.ORIHALCON_INGOT, "Orihalcon Ingot");

        add("creativetabs.introduction_tab", "Introdaction");

        addBlock(IntroductionBlocks.ORIHALCON_BLOCK, "Orihalcon Block");
        addBlock(IntroductionBlocks.RAW_ORIHALCON_BLOCK, "RAW Orihalcon Block");
    }
}
