package net.galgan.skyupplus.hud;

import net.galgan.skyupplus.config.Config;
import net.galgan.skyupplus.features.Quests;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;

import java.util.List;

public class QuestsHUD {

    public static void questsHUD(DrawContext context, TextRenderer tr, int xOffset, int yOffset) {
        if (Quests.isQuestActive && Config.INSTANCE.toggleQuests) {
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

        HUD.yOffset = yOffset;
    }
}
