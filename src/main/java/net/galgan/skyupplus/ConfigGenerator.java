package net.galgan.skyupplus;


import net.fabricmc.loader.api.FabricLoader;

import java.io.*;
import java.nio.file.*;
import java.util.Properties;


public class ConfigGenerator {
    private static final Path PATH = FabricLoader.getInstance()
            .getConfigDir().resolve("skyupextras.properties");

    //Default values
    public static int niewielka = 0;
    public static int przecietna = 0;
    public static int wymiarowa = 0;
    public static int ogromna = 0;
    public static int mamucia = 0;
    public static int sumaryb = 0;
    public static double zarobekzryb = 0;
    public static boolean togglerybak = true;
    public static boolean togglecooldown = true;

    public static void load() {
        Properties props = new Properties();

        if (Files.exists(PATH)) {
            try (InputStream in = Files.newInputStream(PATH)) {
                props.load(in);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        niewielka = Integer.parseInt(props.getProperty("niewielka", String.valueOf(niewielka)));
        przecietna = Integer.parseInt(props.getProperty("przecietna", String.valueOf(przecietna)));
        wymiarowa = Integer.parseInt(props.getProperty("wymiarowa", String.valueOf(wymiarowa)));
        ogromna = Integer.parseInt(props.getProperty("ogromna", String.valueOf(ogromna)));
        mamucia = Integer.parseInt(props.getProperty("mamucia", String.valueOf(mamucia)));
        sumaryb = Integer.parseInt(props.getProperty("sumaryb", String.valueOf(sumaryb)));
        zarobekzryb = Double.parseDouble(props.getProperty("zarobekzryb", String.valueOf(zarobekzryb)));
        togglerybak = Boolean.parseBoolean(props.getProperty("togglerybak", String.valueOf(togglerybak)));
        togglecooldown = Boolean.parseBoolean(props.getProperty("togglecooldown", String.valueOf(togglecooldown)));

        save();
    }

    public static void save() {
        Properties props = new Properties();
        props.setProperty("niewielka", String.valueOf(niewielka));
        props.setProperty("przecietna", String.valueOf(przecietna));
        props.setProperty("wymiarowa", String.valueOf(wymiarowa));
        props.setProperty("ogromna", String.valueOf(ogromna));
        props.setProperty("mamucia", String.valueOf(mamucia));
        props.setProperty("sumaryb", String.valueOf(sumaryb));
        props.setProperty("zarobekzryb", String.valueOf(zarobekzryb));
        props.setProperty("togglerybak", String.valueOf(togglerybak));
        props.setProperty("togglecooldown", String.valueOf(togglecooldown));


        try (OutputStream out = Files.newOutputStream(PATH,
                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)) {
            props.store(out, "SkyUP+ config");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
