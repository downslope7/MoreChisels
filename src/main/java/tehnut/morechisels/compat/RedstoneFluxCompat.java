package tehnut.morechisels.compat;

import com.cricketcraft.chisel.init.ChiselItems;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import tehnut.morechisels.ConfigHandler;
import tehnut.morechisels.items.ItemRegistry;
import tehnut.morechisels.items.chisel.ItemChiselFluxed;
import tehnut.morechisels.util.EnviroChecks;
import tehnut.morechisels.util.LogHelper;
import tehnut.morechisels.util.Utils;

import static tehnut.morechisels.ConfigHandler.chiselFluxedEnabled;

public class RedstoneFluxCompat {

    public static Item chiselFluxed;

    public static void load() {
        LogHelper.info("RF compatibility is enabled and running");
        registerItems();
        registerRecipes();
    }

    private static void registerItems() {
        chiselFluxed = new ItemChiselFluxed();
        ItemRegistry.registerCompatItem(chiselFluxed, "ItemChiselFluxed", chiselFluxedEnabled, EnviroChecks.isRFAPILoaded());
    }

    // Somebody please do these better...
    private static void registerRecipes() {
        if ((!ConfigHandler.addEnderIOFluxedChiselRecipes && !ConfigHandler.addThermalExpansionFluxedChiselRecipes && !ConfigHandler.addRedstoneArsenalFluxedChiselRecipes) || (!EnviroChecks.isEnderIOLoaded() && !EnviroChecks.isThermalExpansionLoaded() && !EnviroChecks.isRedstoneArsenalLoaded()))
            GameRegistry.addRecipe(new ShapelessOreRecipe(new ItemStack(chiselFluxed), ChiselItems.diamondChisel, Blocks.redstone_block, Blocks.redstone_block, Blocks.redstone_block));

        if (EnviroChecks.isEnderIOLoaded() && ConfigHandler.addEnderIOFluxedChiselRecipes) {
            ItemStack basicCapacitor = new ItemStack(GameRegistry.findItem("EnderIO", "itemBasicCapacitor"), 1, 0);

            GameRegistry.addRecipe(new ShapelessOreRecipe(Utils.setNewEnergyTag(new ItemStack(chiselFluxed), 0), ChiselItems.chisel, basicCapacitor));
        }

        if (EnviroChecks.isThermalExpansionLoaded() && ConfigHandler.addThermalExpansionFluxedChiselRecipes) {
            ItemStack hardenedFluxCapacitor = new ItemStack(GameRegistry.findItem("ThermalExpansion", "capacitor"), 1, 3);

            GameRegistry.addRecipe(new ShapelessOreRecipe(Utils.setNewEnergyTag(new ItemStack(chiselFluxed), 0), ChiselItems.chisel, hardenedFluxCapacitor));
        }

        if (EnviroChecks.isRedstoneArsenalLoaded() && ConfigHandler.addRedstoneArsenalFluxedChiselRecipes)
            GameRegistry.addRecipe(new ShapedOreRecipe(Utils.setNewEnergyTag(new ItemStack(chiselFluxed), 0), " I", "S ", 'I', "ingotElectrumFlux", 'S', "stickWood"));
    }
}
