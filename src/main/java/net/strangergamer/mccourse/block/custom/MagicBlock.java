package net.strangergamer.mccourse.block.custom;

import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.TooltipFlag;
import net.strangergamer.mccourse.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

import java.util.List;


public class MagicBlock extends Block {
    public MagicBlock(Properties properties) {
        super(properties);
    }
    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos,
                                               Player pPlayer, BlockHitResult pHitResult) {
        pLevel.playSound(pPlayer, pPos, SoundEvents.DONKEY_DEATH, SoundSource.BLOCKS, 1f, 1f);
        return InteractionResult.SUCCESS;
    }
    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if(pEntity instanceof ItemEntity itemEntity) {
            if(isValidItem(itemEntity.getItem())) {
                itemEntity.setItem(new ItemStack(Items.DIAMOND, itemEntity.getItem().getCount()));
            }
        }
        super.stepOn(pLevel, pPos, pState, pEntity);
    }
    private boolean isValidItem(ItemStack item) {
        return item.getItem() == ModItems.RAW_BLACK_OPAL.get()
                || item.getItem() == Items.COAL || item.getItem() == Items.DANDELION;
    }
    @Override
    public void appendHoverText(ItemStack pStack, Item.TooltipContext pContext, List<Component> pTootipComponents, TooltipFlag pTooltipFlag) {
        pTootipComponents.add(Component.translatable("tooltip.mccourse.magic_block.tooltip.1"));
        super.appendHoverText(pStack, pContext, pTootipComponents, pTooltipFlag);
    }
}