package net.galgan.skyupplus;

import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;

import java.util.List;

public class HUD {

    public static void renderHUD() {
        // Render just before the chat layer so it’s visible above most vanilla elements.
        HudElementRegistry.attachElementBefore(
                VanillaHudElements.CHAT,
                Identifier.of("skyupplus", "hud"),
                HUD::render
        );
    }

    public static void render(DrawContext context, RenderTickCounter counter) {
        if(!Config.INSTANCE.toggleHud) return;
        //Initialize text renderer
        TextRenderer tr = MinecraftClient.getInstance().textRenderer;

        //Set the default offset
        int xOffset = Config.INSTANCE.offsetX;
        int yOffset = Config.INSTANCE.offsetY;

        //Check if there is a quest active
        if (Zadania.isQuestActive && Config.INSTANCE.toggleZadania) {
            //Get the quest name and description
            Text questName = Zadania.questName;
            List<Text> filteredDescription = Zadania.filteredDescription;

            //Draw the quest on screen
            context.drawTextWithShadow(tr, questName, xOffset, yOffset,0xFFFFFFFF);
            yOffset += tr.fontHeight + 2;
            for (Text line : filteredDescription) {
                context.drawTextWithShadow(tr, line, xOffset, yOffset,0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
        }
        //Check if fishing is active
        if (Config.INSTANCE.wyswietlanieRybaka.mode().equals("zawsze") || (Rybak.isFishing && Config.INSTANCE.wyswietlanieRybaka.mode().equals("wedka"))) {
            //Draw the fishing headers
            if (Config.INSTANCE.toggleNiewielka || Config.INSTANCE.togglePrzecietna || Config.INSTANCE.toggleWymiarowa || Config.INSTANCE.toggleOgromna || Config.INSTANCE.toggleMamucia || Config.INSTANCE.toggleSuma || Config.INSTANCE.toggleZarobek) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("» ").formatted(Formatting.BLUE))
                        .append(Text.literal("Rybak").formatted(Formatting.DARK_AQUA, Formatting.BOLD))
                        .append(Text.literal(" «").formatted(Formatting.BLUE)), xOffset, yOffset,0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.toggleNiewielka || Config.INSTANCE.togglePrzecietna || Config.INSTANCE.toggleWymiarowa || Config.INSTANCE.toggleOgromna || Config.INSTANCE.toggleMamucia || Config.INSTANCE.toggleSuma) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("▪ ").formatted(Formatting.DARK_GRAY, Formatting.BOLD))
                        .append(Text.literal("Wyłowione ryby:").formatted(Formatting.AQUA)), xOffset, yOffset,0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            //Draw the numbers for every fish tier
            if (Config.INSTANCE.toggleNiewielka) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("» ").formatted(Formatting.BLUE))
                        .append(Text.literal("Niewielka: ").formatted(Formatting.GRAY))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.niewielka)).formatted(Formatting.GRAY)), xOffset, yOffset,0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.togglePrzecietna) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("» ").formatted(Formatting.BLUE))
                        .append(Text.literal("Przeciętna: ").formatted(Formatting.YELLOW))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.przecietna)).formatted(Formatting.YELLOW)), xOffset, yOffset,0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.toggleWymiarowa) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("» ").formatted(Formatting.BLUE))
                        .append(Text.literal("Wymiarowa: ").formatted(Formatting.GREEN))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.wymiarowa)).formatted(Formatting.GREEN)), xOffset, yOffset,0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.toggleOgromna) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("» ").formatted(Formatting.BLUE))
                        .append(Text.literal("Ogromna: ").formatted(Formatting.GOLD))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.ogromna)).formatted(Formatting.GOLD)), xOffset, yOffset,0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.toggleMamucia) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("» ").formatted(Formatting.BLUE))
                        .append(Text.literal("Mamucia: ").formatted(Formatting.DARK_PURPLE))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.mamucia)).formatted(Formatting.DARK_PURPLE)), xOffset, yOffset,0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.toggleSuma) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("» ").formatted(Formatting.BLUE))
                        .append(Text.literal("Suma: ").formatted(Formatting.WHITE))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.sumaryb)).formatted(Formatting.WHITE)), xOffset, yOffset,0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.toggleZarobek) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("▪ ").formatted(Formatting.DARK_GRAY, Formatting.BOLD))
                        .append(Text.literal("Zarobek z ryb:").formatted(Formatting.AQUA)), xOffset, yOffset,0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
            if (Config.INSTANCE.toggleZarobek) {
                context.drawTextWithShadow(tr, Text.empty()
                        .append(Text.literal("» ").formatted(Formatting.BLUE))
                        .append(Text.literal(String.valueOf(Config.INSTANCE.zarobekzryb)).append(" SC").formatted(Formatting.YELLOW)), xOffset, yOffset,0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
        }
    }
}
