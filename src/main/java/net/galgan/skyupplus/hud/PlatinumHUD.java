package net.galgan.skyupplus.hud;

import net.galgan.skyupplus.config.Config;
import net.galgan.skyupplus.features.Crates;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.ArrayList;
import java.util.List;

public class PlatinumHUD {

    public static void generateBody() {
        List<Text> bodyText = new ArrayList<>();

        if (Config.INSTANCE.platinumDisplay.mode().equals("always") || (Crates.isHoldingPlatinum && Config.INSTANCE.platinumDisplay.mode().equals("key"))) {

            if (Config.INSTANCE.elementiumToggle) {
                bodyText.add(Text.empty()
                        .append(Text.literal("Elementium: ").formatted(Formatting.AQUA, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.elementiumDropped)).formatted(Formatting.WHITE)));
            }
            if (Config.INSTANCE.mendingToggle) {
                bodyText.add(Text.empty()
                        .append(Text.literal("Mending: ").formatted(Formatting.LIGHT_PURPLE, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.mendingDropped)).formatted(Formatting.WHITE)));
            }
            if (Config.INSTANCE.emeraldBlockToggle) {
                bodyText.add(Text.empty()
                        .append(Text.literal("Blok szmaragdu: ").formatted(Formatting.GREEN, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.emeraldBlockDropped)).formatted(Formatting.WHITE)));
            }
        }

        RenderHUD.platinumHUD = bodyText;
    }
}
