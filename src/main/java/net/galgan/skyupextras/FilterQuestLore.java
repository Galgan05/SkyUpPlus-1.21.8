package net.galgan.skyupextras;

import net.minecraft.component.type.LoreComponent;
import net.minecraft.text.Text;


import java.util.ArrayList;
import java.util.List;

public class FilterQuestLore {
    public static List<Text> loreFilter(LoreComponent questLore) {
        List<Text> output = new ArrayList<>();
        boolean addNext = false;

        for (Text line : questLore.lines()) {
            String s = line.getString().trim();

            if (s.startsWith("▪")) {
                if (s.startsWith("▪ Opis") || s.startsWith("▪ Za ukończenie") || s.startsWith("▪ LPM") || s.startsWith("▪ Uwaga") || s.startsWith("▪ Kategoria")) {
                    addNext = false;
                } else {
                    output.add(line);
                    addNext = true;
                }
            } else {
                if (addNext) output.add(line);
            }
        }
        return output;
    }
}
