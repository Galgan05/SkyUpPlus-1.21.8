package net.galgan.skyupplus.hud;

import net.galgan.skyupplus.config.Config;
import net.galgan.skyupplus.features.Abilities;
import net.galgan.skyupplus.features.Dungeon;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.ArrayList;
import java.util.List;

public class CooldownHUD {

    public static void generateBody() {
        List<Text> bodyText = new ArrayList<>();

        if (Config.INSTANCE.onCooldown && Config.INSTANCE.dungeonCooldownToggle) {
            bodyText.add(Text.empty()
                    .append(Text.literal("Dungeon: ").formatted(Formatting.DARK_GRAY))
                    .append(Text.literal(String.format("%02d:%02d", Dungeon.min, Dungeon.sec)).formatted(Formatting.WHITE)));
        }

        if (Config.INSTANCE.cooldownPlug && Abilities.timePlug != null && !Abilities.isActivePlug) {
            bodyText.add(Text.empty()
                    .append(Text.literal("Pług: ").formatted(Formatting.RED, Formatting.BOLD))
                    .append(Text.literal(String.format("%02d:%02d", Abilities.timePlug[0], Abilities.timePlug[1])).formatted(Formatting.WHITE)));
        }

        if (Config.INSTANCE.cooldownRozbiorka && Abilities.timeRozbiorka != null && !Abilities.isActiveRozbiorka) {
            bodyText.add(Text.empty()
                    .append(Text.literal("Rozbiórka: ").formatted(Formatting.RED, Formatting.BOLD))
                    .append(Text.literal(String.format("%02d:%02d", Abilities.timeRozbiorka[0], Abilities.timeRozbiorka[1])).formatted(Formatting.WHITE)));
        }

        if (Config.INSTANCE.cooldownNawalnica && Abilities.timeNawalnica != null && !Abilities.isActiveNawalnica) {
            bodyText.add(Text.empty()
                    .append(Text.literal("Nawałnica: ").formatted(Formatting.RED, Formatting.BOLD))
                    .append(Text.literal(String.format("%02d:%02d", Abilities.timeNawalnica[0], Abilities.timeNawalnica[1])).formatted(Formatting.WHITE)));
        }

        if (Config.INSTANCE.cooldownSieciRybackie && Abilities.timeSieciRybackie != null && !Abilities.isActiveSieciRybackie) {
            bodyText.add(Text.empty()
                    .append(Text.literal("Sieci Rybackie: ").formatted(Formatting.RED, Formatting.BOLD))
                    .append(Text.literal(String.format("%02d:%02d", Abilities.timeSieciRybackie[0], Abilities.timeSieciRybackie[1])).formatted(Formatting.WHITE)));
        }

        if (Config.INSTANCE.cooldownPila && Abilities.timePila != null && !Abilities.isActivePila) {
            bodyText.add(Text.empty()
                    .append(Text.literal("Piła: ").formatted(Formatting.RED, Formatting.BOLD))
                    .append(Text.literal(String.format("%02d:%02d", Abilities.timePila[0], Abilities.timePila[1])).formatted(Formatting.WHITE)));
        }

        if (Config.INSTANCE.cooldownWiertlo && Abilities.timeWiertlo != null && !Abilities.isActiveWiertlo) {
            bodyText.add(Text.empty()
                    .append(Text.literal("Wiertło: ").formatted(Formatting.RED, Formatting.BOLD))
                    .append(Text.literal(String.format("%02d:%02d", Abilities.timeWiertlo[0], Abilities.timeWiertlo[1])).formatted(Formatting.WHITE)));
        }

        RenderHUD.cooldownHUD = bodyText;
    }
}
