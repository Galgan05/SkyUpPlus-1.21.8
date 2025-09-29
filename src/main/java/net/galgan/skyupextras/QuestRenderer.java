package net.galgan.skyupextras;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.text.Text;

import java.util.List;

public final class QuestRenderer {
    public static void render(DrawContext context, RenderTickCounter counter) {
        //Initialize text renderer
        TextRenderer tr = MinecraftClient.getInstance().textRenderer;
        //Get the quest name and description
        Text questName = DetectQuest.questName;
        List<Text> filteredDescription = DetectQuest.filteredDescription;
        //Stop rendering if there is no quest active
        if (questName == null || !DetectQuest.isQuestActive) return;
        //Set the offset
        int xOffset = 5;
        int yOffset = 5;
        //Draw the quest on screen
        context.drawTextWithShadow(tr, questName, xOffset, yOffset,0xFFFFFFFF);
        yOffset += tr.fontHeight + 2;
        for (Text line : filteredDescription) {
            context.drawTextWithShadow(tr, line, xOffset, yOffset,0xFFFFFFFF);
            yOffset += tr.fontHeight + 2;
        }
    }
}
