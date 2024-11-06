package parser;

import file.FileUtility;
import file.FileWriterUtility;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tuple.SimpleTuple;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Html4ParserJs {

    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final FileUtility FILE_UTILITY = new FileUtility();
    private static final FileWriterUtility FILE_WRITER_UTILITY = new FileWriterUtility();
	// use some methods from the old Html4Parser utility
    private static final Html4Parser HTML4_PARSER = new Html4Parser();
    // creating a basic logger for this class
    private static final Logger LOGGER = LoggerFactory.getLogger(Html4ParserJs.class);

    public void extractHtmlDataAndLiteralsToFile(String inputFileName, String outputFileName) {
        // extract the html tags and content
        extractHtmlDataToFile(inputFileName, outputFileName);
        // extract the integer and double literals
        List<Integer> integerValues = extractIntegersFromFile(inputFileName);
        List<Double> doubleValues = extractRealNumbersFromFile(inputFileName);
        List<String> propertyValues = extractPropertiesFromFile(inputFileName);

        FILE_WRITER_UTILITY.appendStringToFile("\n\nNUMBER LITERALS\n\n", outputFileName);

        for (Integer intValue: integerValues) {
            FILE_WRITER_UTILITY.appendStringToFile(intValue.toString() + '\n', outputFileName);
        }
        for (Double doubleValue: doubleValues) {
            FILE_WRITER_UTILITY.appendStringToFile(doubleValue.toString() + '\n', outputFileName);
        }

        FILE_WRITER_UTILITY.appendStringToFile("\n\nPROPERTIES (LINKS AND CONFIGS)\n\n", outputFileName);

        for (String propertyValue: propertyValues) {
            FILE_WRITER_UTILITY.appendStringToFile(propertyValue + '\n', outputFileName);
        }
    }

    private void extractHtmlDataToFile(String inputFileName, String outputFileName) {
        // erase output file before writing data to it
        FILE_UTILITY.eraseContentFromFile(outputFileName);

        File inputFile = FILE_UTILITY
                            .getPathToFileFromResources(inputFileName)
                            .toFile();

        List<SimpleTuple<String, String>> data =
                extractHtmlTagsWithContent(inputFile, DEFAULT_CHARSET);

        FILE_WRITER_UTILITY.appendStringToFile("HTML TAGS AND CONTENT\n\n", outputFileName);

        for (SimpleTuple<String, String> element: data) {
            String tagName = element.getFirst();
            String tagContent = element.getSecond();

            String toAddToFile = "";

            if (tagContent.equals("")) {
                toAddToFile = "Tag: " + "<" + tagName + ">" + '\n';
            } else {
                toAddToFile = "Tag: " + "<" + tagName + ">" + " ---> contains ---> " + tagContent + '\n';
            }

            FILE_WRITER_UTILITY.appendStringToFile(toAddToFile, outputFileName);
        }
    }

    private List<SimpleTuple<String, String>> extractHtmlTagsWithContent(File file, String charsetName) {
        List<SimpleTuple<String, String>> htmlTagsWithContent = new LinkedList<>();
        try {
            Document htmlDocument = Jsoup.parse(file,  charsetName);
            Elements elements = htmlDocument.body().select("*");

            for (Element element : elements) {
                SimpleTuple<String, String> tagContentTuple =
                        new SimpleTuple<>(element.tagName(), element.ownText());

                htmlTagsWithContent.add(tagContentTuple);
            }
        } catch (IOException ioe) {
            LOGGER.error("Could not process the file\n");
            LOGGER.error(ioe.getMessage());
        }
        return htmlTagsWithContent;
    }

    // delegate some functionality into this new utility
    private List<Integer> extractIntegersFromFile(String fileName) {
        return HTML4_PARSER.extractIntegersFromFile(fileName);
    }

    // delegate some functionality into this new utility
    private List<Double> extractRealNumbersFromFile(String fileName) {
        return HTML4_PARSER.extractRealNumbersFromFile(fileName);
    }

    // delegate some functionality into this new utility
    private List<String> extractPropertiesFromFile(String fileName) {
        return HTML4_PARSER.extractPropertiesFromFile(fileName);
    }

    private List<String> extractHtmlContent(File file, String charsetName) {
        List<String> htmlContent = new LinkedList<>();
        try {
            Document htmlDocument = Jsoup.parse(file,  charsetName);
            Elements elements = htmlDocument.body().select("*");

            for (Element element : elements) {
                htmlContent.add(element.ownText());
            }
        } catch (IOException ioe) {
            LOGGER.error("Could not process the file\n");
            LOGGER.error(ioe.getMessage());
        }
        return htmlContent;
    }

    private List<String> extractHtmlTagNames(File file, String charsetName) {
        List<String> htmlTagNames = new LinkedList<>();
        try {
            Document htmlDocument = Jsoup.parse(file,  charsetName);
            Elements elements = htmlDocument.body().select("*");

            for (Element element : elements) {
                htmlTagNames.add(element.tagName());
            }
        } catch (IOException ioe) {
            LOGGER.error("Could not process the file\n");
            LOGGER.error(ioe.getMessage());
        }
        return htmlTagNames;
    }
}