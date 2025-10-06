package net.galgan.skyupplus.features;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.galgan.skyupplus.config.Config;
import net.galgan.skyupplus.utility.ServerRestrictor;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Notiffications {
    public static void notiffications() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(!ServerRestrictor.isAllowed()) return;
            if (!Config.INSTANCE.toggleDaily) return;
            if (client.player == null) return;

            ZonedDateTime polishTime = ZonedDateTime.now(ZoneId.of("Europe/Warsaw"));

            if (polishTime.getDayOfYear() != Config.INSTANCE.currentDay ) {
                Config.INSTANCE.currentDay = polishTime.getDayOfYear();
                Config.INSTANCE.seenTodaysDaily = false;
                Config.save();
            }
        });
    }
}
