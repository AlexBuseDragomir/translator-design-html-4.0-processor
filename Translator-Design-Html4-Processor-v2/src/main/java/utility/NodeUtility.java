package utility;

import html.HtmlAttribute;
import tree.Node;
import tuple.SimpleTuple;

import java.util.*;
import java.util.function.BiFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NodeUtility {

    // gets all the attributes
    // for a given node
    public static List<HtmlAttribute> getNodeAttributes(Node node) {

        List<HtmlAttribute> attributes = new LinkedList<>();

        Map<String, BiFunction<String, String, HtmlAttribute>>
                attributeMap = AttributeMap.generateMap();

        SimpleTuple<String, String> info = getNodeInformation(node);
        String tagName = info.getFirst();
        String tagNameWithAttributes = info.getSecond();

        if (tagNameWithAttributes != null) {

            // first case, for attributes with values
            Pattern patternValue = Pattern
                    .compile(AttributeMetrics.ATTRIBUTE_WITH_VALUE_PATTERN);

            Matcher matcherValue = patternValue.matcher(tagNameWithAttributes);

            while (matcherValue.find()) {
                String rawAttribute = matcherValue.group();

                String attributeName =
                        StringUtility.extractAllBeforeSeparator(rawAttribute);
                String attributeValue =
                        StringUtility.extractAllAfterSeparator(rawAttribute);

                HtmlAttribute htmlAttribute = attributeMap
                        .get(attributeName)
                        .apply(tagName, attributeValue);

                attributes.add(htmlAttribute);
            }

            // second case, for attributes without values
            // we get all words
            String[] words = tagNameWithAttributes.split("\\s+");
            List<String> wordList = Arrays.asList(words);
            List<String> booleanAttributes = AttributeMetrics.VALID_BOOLEAN_ATTRIBUTES;

            // find the intersection of the two lists
            Set<String> intersection = booleanAttributes
                    .stream()
                    .distinct()
                    .filter(wordList::contains)
                    .collect(Collectors.toSet());

            for (String attributeName: intersection) {
                // second parameter will be null
                // because we do not have a value
                HtmlAttribute htmlAttribute = attributeMap
                        .get(attributeName)
                        .apply(tagName, null);

                attributes.add(htmlAttribute);
            }
        }
        return attributes;
    }

    // gets node name
    // works for ending tags also
    public static String getNodeName(Node node) {

        String tagNameWithAttributes;
        String tagName = null;

        String fullName = node.getName().trim();
        int fullNameSize = fullName.length();

        if (fullName.charAt(0) == '<' &&
            fullName.charAt(fullNameSize - 1) == '>') {

            if (fullName.charAt(1) == '/') {
                tagNameWithAttributes = fullName
                        .substring(2, fullNameSize - 1)
                        .trim();
            } else {
                tagNameWithAttributes = fullName
                        .substring(1, fullNameSize - 1)
                        .trim();
            }

            if (tagNameWithAttributes.indexOf(' ') != -1) {
                tagName = tagNameWithAttributes
                        .substring(0, tagNameWithAttributes.indexOf(' '));
            } else {
                tagName = tagNameWithAttributes;
            }
        }

        return tagName;
    }

    // extracts the node name
    // and the node attributes
    // works only for opening tags
    private static SimpleTuple<String, String> getNodeInformation(Node node) {
        String tagNameWithAttributes = null;
        String tagName = null;

        String fullName = node.getName().trim();
        int fullNameSize = fullName.length();

        if (fullName.charAt(0) == '<' &&
                fullName.charAt(1) != '/' &&
                fullName.charAt(fullNameSize - 1) == '>') {

            tagNameWithAttributes = fullName
                    .substring(1, fullNameSize - 1)
                    .trim();

            if (tagNameWithAttributes.indexOf(' ') != -1) {
                tagName = tagNameWithAttributes
                        .substring(0, tagNameWithAttributes.indexOf(' '));
            } else {
                tagName = tagNameWithAttributes;
            }
        }

        return new SimpleTuple<>(tagName, tagNameWithAttributes);
    }
}
