package net.galgan.skyupplus.features;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents;
import net.galgan.skyupplus.config.Config;
import net.galgan.skyupplus.utility.ServerRestrictor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.text.Text;

public class Crates {

    public static boolean isHoldingElementium;
    public static boolean isHoldingPlatinum;
    private static String playerName;

    public static void crates() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if(!ServerRestrictor.isAllowed()) return;

            if (client.player == null) return;

            Text mainHand = client.player.getMainHandStack().getCustomName();

            if (mainHand != null) {
                isHoldingElementium = mainHand.getString().startsWith("Klucz do Elementium");
                isHoldingPlatinum = mainHand.getString().startsWith("Klucz do Platinum");
            } else {
                isHoldingElementium = false;
                isHoldingPlatinum = false;
            }
        });

        ClientReceiveMessageEvents.GAME.register((message, overlay) -> {
            if(!ServerRestrictor.isAllowed()) return;

            if (!overlay && message.getString().startsWith("SkyCase »")) {
                MinecraftClient client = MinecraftClient.getInstance();
                ClientPlayerEntity player = client.player;

                if (player != null) playerName = player.getName().getString();

                //PLATINUM
                if (message.getString().startsWith("SkyCase » Wygrano: Klucz do Elementium")) {
                    Config.INSTANCE.elementiumDropped++;
                }
                if (message.getString().startsWith("SkyCase » Wygrano: Zaklęta książka (Naprawa I)")) {
                    Config.INSTANCE.mendingDropped++;
                }
                if (message.getString().startsWith("SkyCase » Wygrano: Blok szmaragdu")) {
                    Config.INSTANCE.emeraldBlockDropped = Config.INSTANCE.emeraldBlockDropped + 1;
                }
                if (message.getString().startsWith("SkyCase » Wygrano: 2x Blok szmaragdu")) {
                    Config.INSTANCE.emeraldBlockDropped = Config.INSTANCE.emeraldBlockDropped + 2;
                }
                if (message.getString().startsWith("SkyCase » Wygrano: 3x Blok szmaragdu")) {
                    Config.INSTANCE.emeraldBlockDropped = Config.INSTANCE.emeraldBlockDropped + 3;
                }
                if (message.getString().startsWith("SkyCase » Wygrano: 4x Blok szmaragdu")) {
                    Config.INSTANCE.emeraldBlockDropped = Config.INSTANCE.emeraldBlockDropped + 4;
                }
                if (message.getString().startsWith("SkyCase » Wygrano: 5x Blok szmaragdu")) {
                    Config.INSTANCE.emeraldBlockDropped = Config.INSTANCE.emeraldBlockDropped + 5;
                }

                //ELEMENTIUM
                if (message.getString().startsWith("SkyCase » " + playerName + " otworzył Elementium i wygrał: :: Karambit ::")) {
                    Config.INSTANCE.karambitDropped++;
                }
                if (message.getString().startsWith("SkyCase » " + playerName + " otworzył Elementium i wygrał: :: Perun ::")) {
                    Config.INSTANCE.perunDropped++;
                }
                if (message.getString().startsWith("SkyCase » " + playerName + " otworzył Elementium i wygrał: :: Cymofan ::")) {
                    Config.INSTANCE.cymofanDropped++;
                }
                if (message.getString().startsWith("SkyCase » " + playerName + " otworzył Elementium i wygrał: :: Młot Thora ::")) {
                    Config.INSTANCE.mlotThoraDropped++;
                }
                if (message.getString().startsWith("SkyCase » " + playerName + " otworzył Elementium i wygrał: :: Urizel ::")) {
                    Config.INSTANCE.urizelDropped++;
                }
                if (message.getString().startsWith("SkyCase » " + playerName + " otworzył Elementium i wygrał: :: Azada ::")) {
                    Config.INSTANCE.azadaDropped++;
                }
                if (message.getString().startsWith("SkyCase » " + playerName + " otworzył Elementium i wygrał: :: Spinel ::")) {
                    Config.INSTANCE.spinelDropped++;
                }
                if (message.getString().startsWith("SkyCase » " + playerName + " otworzył Elementium i wygrał: :: Karpiołap ::")) {
                    Config.INSTANCE.karpiolapDropped++;
                }
                if (message.getString().startsWith("SkyCase » " + playerName + " otworzył Elementium i wygrał: :: Etherica ::")) {
                    Config.INSTANCE.ethericaDropped++;
                }
                if (message.getString().startsWith("SkyCase » " + playerName + " otworzył Elementium i wygrał: :: Łuk Legolasa ::")) {
                    Config.INSTANCE.lukLegolasaDropped++;
                }
                if (message.getString().startsWith("SkyCase » " + playerName + " otworzył Elementium i wygrał: :: Arbalet ::")) {
                    Config.INSTANCE.arbaletDropped++;
                }
                if (message.getString().startsWith("SkyCase » " + playerName + " otworzył Elementium i wygrał: :: Powrót Odysa ::")) {
                    Config.INSTANCE.powrotOdysaDropped++;
                }
                if (message.getString().startsWith("SkyCase » " + playerName + " otworzył Elementium i wygrał: :: Cassis ::")) {
                    Config.INSTANCE.cassisDropped++;
                }
                if (message.getString().startsWith("SkyCase » " + playerName + " otworzył Elementium i wygrał: :: Cuirass ::")) {
                    Config.INSTANCE.cuirassDropped++;
                }
                if (message.getString().startsWith("SkyCase » " + playerName + " otworzył Elementium i wygrał: :: Cuissot ::")) {
                    Config.INSTANCE.cuissotDropped++;
                }
                if (message.getString().startsWith("SkyCase » " + playerName + " otworzył Elementium i wygrał: :: Cosset ::")) {
                    Config.INSTANCE.cossetDropped++;
                }
                if (message.getString().startsWith("SkyCase » " + playerName + " otworzył Elementium i wygrał: :: Kapcie lotnika ::")) {
                    Config.INSTANCE.kapcieLotnikaDropped++;
                }
                if (message.getString().startsWith("SkyCase » " + playerName + " otworzył Elementium i wygrał: :: Rivendell ::")) {
                    Config.INSTANCE.rivendellDropped++;
                }
                if (message.getString().startsWith("SkyCase » " + playerName + " otworzył Elementium i wygrał: :: Impet ::")) {
                    Config.INSTANCE.impetDropped++;
                }
                if (message.getString().startsWith("SkyCase » " + playerName + " otworzył Elementium i wygrał: :: Phlox ::")) {
                    Config.INSTANCE.phloxDropped++;
                }
                if (message.getString().startsWith("SkyCase » " + playerName + " otworzył Elementium i wygrał: :: Majster ::")) {
                    Config.INSTANCE.majsterDropped++;
                }
                if (message.getString().startsWith("SkyCase » " + playerName + " otworzył Elementium i wygrał: :: Magiczne wiaderko ::")) {
                    Config.INSTANCE.magiczneWiaderkoDropped++;
                }
                if (message.getString().startsWith("SkyCase » " + playerName + " otworzył Elementium i wygrał: :: StatTracker ::")) {
                    Config.INSTANCE.statTrackerDropped++;
                }
                if (message.getString().startsWith("SkyCase » " + playerName + " otworzył Elementium i wygrał: :: Jajko niespodzianka ::")) {
                    Config.INSTANCE.jajkoNiespodziankaDropped++;
                }
                if (message.getString().startsWith("SkyCase » " + playerName + " otworzył Elementium i wygrał: :: Klejnot kupiecki uniwersalny ::")) {
                    Config.INSTANCE.klejnotKupieckiDropped++;
                }
                if (message.getString().startsWith("SkyCase » " + playerName + " otworzył Elementium i wygrał: :: Kontroler magazynów ::")) {
                    Config.INSTANCE.kontrolerMagazynowDropped++;
                }
                if (message.getString().startsWith("SkyCase » " + playerName + " otworzył Elementium i wygrał: :: Tajemnice SkyUPa v.5 ::")) {
                    Config.INSTANCE.tajemniceSkyUPaDropped++;
                }

                Config.save();
            }
        });
    }
}