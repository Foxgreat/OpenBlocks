package jadedladder.common.block;

import jadedladder.JadedLadder;
import jadedladder.common.tileentity.TileEntityDropBlock;
import jadedladder.common.tileentity.TileEntityHealBlock;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockHeal extends BlockContainer {

	public BlockHeal(){
		super(JadedLadder.Config.blockHealId, Material.ground);
		setHardness(3.0F);
		GameRegistry.registerBlock(this, "openblocks_healblock");
		GameRegistry.registerTileEntity(TileEntityHealBlock.class,"openblocks_healblock");
		LanguageRegistry.instance().addStringLocalization("tile.jadedladder.healblock.name", "Heal Block");
		setUnlocalizedName("jadedladder.healblock");
		setCreativeTab(CreativeTabs.tabMisc);
	}
	
	public void registerIcons(IconRegister registry) {
		this.blockIcon = registry.registerIcon("jadedladder:heal");
	}

	@Override
	public boolean canBeReplacedByLeaves(World world, int x, int y, int z) {
		return false;
	}

	@Override
	public boolean isFlammable(IBlockAccess world, int x, int y, int z, int metadata, ForgeDirection face) {
		return false;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityHealBlock();
	}

}
