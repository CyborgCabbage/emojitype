package cyborgcabbage.emojitype.client;

import cyborgcabbage.emojitype.emoji.EmojiCode;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class EmojiTypeClient implements ClientModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("emojitype");
    public static ArrayList<EmojiCode> emojiCodes = new ArrayList<>();
    public static ArrayList<String> allCodes = new ArrayList<>();
    public static ArrayList<String> allEmoji = new ArrayList<>();
    @Override
    public void onInitializeClient() {
        //Face
        emojiCodes.add(new EmojiCode(":happy:","☺"));
        emojiCodes.add(new EmojiCode(":happy2:","☻"));
        emojiCodes.add(new EmojiCode(":sad:","☹"));
        emojiCodes.add(new EmojiCode(":skull:","☠"));
        //Tool
        emojiCodes.add(new EmojiCode(":pickaxe:","⛏"));
        emojiCodes.add(new EmojiCode(":axe:","\uD83E\uDE93"));
        emojiCodes.add(new EmojiCode(":shovel:","☠"));
        emojiCodes.add(new EmojiCode(":bucket:","\uD83E\uDEA3"));
        emojiCodes.add(new EmojiCode(":shears:","✂"));
        emojiCodes.add(new EmojiCode(":fishing:","\uD83C\uDFA3"));
        emojiCodes.add(new EmojiCode(":umbrella:","☂"));
        //Combat
        emojiCodes.add(new EmojiCode(":trident:","\uD83D\uDD31"));
        emojiCodes.add(new EmojiCode(":sword:","\uD83D\uDDE1"));
        emojiCodes.add(new EmojiCode(":shield:","\uD83D\uDEE1"));
        emojiCodes.add(new EmojiCode(":duel:","⚔"));
        emojiCodes.add(new EmojiCode(":bow:","\uD83C\uDFF9"));
        //Potion
        emojiCodes.add(new EmojiCode(":potion:","\uD83E\uDDEA"));
        emojiCodes.add(new EmojiCode(":splash:","⚗"));
        //Mark
        emojiCodes.add(new EmojiCode(":copyright:","©"));
        emojiCodes.add(new EmojiCode(":registered:","®"));
        emojiCodes.add(new EmojiCode(":protected:","℗"));
        emojiCodes.add(new EmojiCode(":trademark:","™"));
        //Water
        emojiCodes.add(new EmojiCode(":anchor:","⚓"));
        emojiCodes.add(new EmojiCode(":wave:","\uD83C\uDF0A"));
        emojiCodes.add(new EmojiCode(":trademark:","™"));
        //Sex
        emojiCodes.add(new EmojiCode(":male:","♂"));
        emojiCodes.add(new EmojiCode(":female:","♀"));
        emojiCodes.add(new EmojiCode(":intersex:","⚥"));
        //Direction
        emojiCodes.add(new EmojiCode(":left:","⏴"));
        emojiCodes.add(new EmojiCode(":right:","⏵"));
        emojiCodes.add(new EmojiCode(":up:","⏶"));
        emojiCodes.add(new EmojiCode(":down:","⏷"));
        emojiCodes.add(new EmojiCode(":handleft:","☜"));
        emojiCodes.add(new EmojiCode(":handright:","☞"));
        emojiCodes.add(new EmojiCode(":swap:","⇄"));
        //Culture
        emojiCodes.add(new EmojiCode(":yingyang:","☯"));
        emojiCodes.add(new EmojiCode(":peace:","☮"));
        //Weather
        emojiCodes.add(new EmojiCode(":sun:","☀"));
        emojiCodes.add(new EmojiCode(":cloud:","☁"));
        emojiCodes.add(new EmojiCode(":comet:","☄"));
        emojiCodes.add(new EmojiCode(":star:","⭐"));
        emojiCodes.add(new EmojiCode(":moon:","☽"));
        emojiCodes.add(new EmojiCode(":snowman:","⛄"));
        emojiCodes.add(new EmojiCode(":storm:","⛈"));
        emojiCodes.add(new EmojiCode(":snow:","❄"));
        //Control
        emojiCodes.add(new EmojiCode(":eject:","⏏"));
        emojiCodes.add(new EmojiCode(":fastforward:","⏩"));
        emojiCodes.add(new EmojiCode(":fastbackward:","⏪"));
        emojiCodes.add(new EmojiCode(":toend:","⏭"));
        emojiCodes.add(new EmojiCode(":tostart:","⏮"));
        emojiCodes.add(new EmojiCode(":playpause:","⏯"));
        emojiCodes.add(new EmojiCode(":pause:","⏸"));
        emojiCodes.add(new EmojiCode(":poweron:","⏻"));
        emojiCodes.add(new EmojiCode(":poweroff:","⏼"));
        //Flag
        emojiCodes.add(new EmojiCode(":whiteflag:","⚑"));
        emojiCodes.add(new EmojiCode(":blackflag:","⚐"));
        //Boolean
        emojiCodes.add(new EmojiCode(":box:","☐"));
        emojiCodes.add(new EmojiCode(":yesbox:","☑"));
        emojiCodes.add(new EmojiCode(":nobox:","☒"));
        emojiCodes.add(new EmojiCode(":yes:","✔"));
        emojiCodes.add(new EmojiCode(":no:","✘"));
        //Shape
        emojiCodes.add(new EmojiCode(":square:","⏹"));
        emojiCodes.add(new EmojiCode(":circle:","⏺"));
        emojiCodes.add(new EmojiCode(":cross:","❌"));
        emojiCodes.add(new EmojiCode(":heart:","❤"));
        emojiCodes.add(new EmojiCode(":triangle:","▲"));
        emojiCodes.add(new EmojiCode(":diamond:","◆"));
        //Misc
        emojiCodes.add(new EmojiCode(":fire:","\uD83D\uDD25"));
        emojiCodes.add(new EmojiCode(":bell:","\uD83D\uDD14"));
        emojiCodes.add(new EmojiCode(":hunger:","\uD83C\uDF56"));
        emojiCodes.add(new EmojiCode(":unknown:","�"));
        emojiCodes.add(new EmojiCode(":house:","⌂"));
        emojiCodes.add(new EmojiCode(":clock:","⌚"));
        emojiCodes.add(new EmojiCode(":warning:","⚠"));
        emojiCodes.add(new EmojiCode(":electric:","⚡"));
        emojiCodes.add(new EmojiCode(":mail:","✉"));
        emojiCodes.add(new EmojiCode(":pencil:","✎"));
        for(EmojiCode ec: emojiCodes){
            allCodes.add(ec.getCode());
            allEmoji.add(ec.getEmoji());
        }
    }
}
