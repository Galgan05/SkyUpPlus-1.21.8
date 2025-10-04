package net.galgan.skyupplus.hud;

import net.galgan.skyupplus.config.Config;
import net.galgan.skyupplus.features.Dungeon;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class DungeonHUD {

    public static void dungeonHUD(DrawContext context, TextRenderer tr, int xOffset, int yOffset) {
        if (Config.INSTANCE.onCooldown && Config.INSTANCE.dungeonCooldownToggle) {
            context.drawTextWithShadow(tr, Text.empty()
                    .append(Text.literal("» ").formatted(Formatting.BLUE))
                    .append(Text.literal("Dungeony").formatted(Formatting.GRAY, Formatting.BOLD))
                    .append(Text.literal(" «").formatted(Formatting.BLUE)), xOffset, yOffset,0xFFFFFFFF);
            yOffset += tr.fontHeight + 2;
            context.drawTextWithShadow(tr, Text.empty()
                    .append(Text.literal("▪ ").formatted(Formatting.DARK_GRAY, Formatting.BOLD))
                    .append(Text.literal("Cooldown: ").formatted(Formatting.AQUA))
                    .append(Text.literal(String.format("%02d:%02d", Dungeon.min, Dungeon.sec)).formatted(Formatting.YELLOW)), xOffset, yOffset,0xFFFFFFFF);
            yOffset += (tr.fontHeight + 2) * 2;
        }

        HUD.yOffset = yOffset;
    }
}
