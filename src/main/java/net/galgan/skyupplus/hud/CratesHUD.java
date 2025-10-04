package net.galgan.skyupplus.hud;

import net.galgan.skyupplus.config.Config;
import net.galgan.skyupplus.features.Crates;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Formatting;

public class CratesHUD {

    public static void cratesHUD(DrawContext context, TextRenderer tr, int xOffset, int yOffset) {
        if (Config.INSTANCE.elementiumDisplay.mode().equals("always") || (Crates.isHoldingElementium && Config.INSTANCE.elementiumDisplay.mode().equals("key"))) {
            //Draw the elementium header
            if (Config.INSTANCE.karambitToggle ||
                    Config.INSTANCE.perunToggle ||
                    Config.INSTANCE.cymofanToggle ||
                    Config.INSTANCE.mlotThoraToggle ||
                    Config.INSTANCE.urizelToggle ||
                    Config.INSTANCE.azadaToggle ||
                    Config.INSTANCE.spinelToggle ||
                    Config.INSTANCE.karpiolapToggle ||
                    Config.INSTANCE.ethericaToggle ||
                    Config.INSTANCE.lukLegolasaToggle ||
                    Config.INSTANCE.arbaletToggle ||
                    Config.INSTANCE.powrotOdysaToggle ||
                    Config.INSTANCE.cassisToggle ||
                    Config.INSTANCE.cuirassToggle ||
                    Config.INSTANCE.cuissotToggle ||
                    Config.INSTANCE.cossetToggle ||
                    Config.INSTANCE.kapcieLotnikaToggle ||
                    Config.INSTANCE.rivendellToggle ||
                    Config.INSTANCE.impetToggle ||
                    Config.INSTANCE.phloxToggle ||
                    Config.INSTANCE.majsterToggle ||
                    Config.INSTANCE.magiczneWiaderkoToggle ||
                    Config.INSTANCE.statTrackerToggle ||
                    Config.INSTANCE.jajkoNiespodziankaToggle ||
                    Config.INSTANCE.klejnotKupieckiToggle ||
                    Config.INSTANCE.kontrolerMagazynowToggle ||
                    Config.INSTANCE.tajemniceSkyUPaToggle) {

                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("» ").formatted(Formatting.BLUE))
                        .append(Text.literal("Elementium").formatted(Formatting.AQUA, Formatting.BOLD))
                        .append(Text.literal(" «").formatted(Formatting.BLUE)), xOffset, yOffset,0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("▪ ").formatted(Formatting.DARK_GRAY, Formatting.BOLD))
                        .append(Text.literal("Drop:").formatted(Formatting.AQUA)), xOffset, yOffset,0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            //Draw the counter for every item dropped
            if (Config.INSTANCE.karambitToggle) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("  » ").formatted(Formatting.BLUE))
                        .append(Text.literal("Karambit: ").formatted(Formatting.DARK_RED, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.karambitDropped)).formatted(Formatting.DARK_RED)), xOffset, yOffset,0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.perunToggle) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("  » ").formatted(Formatting.BLUE))
                        .append(Text.literal("Perun: ").formatted(Formatting.GOLD, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.perunDropped)).formatted(Formatting.GOLD)), xOffset, yOffset,0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.cymofanToggle) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("  » ").formatted(Formatting.BLUE))
                        .append(Text.literal("Cymofan: ").formatted(Formatting.GOLD, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.cymofanDropped)).formatted(Formatting.GOLD)), xOffset, yOffset,0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.mlotThoraToggle) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("  » ").formatted(Formatting.BLUE))
                        .append(Text.literal("Młot Thora: ").formatted(Formatting.RED, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.mlotThoraDropped)).formatted(Formatting.RED)), xOffset, yOffset,0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.urizelToggle) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("  » ").formatted(Formatting.BLUE))
                        .append(Text.literal("Urizel: ").formatted(Formatting.LIGHT_PURPLE, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.urizelDropped)).formatted(Formatting.LIGHT_PURPLE)), xOffset, yOffset,0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.azadaToggle) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("  » ").formatted(Formatting.BLUE))
                        .append(Text.literal("Azada: ").formatted(Formatting.GREEN, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.azadaDropped)).formatted(Formatting.GREEN)), xOffset, yOffset,0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.spinelToggle) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("  » ").formatted(Formatting.BLUE))
                        .append(Text.literal("Spinel: ").formatted(Formatting.YELLOW, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.spinelDropped)).formatted(Formatting.YELLOW)), xOffset, yOffset, 0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.karpiolapToggle) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("  » ").formatted(Formatting.BLUE))
                        .append(Text.literal("Karpiołap: ").formatted(Formatting.YELLOW, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.karpiolapDropped)).formatted(Formatting.YELLOW)), xOffset, yOffset, 0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.ethericaToggle) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("  » ").formatted(Formatting.BLUE))
                        .append(Text.literal("Etherica: ").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0xA956FC)).withBold(true)))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.ethericaDropped)).setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0xA956FC)))), xOffset, yOffset, 0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.lukLegolasaToggle) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("  » ").formatted(Formatting.BLUE))
                        .append(Text.literal("Łuk Legolasa: ").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0x56FCA9)).withBold(true)))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.lukLegolasaDropped)).setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0x56FCA9)))), xOffset, yOffset, 0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.arbaletToggle) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("  » ").formatted(Formatting.BLUE))
                        .append(Text.literal("Arbalet: ").formatted(Formatting.GOLD, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.arbaletDropped)).formatted(Formatting.GOLD)), xOffset, yOffset, 0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.powrotOdysaToggle) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("  » ").formatted(Formatting.BLUE))
                        .append(Text.literal("Powrót Odysa: ").formatted(Formatting.GREEN, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.powrotOdysaDropped)).formatted(Formatting.GREEN)), xOffset, yOffset, 0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.cassisToggle) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("  » ").formatted(Formatting.BLUE))
                        .append(Text.literal("Cassis: ").formatted(Formatting.AQUA, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.cassisDropped)).formatted(Formatting.AQUA)), xOffset, yOffset, 0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.cuirassToggle) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("  » ").formatted(Formatting.BLUE))
                        .append(Text.literal("Cuirass: ").formatted(Formatting.AQUA, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.cuirassDropped)).formatted(Formatting.AQUA)), xOffset, yOffset, 0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.cuissotToggle) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("  » ").formatted(Formatting.BLUE))
                        .append(Text.literal("Cuissot: ").formatted(Formatting.AQUA, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.cuissotDropped)).formatted(Formatting.AQUA)), xOffset, yOffset, 0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.cossetToggle) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("  » ").formatted(Formatting.BLUE))
                        .append(Text.literal("Cosset: ").formatted(Formatting.AQUA, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.cossetDropped)).formatted(Formatting.AQUA)), xOffset, yOffset, 0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.kapcieLotnikaToggle) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("  » ").formatted(Formatting.BLUE))
                        .append(Text.literal("Kapcie lotnika: ").formatted(Formatting.AQUA, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.kapcieLotnikaDropped)).formatted(Formatting.AQUA)), xOffset, yOffset, 0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.rivendellToggle) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("  » ").formatted(Formatting.BLUE))
                        .append(Text.literal("Rivendell: ").formatted(Formatting.YELLOW, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.rivendellDropped)).formatted(Formatting.YELLOW)), xOffset, yOffset, 0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.impetToggle) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("  » ").formatted(Formatting.BLUE))
                        .append(Text.literal("Impet: ").formatted(Formatting.GREEN, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.impetDropped)).formatted(Formatting.GREEN)), xOffset, yOffset, 0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.phloxToggle) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("  » ").formatted(Formatting.BLUE))
                        .append(Text.literal("Phlox: ").formatted(Formatting.RED, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.phloxDropped)).formatted(Formatting.RED)), xOffset, yOffset, 0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.majsterToggle) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("  » ").formatted(Formatting.BLUE))
                        .append(Text.literal("Majster: ").formatted(Formatting.GOLD, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.majsterDropped)).formatted(Formatting.GOLD)), xOffset, yOffset, 0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.magiczneWiaderkoToggle) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("  » ").formatted(Formatting.BLUE))
                        .append(Text.literal("Magiczne wiaderko: ").formatted(Formatting.AQUA, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.magiczneWiaderkoDropped)).formatted(Formatting.AQUA)), xOffset, yOffset, 0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.statTrackerToggle) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("  » ").formatted(Formatting.BLUE))
                        .append(Text.literal("StatTracker: ").formatted(Formatting.GOLD, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.statTrackerDropped)).formatted(Formatting.GOLD)), xOffset, yOffset, 0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.jajkoNiespodziankaToggle) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("  » ").formatted(Formatting.BLUE))
                        .append(Text.literal("Jajko niespodzianka: ").formatted(Formatting.RED, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.jajkoNiespodziankaDropped)).formatted(Formatting.RED)), xOffset, yOffset, 0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.klejnotKupieckiToggle) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("  » ").formatted(Formatting.BLUE))
                        .append(Text.literal("Klejnot kupiecki: ").formatted(Formatting.YELLOW, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.klejnotKupieckiDropped)).formatted(Formatting.YELLOW)), xOffset, yOffset, 0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.kontrolerMagazynowToggle) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("  » ").formatted(Formatting.BLUE))
                        .append(Text.literal("Kontroler magazynów: ").formatted(Formatting.GOLD, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.kontrolerMagazynowDropped)).formatted(Formatting.GOLD)), xOffset, yOffset, 0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.tajemniceSkyUPaToggle) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("  » ").formatted(Formatting.BLUE))
                        .append(Text.literal("Tajemnice SkyUPa: ").formatted(Formatting.LIGHT_PURPLE, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.tajemniceSkyUPaDropped)).formatted(Formatting.LIGHT_PURPLE)), xOffset, yOffset, 0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.karambitToggle ||
                    Config.INSTANCE.perunToggle ||
                    Config.INSTANCE.cymofanToggle ||
                    Config.INSTANCE.mlotThoraToggle ||
                    Config.INSTANCE.urizelToggle ||
                    Config.INSTANCE.azadaToggle ||
                    Config.INSTANCE.spinelToggle ||
                    Config.INSTANCE.karpiolapToggle ||
                    Config.INSTANCE.ethericaToggle ||
                    Config.INSTANCE.lukLegolasaToggle ||
                    Config.INSTANCE.arbaletToggle ||
                    Config.INSTANCE.powrotOdysaToggle ||
                    Config.INSTANCE.cassisToggle ||
                    Config.INSTANCE.cuirassToggle ||
                    Config.INSTANCE.cuissotToggle ||
                    Config.INSTANCE.cossetToggle ||
                    Config.INSTANCE.kapcieLotnikaToggle ||
                    Config.INSTANCE.rivendellToggle ||
                    Config.INSTANCE.impetToggle ||
                    Config.INSTANCE.phloxToggle ||
                    Config.INSTANCE.majsterToggle ||
                    Config.INSTANCE.magiczneWiaderkoToggle ||
                    Config.INSTANCE.statTrackerToggle ||
                    Config.INSTANCE.jajkoNiespodziankaToggle ||
                    Config.INSTANCE.klejnotKupieckiToggle ||
                    Config.INSTANCE.kontrolerMagazynowToggle ||
                    Config.INSTANCE.tajemniceSkyUPaToggle) {
                //ADD SPACER
                yOffset += tr.fontHeight + 2;
            }
        }

        if (Config.INSTANCE.platinumDisplay.mode().equals("always") || (Crates.isHoldingPlatinum && Config.INSTANCE.platinumDisplay.mode().equals("key"))) {
            //Draw the elementium header
            if (Config.INSTANCE.elementiumToggle ||
                    Config.INSTANCE.mendingToggle ||
                    Config.INSTANCE.emeraldBlockToggle) {

                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("» ").formatted(Formatting.BLUE))
                        .append(Text.literal("Platinum").formatted(Formatting.GREEN, Formatting.BOLD))
                        .append(Text.literal(" «").formatted(Formatting.BLUE)), xOffset, yOffset,0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("▪ ").formatted(Formatting.DARK_GRAY, Formatting.BOLD))
                        .append(Text.literal("Drop:").formatted(Formatting.AQUA)), xOffset, yOffset,0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            //Draw the counter for every item dropped
            if (Config.INSTANCE.elementiumToggle) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("  » ").formatted(Formatting.BLUE))
                        .append(Text.literal("Elementium: ").formatted(Formatting.AQUA, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.elementiumDropped)).formatted(Formatting.AQUA)), xOffset, yOffset,0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.mendingToggle) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("  » ").formatted(Formatting.BLUE))
                        .append(Text.literal("Mending: ").formatted(Formatting.LIGHT_PURPLE, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.mendingDropped)).formatted(Formatting.LIGHT_PURPLE)), xOffset, yOffset,0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.emeraldBlockToggle) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("  » ").formatted(Formatting.BLUE))
                        .append(Text.literal("Blok szmaragdu: ").formatted(Formatting.GREEN, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.emeraldBlockDropped)).formatted(Formatting.GREEN)), xOffset, yOffset,0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }

            if (Config.INSTANCE.elementiumToggle ||
                    Config.INSTANCE.mendingToggle ||
                    Config.INSTANCE.emeraldBlockToggle){
                //ADD SPACER
                yOffset += tr.fontHeight + 2;
            }
        }

        HUD.yOffset = yOffset;
    }
}
