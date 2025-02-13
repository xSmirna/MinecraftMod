package com.smirna.WeatherSwordmod.item;

import com.smirna.WeatherSwordmod.Weatherswordmod;
import com.smirna.WeatherSwordmod.item.custom.WeatherSwordItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Weatherswordmod.MOD_ID);

    public static final RegistryObject<Item> AZURITE = ITEMS.register("azurite",() -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_AZURITE = ITEMS.register("raw_azurite", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TIGER_EYE = ITEMS.register("tiger_eye",() -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> WEATHER_SWORD = ITEMS.register("weather_sword",
            () -> new WeatherSwordItem(Tiers.DIAMOND, 
                new Item.Properties().durability(1562)));

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
