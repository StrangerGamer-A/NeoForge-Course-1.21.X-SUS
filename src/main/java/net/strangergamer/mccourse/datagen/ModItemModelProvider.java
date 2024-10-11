package net.strangergamer.mccourse.datagen;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.strangergamer.mccourse.MCCourseMod;
import net.strangergamer.mccourse.block.ModBlocks;
import net.strangergamer.mccourse.item.ModItems;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MCCourseMod.MOD_ID, existingFileHelper);
    }
    @Override
    protected void registerModels() {
        basicItem(ModItems.BLACK_OPAL.get());
        basicItem(ModItems.RAW_BLACK_OPAL.get());
        basicItem(ModItems.CHAINSAW.get());
        basicItem(ModItems.TOMATO.get());
        basicItem(ModItems.FROSTFIRE_ICE.get());

        buttonItem(ModBlocks.BLACK_OPAL_BUTTON, ModBlocks.BLACK_OPAL_BLOCK);
    }
    public void buttonItem(DeferredBlock<Block> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(MCCourseMod.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }
}