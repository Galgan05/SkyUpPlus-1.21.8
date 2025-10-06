package net.galgan.skyupplus.hud;

import net.galgan.skyupplus.config.Config;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.ArrayList;
import java.util.List;

public class NotifficationsHUD {

    public static void generateBody() {
        List<Text> bodyText = new ArrayList<>();

        if (!Config.INSTANCE.seenTodaysDaily && Config.INSTANCE.toggleDaily) {
            bodyText.add(Text.empty()
                    .append(Text.literal("Dostępne jest nowe zadanie codzienne!").formatted(Formatting.WHITE)));
        }

        RenderHUD.notifficationsHUD = bodyText;
    }
}
