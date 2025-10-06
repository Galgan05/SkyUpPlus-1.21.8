package net.galgan.skyupplus.features;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.galgan.skyupplus.utility.ServerRestrictor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.scoreboard.*;
import net.minecraft.text.Text;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Scoreboard {

    public static List<Text> sboard = new ArrayList<>();

    public static void scoreboard() {

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(!ServerRestrictor.isAllowed()) return;

            if (client.player == null) return;

            sboard = getSboard(client);
        });
    }

    public static List<Text> getSboard(MinecraftClient client) {
        if (client.getNetworkHandler() == null) return List.of();

        net.minecraft.scoreboard.Scoreboard scoreboard = client.getNetworkHandler().getScoreboard();
        ScoreboardObjective sidebar = scoreboard.getObjectiveForSlot(ScoreboardDisplaySlot.SIDEBAR);
        if (sidebar == null) return List.of();

        List<ScoreboardEntry> entries = new ArrayList<>(scoreboard.getScoreboardEntries(sidebar));

        entries.sort(Comparator
                .comparingInt(ScoreboardEntry::value).reversed()
                .thenComparing(e -> e.name().getString()));

        if (entries.size() > 15) entries = entries.subList(0, 15);

        List<Text> lines = new ArrayList<>();
        for (ScoreboardEntry e : entries) {
            if (e.hidden()) continue;

            Text left;
            if (e.display() != null) {
                // server provided a prebuilt line text
                left = e.display();
            } else {
                // build it the vanilla way: team prefix/suffix + base name
                Team team = scoreboard.getScoreHolderTeam(e.owner());
                Text base = e.name();                    // may be empty
                left = team != null ? Team.decorateName(team, base) : base;
            }

            // If you also want the number on the right:
            // Text number = e.formatted(sidebar.numberFormat().orElse(null));

            lines.add(left);
        }
        return lines;
    }
}
