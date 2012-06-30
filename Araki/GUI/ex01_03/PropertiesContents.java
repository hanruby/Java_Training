package ex01_03;

import java.awt.GraphicsEnvironment;

public class PropertiesContents {

    static String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    
    // Supported fonts
    public static String[] supportedFonts() {
        // Load System fonts.
        return fonts;
    }

    // Supported sizes
    public static int[] supportedFontSizes() {
        int[] sizes = {12, 24, 30, 45};
        return sizes;
    }
    
    // Supported colors
    public static String[] supportedColors() {
        String[] colors = {
               "BLACK",
               "GREEN",
               "ORANGE",
               "WHITE",
        };
        return colors;
    }
    
}
