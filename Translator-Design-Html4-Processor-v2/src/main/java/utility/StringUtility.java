package utility;

public class StringUtility {

    // extracts string content before -not including-
    // the specified character
    // using the default attribute separator
    public static String extractAllBeforeSeparator(String input) {
        char separator = AttributeMetrics.ATTRIBUTE_SEPARATOR;
        return input.substring(0, input.indexOf(separator));
    }

    // extracts string content after -not including-
    // the specified character
    // using the default attribute separator
    public static String extractAllAfterSeparator(String input) {
        int inputSize = input.length();
        char separator = AttributeMetrics.ATTRIBUTE_SEPARATOR;
        return input.substring(input.indexOf(separator) + 1, inputSize);
    }

    public static String removeDoubleQuotes(String input) {
        int inputSize = input.length();
        return input.substring(1, inputSize - 1).trim();
    }
}
