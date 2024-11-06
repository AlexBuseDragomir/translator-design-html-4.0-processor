package parser;

import file.FileReaderUtility;
import html.HtmlTag;
import html.HtmlTagUtility;
import html.Tag;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// old class used for the lexer part of the project
// for working new version, see Html4ParserJs which used JSoup library
// in order to enhance the old functionality
public class Html4Parser {

    private static final FileReaderUtility FILE_READER_UTILITY =
            new FileReaderUtility();

    // FILE CONTENT EXTRACTORS

    public List<String> extractTagsWithContentFromText(List<String> fileContent) {
        StringBuilder fullText = new StringBuilder();

        for (String line: fileContent) {
            fullText.append(line);
        }

        String contents = fullText.toString();
        Pattern pattern = Pattern.compile("<[^>]*>");
        Matcher matcher = pattern.matcher(contents);

        List<String> tagWithContentList = new LinkedList<>();

        while(matcher.find()) {
            String stringTag = matcher.group();
            tagWithContentList.add(stringTag);
        }

        return tagWithContentList;
    }

    public List<String> extractPropertiesFromFile(List<String> fileContent) {
        List<String> propertiesFromText = new LinkedList<>();

        for (String line: fileContent) {
            propertiesFromText.addAll(extractPropertiesFromString(line));
        }

        return propertiesFromText;
    }

    public List<HtmlTag> extractTagsFromFile(List<String> fileContent) {
        List<HtmlTag> tagsFromText = new LinkedList<>();

        for (String line: fileContent) {
            tagsFromText.addAll(extractTagsFromString(line));
        }

        return tagsFromText;
    }

    public List<Integer> extractIntegersFromFile(List<String> fileContent) {
        List<Integer> IntegersFromText = new LinkedList<>();

        for (String line: fileContent) {
            IntegersFromText.addAll(extractIntegersFromString(line));
        }

        return IntegersFromText;
    }

    public List<Double> extractRealNumbersFromFile(List<String> fileContent) {
        List<Double> realNumbersFromText = new LinkedList<>();

        for (String line: fileContent) {
            realNumbersFromText.addAll(extractRealNumbersFromString(line));
        }

        return realNumbersFromText;
    }

    // FILE PATH EXTRACTORS

    public List<String> extractPropertiesFromFile(String fileName) {
        List<String> propertiesFromFile = new LinkedList<>();

        List<String> fileText =
                FILE_READER_UTILITY.readFileAsList(fileName);

        for (String line: fileText) {
            propertiesFromFile.addAll(extractPropertiesFromString(line));
        }

        return propertiesFromFile;
    }

    public List<Integer> extractIntegersFromFile(String fileName) {
        List<Integer> integersFromFile = new LinkedList<>();

        List<String> fileText =
                FILE_READER_UTILITY.readFileAsList(fileName);

        for (String line: fileText) {
            integersFromFile.addAll(extractIntegersFromString(line));
        }

        return integersFromFile;
    }

    public List<Double> extractRealNumbersFromFile(String fileName) {
        List<Double> realNumbersFromFile = new LinkedList<>();

        List<String> fileText =
                FILE_READER_UTILITY.readFileAsList(fileName);

        for (String line: fileText) {
            realNumbersFromFile.addAll(extractRealNumbersFromString(line));
        }

        return realNumbersFromFile;
    }

    public List<HtmlTag> extractTagsFromFile(String fileName) {
        List<HtmlTag> tagsFromFile = new LinkedList<>();

        List<String> fileText =
                FILE_READER_UTILITY.readFileAsList(fileName);

        for (String line: fileText) {
            tagsFromFile.addAll(extractTagsFromString(line));
        }

        return tagsFromFile;
    }

    // STRING EXTRACTORS

    private List<String> extractPropertiesFromString(String line) {
        Pattern pattern = Pattern.compile("([\"'])(?:(?=(\\\\?))\\2.)*?\\1");
        Matcher matcher = pattern.matcher(line);

        List<String> propertiesList = new LinkedList<>();

        while(matcher.find()) {
            String property = matcher.group();
            propertiesList.add(property);
        }

        return propertiesList;
    }

    private List<Double> extractRealNumbersFromString(String line) {
        Pattern pattern = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+");
        Matcher matcher = pattern.matcher(line);

        List<Double> realNumberList = new LinkedList<>();

        while(matcher.find()) {
            double realNumber = Double.parseDouble(matcher.group());

            // we do not want integers
            if (realNumber != Math.floor(realNumber)) {
                realNumberList.add(realNumber);
            }
        }

        return realNumberList;
    }

    private List<Integer> extractIntegersFromString(String line) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(line);

        List<Integer> numbersList = new LinkedList<>();

        while(matcher.find()) {
            Integer number = Integer.parseInt(matcher.group());
            numbersList.add(number);
        }

        return numbersList;
    }

    private List<HtmlTag> extractTagsFromString(String line) {
        Pattern pattern = Pattern.compile("<([^\\s>/]+)");
        Matcher matcher = pattern.matcher(line);

        List<HtmlTag> tagList = new LinkedList<>();

        while(matcher.find()) {
            String stringTag = matcher.group();

            String tagWithoutBrackets =
                    stringTag.substring(1, stringTag.length());

            Tag tag = Tag.valueOf(tagWithoutBrackets.toUpperCase());
            tagList.add(HtmlTagUtility.htmlTagOf(tag, null));
        }

        return tagList;
    }
}