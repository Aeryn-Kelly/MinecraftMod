package net.Aeryn.example;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ExampleMod.MODID)
public class ExampleMod
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "examplemod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    // Create a Deferred Register to hold Blocks which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    // Create a Deferred Register to hold Items which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "examplemod" namespace
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);


    // Creates a new Block with the id "examplemod:example_block", combining the namespace and path
    public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block", () -> new Block(BlockBehaviour.Properties.of().strength(5).mapColor(MapColor.STONE)));
    // Creates a new BlockItem with the id "examplemod:example_block", combining the namespace and path
    public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM = ITEMS.register("example_block", () -> new BlockItem(EXAMPLE_BLOCK.get(), new Item.Properties()));

    // Creates a new food item with the id "examplemod:example_id", nutrition 1 and saturation 2
    public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEdible().nutrition(1).saturationModifier(2f).build())));

    // Creates a creative tab with the id "examplemod:example_tab" for the example item, that is placed after the combat tab
    public static final RegistryObject<CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("example_tab", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.COMBAT)
            .icon(() -> EXAMPLE_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(EXAMPLE_ITEM.get()); // Add the example item to the tab. For your own tabs, this method is preferred over the event
            }).build());

//Custom Particles

//Items

//Soup

//Death Soup
public static final RegistryObject<Item> DEATH_SOUP = ITEMS.register("death_soup", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
          .alwaysEdible().nutrition(1).saturationModifier(2f).effect(new MobEffectInstance(MobEffects.WITHER, 1000), 1.0f).build())));
// Turquoise Soup
public static final RegistryObject<Item> TURQUOISE_SOUP = ITEMS.register("turquoise_soup", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
        .alwaysEdible().nutrition(1).saturationModifier(2f).effect(new MobEffectInstance(MobEffects.CONFUSION, 1000), 1.0f).build())));
// Fairy Soup
public static final RegistryObject<Item> FAIRY_SOUP = ITEMS.register("fairy_soup", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
        .alwaysEdible().nutrition(1).saturationModifier(2f).effect(new MobEffectInstance(MobEffects.LEVITATION, 1000), 1.0f).build())));
// Spooky Soup
public static final RegistryObject<Item> SPOOKY_SOUP = ITEMS.register("spooky_soup", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
        .alwaysEdible().nutrition(1).saturationModifier(2f).effect(new MobEffectInstance(MobEffects.BLINDNESS, 1000), 1.0f).build())));
// Mystery Soup
public static final RegistryObject<Item> MYSTERY_SOUP = ITEMS.register("mystery_soup", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
        .alwaysEdible().nutrition(1).saturationModifier(2f).effect(new MobEffectInstance(MobEffects.INFESTED, 1000), 1.0f).effect(new MobEffectInstance(MobEffects.CONFUSION, 1000), 1.0f).build())));

//Spores

    public static final RegistryObject<Item> DEATH_SPORE = ITEMS.register("death_spore", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEdible().nutrition(1).saturationModifier(2f).effect(new MobEffectInstance(MobEffects.HUNGER, 1000), 1.0f).build())));
    // Turquoise Soup
    public static final RegistryObject<Item> TURQUOISE_SPORE = ITEMS.register("turquoise_spore", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEdible().nutrition(1).saturationModifier(2f).effect(new MobEffectInstance(MobEffects.HUNGER, 1000), 1.0f).build())));
    // Fairy Soup
    public static final RegistryObject<Item> FAIRY_SPORE = ITEMS.register("fairy_spore", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEdible().nutrition(1).saturationModifier(2f).effect(new MobEffectInstance(MobEffects.HUNGER, 1000), 1.0f).build())));
    // Spooky Soup
    public static final RegistryObject<Item> SPOOKY_SPORE = ITEMS.register("spooky_spore", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEdible().nutrition(1).saturationModifier(2f).effect(new MobEffectInstance(MobEffects.HUNGER, 1000), 1.0f).build())));
    // Mystery Soup
    public static final RegistryObject<Item> MYSTERY_SPORE = ITEMS.register("mystery_spore", () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
            .alwaysEdible().nutrition(1).saturationModifier(2f).effect(new MobEffectInstance(MobEffects.HUNGER, 1000), 1.0f).build())));

    // Swords (Was going to have spores added to swords give an enchantment benifit, but it is too difficult for now) :(
    // I have no idea what to do with these

    // Death Sword
    public static final RegistryObject<Item> DEATH_SWORD = ITEMS.register("death_sword",
            () -> new SwordItem(Tiers.WOOD, new Item.Properties()));
    // Turquoise Sword
    public static final RegistryObject<Item> TURQUOISE_SWORD = ITEMS.register("turquoise_sword",
            () -> new SwordItem(Tiers.WOOD, new Item.Properties()));
    // Fairy Sword
    public static final RegistryObject<Item> FAIRY_SWORD = ITEMS.register("fairy_sword",
            () -> new SwordItem(Tiers.WOOD, new Item.Properties()));
    // Spooky Sword
    public static final RegistryObject<Item> SPOOKY_SWORD = ITEMS.register("spooky_sword",
            () -> new SwordItem(Tiers.WOOD, new Item.Properties()));
    // Mystery Sword
    public static final RegistryObject<Item> MYSTERY_SWORD = ITEMS.register("mystery_sword",
            () -> new SwordItem(Tiers.WOOD, new Item.Properties()));


//Blocks


