package net.galgan.skyupplus;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class Rybak {
    public static boolean isFishing;

    public static void handlerRybaka() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null) return;

            ItemStack mainHand = client.player.getMainHandStack();
            ItemStack offHand = client.player.getOffHandStack();

            isFishing = mainHand.isOf(Items.FISHING_ROD) || offHand.isOf(Items.FISHING_ROD);
        });

        ClientReceiveMessageEvents.GAME.register((message, overlay) -> {
            if (!overlay && message.getString().startsWith("Wędkarstwo » ")) {
                if (message.getString().startsWith("Wędkarstwo » Wyłowiono: Niew")) {
                    Config.INSTANCE.niewielka++;
                }
                if (message.getString().startsWith("Wędkarstwo » Wyłowiono: Prze")) {
                    Config.INSTANCE.przecietna++;
                }
                if (message.getString().startsWith("Wędkarstwo » Wyłowiono: Wymi")) {
                    Config.INSTANCE.wymiarowa++;
                }
                if (message.getString().startsWith("Wędkarstwo » Wyłowiono: Ogro")) {
                    Config.INSTANCE.ogromna++;
                }
                if (message.getString().startsWith("Wędkarstwo » Wyłowiono: Mamu")) {
                    Config.INSTANCE.mamucia++;
                }
                Config.INSTANCE.sumaryb = Config.INSTANCE.niewielka + Config.INSTANCE.przecietna + Config.INSTANCE.wymiarowa + Config.INSTANCE.ogromna + Config.INSTANCE.mamucia;
                Config.save();
            }

            if (!overlay && message.getString().startsWith("Wędkarstwo » Sprz")) {
                String wiadomosc = message.getString().split("za ")[1].split(" SC")[0];
                wiadomosc = wiadomosc.replace(",", ".");
                double zarobek = Double.parseDouble(wiadomosc);

                Config.INSTANCE.zarobekzryb += zarobek;
                Config.save();
            }
        });
    }
}
