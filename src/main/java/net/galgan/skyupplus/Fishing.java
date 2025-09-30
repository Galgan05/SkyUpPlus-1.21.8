package net.galgan.skyupplus;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class Fishing {
    public static boolean isFishing;

    public static void fishingStats() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null) return;

            ItemStack mainHand = client.player.getMainHandStack();
            ItemStack offHand = client.player.getOffHandStack();

            isFishing = mainHand.isOf(Items.FISHING_ROD) || offHand.isOf(Items.FISHING_ROD);
        });

        ClientReceiveMessageEvents.GAME.register((message, overlay) -> {
            if (overlay || !message.getString().startsWith("Wędkarstwo » ")) return;
            //Detect fish tier
            if (message.getString().startsWith("Wędkarstwo » Wyłowiono: Niew")) ConfigGenerator.niewielka++;
            if (message.getString().startsWith("Wędkarstwo » Wyłowiono: Prze")) ConfigGenerator.przecietna++;
            if (message.getString().startsWith("Wędkarstwo » Wyłowiono: Wymi")) ConfigGenerator.wymiarowa++;
            if (message.getString().startsWith("Wędkarstwo » Wyłowiono: Ogro")) ConfigGenerator.ogromna++;
            if (message.getString().startsWith("Wędkarstwo » Wyłowiono: Mamu")) ConfigGenerator.mamucia++;
            ConfigGenerator.sumaryb = ConfigGenerator.niewielka + ConfigGenerator.przecietna + ConfigGenerator.wymiarowa + ConfigGenerator.ogromna + ConfigGenerator.mamucia;

            if (message.getString().startsWith("Wędkarstwo » Sprz")) {
                String wiadomosc = message.getString().split("za ")[1].split(" SC")[0];
                wiadomosc = wiadomosc.replace(",", ".");
                double zarobek = Double.parseDouble(wiadomosc);
                ConfigGenerator.zarobekzryb += zarobek;
            }

            ConfigGenerator.save();
        });
    }
}
