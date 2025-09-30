package net.galgan.skyupplus.mixin;

import net.minecraft.client.gui.hud.BossBarHud;
import net.minecraft.client.gui.hud.ClientBossBar;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;
import java.util.UUID;

@Mixin(BossBarHud.class)
public interface BossBarHudAccessor {
    // Field name in Yarn is "bossBars" (Map<UUID, ClientBossBar>)
    @Accessor("bossBars")
    Map<UUID, ClientBossBar> getBossBarsMap();
}