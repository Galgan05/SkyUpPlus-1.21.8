package net.galgan.skyupplus.config;

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

    //QUESTS
    public boolean toggleQuests = true;
    public boolean closeQuests = true;

    //CRATES
    public boolean karambitToggle = true;
    public boolean perunToggle = true;
    public boolean cymofanToggle = true;
    public boolean mlotThoraToggle = true;
    public boolean urizelToggle = false;
    public boolean azadaToggle = true;
    public boolean spinelToggle = false;
    public boolean karpiolapToggle = true;
    public boolean ethericaToggle = false;
    public boolean lukLegolasaToggle = false;
    public boolean arbaletToggle = false;
    public boolean powrotOdysaToggle = false;
    public boolean cassisToggle = true;
    public boolean cuirassToggle = true;
    public boolean cuissotToggle = true;
    public boolean cossetToggle = true;
    public boolean kapcieLotnikaToggle = false;
    public boolean rivendellToggle = false;
    public boolean impetToggle = false;
    public boolean phloxToggle = false;
    public boolean majsterToggle = false;
    public boolean magiczneWiaderkoToggle = false;
    public boolean statTrackerToggle = false;
    public boolean jajkoNiespodziankaToggle = true;
    public boolean klejnotKupieckiToggle = false;
    public boolean kontrolerMagazynowToggle = false;
    public boolean tajemniceSkyUPaToggle = false;
    public boolean elementiumToggle = true;
    public boolean mendingToggle = true;
    public boolean emeraldBlockToggle = false;

    public int karambitDropped = 0;
    public int perunDropped = 0;
    public int cymofanDropped = 0;
    public int mlotThoraDropped = 0;
    public int urizelDropped = 0;
    public int azadaDropped = 0;
    public int spinelDropped = 0;
    public int karpiolapDropped = 0;
    public int ethericaDropped = 0;
    public int lukLegolasaDropped = 0;
    public int arbaletDropped = 0;
    public int powrotOdysaDropped = 0;
    public int cassisDropped = 0;
    public int cuirassDropped = 0;
    public int cuissotDropped = 0;
    public int cossetDropped = 0;
    public int kapcieLotnikaDropped = 0;
    public int rivendellDropped = 0;
    public int impetDropped = 0;
    public int phloxDropped = 0;
    public int majsterDropped = 0;
    public int magiczneWiaderkoDropped = 0;
    public int statTrackerDropped = 0;
    public int jajkoNiespodziankaDropped = 0;
    public int klejnotKupieckiDropped = 0;
    public int kontrolerMagazynowDropped = 0;
    public int tajemniceSkyUPaDropped = 0;
    public int elementiumDropped = 0;
    public int mendingDropped = 0;
    public int emeraldBlockDropped = 0;

    public ElementiumDisplay elementiumDisplay = ElementiumDisplay.KEY;
    public PlatinumDisplay platinumDisplay = PlatinumDisplay.KEY;

    public enum ElementiumDisplay {
        KEY("Trzymając klucz", "key"),
        ALWAYS("Zawsze", "always"),
        NEVER("Nigdy", "never");

        private final String label;
        private final String mode;

        ElementiumDisplay(String label, String mode) {
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

    public enum PlatinumDisplay {
        KEY("Trzymając klucz", "key"),
        ALWAYS("Zawsze", "always"),
        NEVER("Nigdy", "never");

        private final String label;
        private final String mode;

        PlatinumDisplay(String label, String mode) {
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

    //FISHING
    public boolean toggleNiewielka = true;
    public boolean togglePrzecietna = true;
    public boolean toggleWymiarowa = true;
    public boolean toggleOgromna = true;
    public boolean toggleMamucia = true;
    public boolean toggleSuma = true;
    public boolean toggleZarobek = true;
    public boolean toggleWaga = true;
    public boolean toggleNajwieksza = true;
    public boolean toggleNajmniejsza = true;
    public int niewielkaCount = 0;
    public int przecietnaCount = 0;
    public int wymiarowaCount = 0;
    public int ogromnaCount = 0;
    public int mamuciaCount = 0;
    public int totalCount = 0;
    public double totalEarned = 0;
    public double totalWeight = 0;
    public double biggestWeight = 0;
    public double smallestWeight = 0;

    public FishingDisplay fishingDisplay = FishingDisplay.FISHING_ROD;

    public enum FishingDisplay {
        FISHING_ROD("Trzymając wędkę", "fishing_rod"),
        ALWAYS("Zawsze", "always"),
        NEVER("Nigdy", "never");

        private final String label;
        private final String mode;

        FishingDisplay(String label, String mode) {
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

    //ABILITIES
    public boolean cooldownPlug = true;
    public boolean cooldownWiertlo = true;
    public boolean cooldownRozbiorka = true;
    public boolean cooldownPila = true;
    public boolean cooldownSieciRybackie = true;
    public boolean cooldownNawalnica = true;
    public boolean countdownPlug = true;
    public boolean countdownWiertlo = true;
    public boolean countdownRozbiorka = true;
    public boolean countdownPila = true;
    public boolean countdownSieciRybackie = true;
    public boolean countdownNawalnica = true;
    public MainSound mainSound = MainSound.BELL;
    public CountdownSound countdownSound = CountdownSound.EXP;

    public enum MainSound {
        BELL("Dzwon", SoundEvents.BLOCK_BELL_USE),
        GOAT_HORN("Kozi Róg", SoundEvents.GOAT_HORN_SOUNDS.get(1).value()),
        WITHER("Wither", SoundEvents.ENTITY_WITHER_SPAWN),
        CHALLENGE("Wyzwanie", SoundEvents.UI_TOAST_CHALLENGE_COMPLETE);

        private final String label;
        private final SoundEvent sound;

        MainSound(String label, SoundEvent sound) {
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

    public enum CountdownSound {
        EXP("Exp", SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP),
        CLICK("Klik", SoundEvents.BLOCK_NOTE_BLOCK_HAT.value()),
        EIGHT_BIT("8-Bit", SoundEvents.BLOCK_NOTE_BLOCK_BIT.value()),
        NOTEBLOCK("Noteblock", SoundEvents.BLOCK_NOTE_BLOCK_BASS.value());

        private final String label;
        private final SoundEvent sound;

        CountdownSound(String label, SoundEvent sound) {
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

    //DUNGEON
    public boolean dungeonCooldownToggle = true;
    public long nextEntryTime = -1L;
    public boolean onCooldown = false;
    public DungeonSound dungeonSound = DungeonSound.GOAT_HORN;

    public enum DungeonSound {
        BELL("Dzwon", SoundEvents.BLOCK_BELL_USE),
        GOAT_HORN("Kozi Róg", SoundEvents.GOAT_HORN_SOUNDS.get(1).value()),
        WITHER("Wither", SoundEvents.ENTITY_WITHER_SPAWN),
        WYZWANIE("Wyzwanie", SoundEvents.UI_TOAST_CHALLENGE_COMPLETE);

        private final String label;
        private final SoundEvent sound;

        DungeonSound(String label, SoundEvent sound) {
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
