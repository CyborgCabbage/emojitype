package cyborgcabbage.emojitype.client;

import cyborgcabbage.emojitype.emoji.EmojiCode;
import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class EmojiType {
    public static final Logger LOGGER = LoggerFactory.getLogger("emojitype");
    public static ArrayList<EmojiCode> emojiCodes = new ArrayList<>() {
        {
            //Face
            add(new EmojiCode(":happy:","☺"));
            add(new EmojiCode(":happy2:","☻"));
            add(new EmojiCode(":sad:","☹"));
            add(new EmojiCode(":skull:","☠"));
            //Tool
            add(new EmojiCode(":pickaxe:","⛏"));
            add(new EmojiCode(":axe:","\uD83E\uDE93"));
            add(new EmojiCode(":bucket:","\uD83E\uDEA3"));
            add(new EmojiCode(":shears:","✂"));
            add(new EmojiCode(":fishing:","\uD83C\uDFA3"));
            add(new EmojiCode(":umbrella:","☂"));
            //Combat
            add(new EmojiCode(":trident:","\uD83D\uDD31"));
            add(new EmojiCode(":sword:","\uD83D\uDDE1"));
            add(new EmojiCode(":shield:","\uD83D\uDEE1"));
            add(new EmojiCode(":duel:","⚔"));
            add(new EmojiCode(":bow:","\uD83C\uDFF9"));
            //Potion
            add(new EmojiCode(":potion:","\uD83E\uDDEA"));
            add(new EmojiCode(":splash:","⚗"));
            //Mark
            add(new EmojiCode(":copyright:","©"));
            add(new EmojiCode(":registered:","®"));
            add(new EmojiCode(":protected:","℗"));
            add(new EmojiCode(":trademark:","™"));
            //Water
            add(new EmojiCode(":anchor:","⚓"));
            add(new EmojiCode(":wave:","\uD83C\uDF0A"));
            add(new EmojiCode(":trademark:","™"));
            //Sex
            add(new EmojiCode(":male:","♂"));
            add(new EmojiCode(":female:","♀"));
            add(new EmojiCode(":intersex:","⚥"));
            //Direction
            add(new EmojiCode(":left:","⏴"));
            add(new EmojiCode(":right:","⏵"));
            add(new EmojiCode(":up:","⏶"));
            add(new EmojiCode(":down:","⏷"));
            add(new EmojiCode(":handleft:","☜"));
            add(new EmojiCode(":handright:","☞"));
            add(new EmojiCode(":swap:","⇄"));
            //Culture
            add(new EmojiCode(":yingyang:","☯"));
            add(new EmojiCode(":peace:","☮"));
            //Weather
            add(new EmojiCode(":sun:","☀"));
            add(new EmojiCode(":cloud:","☁"));
            add(new EmojiCode(":comet:","☄"));
            add(new EmojiCode(":star:","⭐"));
            add(new EmojiCode(":moon:","☽"));
            add(new EmojiCode(":snowman:","⛄"));
            add(new EmojiCode(":storm:","⛈"));
            add(new EmojiCode(":snow:","❄"));
            //Control
            add(new EmojiCode(":eject:","⏏"));
            add(new EmojiCode(":fastforward:","⏩"));
            add(new EmojiCode(":fastbackward:","⏪"));
            add(new EmojiCode(":toend:","⏭"));
            add(new EmojiCode(":tostart:","⏮"));
            add(new EmojiCode(":playpause:","⏯"));
            add(new EmojiCode(":pause:","⏸"));
            add(new EmojiCode(":poweron:","⏻"));
            add(new EmojiCode(":poweroff:","⏼"));
            //Flag
            add(new EmojiCode(":whiteflag:","⚑"));
            add(new EmojiCode(":blackflag:","⚐"));
            //Boolean
            add(new EmojiCode(":box:","☐"));
            add(new EmojiCode(":yesbox:","☑"));
            add(new EmojiCode(":nobox:","☒"));
            add(new EmojiCode(":yes:","✔"));
            add(new EmojiCode(":no:","✘"));
            //Shape
            add(new EmojiCode(":square:","⏹"));
            add(new EmojiCode(":square2:","□"));
            add(new EmojiCode(":circle:","⏺"));
            add(new EmojiCode(":circle2:","○"));
            add(new EmojiCode(":cross:","❌"));
            add(new EmojiCode(":heart:","❤"));
            add(new EmojiCode(":heart2:","❣"));
            add(new EmojiCode(":triangle:","▲"));
            add(new EmojiCode(":triangle2:","△"));
            add(new EmojiCode(":diamond:","◆"));
            add(new EmojiCode(":diamond2:","◇"));
            add(new EmojiCode(":loopedsquare:","⌘"));
            add(new EmojiCode(":target:","⏳"));
            //Misc
            add(new EmojiCode(":fire:","\uD83D\uDD25"));
            add(new EmojiCode(":bell:","\uD83D\uDD14"));
            add(new EmojiCode(":hunger:","\uD83C\uDF56"));
            add(new EmojiCode(":unknown:","�"));
            add(new EmojiCode(":house:","⌂"));
            add(new EmojiCode(":clock:","⌚"));
            add(new EmojiCode(":warning:","⚠"));
            add(new EmojiCode(":electric:","⚡"));
            add(new EmojiCode(":mail:","✉"));
            add(new EmojiCode(":pencil:","✎"));
            add(new EmojiCode(":degree:","°"));
            add(new EmojiCode(":hourglass:","⌛"));
            add(new EmojiCode(":hourglass2:","⏳"));
            add(new EmojiCode(":z0:","▀"));
            add(new EmojiCode(":z1:","▄"));
            add(new EmojiCode(":z2:","█"));
            add(new EmojiCode(":z3:","▌"));
            add(new EmojiCode(":z4:","▐"));
            add(new EmojiCode(":z5:","░"));
            add(new EmojiCode(":z6:","▒"));
            add(new EmojiCode(":z7:","▓"));
        }
    };
    public static ArrayList<String> allCodes = new ArrayList<>();
    public static ArrayList<String> allEmoji = new ArrayList<>();
    public static ArrayList<String> emojiCodesCombined = new ArrayList<>();
    static {
        for(EmojiCode ec: emojiCodes){
            allCodes.add(ec.getCode());
            allEmoji.add(ec.getEmoji());
            emojiCodesCombined.add(ec.getCode()+" "+ec.getEmoji());
        }
    }
}
