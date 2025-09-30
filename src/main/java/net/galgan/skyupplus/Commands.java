package net.galgan.skyupplus;

import com.mojang.brigadier.arguments.StringArgumentType;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class Commands {
    public static void registerCommands() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, registryAccess) -> {
            dispatcher.register(
                    ClientCommandManager.literal("sup")
                            .then(ClientCommandManager.argument("key", StringArgumentType.word())
                                    .suggests((ctx, builder) -> {
                                        String prefix = builder.getRemaining().toLowerCase();
                                        for (String s : List.of("rybak", "cooldown")) {
                                            if (s.startsWith(prefix)) builder.suggest(s);
                                        }
                                        return builder.buildFuture();
                                    })
                                    .then(ClientCommandManager.argument("value", StringArgumentType.greedyString())
                                            .suggests((ctx, builder) -> {
                                                String key = ctx.getArgument("key", String.class);
                                                String p = builder.getRemaining().toLowerCase();
                                                List<String> vals = switch (key) {
                                                    case "rybak" -> List.of("wlacz", "wylacz", "reset");
                                                    case "cooldown" -> List.of("wlacz", "wylacz");
                                                    default -> List.of();
                                                };
                                                for (String v : vals) if (v.startsWith(p)) builder.suggest(v);
                                                return builder.buildFuture();
                                            })
                                            .executes(ctx -> {
                                                String key = ctx.getArgument("key", String.class);
                                                String value = ctx.getArgument("value", String.class);

                                                switch (key + ":" + value) {
                                                    case "rybak:wlacz" -> {
                                                        ConfigGenerator.togglerybak = true;
                                                        Chat.send(Text.literal("Włączono HUD rybaka!").formatted(Formatting.GREEN));
                                                        ConfigGenerator.save();
                                                    }
                                                    case "rybak:wylacz" -> {
                                                        ConfigGenerator.togglerybak = false;
                                                        Chat.send(Text.literal("Wyłączono HUD rybaka!").formatted(Formatting.RED));
                                                        ConfigGenerator.save();
                                                    }
                                                    case "rybak:reset" -> {
                                                        ConfigGenerator.niewielka = 0;
                                                        ConfigGenerator.przecietna = 0;
                                                        ConfigGenerator.wymiarowa = 0;
                                                        ConfigGenerator.ogromna = 0;
                                                        ConfigGenerator.mamucia = 0;
                                                        ConfigGenerator.sumaryb = 0;
                                                        ConfigGenerator.zarobekzryb = 0;
                                                        Chat.send(Text.literal("Zresetowano licznik rybaka!").formatted(Formatting.YELLOW));
                                                        ConfigGenerator.save();
                                                    }
                                                    case "cooldown:wlacz" -> {
                                                        ConfigGenerator.togglecooldown = true;
                                                        Chat.send(Text.literal("Włączono powiadomienia dźwiękowe cooldownu!").formatted(Formatting.GREEN));
                                                        ConfigGenerator.save();
                                                    }
                                                    case "cooldown:wylacz" -> {
                                                        ConfigGenerator.togglecooldown = false;
                                                        Chat.send(Text.literal("Wyłączono powiadomienia dźwiękowe cooldownu!").formatted(Formatting.RED));
                                                        ConfigGenerator.save();
                                                    }
                                                }
                                                return 1;
                                            })
                                    )
                            )
            );
        });
    }
}
