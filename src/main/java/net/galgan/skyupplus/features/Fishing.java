package net.galgan.skyupplus.features;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents;
import net.galgan.skyupplus.config.Config;
import net.galgan.skyupplus.utility.ServerRestrictor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class Fishing {
    public static boolean isFishing;

    public static void fishing() {

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(!ServerRestrictor.isAllowed()) return;

            if (client.player == null) return;

            ItemStack mainHand = client.player.getMainHandStack();
            ItemStack offHand = client.player.getOffHandStack();

            isFishing = mainHand.isOf(Items.FISHING_ROD) || offHand.isOf(Items.FISHING_ROD);
        });

        ClientReceiveMessageEvents.GAME.register((message, overlay) -> {
            if(!ServerRestrictor.isAllowed()) return;

            if (!overlay && message.getString().startsWith("Wędkarstwo » ")) {
                if (message.getString().startsWith("Wędkarstwo » Wyłowiono: Niew")) {
                    Config.INSTANCE.niewielkaCount++;
                }
                if (message.getString().startsWith("Wędkarstwo » Wyłowiono: Prze")) {
                    Config.INSTANCE.przecietnaCount++;
                }
                if (message.getString().startsWith("Wędkarstwo » Wyłowiono: Wymi")) {
                    Config.INSTANCE.wymiarowaCount++;
                }
                if (message.getString().startsWith("Wędkarstwo » Wyłowiono: Ogro")) {
                    Config.INSTANCE.ogromnaCount++;
                }
                if (message.getString().startsWith("Wędkarstwo » Wyłowiono: Mamu")) {
                    Config.INSTANCE.mamuciaCount++;
                }
                if (message.getString().startsWith("Wędkarstwo » Sprz")) {
                    String price = message.getString().split("za ")[1].split(" SC")[0];
                    price = price.replace(",", ".");
                    price = price.replace(" ", "");
                    double earned = Double.parseDouble(price);
                    Config.INSTANCE.totalEarned += earned;
                }
                if (message.getString().startsWith("Wędkarstwo » Wyłowiono:")) {
                    String mass = message.getString().split(" \\(")[1].split("g, ")[0];
                    double weight = Double.parseDouble(mass);

                    Config.INSTANCE.totalWeight += weight;

                    if (weight > Config.INSTANCE.biggestWeight || Config.INSTANCE.biggestWeight == 0) Config.INSTANCE.biggestWeight = weight;
                    if (weight < Config.INSTANCE.smallestWeight || Config.INSTANCE.smallestWeight == 0) Config.INSTANCE.smallestWeight = weight;
                }
                Config.INSTANCE.totalCount = Config.INSTANCE.niewielkaCount + Config.INSTANCE.przecietnaCount + Config.INSTANCE.wymiarowaCount + Config.INSTANCE.ogromnaCount + Config.INSTANCE.mamuciaCount;
                Config.save();
            }
        });
    }
}