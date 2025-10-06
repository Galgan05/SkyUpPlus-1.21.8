package net.galgan.skyupplus.hud;

import net.galgan.skyupplus.config.Config;
import net.galgan.skyupplus.features.Quests;
import net.galgan.skyupplus.utility.Chat;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.List;

public class QuestsHUD {

    public static void generateBody() {
        List<Text> bodyText = new ArrayList<>();

        if (Quests.isQuestActive && Config.INSTANCE.toggleQuests) {

           List<Text> description = Quests.filteredDescription;

            for (Text line : description) {
                if (line.getSiblings().isEmpty()) {
                    bodyText.add(line);
                }

                List<Text> siblings = line.getSiblings();

                if (!siblings.isEmpty() && siblings.get(0).getString().trim().startsWith("▪")) {
                    int startIndex = 1;
                    MutableText result = Text.empty();
                    for (int i = startIndex; i < siblings.size(); i++) {
                        result.append(siblings.get(i).copy().setStyle(siblings.get(i).getStyle().withBold(true)));
                    }
                    bodyText.add(result);
                } else if (!siblings.isEmpty() && siblings.get(1).getString().trim().startsWith("»")) {
                    int startIndex = 2;
                    MutableText result = Text.empty();
                    for (int i = startIndex; i < siblings.size(); i++) {
                        result.append(siblings.get(i).copy().setStyle(siblings.get(i).getStyle()));
                    }
                    bodyText.add(result);
                }
            }
        }

        RenderHUD.questsHUD = bodyText;
    }
}
