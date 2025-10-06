package net.galgan.skyupplus.hud;

import net.galgan.skyupplus.config.Config;
import net.galgan.skyupplus.features.Crates;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Formatting;

import java.util.ArrayList;
import java.util.List;

public class ElementiumHUD {

    public static void generateBody() {
        List<Text> bodyText = new ArrayList<>();

        if (Config.INSTANCE.elementiumDisplay.mode().equals("always") || (Crates.isHoldingElementium && Config.INSTANCE.elementiumDisplay.mode().equals("key"))) {
            
            if (Config.INSTANCE.karambitToggle) {
                bodyText.add(Text.empty()
                        .append(Text.literal("Karambit: ").formatted(Formatting.DARK_RED, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.karambitDropped)).formatted(Formatting.WHITE)));
            }
            if (Config.INSTANCE.perunToggle) {
                bodyText.add(Text.empty()
                        .append(Text.literal("Perun: ").formatted(Formatting.GOLD, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.perunDropped)).formatted(Formatting.WHITE)));
            }
            if (Config.INSTANCE.cymofanToggle) {
                bodyText.add(Text.empty()
                        .append(Text.literal("Cymofan: ").formatted(Formatting.GOLD, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.cymofanDropped)).formatted(Formatting.WHITE)));
            }
            if (Config.INSTANCE.mlotThoraToggle) {
                bodyText.add(Text.empty()
                        .append(Text.literal("Młot Thora: ").formatted(Formatting.RED, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.mlotThoraDropped)).formatted(Formatting.WHITE)));
            }
            if (Config.INSTANCE.urizelToggle) {
                bodyText.add(Text.empty()
                        .append(Text.literal("Urizel: ").formatted(Formatting.LIGHT_PURPLE, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.urizelDropped)).formatted(Formatting.WHITE)));
            }
            if (Config.INSTANCE.azadaToggle) {
                bodyText.add(Text.empty()
                        .append(Text.literal("Azada: ").formatted(Formatting.GREEN, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.azadaDropped)).formatted(Formatting.WHITE)));
            }
            if (Config.INSTANCE.spinelToggle) {
                bodyText.add(Text.empty()
                        .append(Text.literal("Spinel: ").formatted(Formatting.YELLOW, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.spinelDropped)).formatted(Formatting.WHITE)));
            }
            if (Config.INSTANCE.karpiolapToggle) {
                bodyText.add(Text.empty()
                        .append(Text.literal("Karpiołap: ").formatted(Formatting.YELLOW, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.karpiolapDropped)).formatted(Formatting.WHITE)));
            }
            if (Config.INSTANCE.ethericaToggle) {
                bodyText.add(Text.empty()
                        .append(Text.literal("Etherica: ").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0xA956FC)).withBold(true)))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.ethericaDropped)).formatted(Formatting.WHITE)));
            }
            if (Config.INSTANCE.lukLegolasaToggle) {
                bodyText.add(Text.empty()
                        .append(Text.literal("Łuk Legolasa: ").setStyle(Style.EMPTY.withColor(TextColor.fromRgb(0x56FCA9)).withBold(true)))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.lukLegolasaDropped)).formatted(Formatting.WHITE)));
            }
            if (Config.INSTANCE.arbaletToggle) {
                bodyText.add(Text.empty()
                        .append(Text.literal("Arbalet: ").formatted(Formatting.GOLD, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.arbaletDropped)).formatted(Formatting.WHITE)));
            }
            if (Config.INSTANCE.powrotOdysaToggle) {
                bodyText.add(Text.empty()
                        .append(Text.literal("Powrót Odysa: ").formatted(Formatting.GREEN, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.powrotOdysaDropped)).formatted(Formatting.WHITE)));
            }
            if (Config.INSTANCE.cassisToggle) {
                bodyText.add(Text.empty()
                        .append(Text.literal("Cassis: ").formatted(Formatting.AQUA, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.cassisDropped)).formatted(Formatting.WHITE)));
            }
            if (Config.INSTANCE.cuirassToggle) {
                bodyText.add(Text.empty()
                        .append(Text.literal("Cuirass: ").formatted(Formatting.AQUA, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.cuirassDropped)).formatted(Formatting.WHITE)));
            }
            if (Config.INSTANCE.cuissotToggle) {
                bodyText.add(Text.empty()
                        .append(Text.literal("Cuissot: ").formatted(Formatting.AQUA, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.cuissotDropped)).formatted(Formatting.WHITE)));
            }
            if (Config.INSTANCE.cossetToggle) {
                bodyText.add(Text.empty()
                        .append(Text.literal("Cosset: ").formatted(Formatting.AQUA, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.cossetDropped)).formatted(Formatting.WHITE)));
            }
            if (Config.INSTANCE.kapcieLotnikaToggle) {
                bodyText.add(Text.empty()
                        .append(Text.literal("Kapcie lotnika: ").formatted(Formatting.AQUA, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.kapcieLotnikaDropped)).formatted(Formatting.WHITE)));
            }
            if (Config.INSTANCE.rivendellToggle) {
                bodyText.add(Text.empty()
                        .append(Text.literal("Rivendell: ").formatted(Formatting.YELLOW, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.rivendellDropped)).formatted(Formatting.WHITE)));
            }
            if (Config.INSTANCE.impetToggle) {
                bodyText.add(Text.empty()
                        .append(Text.literal("Impet: ").formatted(Formatting.GREEN, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.impetDropped)).formatted(Formatting.WHITE)));
            }
            if (Config.INSTANCE.phloxToggle) {
                bodyText.add(Text.empty()
                        .append(Text.literal("Phlox: ").formatted(Formatting.RED, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.phloxDropped)).formatted(Formatting.WHITE)));
            }
            if (Config.INSTANCE.majsterToggle) {
                bodyText.add(Text.empty()
                        .append(Text.literal("Majster: ").formatted(Formatting.GOLD, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.majsterDropped)).formatted(Formatting.WHITE)));
            }
            if (Config.INSTANCE.magiczneWiaderkoToggle) {
                bodyText.add(Text.empty()
                        .append(Text.literal("Magiczne wiaderko: ").formatted(Formatting.AQUA, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.magiczneWiaderkoDropped)).formatted(Formatting.WHITE)));
            }
            if (Config.INSTANCE.statTrackerToggle) {
                bodyText.add(Text.empty()
                        .append(Text.literal("StatTracker: ").formatted(Formatting.GOLD, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.statTrackerDropped)).formatted(Formatting.WHITE)));
            }
            if (Config.INSTANCE.jajkoNiespodziankaToggle) {
                bodyText.add(Text.empty()
                        .append(Text.literal("Jajko niespodzianka: ").formatted(Formatting.RED, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.jajkoNiespodziankaDropped)).formatted(Formatting.WHITE)));
            }
            if (Config.INSTANCE.klejnotKupieckiToggle) {
                bodyText.add(Text.empty()
                        .append(Text.literal("Klejnot kupiecki: ").formatted(Formatting.YELLOW, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.klejnotKupieckiDropped)).formatted(Formatting.WHITE)));
            }
            if (Config.INSTANCE.kontrolerMagazynowToggle) {
                bodyText.add(Text.empty()
                        .append(Text.literal("Kontroler magazynów: ").formatted(Formatting.GOLD, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.kontrolerMagazynowDropped)).formatted(Formatting.WHITE)));
            }
            if (Config.INSTANCE.tajemniceSkyUPaToggle) {
                bodyText.add(Text.empty()
                        .append(Text.literal("Tajemnice SkyUPa: ").formatted(Formatting.LIGHT_PURPLE, Formatting.BOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.tajemniceSkyUPaDropped)).formatted(Formatting.WHITE)));
            }
        }
        RenderHUD.elementiumHUD = bodyText;
    }
}
