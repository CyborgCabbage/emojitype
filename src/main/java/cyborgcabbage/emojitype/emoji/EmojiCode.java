package cyborgcabbage.emojitype.emoji;

public class EmojiCode {
    private final String code;
    private final String emoji;
    private final int minDataVersion;
    public EmojiCode(String code, String emoji, int minDataVersion){
        this.code = code;
        this.emoji = emoji;
        this.minDataVersion = minDataVersion;
    }

    public EmojiCode(String code, String emoji){
        this(code, emoji, 100);
    }

    public String getCode(){
        return code;
    }
    public int getMinDataVersion(){
        return minDataVersion;
    }
    public String getEmoji() {
        return emoji;
    }
    public boolean match(String string, int charIndex){
        for(int i = 0; i < code.length(); i++){
            int stringIndex = charIndex-i;
            int codeIndex = code.length()-1-i;
            if(stringIndex < 0 || codeIndex < 0) return false;
            if(string.charAt(stringIndex) != code.charAt(codeIndex)) return false;
        }
        return true;
    }
}
