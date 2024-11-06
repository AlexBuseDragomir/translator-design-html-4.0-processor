package utility;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtility {

    public static boolean isHexColorValid(String hexColor) {
        Pattern pattern = Pattern.compile(AttributeMetrics.HEX_PATTERN);
        Matcher matcher = pattern.matcher(hexColor);

        return matcher.matches();
    }

    public static boolean isRgbColorValid(String rgbColor) {
        Pattern pattern = Pattern.compile(AttributeMetrics.RGB_PATTERN);
        Matcher matcher = pattern.matcher(rgbColor);

        return matcher.matches();
    }

    public static boolean isColorNameValid(String colorName) {
        for (String color: AttributeMetrics.VALID_HTML_COLORS) {
            if (colorName.equals(color)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isHttpUrlValid(String httpUrl) {
        Pattern pattern = Pattern.compile(AttributeMetrics.HTTP_URL_PATTERN);
        Matcher matcher = pattern.matcher(httpUrl);

        return matcher.matches();
    }

    public static boolean isFilePathUrlValid(String filePath) {
        Pattern pattern = Pattern.compile(AttributeMetrics.FILE_PATH_URL_PATTERN);
        Matcher matcher = pattern.matcher(filePath);

        return matcher.matches();
    }

    public static boolean isStringPercentValue(String input) {

        List<Character> firstNumber =
                Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9');
        List<Character> secondNumber =
                Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');

        if (input.equals("0%") || input.equals("100%")) {
            return true;
        }

        if (firstNumber.contains(input.charAt(0)) &&
            input.charAt(1) == '%' &&
            input.length() == 2) {
            return true;
        }

        return firstNumber.contains(input.charAt(0)) &&
               secondNumber.contains(input.charAt(1)) &&
               input.charAt(2) == '%' &&
               input.length() == 3;
    }

    public static boolean isFontFaceValid(String fontFace) {
        for (String font: AttributeMetrics.VALID_FONT_FACES) {
            if (fontFace.toLowerCase().equals(font.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isMediaTypeValid(String mediaType) {
        for (String media: AttributeMetrics.VALID_MEDIA_TYPES) {
            if (mediaType.toLowerCase().equals(media.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isRelationshipValid(String relationship) {
        for (String rel: AttributeMetrics.VALID_RELATIONSHIP_TYPES) {
            if (relationship.toLowerCase().equals(rel.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isShapeValid(String shape) {
        for (String validShape: AttributeMetrics.VALID_SHAPES) {
            if (shape.toLowerCase().equals(validShape.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isAlignValid(String align) {
        for (String a: AttributeMetrics.VALID_ALIGN) {
            if (align.equals(a)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isImgAlignValid(String imgAlign) {
        for (String a: AttributeMetrics.VALID_IMG_ALIGN) {
            if (imgAlign.equals(a)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isTableAlignValid(String tableAlign) {
        for (String a: AttributeMetrics.VALID_TABLE_ALIGN) {
            if (tableAlign.equals(a)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isLiTypeValid(String liType) {
        for (String type: AttributeMetrics.VALID_LI_TYPE) {
            if (liType.equals(type)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isOlTypeValid(String olType) {
        for (String type: AttributeMetrics.VALID_OL_TYPE) {
            if (olType.equals(type)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isUlTypeValid(String ulType) {
        for (String type: AttributeMetrics.VALID_UL_TYPE) {
            if (ulType.equals(type)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isBorderValid(String border) {
        for (String b: AttributeMetrics.VALID_BORDER_VALUES) {
            if (border.equals(b)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isVerticalAlignValid(String valign) {
        for (String v: AttributeMetrics.VALID_VALIGN_VALUES) {
            if (valign.equals(v)) {
                return true;
            }
        }
        return false;
    }
}