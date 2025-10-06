package net.galgan.skyupplus.hud;

import net.galgan.skyupplus.features.Scoreboard;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.List;

public class ScoreboardHUD {

    public static void generateBody() {
        List<Text> bodyText = new ArrayList<>();

        List<Text> scoreboard = Scoreboard.sboard;

        for (Text line : scoreboard) {
            if (!line.getString().startsWith(" §a§5§b")) {
                List<Text> siblings = line.getSiblings().getFirst().getSiblings();

                if (siblings.get(1).getString().trim().startsWith("»")) {
                    int startIndex = 2;
                    MutableText result = Text.empty();
                    for (int i = startIndex; i < siblings.size(); i++) {
                        result.append(siblings.get(i).copy().setStyle(siblings.get(i).getStyle()));
                        if (i == siblings.size() - 1) {
                            result.append(Text.literal(":").setStyle(siblings.get(i).getStyle()));
                        }
                    }
                    bodyText.add(result);
                } else {
                    bodyText.add(line);
                }
            }
        }
        RenderHUD.scoreboardHUD = bodyText;
    }
}
