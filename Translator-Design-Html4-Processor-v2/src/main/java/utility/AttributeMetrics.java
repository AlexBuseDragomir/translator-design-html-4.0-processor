package utility;

import java.util.Arrays;
import java.util.List;

public class AttributeMetrics {

    public static final String HEX_PATTERN =
            "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";
    public static final String RGB_PATTERN =
            "rgb\\(\\s*(?:(?:\\d{1,2}|1\\d\\d|2(?:[0-4]\\d|5[0-5]))\\s*,?){3}\\)$";
    public static final String HTTP_URL_PATTERN =
            "(http(s?):)([/|.|\\w|\\s|-])*\\.(?:jpg|gif|png)";
    public static final String FILE_PATH_URL_PATTERN =
            "(\\\\?([^\\/]*[\\/])*)([^\\/]+)$";

    public static final String[] VALID_HTML_COLORS =
    {
        "aliceblue", "antiquewhite", "aqua", "aquamarine",
        "azure", "beige", "bisque", "black", "blanchedalmond",
        "blue", "blueviolet", "brown", "burlywood", "cadetblue",
        "chartreuse", "chocolate", "coral", "cornflowerblue",
        "cornsilk", "crimson", "cyan", "darkblue", "darkcyan",
        "darkgoldenrod", "darkgray", "darkgreen", "darkkhaki",
        "darkmagenta", "darkolivegreen", "darkorange", "darkorchid",
        "darkred", "darksalmon", "darkseagreen", "darkslateblue",
        "darkslategray", "darkturquoise", "darkviolet", "deeppink",
        "deepskyblue", "dimgray", "dodgerblue", "firebrick", "floralwhite",
        "forestgreen", "fuchsia", "gainsboro", "ghostwhite", "gold",
        "goldenrod", "gray", "green", "greenyellow", "honeydew",
        "hotpink", "indianred", "indigo", "ivory", "khaki", "lavender",
        "lavenderblush", "lawngreen", "lemonchiffon", "lightblue", "lightcoral",
        "lightcyan", "lightgoldenrodyellow", "lightgreen", "lightgrey",
        "lightpink", "lightsalmon", "lightseagreen", "lightskyblue",
        "lightslategray", "lightsteelblue", "lightyellow", "lime",
        "limegreen", "linen", "magenta", "maroon", "mediumaquamarine",
        "mediumblue", "mediumorchid", "mediumpurple", "mediumseagreen",
        "mediumslateblue", "mediumspringgreen", "mediumturquoise",
        "mediumvioletred", "midnightblue", "mintcream", "mistyrose",
        "moccasin", "navajowhite", "navy", "oldlace", "olive", "olivedrab",
        "orange", "orangered", "orchid", "palegoldenrod", "palegreen",
        "paleturquoise", "palevioletred", "papayawhip", "peachpuff", "peru",
        "pink", "plum", "powderblue", "purple", "red", "rosybrown", "royalblue",
        "saddlebrown", "salmon", "sandybrown", "seagreen", "seashell", "sienna",
        "silver", "skyblue", "slateblue", "slategray", "snow", "springgreen",
        "steelblue", "tan", "teal", "thistle", "tomato", "turquoise", "violet",
        "wheat", "white", "whitesmoke", "yellow", "yellowgreen"
    };

    public static final String[] VALID_FONT_FACES =
    {
        "Agency FB", "Albertina", "Antiqua", "Architect", "Arial", "BankFuturistic",
        "BankGothic", "Blackletter", "Blagovest", "Calibri", "Comic Sans MS",
        "Consolas", "Courier", "Cursive", "Decorative", "Fantasy", "Fraktur",
        "Frosty", "Garamond", "Georgia", "Helvetica", "Impact", "Minion", "Modern",
        "Monospace", "Open Sans", "Palatino", "Perpetua", "Roman", "Sans-serif",
        "Serif", "Script", "Swiss", "Times", "Times New Roman", "Tw Cen MT", "Verdana"
    };

    public static final String[] VALID_MEDIA_TYPES =
    {
        "application", "audio", "font", "example",
        "image", "message", "model", "multipart",
        "text", "video"
    };

    public static final String[] VALID_RELATIONSHIP_TYPES =
    {
        "alternate", "author", "bookmark",
        "external", "help", "license",
        "next", "nofollow", "noreferrer",
        "noopener", "prev", "search", "tag"
    };

    public static final List<String> VALID_SHAPES =
            Arrays.asList("default", "rect", "circle", "poly");

    public static final List<String> VALID_ALIGN =
            Arrays.asList("right", "center", "left", "justify");

    public static final List<String> VALID_IMG_ALIGN =
            Arrays.asList("right", "middle", "left", "top", "bottom");

    public static final List<String> VALID_TABLE_ALIGN =
            Arrays.asList("right", "center", "left");

    public static final List<String> VALID_LI_TYPE =
            Arrays.asList("disc", "circle", "square", "1", "a", "A", "i", "I");

    public static final List<String> VALID_OL_TYPE =
            Arrays.asList("1", "a", "A", "i", "I");

    public static final List<String> VALID_UL_TYPE =
            Arrays.asList("disc", "circle", "square");

    public static final List<String> VALID_BORDER_VALUES =
            Arrays.asList("0", "1");

    public static final List<String> VALID_VALIGN_VALUES =
            Arrays.asList("top", "middle", "bottom", "baseline");

    public static final List<String> VALID_BOOLEAN_ATTRIBUTES =
            Arrays.asList("nowrap", "reversed");

    public static final String ATTRIBUTE_WITH_VALUE_PATTERN =
            "[a-zA-Z]*=\"[\\w!#-:;.|@$%^&*()+ ~/?=]+\"";

    public static final char ATTRIBUTE_SEPARATOR = '=';

    public static final int COMMON_MIN_HEIGHT = 1;
    public static final int COMMON_MAX_HEIGHT = 2000;

    public static final int COMMON_MIN_WIDTH = 1;
    public static final int COMMON_MAX_WIDTH = 5000;

    public static final int MIN_FONT_SIZE = 1;
    public static final int MAX_FONT_SIZE = 7;

    public static final int MIN_ALT_SIZE = 2;
    public static final int MAX_ALT_SIZE = 1000;

    public static final int MIN_IMG_HEIGHT = 1;
    public static final int MAX_IMG_HEIGHT = 4000;

    public static final int MIN_IMG_WIDTH = 1;
    public static final int MAX_IMG_WIDTH = 6000;

    public static final int MIN_START_VALUE = -10000;
    public static final int MAX_START_VALUE = 10000;

    public static final int MIN_SUMMARY_SIZE = 2;
    public static final int MAX_SUMMARY_SIZE = 1000;

    public static final int MIN_COL_SPAN = 0;
    public static final int MAX_COL_SPAN = 1000;
}