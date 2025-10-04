package net.galgan.skyupplus.hud;

import net.galgan.skyupplus.config.Config;
import net.galgan.skyupplus.features.Fishing;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class FishingHUD {

    public static void fishingHUD(DrawContext context, TextRenderer tr, int xOffset, int yOffset) {
        if (Config.INSTANCE.fishingDisplay.mode().equals("always") || (Fishing.isFishing && Config.INSTANCE.fishingDisplay.mode().equals("fishing_rod"))) {
            //Draw the fishing headers
            if (Config.INSTANCE.toggleNiewielka ||
                    Config.INSTANCE.togglePrzecietna ||
                    Config.INSTANCE.toggleWymiarowa ||
                    Config.INSTANCE.toggleOgromna ||
                    Config.INSTANCE.toggleMamucia ||
                    Config.INSTANCE.toggleSuma ||
                    Config.INSTANCE.toggleZarobek ||
                    Config.INSTANCE.toggleWaga ||
                    Config.INSTANCE.toggleNajwieksza ||
                    Config.INSTANCE.toggleNajmniejsza) {

                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("» ").formatted(Formatting.BLUE))
                        .append(Text.literal("Rybak").formatted(Formatting.DARK_AQUA, Formatting.BOLD))
                        .append(Text.literal(" «").formatted(Formatting.BLUE)), xOffset, yOffset,0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("▪ ").formatted(Formatting.DARK_GRAY, Formatting.BOLD))
                        .append(Text.literal("Statystyki:").formatted(Formatting.AQUA)), xOffset, yOffset,0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            //Draw the numbers for every fish tier
            if (Config.INSTANCE.toggleNiewielka) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("  » ").formatted(Formatting.BLUE))
                        .append(Text.literal("Niewielka: ").formatted(Formatting.GRAY))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.niewielkaCount)).formatted(Formatting.GRAY)), xOffset, yOffset,0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.togglePrzecietna) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("  » ").formatted(Formatting.BLUE))
                        .append(Text.literal("Przeciętna: ").formatted(Formatting.YELLOW))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.przecietnaCount)).formatted(Formatting.YELLOW)), xOffset, yOffset,0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.toggleWymiarowa) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("  » ").formatted(Formatting.BLUE))
                        .append(Text.literal("Wymiarowa: ").formatted(Formatting.GREEN))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.wymiarowaCount)).formatted(Formatting.GREEN)), xOffset, yOffset,0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.toggleOgromna) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("  » ").formatted(Formatting.BLUE))
                        .append(Text.literal("Ogromna: ").formatted(Formatting.GOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.ogromnaCount)).formatted(Formatting.GOLD)), xOffset, yOffset,0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.toggleMamucia) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("  » ").formatted(Formatting.BLUE))
                        .append(Text.literal("Mamucia: ").formatted(Formatting.DARK_PURPLE))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.mamuciaCount)).formatted(Formatting.DARK_PURPLE)), xOffset, yOffset,0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.toggleSuma) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("  » ").formatted(Formatting.BLUE))
                        .append(Text.literal("Suma: ").formatted(Formatting.WHITE))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.totalCount)).formatted(Formatting.WHITE)), xOffset, yOffset,0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.toggleZarobek) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("  » ").formatted(Formatting.BLUE))
                        .append(Text.literal("Zarobek: ").formatted(Formatting.YELLOW))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.totalEarned)).append(" SC").formatted(Formatting.YELLOW)), xOffset, yOffset,0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.toggleWaga) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("  » ").formatted(Formatting.BLUE))
                        .append(Text.literal("Waga: ").formatted(Formatting.AQUA))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.totalWeight)).append("g").formatted(Formatting.AQUA)), xOffset, yOffset,0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.toggleNajwieksza) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("  » ").formatted(Formatting.BLUE))
                        .append(Text.literal("Max: ").formatted(Formatting.GREEN))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.biggestWeight)).append("g").formatted(Formatting.GREEN)), xOffset, yOffset,0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.toggleNajmniejsza) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("  » ").formatted(Formatting.BLUE))
                        .append(Text.literal("Min: ").formatted(Formatting.RED))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.smallestWeight)).append("g").formatted(Formatting.RED)), xOffset, yOffset,0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.toggleNiewielka ||
                    Config.INSTANCE.togglePrzecietna ||
                    Config.INSTANCE.toggleWymiarowa ||
                    Config.INSTANCE.toggleOgromna ||
                    Config.INSTANCE.toggleMamucia ||
                    Config.INSTANCE.toggleSuma ||
                    Config.INSTANCE.toggleZarobek ||
                    Config.INSTANCE.toggleWaga ||
                    Config.INSTANCE.toggleNajwieksza ||
                    Config.INSTANCE.toggleNajmniejsza) {
                //ADD SPACER
                yOffset += tr.fontHeight + 2;
            }
        }

        HUD.yOffset = yOffset;
    }
}
