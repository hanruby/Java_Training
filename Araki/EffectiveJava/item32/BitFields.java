package item32;

import java.util.EnumSet;
import java.util.Set;

public class BitFields {
}

// ビットフィールド列挙定数（古い）
class OldText {
    public static final int STYLE_BOLD          = 1 << 0;  // 1
    public static final int STYLE_ITALIC        = 1 << 1;  // 2
    public static final int STYLE_UNDERLINE     = 1 << 2;  // 4
    public static final int STYLE_STRIKETHROUGH = 1 << 3;  // 8

    // パラメータは、0個以上のSTYLE_定数のビット
    public void applyStyles(int styles) { /*...*/ }

    // 利用例
    public static void example(String[] args) {
        OldText text = new OldText();
        text.applyStyles(STYLE_BOLD | STYLE_ITALIC);
    }
}

// EnumSet - ビットフィールドの最新表現方法
class NewText {
    public enum Style { BOLD, ITALIC, UNDERLINE, STRIKETHROUGH }

    // どのようなSetでも渡せるが、EnumSetが明らかに最善
    public void applyStyles(Set<Style> styles) { /*...*/ }

    // 利用例
    public static void example(String[] args) {
        NewText text = new NewText();
        text.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
    }
}

