package net.galgan.skyupplus;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;


public final class Ustawienia {

    private Ustawienia() {}

    public static Screen create(Screen parent) {
        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(Text.empty()
                        .append(Text.literal("Sky").formatted(Formatting.AQUA, Formatting.BOLD))
                        .append(Text.literal("UP").formatted(Formatting.WHITE, Formatting.BOLD))
                        .append(Text.literal("+ ").formatted(Formatting.LIGHT_PURPLE, Formatting.BOLD))
                        .append(Text.literal("» ").formatted(Formatting.DARK_GRAY, Formatting.BOLD))
                        .append(Text.literal("Ustawienia").formatted(Formatting.YELLOW, Formatting.BOLD)));

        // Ensure we save file when user clicks Done.
        builder.setSavingRunnable(Config::save);


        ConfigEntryBuilder eb = builder.entryBuilder();
        ConfigCategory zadania = builder.getOrCreateCategory(Text.literal("Zadania").formatted(Formatting.GOLD, Formatting.BOLD));
        ConfigCategory rybak = builder.getOrCreateCategory(Text.literal("Rybak").formatted(Formatting.DARK_AQUA, Formatting.BOLD));
        ConfigCategory umiejetnosci = builder.getOrCreateCategory(Text.literal("Umiejętności").formatted(Formatting.LIGHT_PURPLE, Formatting.BOLD));


        zadania.addEntry(
                eb.startBooleanToggle(Text.literal("Wyświetlanie zadań"), Config.INSTANCE.toggleZadania)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Wyświetlanie zadań").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Pozwala na wyświetlanie treści zadań w lewej górnej części ekranu").formatted(Formatting.GRAY),
                                Text.literal("Aby wybrać zadanie, kliknij na nie środkowym przyciskiem myszki (scrollem) w /zadania)").formatted(Formatting.GRAY),
                                Text.literal("Aby przestać wyświetlać zadanie, kliknij gdiekolwiek w /zadania środkowym przyciskiem myszki (scrollem)").formatted(Formatting.GRAY),
                                Text.literal("UWAGA! Ta funkcja jest obecnie w becie i treść zadań nie aktualizuje się na żywo").formatted(Formatting.RED),
                                Text.literal("UWAGA! Aby odświerzyć treść musisz wybrać ponownie to samo zadanie").formatted(Formatting.RED)
                                )
                        .setSaveConsumer(v -> Config.INSTANCE.toggleZadania = v)
                        .build()
        );

        zadania.addEntry(
                eb.startIntField(Text.literal("Przesunięcie w poziomie"), Config.INSTANCE.offsetX)
                        .setDefaultValue(5)
                        .setTooltip(
                                Text.literal("Przesunięcie w poziomie").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Przesuwa wyświetlanie HUDu w poziomie (0-512px)").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> {
                            if (v < 0) v = 0;
                            if (v > 512) v = 512;
                            Config.INSTANCE.offsetX = v;
                        })
                        .build()
        );

        zadania.addEntry(
                eb.startIntField(Text.literal("Przesunięcie w pionie"), Config.INSTANCE.offsetY)
                        .setDefaultValue(5)
                        .setTooltip(
                                Text.literal("Przesunięcie w pionie").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Przesuwa wyświetlanie HUDu w pionie (0-256px)").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> {
                            if (v < 0) v = 0;
                            if (v > 256) v = 256;
                            Config.INSTANCE.offsetY = v;
                        })
                        .build()
        );

        zadania.addEntry(
                eb.startBooleanToggle(Text.literal("Automatyczne zamykanie zadań"), Config.INSTANCE.zamykajZadania)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Automatyczne zamykanie zadań").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Automatycznie przestaje wyświetlać zadanie po jego ukończeniu").formatted(Formatting.GRAY)
                                )
                        .setSaveConsumer(v -> Config.INSTANCE.zamykajZadania = v)
                        .build()
        );

        rybak.addEntry(
                eb.startBooleanToggle(Text.literal("Statystyki rybaka"), Config.INSTANCE.toggleRybak)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Wyświetlanie statystyk rybaka").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Pozwala na wyświetlanie statystyk rybaka w lewej górnej części ekranu").formatted(Formatting.GRAY),
                                Text.literal("Statystyki wyświetlają się automatycznie, kiedy trzymasz w ręku wędkę").formatted(Formatting.GRAY),
                                Text.literal("Co dokładnie wyświetla się w statystykach możesz wybrać poniżej").formatted(Formatting.GRAY)
                                )
                        .setSaveConsumer(v -> Config.INSTANCE.toggleRybak = v)
                        .build()
        );

        var wyswietlanieStatystyk = eb.startSubCategory(Text.literal("Wyświetlanie statystyk")).setExpanded(true);

        wyswietlanieStatystyk.add(
                eb.startBooleanToggle(Text.literal("Niewielka"), Config.INSTANCE.toggleNiewielka)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Niewielka").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach liczbę złapanych niewielkich ryb").formatted(Formatting.GRAY)
                                )
                        .setSaveConsumer(v -> Config.INSTANCE.toggleNiewielka = v)
                        .build()
        );

        wyswietlanieStatystyk.add(
                eb.startBooleanToggle(Text.literal("Przeciętna"), Config.INSTANCE.togglePrzecietna)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Przeciętna").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach liczbę złapanych przeciętnych ryb").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.togglePrzecietna = v)
                        .build()
        );

        wyswietlanieStatystyk.add(
                eb.startBooleanToggle(Text.literal("Wymiarowa"), Config.INSTANCE.toggleWymiarowa)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Wymiarowa").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach liczbę złapanych wymairowych ryb").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.toggleWymiarowa = v)
                        .build()
        );

        wyswietlanieStatystyk.add(
                eb.startBooleanToggle(Text.literal("Ogromna"), Config.INSTANCE.toggleOgromna)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Ogromna").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach liczbę złapanych ogromnych ryb").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.toggleOgromna = v)
                        .build()
        );

        wyswietlanieStatystyk.add(
                eb.startBooleanToggle(Text.literal("Mamucia"), Config.INSTANCE.toggleMamucia)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Mamucia").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach liczbę złapanych mamucich ryb").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.toggleMamucia = v)
                        .build()
        );

        wyswietlanieStatystyk.add(
                eb.startBooleanToggle(Text.literal("Suma"), Config.INSTANCE.toggleSuma)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Suma").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach łączną liczbę złapanych ryb").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.toggleSuma = v)
                        .build()
        );

        wyswietlanieStatystyk.add(
                eb.startBooleanToggle(Text.literal("Zarobek"), Config.INSTANCE.toggleZarobek)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Zarobek").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach łączny zarobek ze sprzedanych ryb").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.toggleZarobek = v)
                        .build()
        );

        rybak.addEntry(wyswietlanieStatystyk.build());

        umiejetnosci.addEntry(
                eb.startEnumSelector(Text.literal("Dźwięk główny"), Config.GlownyDzwiek.class, Config.INSTANCE.glownyDzwiek)
                        .setDefaultValue(Config.GlownyDzwiek.DZWON)
                        .setTooltip(
                                Text.literal("Dźwięk główny").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Ustawia dźwięk odtwarzany po zakończeniu umiejętności lub jej cooldownu").formatted(Formatting.GRAY)
                        )
                        .setEnumNameProvider(e -> Text.literal(((Config.GlownyDzwiek) e).label()))
                        .setSaveConsumer(v -> Config.INSTANCE.glownyDzwiek = v) // write to your config obj here
                        .build()
        );

        umiejetnosci.addEntry(
                eb.startEnumSelector(Text.literal("Dźwięk odliczania"), Config.OdliczanieDzwiek.class, Config.INSTANCE.odliczanieDzwiek)
                        .setDefaultValue(Config.OdliczanieDzwiek.EXP)
                        .setTooltip(
                                Text.literal("Dźwięk odliczania").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Ustawia dźwięk odtwarzany podczas odliczania do końca umiejętności").formatted(Formatting.GRAY)
                        )
                        .setEnumNameProvider(e -> Text.literal(((Config.OdliczanieDzwiek) e).label()))
                        .setSaveConsumer(v -> Config.INSTANCE.odliczanieDzwiek = v) // write to your config obj here
                        .build()
        );

        var powiadomienieCooldown = eb.startSubCategory(Text.literal("Powiadomienie o cooldownie")).setExpanded(true);

        powiadomienieCooldown.add(
                eb.startBooleanToggle(Text.literal("Pług"), Config.INSTANCE.cooldownPlug)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Pług").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Odtwarza wybrany dźwięk po zakończeniu cooldownu pługu").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.cooldownPlug = v)
                        .build()
        );

        powiadomienieCooldown.add(
                eb.startBooleanToggle(Text.literal("Wiertło"), Config.INSTANCE.cooldownWiertlo)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Wiertło").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Odtwarza wybrany dźwięk po zakończeniu cooldownu wiertła").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.cooldownWiertlo = v)
                        .build()
        );

        powiadomienieCooldown.add(
                eb.startBooleanToggle(Text.literal("Rozbiórka"), Config.INSTANCE.cooldownRozbiorka)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Rozbiórka").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Odtwarza wybrany dźwięk po zakończeniu cooldownu rozbiórki").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.cooldownRozbiorka = v)
                        .build()
        );

        powiadomienieCooldown.add(
                eb.startBooleanToggle(Text.literal("Piła"), Config.INSTANCE.cooldownPila)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Piła").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Odtwarza wybrany dźwięk po zakończeniu cooldownu piły").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.cooldownPila = v)
                        .build()
        );

        powiadomienieCooldown.add(
                eb.startBooleanToggle(Text.literal("Sieci rybackie"), Config.INSTANCE.cooldownSieciRybackie)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Sieci rybackie").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Odtwarza wybrany dźwięk po zakończeniu cooldownu sieci rybackich").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.cooldownSieciRybackie = v)
                        .build()
        );

        powiadomienieCooldown.add(
                eb.startBooleanToggle(Text.literal("Nawałnica"), Config.INSTANCE.cooldownNawalnica)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Nawałnica").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Odtwarza wybrany dźwięk po zakończeniu cooldownu nawałnicy").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.cooldownNawalnica = v)
                        .build()
        );

        umiejetnosci.addEntry(powiadomienieCooldown.build());

        var odliczanieUmiejetnosci = eb.startSubCategory(Text.literal("Odliczanie do końca umiejętności")).setExpanded(true);

        odliczanieUmiejetnosci.add(
                eb.startBooleanToggle(Text.literal("Pług"), Config.INSTANCE.odliczaniePlug)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Pług").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Odlicza ostatnie 3 sekundy trwania pługu").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.odliczaniePlug = v)
                        .build()
        );

        odliczanieUmiejetnosci.add(
                eb.startBooleanToggle(Text.literal("Wiertło"), Config.INSTANCE.odliczanieWiertlo)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Wiertło").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Odlicza ostatnie 3 sekundy trwania wiertła").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.odliczanieWiertlo = v)
                        .build()
        );

        odliczanieUmiejetnosci.add(
                eb.startBooleanToggle(Text.literal("Rozbiórka"), Config.INSTANCE.odliczanieRozbiorka)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Rozbiórka").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Odlicza ostatnie 3 sekundy trwania rozbiórki").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.odliczanieRozbiorka = v)
                        .build()
        );

        odliczanieUmiejetnosci.add(
                eb.startBooleanToggle(Text.literal("Piła"), Config.INSTANCE.odliczaniePila)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Piła").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Odlicza ostatnie 3 sekundy trwania piły").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.odliczaniePila = v)
                        .build()
        );

        odliczanieUmiejetnosci.add(
                eb.startBooleanToggle(Text.literal("Sieci rybackie"), Config.INSTANCE.odliczanieSieciRybackie)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Sieci rybackie").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Odlicza ostatnie 3 sekundy trwania sieci rybackich").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.odliczanieSieciRybackie = v)
                        .build()
        );

        odliczanieUmiejetnosci.add(
                eb.startBooleanToggle(Text.literal("Nawałnica"), Config.INSTANCE.odliczanieNawalnica)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Nawałnica").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Odlicza ostatnie 3 sekundy trwania nawałnicy").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.odliczanieNawalnica = v)
                        .build()
        );

        umiejetnosci.addEntry(odliczanieUmiejetnosci.build());

        builder.setSavingRunnable(Config::save);

        return builder.build();
    }
}