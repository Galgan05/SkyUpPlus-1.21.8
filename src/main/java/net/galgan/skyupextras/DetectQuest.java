package net.galgan.skyupextras;

import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.fabricmc.fabric.api.client.screen.v1.ScreenMouseEvents;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;

import java.util.List;

public class DetectQuest {

    public static void questDetection() {
        ScreenEvents.BEFORE_INIT.register((client, screen, w, h) -> {
            //Check if you're inside a container that's valid
            if (!(screen instanceof HandledScreen<?> handled)) return;
            if (!QuestData.containerTitles.contains(handled.getTitle().getString())) return;

            // Register per-screen listeners
            ScreenMouseEvents.beforeMouseClick(screen).register((s, mouseX, mouseY, button) -> {
                //Check if the button clicked was a middle button
                if (button != 2) return;
                //Check if you clicked a valid slot
                Slot slot = ScreenUtil.getSlotAt(handled, mouseX, mouseY);
                if (slot == null) return;
                //Check if the quest is valid
                LoreComponent questLore = slot.getStack().get(DataComponentTypes.LORE);
                if (questLore == null) return;
                if (QuestData.completedLore.equals(questLore.toString())) return;
                if (!QuestData.questNames.contains(slot.getStack().getName().getString())) return;
                //If every check passed, print out the name of the quest
                Text questName = slot.getStack().getName();
                client.inGameHud.getChatHud().addMessage(Text.empty().append(QuestData.questSelectedPrefix).append(questName));
                //Get the filtered description of the quest
                List<Text> filteredDescription = FilterQuestLore.loreFilter(questLore);
                for (Text line : filteredDescription) {
                    client.inGameHud.getChatHud().addMessage(line);
                }

            });
        });
    }
}
