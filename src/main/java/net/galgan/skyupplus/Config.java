package net.galgan.skyupplus;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Config {
    //HUD
    public boolean toggleHud = true;
    public int offsetY = 5;
    public int offsetX = 5;

    //ZADANIA
    public boolean toggleZadania = true;
    public boolean zamykajZadania = false;

    //RYBAK
    public WyswietlanieRybaka wyswietlanieRybaka = WyswietlanieRybaka.WEDKA;
    public boolean toggleNiewielka = true;
    public boolean togglePrzecietna = true;
    public boolean toggleWymiarowa = true;
    public boolean toggleOgromna = true;
    public boolean toggleMamucia = true;
    public boolean toggleSuma = true;
    public boolean toggleZarobek = true;
    public int niewielka = 0;
    public int przecietna = 0;
    public int wymiarowa = 0;
    public int ogromna = 0;
    public int mamucia = 0;
    public int sumaryb = 0;
    public double zarobekzryb = 0;

    //UMIEJĘTNOŚCI
    public boolean cooldownPlug = true;
    public boolean cooldownWiertlo = true;
    public boolean cooldownRozbiorka = true;
    public boolean cooldownPila = true;
    public boolean cooldownSieciRybackie = true;
    public boolean cooldownNawalnica = true;
    public boolean odliczaniePlug = true;
    public boolean odliczanieWiertlo = true;
    public boolean odliczanieRozbiorka = true;
    public boolean odliczaniePila = true;
    public boolean odliczanieSieciRybackie = true;
    public boolean odliczanieNawalnica = true;
    public GlownyDzwiek glownyDzwiek = GlownyDzwiek.DZWON;
    public OdliczanieDzwiek odliczanieDzwiek = OdliczanieDzwiek.EXP;

    //DUNGEONY
    public boolean toggleDungeony = true;
    public long czasPonownegoWejscia = -1L;
    public boolean onCooldown = false;
    public DungeonyDzwiek dungeonyDzwiek = DungeonyDzwiek.KOZI_ROG;

    public enum WyswietlanieRybaka {
        WEDKA("Trzymając wędkę", "wedka"),
        ZAWSZE("Zawsze", "zawsze"),
        NIGDY("Nigdy", "nigdy");

        private final String label;
        private final String mode;

        WyswietlanieRybaka(String label, String mode) {
            this.label = label;
            this.mode = mode;
        }

        public String label() {
            return label;
        }
        public String mode() {
            return mode;
        }
    }

    public enum GlownyDzwiek {
        DZWON("Dzwon", SoundEvents.BLOCK_BELL_USE),
        KOZI_ROG("Kozi Róg", SoundEvents.GOAT_HORN_SOUNDS.get(1).value()),
        WITHER("Wither", SoundEvents.ENTITY_WITHER_SPAWN),
        WYZWANIE("Wyzwanie", SoundEvents.UI_TOAST_CHALLENGE_COMPLETE);

        private final String label;
        private final SoundEvent sound;

        GlownyDzwiek(String label, SoundEvent sound) {
            this.label = label;
            this.sound = sound;
        }

        public String label() {
            return label;
        }
        public SoundEvent sound() {
            return sound;
        }
    }

    public enum OdliczanieDzwiek {
        EXP("Exp", SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP),
        KLIK("Klik", SoundEvents.BLOCK_NOTE_BLOCK_HAT.value()),
        EIGHT_BIT("8-Bit", SoundEvents.BLOCK_NOTE_BLOCK_BIT.value()),
        NOTEBLOCK("Noteblock", SoundEvents.BLOCK_NOTE_BLOCK_BASS.value());

        private final String label;
        private final SoundEvent sound;

        OdliczanieDzwiek(String label, SoundEvent sound) {
            this.label = label;
            this.sound = sound;
        }

        public String label() {
            return label;
        }
        public SoundEvent sound() {
            return sound;
        }
    }

    public enum DungeonyDzwiek {
        DZWON("Dzwon", SoundEvents.BLOCK_BELL_USE),
        KOZI_ROG("Kozi Róg", SoundEvents.GOAT_HORN_SOUNDS.get(1).value()),
        WITHER("Wither", SoundEvents.ENTITY_WITHER_SPAWN),
        WYZWANIE("Wyzwanie", SoundEvents.UI_TOAST_CHALLENGE_COMPLETE);

        private final String label;
        private final SoundEvent sound;

        DungeonyDzwiek(String label, SoundEvent sound) {
            this.label = label;
            this.sound = sound;
        }

        public String label() {
            return label;
        }
        public SoundEvent sound() {
            return sound;
        }
    }

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path FILE = FabricLoader.getInstance().getConfigDir().resolve("skyupplus.json");
    public static Config INSTANCE = new Config();

    public static void load() {
        try {
            if (Files.exists(FILE)) {
                INSTANCE = GSON.fromJson(Files.readString(FILE), Config.class);
            } else {
                save(); // write defaults
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void save() {
        try {
            Files.createDirectories(FILE.getParent());
            Files.writeString(FILE, GSON.toJson(INSTANCE));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
