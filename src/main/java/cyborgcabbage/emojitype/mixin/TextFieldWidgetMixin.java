package cyborgcabbage.emojitype.mixin;

import cyborgcabbage.emojitype.EmojiTypeMod;
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

    @Shadow private int selectionEnd;

    @Shadow private int selectionStart;

    @Inject(method="charTyped",at=@At("RETURN"))
    private void inject(char chr, int modifiers, CallbackInfoReturnable<Boolean> cir){
        if(cir.getReturnValue()) {
            int justTyped = getCursorPosWithOffset(-1);
            for(EmojiCode ec: EmojiTypeMod.emojiCodes){
                if(ec.match(getText(),justTyped)){
                    eraseCharacters(-ec.getCode().length());
                    //When you hold shift (which you do to type ':') it messes up when eraseCharacters trys to move the cursor back, instead extending the selection
                    selectionEnd = selectionStart;
                    write(ec.getEmoji());
                    break;
                }
            }
        }
    }
}
