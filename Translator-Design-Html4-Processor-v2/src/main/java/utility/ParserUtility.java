package utility;

import file.FileReaderUtility;
import file.FileWriterUtility;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class ParserUtility {

    private static final FileWriterUtility FILE_WRITER_UTILITY =
            new FileWriterUtility();

    // lower cases the tags and removes
    // any redundant whitespaces
    // puts result into a new file
    public File getNormalizedFile(String inputFileName, String normalizedFileName) {
        List<String> normalizedContent = normalizeFileContent(inputFileName);

        return FILE_WRITER_UTILITY
                .writeAndReturnDataAsFile(normalizedContent, normalizedFileName);
    }

    // lower cases the tags and removes
    // any redundant whitespaces
    private List<String> normalizeFileContent(String fileName) {
        List<String> lowercaseContent = getLowercaseFileContent(fileName);
        List<String> normalizedContent = new LinkedList<>();

        for (String line: lowercaseContent) {
            normalizedContent.add(removeRedundantSpacesFromString(line));
        }

        return normalizedContent;
    }

    // lower cases tags as HTML is case insensitive
    private List<String> getLowercaseFileContent(String fileName) {
        FileReaderUtility fileReaderUtility = new FileReaderUtility();
        List<String> lowercaseText = new LinkedList<>();
        List<String> fileText =
                fileReaderUtility.readFileAsList(fileName);

        // for all lines of text
        for (String line: fileText) {
            String lowercaseLine = line.toLowerCase();
            lowercaseText.add(lowercaseLine);
        }

        return lowercaseText;
    }

    private String lowercaseAndTrimString(String line, int inclusiveStart, int exclusiveEnd) {
        return line.replace(line.substring(inclusiveStart, exclusiveEnd),
                line.substring(inclusiveStart, exclusiveEnd)
                        .trim()
                        .toLowerCase());
    }

    private String removeRedundantSpacesFromString(String line) {
        return line
                .replaceAll("\\s{2,}", " ")
                .trim();
    }
}
