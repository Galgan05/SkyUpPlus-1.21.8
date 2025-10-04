package net.galgan.skyupplus.features;

import net.fabricmc.fabric.api.client.message.v1.ClientReceiveMessageEvents;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.fabricmc.fabric.api.client.screen.v1.ScreenMouseEvents;
import net.galgan.skyupplus.config.Config;
import net.galgan.skyupplus.mixin.HandledScreenAccess;
import net.galgan.skyupplus.utility.Chat;
import net.galgan.skyupplus.utility.ServerRestrictor;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.screen.slot.Slot;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Quests {
    public static Text questName;
    public static List<Text> filteredDescription;
    public static boolean isQuestActive;

    public static void quests() {

        ScreenEvents.BEFORE_INIT.register((client, screen, w, h) -> {
            if(!ServerRestrictor.isAllowed()) return;

            //Check if you're inside a container that's valid
            if(!Config.INSTANCE.toggleQuests) return;
            if (!(screen instanceof HandledScreen<?> handled)) return;
            if (!containerTitles.contains(handled.getTitle().getString())) return;

            // Register per-screen listeners
            ScreenMouseEvents.beforeMouseClick(screen).register((s, mouseX, mouseY, button) -> {
                //Check if the button clicked was a middle button
                if (button != 2) return;
                //Check if you clicked a valid slot
                Slot slot = getSlotAt(handled, mouseX, mouseY);
                if (slot == null) {
                    questName = null;
                    filteredDescription = null;
                    isQuestActive = false;
                    return;
                }
                //Check if the quest is valid
                LoreComponent questLore = slot.getStack().get(DataComponentTypes.LORE);

                if (questLore == null) {
                    questName = null;
                    filteredDescription = null;
                    isQuestActive = false;
                    return;
                }
                if (completedLore.equals(questLore.toString())) {
                    questName = null;
                    filteredDescription = null;
                    isQuestActive = false;
                    return;
                }
                if (!questNames.contains(slot.getStack().getName().getString())) {
                    questName = null;
                    filteredDescription = null;
                    isQuestActive = false;
                    return;
                }
                //If every check passed, print out the name of the quest
                isQuestActive = true;
                questName = slot.getStack().getName();
                Chat.send(Text.empty().append(Text.literal("Wybrano zadanie: ").formatted(Formatting.DARK_AQUA)).append(questName));
                //Get the filtered description of the quest
                filteredDescription = loreFilter(questLore);
            });
        });

        ClientReceiveMessageEvents.GAME.register((message, overlay) -> {
            if(!ServerRestrictor.isAllowed()) return;

            if (!overlay && message.getString().startsWith("Wyzwania » Ukończono zadanie")) {
                isQuestActive = false;
            }
        });
    }

    public static Slot getSlotAt(HandledScreen<?> screen, double x, double y) {
        return ((HandledScreenAccess) screen).invokeGetSlotAt(x, y);
    }

    public static List<Text> loreFilter(LoreComponent questLore) {
        List<Text> output = new ArrayList<>();
        boolean addNext = false;

        for (Text line : questLore.lines()) {
            String s = line.getString().trim();

            if (s.startsWith("▪")) {
                if (s.startsWith("▪ Opis") || s.startsWith("▪ Za ukończenie") || s.startsWith("▪ LPM") || s.startsWith("▪ Uwaga") || s.startsWith("▪ Kategoria")) {
                    addNext = false;
                } else {
                    output.add(line);
                    addNext = true;
                }
            } else {
                if (addNext) output.add(line);
            }
        }
        return output;
    }

    public static final Set<String> containerTitles = Set.of(
            "\uE003\uE150\uE002Wyzwania",
            "\uE001\uE151\uE002Wyzwania » Nowicjusz",
            "\uE001\uE152\uE002Wyzwania » Wtajemniczony",
            "\uE001\uE153\uE002Wyzwania » Zaawansowany",
            "\uE001\uE154\uE002Wyzwania » Znawca",
            "\uE001\uE155\uE002Wyzwania » Ekspert",
            "\uE001\uE156\uE002Wyzwania » Mistrz",
            "\uE001\uE157\uE002Wyzwania » Guru",
            "\uE001\uE158\uE002Wyzwania » Legenda",
            "\uE001\uE159\uE002Wyzwania » Wirtuoz",
            "\uE001\uE15A\uE002Wyzwania » Bonus"
    );

    public static final Set<String> questNames = Set.of(
            "» Od czego zacząć? «",
            "» Podstawowy kamieniołom «",
            "» Obozowisko «",
            "» Cieśla amator «",
            "» Jabłecznik «",
            "» Składzik «",
            "» Ściernisko «",
            "» Mała farma «",
            "» Piekarz «",
            "» (Nie)zbilansowana dieta «",
            "» Kucharz grzybowy «",
            "» Plantacja «",
            "» Zielony Jeż «",
            "» Moczykij «",
            "» Huta «",
            "» Gotowy do Pracy «",
            "» Światełko nadziei «",
            "» Szerokie horyzonty «",
            "» Moja pierwsza praca «",
            "» Ciasno, ale własno «",
            "» Kamienny kilof «",
            "» Mało miejsca dla kolegów «",
            "» Tajga «",
            "» Gospodarka leśna «",
            "» Drwal alchemik «",
            "» Zmory podziemi «",
            "» Kryptomaniak «",
            "» Zbrojownia «",
            "» Kuźnia «",
            "» Architekt wnętrz «",
            "» Żabie oświecenie «",
            "» Szamaństwo «",
            "» Ranczo «",
            "» Pożywne śniadanie «",
            "» Sok z buraka «",
            "» Rybak «",
            "» Przelewa się «",
            "» Piecoznawstwo «",
            "» Morski świat do morskich opowieści «",
            "» Agresywna ekspansja «",
            "» Pracuś «",
            "» Wiśniowe bagna «",
            "» Wioska smerfów «",
            "» Szlambonurek «",
            "» Przymiarki do dyniarki «",
            "» Frytki do tego? «",
            "» Cukiernik «",
            "» Rzeźnik «",
            "» Polowanie na króliki «",
            "» Ogromna jajecznica «",
            "» Ryba chwyciła haczyk «",
            "» Pokaz fajerwerków «",
            "» Jacuzzi «",
            "» Mój bohater «",
            "» Obieżyświat «",
            "» Łucznictwo «",
            "» Kolekcjoner sztuki «",
            "» Biednemu wiatr w oczy «",
            "» Przemiana «",
            "» Dzwoń na trwogę «",
            "» Da się żyć «",
            "» Piekło «",
            "» Piekielny kamień «",
            "» Łowca «",
            "» Zapasowe ciało «",
            "» Znawca walki na dystans «",
            "» Kryptolog «",
            "» Archeolog «",
            "» Daleko jeszcze? «",
            "» Witamy w endzie «",
            "» Jaki skyblock, taki smok «",
            "» Willy Wonka «",
            "» Owocowy las «",
            "» Super odporność «",
            "» Leśny zakątek «",
            "» \"Potężna wichura łamiąc duże drzewa...\" «",
            "» Agrotechnika «",
            "» Susza «",
            "» Szkarłatne rzeczy «",
            "» Nie igraj z ogniem «",
            "» Skumulowana Energia «",
            "» Ochłodzenie klimatu «",
            "» Magia «",
            "» Dobry pasterz «",
            "» Niebieski kwiat i kolce «",
            "» Handlarz z piekła rodem «",
            "» Pracownik miesiąca «",
            "» Własny dinozaur «",
            "» Szkółka leśna «",
            "» Czas na las «",
            "» Sięgając korzeni «",
            "» Jagodzianka «",
            "» Szczęściarz «",
            "» Pancerna hodowla «",
            "» Grabarz? Garbarz! «",
            "» Słoneczny patrol «",
            "» Pasieka «",
            "» Magazyn «",
            "» W zwolnionym tempie  «",
            "» Piekielny szaleniec «",
            "» Obce organizmy «",
            "» Nemezis «",
            "» Mur «",
            "» Mój słodziutki «",
            "» Purée «",
            "» Dziki Zachód «",
            "» Basen olimpijski «",
            "» Podwodne życie «",
            "» Mamut morski «",
            "» Epoka diamentów «",
            "» Boska ręka «",
            "» Królowa sawanny «",
            "» Skarbek «",
            "» Piekielny kowal «",
            "» Zaklęty kowal «",
            "» Magazynier «",
            "» Redstonowiec «",
            "» Rolnik z zaświatów «",
            "» Gorzka (wątpliwa) przyjemność «",
            "» Pola malowane zbożem rozmaitem «",
            "» Sukulenty «",
            "» Artysta kulinarny «",
            "» Raz kozie śmierć «",
            "» Podpłomyk «",
            "» Pokój alchemika «",
            "» Nekromanta «",
            "» Arachnofobia «",
            "» Glazurnik «",
            "» Antofobia «",
            "» Rafa koralowa «",
            "» Zero absolutne «",
            "» To moje bagno! «",
            "» Skondensowana wiedza «",
            "» Chów ściółkowy «",
            "» Kierownik roku «",
            "» Uczeń czarnoksiężnika «",
            "» Próba testu «",
            "» Prosto z kopalni «",
            "» Kolekcjoner klejnotów «",
            "» Ametyściara «",
            "» Siekieronator «",
            "» Ziemianin «",
            "» Szatańskie łzy «",
            "» Piekielna twierdza «",
            "» Stawik kałamarnic «",
            "» Królicza opatrzność «",
            "» Kuter rybacki «",
            "» Co za dużo to niezdrowo «",
            "» Dyniara, czy nie dyniara? «",
            "» Ziemniaczki zostaw «",
            "» Kresowe owocki «",
            "» Nieudolny rolnik «",
            "» Bezpieczeństwo Hamuje Prace «",
            "» Gdy zapada noc «",
            "» Świński makler «",
            "» Degustator «",
            "» Mój mały świat «",
            "» Skołatane nerwy «",
            "» Cesarz rybołówstwa «",
            "» Pszczelarz «",
            "» Ostatni przyjaciele «",
            "» Nawiedzony tropiciel «",
            "» Świecznik «",
            "» Shulkusiowa rodzina «",
            "» Piroman absolutny «",
            "» Miodowe Lata «",
            "» Kolorowa plaża «",
            "» Geolog «",
            "» Biblioteka Aleksandryjska «",
            "» Prastare zwoje «",
            "» Piekielny rycerz «",
            "» Czarny pas w dungeonie «",
            "» CEO «",
            "» Władca skyblocka «",
            "» Wirtuoz piekła «",
            "» Leśny potwór «",
            "» Warzywniak «",
            "» Piekielna roślinność «",
            "» Bambusowy las «",
            "» Czekoladowe fondue «",
            "» Trzcinator «",
            "» Operacja Borówka «",
            "» Obrońca wszechświata «",
            "» Wielka uczta «",
            "» Sztygar «",
            "» Władca pustki «",
            "» Budowniczy na medal «",
            "» Gorączka ametystu «",
            "» Ofiara dla Dadźboga «",
            "» Maszynka do mielenia «",
            "» Pracoholik «",
            "» Technik «",
            "» Złoto w każdej postaci «",
            "» Wspinaczka «",
            "» Świat pełen kolorów «",
            "» Robi się gorąco «",
            "» Strażnik światłości «",
            "» Puk puk, kto tam? «",
            "» Prawiebloki «",
            "» Świat jest piękny «",
            "» Nieszczęśliwy traf «",
            "» Obłąkany rolnik «",
            "» Kolumbijscy drapieżcy «",
            "» Epoka lodowcowa «",
            "» Czarno to widze «",
            "» Pan życia i śmierci «",
            "» Nic mnie już nie zaskoczy «",
            "» Imiennik «",
            "» Zadanie codzienne «"
    );

    public static final String completedLore = "LoreComponent[lines=[empty, empty[siblings=[literal{▪ }[style={color=dark_gray,bold,!italic,!underlined,!strikethrough,!obfuscated}], literal{Zadanie ukończone!}[style={color=green,!bold,!italic}]]], empty], styledLines=[empty[style={color=dark_purple,italic}], empty[style={color=dark_purple,italic}, siblings=[literal{▪ }[style={color=dark_gray,bold,!italic,!underlined,!strikethrough,!obfuscated}], literal{Zadanie ukończone!}[style={color=green,!bold,!italic}]]], empty[style={color=dark_purple,italic}]]]";
}
