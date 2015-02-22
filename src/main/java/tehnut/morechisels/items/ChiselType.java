package tehnut.morechisels.items;

import java.util.Locale;

import static tehnut.morechisels.ConfigHandler.*;

public enum ChiselType {

    BLOODY(durabilityBloody), BOUND(), // Blood Magic
    BEDROCKIUM(durabilityBedrockium), UNSTABLE(durabilityUnstable), // Extra Utilities
    FLUXED(), // RF
    IRONWOOD(durabilityIronwood), STEELEAF(durabilitySteeleaf), KNIGHTMETAL(durabilityKnightmetal), FIERY(durabilityFiery), // Twilight Forest
    MANASTEEL(durabilityManasteel), ELEMENTIUM(durabilityElementium), // Botania
    SKYROOT(durabilitySkyroot), HOLYSTONE(durabilityHolystone), ZANITE(durabilityZanite), GRAVITITE(durabilityGravitite), // Aether II
    STEAM(durabilitySteam),
    THAUMIUM(durabilityThaumium), VOIDMETAL(durabilityVoidmetal); // Thaumcraft

    /**
     * Used for all types of durability (RF, EU, etc)
     */
    public final int durability;

    private ChiselType(int dura) {
        this.durability = dura;
    }

    private ChiselType() {
        this(100);
    }

    @Override
    public String toString() {
        return name().toLowerCase(Locale.ENGLISH);
    }
}
