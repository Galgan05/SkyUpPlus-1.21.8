package net.galgan.skyupplus;

import net.galgan.skyupplus.mixin.HandledScreenAccess;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.screen.slot.Slot;

public final class ScreenUtil {

    public static Slot getSlotAt(HandledScreen<?> screen, double x, double y) {
        return ((HandledScreenAccess) (Object) screen).invokeGetSlotAt(x, y);
    }
}