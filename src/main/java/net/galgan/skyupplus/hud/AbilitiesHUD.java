package net.galgan.skyupplus.hud;

import net.galgan.skyupplus.config.Config;
import net.galgan.skyupplus.features.Abilities;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class AbilitiesHUD {

    public static void abilitiesHUD(DrawContext context, TextRenderer tr, int xOffset, int yOffset) {
        if ((Config.INSTANCE.cooldownPlug && Abilities.timePlug != null && !Abilities.isActivePlug) ||
            (Config.INSTANCE.cooldownRozbiorka && Abilities.timeRozbiorka != null && !Abilities.isActiveRozbiorka) ||
            (Config.INSTANCE.cooldownNawalnica && Abilities.timeNawalnica != null && !Abilities.isActiveNawalnica) ||
            (Config.INSTANCE.cooldownSieciRybackie && Abilities.timeSieciRybackie != null && !Abilities.isActiveSieciRybackie) ||
            (Config.INSTANCE.cooldownPila && Abilities.timePila != null && !Abilities.isActivePila) ||
            (Config.INSTANCE.cooldownWiertlo && Abilities.timeWiertlo != null && !Abilities.isActiveWiertlo)) {

            context.drawTextWithShadow(tr, Text.empty()
                    .append(Text.literal("» ").formatted(Formatting.BLUE))
                    .append(Text.literal("Umiejętności").formatted(Formatting.LIGHT_PURPLE, Formatting.BOLD))
                    .append(Text.literal(" «").formatted(Formatting.BLUE)), xOffset, yOffset,0xFFFFFFFF);
            yOffset += tr.fontHeight + 2;
            context.drawTextWithShadow(tr, Text.empty()
                    .append(Text.literal("▪ ").formatted(Formatting.DARK_GRAY, Formatting.BOLD))
                    .append(Text.literal("Cooldown:").formatted(Formatting.AQUA)), xOffset, yOffset,0xFFFFFFFF);
            yOffset += tr.fontHeight + 2;
        }

        if (Config.INSTANCE.cooldownPlug && Abilities.timePlug != null && !Abilities.isActivePlug) {
            context.drawTextWithShadow(tr, Text.empty()
                    .append(Text.literal("  » ").formatted(Formatting.BLUE))
                    .append(Text.literal("Pług: ").formatted(Formatting.RED, Formatting.BOLD))
                    .append(Text.literal(String.format("%02d:%02d", Abilities.timePlug[0], Abilities.timePlug[1])).formatted(Formatting.WHITE)), xOffset, yOffset,0xFFFFFFFF);
            yOffset += tr.fontHeight + 2;
        }
        if (Config.INSTANCE.cooldownRozbiorka && Abilities.timeRozbiorka != null && !Abilities.isActiveRozbiorka) {
            context.drawTextWithShadow(tr, Text.empty()
                    .append(Text.literal("  » ").formatted(Formatting.BLUE))
                    .append(Text.literal("Rozbiórka: ").formatted(Formatting.RED, Formatting.BOLD))
                    .append(Text.literal(String.format("%02d:%02d", Abilities.timeRozbiorka[0], Abilities.timeRozbiorka[1])).formatted(Formatting.WHITE)), xOffset, yOffset,0xFFFFFFFF);
            yOffset += tr.fontHeight + 2;
        }
        if (Config.INSTANCE.cooldownNawalnica && Abilities.timeNawalnica != null && !Abilities.isActiveNawalnica) {
            context.drawTextWithShadow(tr, Text.empty()
                    .append(Text.literal("  » ").formatted(Formatting.BLUE))
                    .append(Text.literal("Nawałnica: ").formatted(Formatting.RED, Formatting.BOLD))
                    .append(Text.literal(String.format("%02d:%02d", Abilities.timeNawalnica[0], Abilities.timeNawalnica[1])).formatted(Formatting.WHITE)), xOffset, yOffset,0xFFFFFFFF);
            yOffset += tr.fontHeight + 2;
        }
        if (Config.INSTANCE.cooldownSieciRybackie && Abilities.timeSieciRybackie != null && !Abilities.isActiveSieciRybackie) {
            context.drawTextWithShadow(tr, Text.empty()
                    .append(Text.literal("  » ").formatted(Formatting.BLUE))
                    .append(Text.literal("Sieci Rybackie: ").formatted(Formatting.RED, Formatting.BOLD))
                    .append(Text.literal(String.format("%02d:%02d", Abilities.timeSieciRybackie[0], Abilities.timeSieciRybackie[1])).formatted(Formatting.WHITE)), xOffset, yOffset,0xFFFFFFFF);
            yOffset += tr.fontHeight + 2;
        }
        if (Config.INSTANCE.cooldownPila && Abilities.timePila != null && !Abilities.isActivePila) {
            context.drawTextWithShadow(tr, Text.empty()
                    .append(Text.literal("  » ").formatted(Formatting.BLUE))
                    .append(Text.literal("Piła: ").formatted(Formatting.RED, Formatting.BOLD))
                    .append(Text.literal(String.format("%02d:%02d", Abilities.timePila[0], Abilities.timePila[1])).formatted(Formatting.WHITE)), xOffset, yOffset,0xFFFFFFFF);
            yOffset += tr.fontHeight + 2;
        }
        if (Config.INSTANCE.cooldownWiertlo && Abilities.timeWiertlo != null && !Abilities.isActiveWiertlo) {
            context.drawTextWithShadow(tr, Text.empty()
                    .append(Text.literal("  » ").formatted(Formatting.BLUE))
                    .append(Text.literal("Wiertło: ").formatted(Formatting.RED, Formatting.BOLD))
                    .append(Text.literal(String.format("%02d:%02d", Abilities.timeWiertlo[0], Abilities.timeWiertlo[1])).formatted(Formatting.WHITE)), xOffset, yOffset,0xFFFFFFFF);
            yOffset += tr.fontHeight + 2;
        }

        if ((Config.INSTANCE.cooldownPlug && Abilities.timePlug != null && !Abilities.isActivePlug) ||
            (Config.INSTANCE.cooldownRozbiorka && Abilities.timeRozbiorka != null && !Abilities.isActiveRozbiorka) ||
            (Config.INSTANCE.cooldownNawalnica && Abilities.timeNawalnica != null && !Abilities.isActiveNawalnica) ||
            (Config.INSTANCE.cooldownSieciRybackie && Abilities.timeSieciRybackie != null && !Abilities.isActiveSieciRybackie) ||
            (Config.INSTANCE.cooldownPila && Abilities.timePila != null && !Abilities.isActivePila) ||
            (Config.INSTANCE.cooldownWiertlo && Abilities.timeWiertlo != null && !Abilities.isActiveWiertlo)) {

            yOffset += tr.fontHeight + 2;
        }

        HUD.yOffset = yOffset;
    }
}
