package cyborgcabbage.emojitype.mixin;

import cyborgcabbage.emojitype.client.EmojiTypeClient;
import cyborgcabbage.emojitype.emoji.EmojiCode;
import net.minecraft.client.gui.widget.TextFieldWidget;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TextFieldWidget.class)
public abstract class TextFieldWidgetMixin {
    @Shadow public abstract void eraseCharacters(int characterOffset);

    @Shadow public abstract String getText();

    @Shadow protected abstract int getCursorPosWithOffset(int offset);

    @Shadow public abstract void write(String text);

    @Inject(method="charTyped",at=@At("RETURN"))
    private void inject(char chr, int modifiers, CallbackInfoReturnable<Boolean> cir){
        if(cir.getReturnValue()) {
            int justTyped = getCursorPosWithOffset(-1);
            for(EmojiCode ec: EmojiTypeClient.emojiCodes){
                if(ec.substitute(getText(),justTyped)){
                    eraseCharacters(-ec.getCode().length());
                    write(ec.getEmoji());
                    break;
                }
            }
        }
    }
}
