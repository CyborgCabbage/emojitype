package cyborgcabbage.emojitype.mixin;

import com.google.common.base.Strings;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import cyborgcabbage.emojitype.client.EmojiTypeClient;
import net.minecraft.client.gui.screen.CommandSuggestor;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.command.CommandSource;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.concurrent.CompletableFuture;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Mixin(CommandSuggestor.class)
public abstract class CommandSuggestorMixin {
    private static final Pattern COLON_PATTERN = Pattern.compile("(:)");
    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("(\\s+)");

    @Shadow @Final private TextFieldWidget textField;

    @Shadow @Final private boolean slashOptional;

    @Shadow @Nullable private CompletableFuture<Suggestions> pendingSuggestions;

    @Shadow public abstract void showSuggestions(boolean narrateFirstSuggestion);

    @Inject(method="refresh",at=@At("TAIL"),cancellable = true)
    private void inject(CallbackInfo ci){
        String text = this.textField.getText();
        StringReader stringReader = new StringReader(text);
        boolean hasSlash = stringReader.canRead() && stringReader.peek() == '/';
        if (hasSlash) {
            stringReader.skip();
        }
        boolean isCommand = this.slashOptional || hasSlash;
        int cursor = this.textField.getCursor();
        if (!isCommand) {
            String textUptoCursor = text.substring(0, cursor);
            int start = Math.max(getLastColon(textUptoCursor)-1,0);
            int whitespace = getLastWhitespace(textUptoCursor);
            if(start < textUptoCursor.length() && start >= whitespace){
                if(textUptoCursor.charAt(start) == ':') {
                    this.pendingSuggestions = CommandSource.suggestMatching(EmojiTypeClient.allCodes, new SuggestionsBuilder(textUptoCursor, start));
                    this.pendingSuggestions.thenRun(() -> {
                        if (!this.pendingSuggestions.isDone()) {
                            return;
                        }
                        this.showSuggestions(false);
                    });
                    ci.cancel();
                }
            }
        }
    }

    private int getLastColon(String input){
        if (Strings.isNullOrEmpty(input)) {
            return 0;
        }
        int i = 0;
        Matcher matcher = COLON_PATTERN.matcher(input);
        while (matcher.find()) {
            i = matcher.end();
        }
        return i;
    }

    private int getLastWhitespace(String input){
        if (Strings.isNullOrEmpty(input)) {
            return 0;
        }
        int i = 0;
        Matcher matcher = WHITESPACE_PATTERN.matcher(input);
        while (matcher.find()) {
            i = matcher.end();
        }
        return i;
    }
}
