package net.galgan.skyupplus.mixin;

import net.galgan.skyupplus.config.Config;
import net.galgan.skyupplus.utility.ServerRestrictor;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.scoreboard.ScoreboardObjective;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class HideVanillaScoreboard {
    @Inject(
            method = "renderScoreboardSidebar(Lnet/minecraft/client/gui/DrawContext;Lnet/minecraft/scoreboard/ScoreboardObjective;)V",
            at = @At("HEAD"),
            cancellable = true
    )
    private void hideScoreboard(DrawContext ctx, ScoreboardObjective objective, CallbackInfo ci) {
        if (Config.INSTANCE.toggleScoreboard && ServerRestrictor.isAllowed()) {
            ci.cancel();
        }
    }
}