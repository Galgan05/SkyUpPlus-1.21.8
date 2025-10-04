package net.galgan.skyupplus.config;

import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;


public final class Settings {

    private Settings() {}

    public static Screen create(Screen parent) {
        ConfigBuilder builder = ConfigBuilder.create()
                .setParentScreen(parent)
                .setTitle(Text.empty()
                        .append(Text.literal("Sky").formatted(Formatting.AQUA, Formatting.BOLD))
                        .append(Text.literal("UP").formatted(Formatting.WHITE, Formatting.BOLD))
                        .append(Text.literal("+ ").formatted(Formatting.LIGHT_PURPLE, Formatting.BOLD))
                        .append(Text.literal("» ").formatted(Formatting.DARK_GRAY, Formatting.BOLD))
                        .append(Text.literal("Ustawienia").formatted(Formatting.YELLOW, Formatting.BOLD)));

        ConfigEntryBuilder eb = builder.entryBuilder();

        ConfigCategory hud = builder.getOrCreateCategory(Text.literal("HUD").formatted(Formatting.GREEN, Formatting.BOLD));
        ConfigCategory zadania = builder.getOrCreateCategory(Text.literal("Zadania").formatted(Formatting.GOLD, Formatting.BOLD));
        ConfigCategory fishing = builder.getOrCreateCategory(Text.literal("Rybak").formatted(Formatting.DARK_AQUA, Formatting.BOLD));
        ConfigCategory abilities = builder.getOrCreateCategory(Text.literal("Umiejętności").formatted(Formatting.LIGHT_PURPLE, Formatting.BOLD));
        ConfigCategory dungeon = builder.getOrCreateCategory(Text.literal("Dungeony").formatted(Formatting.GRAY, Formatting.BOLD));
        ConfigCategory crates = builder.getOrCreateCategory(Text.literal("Skrzynki").formatted(Formatting.AQUA, Formatting.BOLD));

        hud.addEntry(
                eb.startBooleanToggle(Text.literal("Wyświetlanie HUDu"), Config.INSTANCE.toggleHud)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Wyświetlanie HUDu").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Włącza/Wyłącza wyświetlanie HUDu").formatted(Formatting.GRAY),
                                Text.literal("UWAGA! To ustawienie zarządza renderowaniem całego moda").formatted(Formatting.RED)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.toggleHud = v)
                        .build()
        );

        hud.addEntry(
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

        hud.addEntry(
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
                eb.startBooleanToggle(Text.literal("Wyświetlanie zadań"), Config.INSTANCE.toggleQuests)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Wyświetlanie zadań").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Pozwala na wyświetlanie treści zadań w lewej górnej części ekranu").formatted(Formatting.GRAY),
                                Text.literal("Aby wybrać zadanie, kliknij na nie środkowym przyciskiem myszki (scrollem) w /zadania)").formatted(Formatting.GRAY),
                                Text.literal("Aby przestać wyświetlać zadanie, kliknij gdiekolwiek w /zadania środkowym przyciskiem myszki (scrollem)").formatted(Formatting.GRAY),
                                Text.literal("UWAGA! Ta funkcja jest obecnie w becie i treść zadań nie aktualizuje się na żywo").formatted(Formatting.RED),
                                Text.literal("UWAGA! Aby odświerzyć treść musisz wybrać ponownie to samo zadanie").formatted(Formatting.RED)
                                )
                        .setSaveConsumer(v -> Config.INSTANCE.toggleQuests = v)
                        .build()
        );

        zadania.addEntry(
                eb.startBooleanToggle(Text.literal("Automatyczne zamykanie zadań"), Config.INSTANCE.closeQuests)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Automatyczne zamykanie zadań").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Automatycznie przestaje wyświetlać zadanie po jego ukończeniu").formatted(Formatting.GRAY)
                                )
                        .setSaveConsumer(v -> Config.INSTANCE.closeQuests = v)
                        .build()
        );

        fishing.addEntry(
                eb.startEnumSelector(Text.literal("Wyświetlanie statystyk"), Config.FishingDisplay.class, Config.INSTANCE.fishingDisplay)
                        .setDefaultValue(Config.FishingDisplay.FISHING_ROD)
                        .setTooltip(
                                Text.literal("Wyświetlanie statystyk").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wybierz kiedy mają się wyświetlać staystyki rybaka").formatted(Formatting.GRAY)
                        )
                        .setEnumNameProvider(e -> Text.literal(((Config.FishingDisplay) e).label()))
                        .setSaveConsumer(v -> Config.INSTANCE.fishingDisplay = v)
                        .build()
        );

        var chooseFishingStats = eb.startSubCategory(Text.literal("Wybierz statystyki")).setExpanded(true);

        chooseFishingStats.add(
                eb.startBooleanToggle(Text.literal("Niewielka"), Config.INSTANCE.toggleNiewielka)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Niewielka").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach liczbę złapanych niewielkich ryb").formatted(Formatting.GRAY)
                                )
                        .setSaveConsumer(v -> Config.INSTANCE.toggleNiewielka = v)
                        .build()
        );

        chooseFishingStats.add(
                eb.startBooleanToggle(Text.literal("Przeciętna"), Config.INSTANCE.togglePrzecietna)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Przeciętna").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach liczbę złapanych przeciętnych ryb").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.togglePrzecietna = v)
                        .build()
        );

        chooseFishingStats.add(
                eb.startBooleanToggle(Text.literal("Wymiarowa"), Config.INSTANCE.toggleWymiarowa)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Wymiarowa").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach liczbę złapanych wymairowych ryb").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.toggleWymiarowa = v)
                        .build()
        );

        chooseFishingStats.add(
                eb.startBooleanToggle(Text.literal("Ogromna"), Config.INSTANCE.toggleOgromna)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Ogromna").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach liczbę złapanych ogromnych ryb").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.toggleOgromna = v)
                        .build()
        );

        chooseFishingStats.add(
                eb.startBooleanToggle(Text.literal("Mamucia"), Config.INSTANCE.toggleMamucia)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Mamucia").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach liczbę złapanych mamucich ryb").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.toggleMamucia = v)
                        .build()
        );

        chooseFishingStats.add(
                eb.startBooleanToggle(Text.literal("Suma"), Config.INSTANCE.toggleSuma)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Suma").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach łączną liczbę złowionych ryb").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.toggleSuma = v)
                        .build()
        );

        chooseFishingStats.add(
                eb.startBooleanToggle(Text.literal("Zarobek"), Config.INSTANCE.toggleZarobek)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Zarobek").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach łączny zarobek ze sprzedanych ryb").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.toggleZarobek = v)
                        .build()
        );

        chooseFishingStats.add(
                eb.startBooleanToggle(Text.literal("Waga"), Config.INSTANCE.toggleWaga)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Zarobek").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach łączną wagę złapanych ryb").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.toggleWaga = v)
                        .build()
        );

        chooseFishingStats.add(
                eb.startBooleanToggle(Text.literal("Największa"), Config.INSTANCE.toggleNajwieksza)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Największa").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach wagę największej złapanej ryby").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.toggleNajwieksza = v)
                        .build()
        );

        chooseFishingStats.add(
                eb.startBooleanToggle(Text.literal("Najmniejsza"), Config.INSTANCE.toggleNajmniejsza)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Zarobek").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach wagę najmniejszej złapanej ryby").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.toggleNajmniejsza = v)
                        .build()
        );

        fishing.addEntry(chooseFishingStats.build());

        abilities.addEntry(
                eb.startEnumSelector(Text.literal("Dźwięk główny"), Config.MainSound.class, Config.INSTANCE.mainSound)
                        .setDefaultValue(Config.MainSound.BELL)
                        .setTooltip(
                                Text.literal("Dźwięk główny").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Ustawia dźwięk odtwarzany po zakończeniu umiejętności lub jej cooldownu").formatted(Formatting.GRAY)
                        )
                        .setEnumNameProvider(e -> Text.literal(((Config.MainSound) e).label()))
                        .setSaveConsumer(v -> Config.INSTANCE.mainSound = v)
                        .build()
        );

        abilities.addEntry(
                eb.startEnumSelector(Text.literal("Dźwięk odliczania"), Config.CountdownSound.class, Config.INSTANCE.countdownSound)
                        .setDefaultValue(Config.CountdownSound.EXP)
                        .setTooltip(
                                Text.literal("Dźwięk odliczania").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Ustawia dźwięk odtwarzany podczas odliczania do końca umiejętności").formatted(Formatting.GRAY)
                        )
                        .setEnumNameProvider(e -> Text.literal(((Config.CountdownSound) e).label()))
                        .setSaveConsumer(v -> Config.INSTANCE.countdownSound = v)
                        .build()
        );

        var abilitiesCooldown = eb.startSubCategory(Text.literal("Powiadomienie o cooldownie")).setExpanded(true);

        abilitiesCooldown.add(
                eb.startBooleanToggle(Text.literal("Pług"), Config.INSTANCE.cooldownPlug)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Pług").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Odtwarza wybrany dźwięk po zakończeniu cooldownu pługu").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.cooldownPlug = v)
                        .build()
        );

        abilitiesCooldown.add(
                eb.startBooleanToggle(Text.literal("Wiertło"), Config.INSTANCE.cooldownWiertlo)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Wiertło").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Odtwarza wybrany dźwięk po zakończeniu cooldownu wiertła").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.cooldownWiertlo = v)
                        .build()
        );

        abilitiesCooldown.add(
                eb.startBooleanToggle(Text.literal("Rozbiórka"), Config.INSTANCE.cooldownRozbiorka)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Rozbiórka").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Odtwarza wybrany dźwięk po zakończeniu cooldownu rozbiórki").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.cooldownRozbiorka = v)
                        .build()
        );

        abilitiesCooldown.add(
                eb.startBooleanToggle(Text.literal("Piła"), Config.INSTANCE.cooldownPila)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Piła").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Odtwarza wybrany dźwięk po zakończeniu cooldownu piły").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.cooldownPila = v)
                        .build()
        );

        abilitiesCooldown.add(
                eb.startBooleanToggle(Text.literal("Sieci rybackie"), Config.INSTANCE.cooldownSieciRybackie)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Sieci rybackie").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Odtwarza wybrany dźwięk po zakończeniu cooldownu sieci rybackich").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.cooldownSieciRybackie = v)
                        .build()
        );

        abilitiesCooldown.add(
                eb.startBooleanToggle(Text.literal("Nawałnica"), Config.INSTANCE.cooldownNawalnica)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Nawałnica").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Odtwarza wybrany dźwięk po zakończeniu cooldownu nawałnicy").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.cooldownNawalnica = v)
                        .build()
        );

        abilities.addEntry(abilitiesCooldown.build());

        var abilitiesCountdown = eb.startSubCategory(Text.literal("countdown do końca umiejętności")).setExpanded(true);

        abilitiesCountdown.add(
                eb.startBooleanToggle(Text.literal("Pług"), Config.INSTANCE.countdownPlug)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Pług").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Odlicza ostatnie 3 sekundy trwania pługu").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.countdownPlug = v)
                        .build()
        );

        abilitiesCountdown.add(
                eb.startBooleanToggle(Text.literal("Wiertło"), Config.INSTANCE.countdownWiertlo)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Wiertło").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Odlicza ostatnie 3 sekundy trwania wiertła").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.countdownWiertlo = v)
                        .build()
        );

        abilitiesCountdown.add(
                eb.startBooleanToggle(Text.literal("Rozbiórka"), Config.INSTANCE.countdownRozbiorka)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Rozbiórka").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Odlicza ostatnie 3 sekundy trwania rozbiórki").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.countdownRozbiorka = v)
                        .build()
        );

        abilitiesCountdown.add(
                eb.startBooleanToggle(Text.literal("Piła"), Config.INSTANCE.countdownPila)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Piła").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Odlicza ostatnie 3 sekundy trwania piły").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.countdownPila = v)
                        .build()
        );

        abilitiesCountdown.add(
                eb.startBooleanToggle(Text.literal("Sieci rybackie"), Config.INSTANCE.countdownSieciRybackie)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Sieci rybackie").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Odlicza ostatnie 3 sekundy trwania sieci rybackich").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.countdownSieciRybackie = v)
                        .build()
        );

        abilitiesCountdown.add(
                eb.startBooleanToggle(Text.literal("Nawałnica"), Config.INSTANCE.countdownNawalnica)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Nawałnica").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Odlicza ostatnie 3 sekundy trwania nawałnicy").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.countdownNawalnica = v)
                        .build()
        );

        abilities.addEntry(abilitiesCountdown.build());

        dungeon.addEntry(
                eb.startBooleanToggle(Text.literal("Wyświetlanie cooldownu dungeonu"), Config.INSTANCE.dungeonCooldownToggle)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Wyświetlanie cooldownu dungeonu").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla odliczanie do następnego wejścia do dungeonu").formatted(Formatting.GRAY),
                                Text.literal("UWAGA! Jeżeli wywaliło ciebie z serwera będąc na dungeonie, wpisz /dng cooldown, aby zsynchronizować odliczanie").formatted(Formatting.RED)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.dungeonCooldownToggle = v)
                        .build()
        );

        dungeon.addEntry(
                eb.startEnumSelector(Text.literal("Dźwięk cooldownu dungeonu"), Config.DungeonSound.class, Config.INSTANCE.dungeonSound)
                        .setDefaultValue(Config.DungeonSound.GOAT_HORN)
                        .setTooltip(
                                Text.literal("Dźwięk cooldownu dungeonu").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Ustawia dźwięk odtwarzany po zakończeniu cooldownu dungeonu").formatted(Formatting.GRAY)
                        )
                        .setEnumNameProvider(e -> Text.literal(((Config.DungeonSound) e).label()))
                        .setSaveConsumer(v -> Config.INSTANCE.dungeonSound = v)
                        .build()
        );

        crates.addEntry(
                eb.startEnumSelector(Text.literal("Wyświetlanie platinum"), Config.PlatinumDisplay.class, Config.INSTANCE.platinumDisplay)
                        .setDefaultValue(Config.PlatinumDisplay.KEY)
                        .setTooltip(
                                Text.literal("Wyświetlanie platinum").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wybierz kiedy mają się wyświetlać dropy z platinum").formatted(Formatting.GRAY)
                        )
                        .setEnumNameProvider(e -> Text.literal(((Config.PlatinumDisplay) e).label()))
                        .setSaveConsumer(v -> Config.INSTANCE.platinumDisplay = v)
                        .build()
        );

        crates.addEntry(
                eb.startEnumSelector(Text.literal("Wyświetlanie elementium"), Config.ElementiumDisplay.class, Config.INSTANCE.elementiumDisplay)
                        .setDefaultValue(Config.ElementiumDisplay.KEY)
                        .setTooltip(
                                Text.literal("Wyświetlanie elementium").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wybierz kiedy mają się wyświetlać dropy z elementium").formatted(Formatting.GRAY)
                        )
                        .setEnumNameProvider(e -> Text.literal(((Config.ElementiumDisplay) e).label()))
                        .setSaveConsumer(v -> Config.INSTANCE.elementiumDisplay = v)
                        .build()
        );

        var platinumDrops = eb.startSubCategory(Text.literal("Dropy z platinum")).setExpanded(true);

        platinumDrops.add(
                eb.startBooleanToggle(Text.literal("Elementium"), Config.INSTANCE.elementiumToggle)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Elementium").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach liczbę wydropionych kluczy do elementium").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.elementiumToggle = v)
                        .build()
        );

        platinumDrops.add(
                eb.startBooleanToggle(Text.literal("Mending"), Config.INSTANCE.mendingToggle)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Mending").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach liczbę wydropionych mendingów").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.mendingToggle = v)
                        .build()
        );

        platinumDrops.add(
                eb.startBooleanToggle(Text.literal("Blok szmaragdu"), Config.INSTANCE.emeraldBlockToggle)
                        .setDefaultValue(false)
                        .setTooltip(
                                Text.literal("Blok szmaragdu").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach liczbę wydropionych bloków szmaragdu").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.emeraldBlockToggle = v)
                        .build()
        );

        crates.addEntry(platinumDrops.build());

        var elementiumDrops = eb.startSubCategory(Text.literal("Dropy z elementium")).setExpanded(true);

        elementiumDrops.add(
                eb.startBooleanToggle(Text.literal("Karambit"), Config.INSTANCE.karambitToggle)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Karambit").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach liczbę wydropionych karambitów").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.karambitToggle = v)
                        .build()
        );

        elementiumDrops.add(
                eb.startBooleanToggle(Text.literal("Perun"), Config.INSTANCE.perunToggle)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Perun").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach liczbę wydropionych perunów").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.perunToggle = v)
                        .build()
        );

        elementiumDrops.add(
                eb.startBooleanToggle(Text.literal("Cymofan"), Config.INSTANCE.cymofanToggle)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Cymofan").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach liczbę wydropionych cymofanów").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.cymofanToggle = v)
                        .build()
        );

        elementiumDrops.add(
                eb.startBooleanToggle(Text.literal("Młot Thora"), Config.INSTANCE.mlotThoraToggle)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Młot Thora").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach liczbę wydropionych młotów thora").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.mlotThoraToggle = v)
                        .build()
        );

        elementiumDrops.add(
                eb.startBooleanToggle(Text.literal("Urizel"), Config.INSTANCE.urizelToggle)
                        .setDefaultValue(false)
                        .setTooltip(
                                Text.literal("Urizel").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach liczbę wydropionych urizelów").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.urizelToggle = v)
                        .build()
        );

        elementiumDrops.add(
                eb.startBooleanToggle(Text.literal("Azada"), Config.INSTANCE.azadaToggle)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Azada").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach liczbę wydropionych azad").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.azadaToggle = v)
                        .build()
        );

        elementiumDrops.add(
                eb.startBooleanToggle(Text.literal("Spinel"), Config.INSTANCE.spinelToggle)
                        .setDefaultValue(false)
                        .setTooltip(
                                Text.literal("Spinel").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach liczbę wydropionych spineli").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.spinelToggle = v)
                        .build()
        );

        elementiumDrops.add(
                eb.startBooleanToggle(Text.literal("Karpiołap"), Config.INSTANCE.karpiolapToggle)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Karpiołap").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach liczbę wydropionych karpiołapów").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.karpiolapToggle = v)
                        .build()
        );

        elementiumDrops.add(
                eb.startBooleanToggle(Text.literal("Etherica"), Config.INSTANCE.ethericaToggle)
                        .setDefaultValue(false)
                        .setTooltip(
                                Text.literal("Etherica").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach liczbę wydropionych etheric").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.ethericaToggle = v)
                        .build()
        );

        elementiumDrops.add(
                eb.startBooleanToggle(Text.literal("Łuk Legolasa"), Config.INSTANCE.lukLegolasaToggle)
                        .setDefaultValue(false)
                        .setTooltip(
                                Text.literal("Łuk Legolasa").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach liczbę wydropionych łuków legolasa").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.lukLegolasaToggle = v)
                        .build()
        );

        elementiumDrops.add(
                eb.startBooleanToggle(Text.literal("Arbalet"), Config.INSTANCE.arbaletToggle)
                        .setDefaultValue(false)
                        .setTooltip(
                                Text.literal("Arbalet").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach liczbę wydropionych arbaletów").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.arbaletToggle = v)
                        .build()
        );

        elementiumDrops.add(
                eb.startBooleanToggle(Text.literal("Powrót Odysa"), Config.INSTANCE.powrotOdysaToggle)
                        .setDefaultValue(false)
                        .setTooltip(
                                Text.literal("Powrót Odysa").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach liczbę wydropionych powrotów odysa").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.powrotOdysaToggle = v)
                        .build()
        );

        elementiumDrops.add(
                eb.startBooleanToggle(Text.literal("Cassis"), Config.INSTANCE.cassisToggle)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Cassis").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach liczbę wydropionych cassisów").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.cassisToggle = v)
                        .build()
        );

        elementiumDrops.add(
                eb.startBooleanToggle(Text.literal("Cuirass"), Config.INSTANCE.cuirassToggle)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Cuirass").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach liczbę wydropionych cuirassów").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.cuirassToggle = v)
                        .build()
        );

        elementiumDrops.add(
                eb.startBooleanToggle(Text.literal("Cuissot"), Config.INSTANCE.cuissotToggle)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Cuissot").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach liczbę wydropionych cuissotów").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.cuissotToggle = v)
                        .build()
        );

        elementiumDrops.add(
                eb.startBooleanToggle(Text.literal("Cosset"), Config.INSTANCE.cossetToggle)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Cosset").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach liczbę wydropionych cossetów").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.cossetToggle = v)
                        .build()
        );

        elementiumDrops.add(
                eb.startBooleanToggle(Text.literal("Kapcie lotnika"), Config.INSTANCE.kapcieLotnikaToggle)
                        .setDefaultValue(false)
                        .setTooltip(
                                Text.literal("Kapcie lotnika").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach liczbę wydropionych kapci lotnika").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.kapcieLotnikaToggle = v)
                        .build()
        );

        elementiumDrops.add(
                eb.startBooleanToggle(Text.literal("Rivendell"), Config.INSTANCE.rivendellToggle)
                        .setDefaultValue(false)
                        .setTooltip(
                                Text.literal("Rivendell").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach liczbę wydropionych rivendelli").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.rivendellToggle = v)
                        .build()
        );

        elementiumDrops.add(
                eb.startBooleanToggle(Text.literal("Impet"), Config.INSTANCE.impetToggle)
                        .setDefaultValue(false)
                        .setTooltip(
                                Text.literal("Impet").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach liczbę wydropionych impetów").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.impetToggle = v)
                        .build()
        );

        elementiumDrops.add(
                eb.startBooleanToggle(Text.literal("Phlox"), Config.INSTANCE.phloxToggle)
                        .setDefaultValue(false)
                        .setTooltip(
                                Text.literal("Phlox").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach liczbę wydropionych phloxów").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.phloxToggle = v)
                        .build()
        );

        elementiumDrops.add(
                eb.startBooleanToggle(Text.literal("Majster"), Config.INSTANCE.majsterToggle)
                        .setDefaultValue(false)
                        .setTooltip(
                                Text.literal("Majster").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach liczbę wydropionych majstrów").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.majsterToggle = v)
                        .build()
        );

        elementiumDrops.add(
                eb.startBooleanToggle(Text.literal("Magiczne wiaderko"), Config.INSTANCE.magiczneWiaderkoToggle)
                        .setDefaultValue(false)
                        .setTooltip(
                                Text.literal("Magiczne wiaderko").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach liczbę wydropionych magicznych wiaderek").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.magiczneWiaderkoToggle = v)
                        .build()
        );

        elementiumDrops.add(
                eb.startBooleanToggle(Text.literal("StatTracket"), Config.INSTANCE.statTrackerToggle)
                        .setDefaultValue(false)
                        .setTooltip(
                                Text.literal("StatTracker").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach liczbę wydropionych stattrackerów").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.statTrackerToggle = v)
                        .build()
        );

        elementiumDrops.add(
                eb.startBooleanToggle(Text.literal("Jajko niespodzianka"), Config.INSTANCE.jajkoNiespodziankaToggle)
                        .setDefaultValue(true)
                        .setTooltip(
                                Text.literal("Jajko niespodzianka").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach liczbę wydropionych jajek niespodzianka").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.jajkoNiespodziankaToggle = v)
                        .build()
        );

        elementiumDrops.add(
                eb.startBooleanToggle(Text.literal("Klejnot kupiecki"), Config.INSTANCE.klejnotKupieckiToggle)
                        .setDefaultValue(false)
                        .setTooltip(
                                Text.literal("Klejnot kupiecki").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach liczbę wydropionych klejnotów kupieckich").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.klejnotKupieckiToggle = v)
                        .build()
        );

        elementiumDrops.add(
                eb.startBooleanToggle(Text.literal("Kontroler magazynów"), Config.INSTANCE.kontrolerMagazynowToggle)
                        .setDefaultValue(false)
                        .setTooltip(
                                Text.literal("Kontroler magazynów").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach liczbę wydropionych kontrolerów magazynów").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.kontrolerMagazynowToggle = v)
                        .build()
        );

        elementiumDrops.add(
                eb.startBooleanToggle(Text.literal("Tajemnice SkyUPa"), Config.INSTANCE.tajemniceSkyUPaToggle)
                        .setDefaultValue(false)
                        .setTooltip(
                                Text.literal("Tajemnice SkyUPa").formatted(Formatting.WHITE, Formatting.BOLD),
                                Text.literal("Wyświetla w statystykach liczbę wydropionych tajemnic skyupa").formatted(Formatting.GRAY)
                        )
                        .setSaveConsumer(v -> Config.INSTANCE.tajemniceSkyUPaToggle = v)
                        .build()
        );

        crates.addEntry(elementiumDrops.build());

        builder.setSavingRunnable(Config::save);

        return builder.build();
    }
}