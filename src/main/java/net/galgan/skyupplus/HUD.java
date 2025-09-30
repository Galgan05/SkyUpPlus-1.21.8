package net.galgan.skyupplus;

import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class HUD {

    public static void renderHud() {
        // Render just before the chat layer so it’s visible above most vanilla elements.
        HudElementRegistry.attachElementBefore(
                VanillaHudElements.CHAT,
                Identifier.of("skyupextras", "quest_display"),
                HUD::render
        );
    }

    public static void render(DrawContext context, RenderTickCounter counter) {
        //Initialize text renderer
        TextRenderer tr = MinecraftClient.getInstance().textRenderer;

        //Set the default offset
        int xOffset = 5;
        int yOffset = 5;

        //Check if there is a quest active
        if (Quests.isQuestActive) {
            //Get the quest name and description
            Text questName = Quests.questName;
            List<Text> filteredDescription = Quests.filteredDescription;

            //Draw the quest on screen
            context.drawTextWithShadow(tr, questName, xOffset, yOffset,0xFFFFFFFF);
            yOffset += tr.fontHeight + 2;
            for (Text line : filteredDescription) {
                context.drawTextWithShadow(tr, line, xOffset, yOffset,0xFFFFFFFF);
                yOffset += tr.fontHeight + 2;
            }
        }
        //Check if fishing is active
        if (Fishing.isFishing && ConfigGenerator.togglerybak) {
            //Draw the fishing headers
            context.drawTextWithShadow(tr, Text.empty()
                    .append(Text.literal("» ").styled(s -> s.withColor(0x5555FF)))
                    .append(Text.literal("Rybak").styled(s -> s.withColor(0x00AAAA).withBold(true)))
                    .append(Text.literal(" «").styled(s -> s.withColor(0x5555FF))), xOffset, yOffset,0xFFFFFFFF);
            yOffset += tr.fontHeight + 2;
            context.drawTextWithShadow(tr, Text.empty()
                    .append(Text.literal("▪ ").styled(s -> s.withColor(0x555555).withBold(true)))
                    .append(Text.literal("Wyłowione ryby:").styled(s -> s.withColor(0x55FFFF))), xOffset, yOffset,0xFFFFFFFF);
            yOffset += tr.fontHeight + 2;
            //Draw the numbers for every fish tier
            context.drawTextWithShadow(tr, Text.empty()
                    .append(Text.literal("  » ").styled(s -> s.withColor(0x5555FF)))
                    .append(Text.literal("Niewielka: ").styled(s -> s.withColor(0xAAAAAA)))
                    .append(Text.literal(String.valueOf(ConfigGenerator.niewielka)).styled(s -> s.withColor(0xAAAAAA))), xOffset, yOffset,0xFFFFFFFF);
            yOffset += tr.fontHeight + 2;
            context.drawTextWithShadow(tr, Text.empty()
                    .append(Text.literal("  » ").styled(s -> s.withColor(0x5555FF)))
                    .append(Text.literal("Przeciętna: ").styled(s -> s.withColor(0xFFFF55)))
                    .append(Text.literal(String.valueOf(ConfigGenerator.przecietna)).styled(s -> s.withColor(0xFFFF55))), xOffset, yOffset,0xFFFFFFFF);
            yOffset += tr.fontHeight + 2;
            context.drawTextWithShadow(tr, Text.empty()
                    .append(Text.literal("  » ").styled(s -> s.withColor(0x5555FF)))
                    .append(Text.literal("Wymiarowa: ").styled(s -> s.withColor(0x55FF55)))
                    .append(Text.literal(String.valueOf(ConfigGenerator.wymiarowa)).styled(s -> s.withColor(0x55FF55))), xOffset, yOffset,0xFFFFFFFF);
            yOffset += tr.fontHeight + 2;
            context.drawTextWithShadow(tr, Text.empty()
                    .append(Text.literal("  » ").styled(s -> s.withColor(0x5555FF)))
                    .append(Text.literal("Ogromna: ").styled(s -> s.withColor(0xFFAA00)))
                    .append(Text.literal(String.valueOf(ConfigGenerator.ogromna)).styled(s -> s.withColor(0xFFAA00))), xOffset, yOffset,0xFFFFFFFF);
            yOffset += tr.fontHeight + 2;
            context.drawTextWithShadow(tr, Text.empty()
                    .append(Text.literal("  » ").styled(s -> s.withColor(0x5555FF)))
                    .append(Text.literal("Mamucia: ").styled(s -> s.withColor(0xAA00AA)))
                    .append(Text.literal(String.valueOf(ConfigGenerator.mamucia)).styled(s -> s.withColor(0xAA00AA))), xOffset, yOffset,0xFFFFFFFF);
            yOffset += tr.fontHeight + 2;
            context.drawTextWithShadow(tr, Text.empty()
                    .append(Text.literal("  » ").styled(s -> s.withColor(0x5555FF)))
                    .append(Text.literal("Suma: ").styled(s -> s.withColor(0xFFFFFF)))
                    .append(Text.literal(String.valueOf(ConfigGenerator.sumaryb)).styled(s -> s.withColor(0xFFFFFF))), xOffset, yOffset,0xFFFFFFFF);
            yOffset += tr.fontHeight + 2;
            context.drawTextWithShadow(tr, Text.empty()
                    .append(Text.literal("▪ ").styled(s -> s.withColor(0x555555).withBold(true)))
                    .append(Text.literal("Zarobek z ryb:").styled(s -> s.withColor(0x55FFFF))), xOffset, yOffset,0xFFFFFFFF);
            yOffset += tr.fontHeight + 2;
            context.drawTextWithShadow(tr, Text.empty()
                    .append(Text.literal("  » ").styled(s -> s.withColor(0x5555FF)))
                    .append(Text.literal(String.valueOf(ConfigGenerator.zarobekzryb)).append(" SC").styled(s -> s.withColor(0xFFFF55))), xOffset, yOffset,0xFFFFFFFF);
            yOffset += tr.fontHeight + 2;

        }
    }
}
