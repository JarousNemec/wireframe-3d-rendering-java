package utils;

import java.awt.*;

public class ColorUtil {
    public static final int DEFAULT_LINE_COLOR = Color.WHITE.getRGB();

    //color as "#AARRGGBB", e.g. white -1 -> "#FFFFFFFF"
    public static String integerToHex(int color) {
        return String.format("#%08X", color);
    }

    //accepts "#AARRGGBB" or "#RRGGBB" (then the color is opaque), # is optional
    //parseUnsignedInt, because colors with alpha FF don't fit into positive int
    public static int hexToInteger(String hex) {
        String digits = hex.startsWith("#") ? hex.substring(1) : hex;
        return switch (digits.length()) {
            case 8 -> Integer.parseUnsignedInt(digits, 16);
            case 6 -> 0xFF000000 | Integer.parseInt(digits, 16);
            default -> throw new IllegalArgumentException("Color must be #AARRGGBB or #RRGGBB, found " + hex);
        };
    }
}
