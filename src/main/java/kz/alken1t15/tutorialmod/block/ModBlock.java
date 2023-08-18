package kz.alken1t15.tutorialmod.block;

import kz.alken1t15.tutorialmod.TutorialMod;
import kz.alken1t15.tutorialmod.item.ModCreativeModeTab;
import kz.alken1t15.tutorialmod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlock {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MOD_ID);

    private static final RegistryObject<Block> ZIRCON_BLOCK = registryBLock("zircon_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops()), ModCreativeModeTab.TUTORIAL_TAB);

    private static final RegistryObject<Block> ANDREY_BLOCK = registryBLock("andrey_block",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)), ModCreativeModeTab.TUTORIAL_TAB);

    private static final RegistryObject<Block> DANY_BLOCK = registryBLock("dany_block",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)), ModCreativeModeTab.TUTORIAL_TAB);

//
//    private static final RegistryObject<Block> DEEPSLATE_ZIRCON_ORE = registryBLock("zircon_ore",
//            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
//                    .strength(6f).requiresCorrectToolForDrops(),
//                    UniformInt.of(3,7)), ModCreativeModeTab.TUTORIAL_TAB);

    private static  <T extends Block> RegistryObject<T> registryBLock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registryBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registryBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}