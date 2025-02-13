package com.smirna.WeatherSwordmod.item;

import com.smirna.WeatherSwordmod.Weatherswordmod;
import com.smirna.WeatherSwordmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Weatherswordmod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> WHEATHERMOD_ITEMS_TAB = CREATIVE_MODE_TABS.register("weathermod_items_tabs",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.AZURITE.get()))
                    .title(Component.translatable("creativetab.weatherswordmod.weathermod_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.AZURITE.get());
                        output.accept(ModItems.RAW_AZURITE.get());
                        output.accept(ModItems.TIGER_EYE.get());
                        output.accept(ModItems.WEATHER_SWORD.get());
                    }).build());
    public static final RegistryObject<CreativeModeTab> WHEATHERMOD_BLOCKS_TAB = CREATIVE_MODE_TABS.register("weathermod_blocks_tabs",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.AZURITE_BLOCK.get()))
                    .withTabsBefore(WHEATHERMOD_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.weatherswordmod.weathermod_block"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.AZURITE_BLOCK.get());
                        output.accept(ModBlocks.RAW_AZURITE_BLOCK.get());
                        output.accept(ModBlocks.AZURITE_ORE.get());
                        output.accept(ModBlocks.AZURITE_DEEPSLATE_ORE.get());
                        output.accept(ModBlocks.TIGER_EYE_ORE.get());
                        output.accept(ModBlocks.TIGER_EYE_DEEPSLATE_ORE.get());
                        output.accept(ModBlocks.TIGER_EYE_BLOCK.get());

                    }).build());

    public static void register(IEventBus eventBus)
    {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
