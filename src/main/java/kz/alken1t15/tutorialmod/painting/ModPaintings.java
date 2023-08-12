package kz.alken1t15.tutorialmod.painting;

import kz.alken1t15.tutorialmod.TutorialMod;
import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPaintings {
    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS =
            DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, TutorialMod.MOD_ID);

    public static final RegistryObject<PaintingVariant> DANY = PAINTING_VARIANTS.register("dany",
            () -> new PaintingVariant(100, 100));
    public static final RegistryObject<PaintingVariant> ANDREY = PAINTING_VARIANTS.register("andrey",
            () -> new PaintingVariant(50, 50));

//    private static final RegistryObject<PaintingVariant> SUNSET = PAINTING_VARIANTS.register("plant",
//            () -> new PaintingVariant(32, 32));


    public static void register(IEventBus eventBus) {
        PAINTING_VARIANTS.register(eventBus);
    }
}