package net.galgan.skyupplus.hud;

import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.galgan.skyupplus.utility.ServerRestrictor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;


public class RenderHUD {

    public static int yOffsetLeft = 2;
    public static int yOffsetRight = 2;

    public static List<Text> cooldownHUD = new ArrayList<>();
    public static List<Text> fishingHUD = new ArrayList<>();
    public static List<Text> elementiumHUD = new ArrayList<>();
    public static List<Text> platinumHUD = new ArrayList<>();
    public static List<Text> questsHUD = new ArrayList<>();


    public static void renderHUD() {

        HudElementRegistry.attachElementBefore(
                VanillaHudElements.CHAT,
                Identifier.of("skyupplus", "testhud"),
                RenderHUD::render
        );
    }

    public static void render(DrawContext context, RenderTickCounter counter) {
        if(!ServerRestrictor.isAllowed()) return;

        CooldownHUD.generateBody();
        FishingHUD.generateBody();
        PlatinumHUD.generateBody();
        ElementiumHUD.generateBody();
        QuestsHUD.generateBody();

        if (!cooldownHUD.isEmpty()) {
            drawLeftBorderedText(context, yOffsetLeft, 0xFFFF55FF, "COOLDOWN", cooldownHUD);
            drawRightBorderedText(context, yOffsetRight, 0xFFFF55FF, "COOLDOWN", cooldownHUD);
        }
        if (!elementiumHUD.isEmpty()) {
            drawLeftBorderedText(context, yOffsetLeft, 0xFF55FFFF, "ELEMENTIUM", elementiumHUD);
            drawRightBorderedText(context, yOffsetRight, 0xFF55FFFF, "ELEMENTIUM", elementiumHUD);
        }
        if (!platinumHUD.isEmpty()) {
            drawLeftBorderedText(context, yOffsetLeft, 0xFF55FF55, "PLATINUM", platinumHUD);
            drawRightBorderedText(context, yOffsetRight, 0xFF55FF55, "PLATINUM", platinumHUD);
        }
        if (!fishingHUD.isEmpty()) {
            drawLeftBorderedText(context, yOffsetLeft, 0xFF00AAAA, "RYBAK", fishingHUD);
            drawRightBorderedText(context, yOffsetRight, 0xFF00AAAA, "RYBAK", fishingHUD);
        }
        if (!questsHUD.isEmpty()) {
            drawLeftBorderedText(context, yOffsetLeft, 0xFFFFAA00, "ZADANIA", questsHUD);
            drawRightBorderedText(context, yOffsetRight, 0xFFFFAA00, "ZADANIA", questsHUD);
        }

        yOffsetLeft = 2;
        yOffsetRight = 2;
    }


    public static void drawLeftBorderedText(DrawContext context, int y, int color, String title, List<Text> body) {
        TextRenderer tr = MinecraftClient.getInstance().textRenderer;

        int x = 2;
        int textHeight = 0;
        int textWidth = 0;
        int shadowColor = (color & 0xFCFCFC) >> 2 | (color & 0xFF000000);

        for(Text line : body) {
            textHeight += tr.fontHeight + 2;
            if (tr.getWidth(line) > textWidth) {
                textWidth = tr.getWidth(line);
            }
        }

        if (tr.getWidth(Text.literal(title).setStyle(Style.EMPTY.withColor(TextColor.fromRgb(color)).withBold(true))) > textWidth) {
            textWidth = tr.getWidth(Text.literal(title).setStyle(Style.EMPTY.withColor(TextColor.fromRgb(color)).withBold(true)));
        }

        context.drawTextWithShadow(tr, Text.literal(title).setStyle(Style.EMPTY.withColor(TextColor.fromRgb(color)).withBold(true)), x, y,0xFFFFFFFF);

        y += 9;

        context.fill(
                x + 1,
                y + 1,
                x + textWidth + 4,
                y + textHeight + 2,
                0x80000000
        );

        context.drawBorder(
                x + 1,
                y + 1,
                textWidth + 5,
                textHeight + 3,
                shadowColor
        );

        context.drawBorder(
                x,
                y,
                textWidth + 5,
                textHeight + 3,
                color
        );

        x += 3;
        y += 3;

        for(Text line : body) {
            context.drawTextWithShadow(tr, line, x, y,0xFFFFFFFF);
            y += tr.fontHeight + 2;
        }

        yOffsetLeft = y + 4;
    }

    public static void drawRightBorderedText(DrawContext context, int y, int color, String title, List<Text> body) {
        TextRenderer tr = MinecraftClient.getInstance().textRenderer;

        int textHeight = 0;
        int textWidth = 0;
        int shadowColor = (color & 0xFCFCFC) >> 2 | (color & 0xFF000000);

        for(Text line : body) {
            textHeight += tr.fontHeight + 2;
            if (tr.getWidth(line) > textWidth) {
                textWidth = tr.getWidth(line);
            }
        }

        if (tr.getWidth(Text.literal(title).setStyle(Style.EMPTY.withColor(TextColor.fromRgb(color)).withBold(true))) > textWidth) {
            textWidth = tr.getWidth(Text.literal(title).setStyle(Style.EMPTY.withColor(TextColor.fromRgb(color)).withBold(true)));
        }

        int x = context.getScaledWindowWidth() - textWidth - 8;

        int xTitle = context.getScaledWindowWidth() - tr.getWidth(Text.literal(title).setStyle(Style.EMPTY.withColor(TextColor.fromRgb(color)).withBold(true))) - 2;

        context.drawTextWithShadow(tr, Text.literal(title).setStyle(Style.EMPTY.withColor(TextColor.fromRgb(color)).withBold(true)), xTitle, y,0xFFFFFFFF);

        y += 9;

        context.fill(
                x + 1,
                y + 1,
                x + textWidth + 4,
                y + textHeight + 2,
                0x80000000
        );

        context.drawBorder(
                x + 1,
                y + 1,
                textWidth + 5,
                textHeight + 3,
                shadowColor
        );

        context.drawBorder(
                x,
                y,
                textWidth + 5,
                textHeight + 3,
                color
        );

        x += 3;
        y += 3;

        for(Text line : body) {
            context.drawTextWithShadow(tr, line, x, y,0xFFFFFFFF);
            y += tr.fontHeight + 2;
        }

        yOffsetRight = y + 4;
    }
}
