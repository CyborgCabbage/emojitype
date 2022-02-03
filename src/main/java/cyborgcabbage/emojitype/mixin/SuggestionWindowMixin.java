package cyborgcabbage.emojitype.mixin;

import com.mojang.brigadier.suggestion.Suggestion;
import cyborgcabbage.emojitype.client.EmojiType;
import cyborgcabbage.emojitype.emoji.EmojiCode;
import net.minecraft.client.gui.screen.CommandSuggestor;
import net.minecraft.client.gui.widget.TextFieldWidget;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(CommandSuggestor.SuggestionWindow.class)
public abstract class SuggestionWindowMixin {
    @Final @Shadow CommandSuggestor field_21615;

    @Shadow @Final private List<Suggestion> suggestions;

    @Shadow private int selection;

    @Inject(method="complete",at=@At("TAIL"))
    private void overwriteComplete(CallbackInfo ci){
        TextFieldWidget textFieldWidget = ((CommandSuggestorAccessor)field_21615).getTextField();
        Suggestion suggestion = this.suggestions.get(this.selection);
        int justTyped = suggestion.getRange().getStart() + suggestion.getText().length()-1;
        for(EmojiCode ec: EmojiType.emojiCodes){
            if(ec.match(textFieldWidget.getText(),justTyped)){
                textFieldWidget.eraseCharacters(-ec.getCode().length());
                textFieldWidget.write(ec.getEmoji());
                break;
            }
        }
    }
}
