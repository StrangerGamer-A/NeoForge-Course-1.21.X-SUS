package net.strangergamer.mccourse.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.strangergamer.mccourse.MCCourseMod;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MCCourseMod.MOD_ID);

    public static final DeferredItem<Item> BLACK_OPAL = ITEMS.registerSimpleItem("black_opal");
    public static final DeferredItem<Item> RAW_BLACK_OPAL = ITEMS.registerSimpleItem("raw_black_opal");

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
