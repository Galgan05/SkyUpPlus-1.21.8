package net.galgan.skyupplus.features;

import net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.fabricmc.fabric.api.client.screen.v1.ScreenMouseEvents;
import net.galgan.skyupplus.config.Config;
import net.galgan.skyupplus.mixin.HandledScreenAccess;
import net.galgan.skyupplus.utility.Chat;
import net.galgan.skyupplus.utility.ServerRestrictor;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Quests {
    public static Text questName;
    public static List<Text> filteredDescription;
    public static boolean isQuestActive;

    public static void quests() {

        ScreenEvents.BEFORE_INIT.register((client, screen, w, h) -> {
            if(!ServerRestrictor.isAllowed()) return;


            if(!Config.INSTANCE.toggleQuests) return;
            if (!(screen instanceof HandledScreen<?> handled)) return;
            if (!containerTitles.contains(handled.getTitle().getString())) return;


            ScreenMouseEvents.beforeMouseClick(screen).register((s, mouseX, mouseY, button) -> {

                if (button != 2) return;

                Slot slot = getSlotAt(handled, mouseX, mouseY);
                if (slot == null) {
                    questName = null;
                    filteredDescription = null;
                    isQuestActive = false;
                    return;
                }

                LoreComponent questLore = slot.getStack().get(DataComponentTypes.LORE);

                if (questLore == null) {
                    questName = null;
                    filteredDescription = null;
                    isQuestActive = false;
                    return;
                }

                for(Text line : questLore.lines()) {
                    if (line.getString().startsWith("▪ Zadanie ukończone!")) {
                        questName = null;
                        filteredDescription = null;
                        isQuestActive = false;
                        return;
                    }
                }

                questName = slot.getStack().getName();

                if (!((questName.getString().startsWith("» ") && !handled.getTitle().getString().equals("\uE003\uE150\uE002Wyzwania")) || questName.getString().equals("» Zadanie codzienne «"))) {
                    questName = null;
                    filteredDescription = null;
                    isQuestActive = false;
                    return;
                }

                isQuestActive = true;

                if (questName.getString().equals("» Zadanie codzienne «")) {
                    Config.INSTANCE.seenTodaysDaily = true;
                    Config.save();
                }

                Chat.send(Text.empty().append(Text.literal("Wybrano zadanie: ").formatted(Formatting.DARK_AQUA)).append(questName));

                filteredDescription = loreFilter(questLore);
            });
        });

        ClientReceiveMessageEvents.GAME.register((message, overlay) -> {
            if(!ServerRestrictor.isAllowed()) return;

            if (!overlay && message.getString().startsWith("Wyzwania » Ukończono zadanie")) {
                isQuestActive = false;
            }
        });
    }

    public static Slot getSlotAt(HandledScreen<?> screen, double x, double y) {
        return ((HandledScreenAccess) screen).invokeGetSlotAt(x, y);
    }

    public static List<Text> loreFilter(LoreComponent questLore) {
        List<Text> filtered = new ArrayList<>();
        boolean addNext = false;

        for (Text line : questLore.lines()) {
            String s = line.getString().trim();

            if (!s.isEmpty()) {
                if (s.startsWith("▪")) {
                    if (s.startsWith("▪ Opis") || s.startsWith("▪ Zalecane") || s.startsWith("▪ Za ukończenie") || s.startsWith("▪ LPM") || s.startsWith("▪ Uwaga") || s.startsWith("▪ Kategoria")) {
                        addNext = false;
                    } else {
                        filtered.add(line);
                        addNext = true;
                    }
                } else {
                    if (addNext) filtered.add(line);
                }
            }
        }
        return filtered;
    }

    public static final Set<String> containerTitles = Set.of(
            "\uE003\uE150\uE002Wyzwania",
            "\uE001\uE151\uE002Wyzwania » Nowicjusz",
            "\uE001\uE152\uE002Wyzwania » Wtajemniczony",
            "\uE001\uE153\uE002Wyzwania » Zaawansowany",
            "\uE001\uE154\uE002Wyzwania » Znawca",
            "\uE001\uE155\uE002Wyzwania » Ekspert",
            "\uE001\uE156\uE002Wyzwania » Mistrz",
            "\uE001\uE157\uE002Wyzwania » Guru",
            "\uE001\uE158\uE002Wyzwania » Legenda",
            "\uE001\uE159\uE002Wyzwania » Wirtuoz",
            "\uE001\uE15A\uE002Wyzwania » Bonus"
    );
}