public static final RegistryObject<Block> CREMINI_BLOCK = BLOCKS.register("cremini_block", () -> new Block(BlockBehaviour.Properties.of()));
    // Creates a new BlockItem with the id "examplemod:example_block", combining the namespace and path
    public static final RegistryObject<Item> CREMINI_BLOCK_ITEM = ITEMS.register("cremini_block", () -> new BlockItem(CREMINI_BLOCK.get(), new Item.Properties()));


    public static final RegistryObject<CreativeModeTab> EXAMPLE = CREATIVE_MODE_TABS.register("example_tab1", () -> CreativeModeTab.builder()
            .withTabsBefore(CreativeModeTabs.INGREDIENTS)
            .icon(() -> CREMINI_BLOCK_ITEM.get().getDefaultInstance())
            .displayItems((parameters, output) -> {
                output.accept(CREMINI_BLOCK_ITEM.get()); // Add the example item to the tab. For your own tabs, this method is preferred over the event
            }).build());

//Angel Mushroom

    public static final RegistryObject<Block> ANGEL_BLOCK = BLOCKS.register("angel_block", () -> new Block(BlockBehaviour.Properties.of()));
    // Creates a new BlockItem with the id "examplemod:example_block", combining the namespace and path
    public static final RegistryObject<Item> ANGEL_BLOCK_ITEM = ITEMS.register("angel_block", () -> new BlockItem(ANGEL_BLOCK.get(), new Item.Properties()));

//Blue Oyster

    public static final RegistryObject<Block> OYSTER_BLOCK = BLOCKS.register("oyster_block", () -> new Block(BlockBehaviour.Properties.of()));
    // Creates a new BlockItem with the id "examplemod:example_block", combining the namespace and path
    public static final RegistryObject<Item> OYSTER_BLOCK_ITEM = ITEMS.register("oyster_block", () -> new BlockItem(OYSTER_BLOCK.get(), new Item.Properties()));

    //Pixie Cap

    public static final RegistryObject<Block> PIXIE_BLOCK = BLOCKS.register("pixie_block", () -> new Block(BlockBehaviour.Properties.of()));
    // Creates a new BlockItem with the id "examplemod:example_block", combining the namespace and path
    public static final RegistryObject<Item> PIXIE_BLOCK_ITEM = ITEMS.register("pixie_block", () -> new BlockItem(PIXIE_BLOCK.get(), new Item.Properties()));

//Death Cap

    public static final RegistryObject<Block> CAP_BLOCK = BLOCKS.register("cap_block", () -> new Block(BlockBehaviour.Properties.of()));
    // Creates a new BlockItem with the id "examplemod:example_block", combining the namespace and path
    public static final RegistryObject<Item> CAP_BLOCK_ITEM = ITEMS.register("cap_block", () -> new BlockItem(CAP_BLOCK.get(), new Item.Properties()));

//Black Amanita

    public static final RegistryObject<Block> AMANITA_BLOCK = BLOCKS.register("amanita_block", () -> new Block(BlockBehaviour.Properties.of()));
    // Creates a new BlockItem with the id "examplemod:example_block", combining the namespace and path
    public static final RegistryObject<Item> AMANITA_BLOCK_ITEM = ITEMS.register("amanita_block", () -> new BlockItem(AMANITA_BLOCK.get(), new Item.Properties()));

//Green Russula

    public static final RegistryObject<Block> RUSSULA_BLOCK = BLOCKS.register("russula_block", () -> new Block(BlockBehaviour.Properties.of()));
    // Creates a new BlockItem with the id "examplemod:example_block", combining the namespace and path
    public static final RegistryObject<Item> RUSSULA_BLOCK_ITEM = ITEMS.register("russula_block", () -> new BlockItem(RUSSULA_BLOCK.get(), new Item.Properties()));

//Jack O Lantern (JOLM)

    public static final RegistryObject<Block> JOLM_BLOCK = BLOCKS.register("jolm_block", () -> new Block(BlockBehaviour.Properties.of()));
    // Creates a new BlockItem with the id "examplemod:example_block", combining the namespace and path
    public static final RegistryObject<Item> JOLM_BLOCK_ITEM = ITEMS.register("jolm_block", () -> new BlockItem(JOLM_BLOCK.get(), new Item.Properties()));


//Bolete

    public static final RegistryObject<Block> BOLETE_BLOCK = BLOCKS.register("bolete_block", () -> new Block(BlockBehaviour.Properties.of()));
    // Creates a new BlockItem with the id "examplemod:example_block", combining the namespace and path
    public static final RegistryObject<Item> BOLETE_BLOCK_ITEM = ITEMS.register("bolete_block", () -> new BlockItem(BOLETE_BLOCK.get(), new Item.Properties()));


//Death Trumpet

    public static final RegistryObject<Block> TRUMPET_BLOCK = BLOCKS.register("trumpet_block", () -> new Block(BlockBehaviour.Properties.of()));
    // Creates a new BlockItem with the id "examplemod:example_block", combining the namespace and path
    public static final RegistryObject<Item> TRUMPET_BLOCK_ITEM = ITEMS.register("trumpet_block", () -> new BlockItem(TRUMPET_BLOCK.get(), new Item.Properties()));


    public ExampleMod(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register the Deferred Register to the mod event bus so blocks get registered
        BLOCKS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so items get registered
        ITEMS.register(modEventBus);
        // Register the Deferred Register to the mod event bus so tabs get registered
        CREATIVE_MODE_TABS.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.logDirtBlock)
            LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);

        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS)
            event.accept(EXAMPLE_BLOCK_ITEM);
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
