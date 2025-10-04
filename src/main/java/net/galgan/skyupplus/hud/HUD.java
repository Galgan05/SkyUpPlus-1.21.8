package net.galgan.skyupplus.hud;

import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;
import net.galgan.skyupplus.config.Config;
import net.galgan.skyupplus.utility.Chat;
import net.galgan.skyupplus.utility.ServerRestrictor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.util.Identifier;


public class HUD {

    public static int xOffset = Config.INSTANCE.offsetX;
    public static int yOffset = Config.INSTANCE.offsetY;

    public static void renderHUD() {

        HudElementRegistry.attachElementBefore(
                VanillaHudElements.CHAT,
                Identifier.of("skyupplus", "hud"),
                HUD::render
        );
    }

    public static void render(DrawContext context, RenderTickCounter counter) {
        if(!ServerRestrictor.isAllowed()) return;

        if(Config.INSTANCE.toggleHud) {
            TextRenderer tr = MinecraftClient.getInstance().textRenderer;

            DungeonHUD.dungeonHUD(context, tr, xOffset, yOffset);
            CratesHUD.cratesHUD(context, tr, xOffset, yOffset);
            FishingHUD.fishingHUD(context, tr, xOffset, yOffset);
            QuestsHUD.questsHUD(context, tr, xOffset, yOffset);

            yOffset = Config.INSTANCE.offsetY;
        }
    }
}
