package cyborgcabbage.emojitype.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import cyborgcabbage.emojitype.EmojiTypeMod;
import cyborgcabbage.emojitype.emoji.EmojiCode;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.JsonHelper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class EmojiTypeConfig implements ModMenuApi {
    public static Path CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve(EmojiTypeMod.MOD_ID + ".json");
    public List<String> emojiCodeStrings = new ArrayList<>();
    private void serialise(){
        try {
            Files.createDirectories(CONFIG_PATH.getParent());
            BufferedWriter writer = Files.newBufferedWriter(CONFIG_PATH);
            writer.write(new GsonBuilder().setPrettyPrinting().create().toJson(emojiCodeStrings));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        EmojiTypeMod.update(emojiCodeStrings);
    }

    private void deserialise(){
        if (Files.exists(CONFIG_PATH)) {
            try {
                BufferedReader reader = Files.newBufferedReader(CONFIG_PATH);
                emojiCodeStrings = new Gson().fromJson(reader, new TypeToken<ArrayList<String>>(){}.getType());
                reader.close();
            } catch (IOException e) {
                e.printStackTrace(); //dirty consume
            }
            EmojiTypeMod.update(emojiCodeStrings);
        } else {
            //From defaults
            emojiCodeStrings.clear();
            for (EmojiCode ec : EmojiTypeMod.DEFAULT_EMOJI_CODES) {
                emojiCodeStrings.add(ec.toString());
            }
            serialise();
        }
    }

    public ConfigScreenFactory<Screen> getModConfigScreenFactory() {
        deserialise();
        return screen -> {
            deserialise();
            ConfigBuilder builder = ConfigBuilder.create();
            builder.setTitle(Text.of("Emoji Type Config"));
            builder.setSavingRunnable(this::serialise);
            ConfigEntryBuilder entryBuilder = builder.entryBuilder();
            builder.getOrCreateCategory(Text.of("Emoji Type Category"))
                    .addEntry(entryBuilder.startStrList(Text.of("Emoji Codes"), emojiCodeStrings)
                            .setDefaultValue(() -> {
                                ArrayList<String> l = new ArrayList<>();
                                for (EmojiCode ec : EmojiTypeMod.DEFAULT_EMOJI_CODES) {
                                    l.add(ec.toString());
                                }
                                return l;
                            })
                            .setSaveConsumer((List<String> lstr) -> {
                                System.out.println(lstr);
                                emojiCodeStrings.clear();
                                emojiCodeStrings.addAll(lstr);
                            })
                            .build());
            return builder.setParentScreen(screen).build();
        };
    }
}
