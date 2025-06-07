package com.github.m4qina.mc.mod.introduction.datagen.server;

import com.github.m4qina.mc.mod.introduction.IntroductionMod;
import com.github.m4qina.mc.mod.introduction.datagen.client.ENUSLanguageProvider;
import com.github.m4qina.mc.mod.introduction.datagen.client.IntroductionBlockStateProvider;
import com.github.m4qina.mc.mod.introduction.datagen.client.IntroductionItemModelProvider;
import com.github.m4qina.mc.mod.introduction.datagen.client.JAJPLanguageProvider;
import com.github.m4qina.mc.mod.introduction.datagen.server.loot.IntroductionLootTables;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = IntroductionMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class IntroductionDataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeClient(), new IntroductionItemModelProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new IntroductionBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ENUSLanguageProvider(packOutput));
        generator.addProvider(event.includeClient(), new JAJPLanguageProvider(packOutput));

        // レシピ
        generator.addProvider(event.includeServer(), new IntroductionRecipeProvider(packOutput));

        // ルートテーブル
        generator.addProvider(event.includeServer(), IntroductionLootTables.create(packOutput));
        // ブロックタグ
        generator.addProvider(event.includeServer(), new IntroductionBlockTagsProvider(packOutput, lookupProvider, existingFileHelper));
    }
}
