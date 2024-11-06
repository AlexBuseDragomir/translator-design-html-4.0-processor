package utility;

import file.FileWriterUtility;
import html.HtmlAttribute;
import tree.Node;

public class NodePrinter {

    private static final String OUTPUT_FILE = "output.txt";
    private static final FileWriterUtility FILE_WRITER_UTILITY =
            new FileWriterUtility();

    public static void printAsHtml(Node node, int numberOfSpaces, int increment) {
        String spaces = new String(new char[numberOfSpaces])
                .replace('\0', ' ');

        String newLine = spaces + node.getName() + "\n\n";
        FILE_WRITER_UTILITY.appendStringToFile(newLine, OUTPUT_FILE);

        node.getChildren().forEach(child -> {
            printAsHtml(child, numberOfSpaces + increment, increment);
        });
    }

    public static void print(Node node, int numberOfSpaces, int increment) {
        node.updateAttributes();

        String spaces = new String(new char[numberOfSpaces])
                .replace('\0', '-');

        StringBuilder tagData = new StringBuilder();

        // if it is not a closing tag
        if ( ! node.getName().contains("</")) {
            // if it is a tag with attributes
            if (node.getName().contains("<") && node.getName().contains(">")) {
                // append the tag name
                String tagLine = spaces + "TAG: " + node.getSimpleName().toUpperCase() + "\n";
                tagData.append(tagLine);

                // append all the attributes with values
                for (HtmlAttribute htmlAttribute: node.getAttributes()) {
                    // if attribute is valid
                    if (htmlAttribute.isSyntacticallyValid()) {
                        String attributeLine = spaces + "attribute: " + htmlAttribute.getName() +
                                " -> value: " + htmlAttribute.getValue() + '\n';
                        tagData.append(attributeLine);
                    }
                    // if attribute is not valid
                    else {
                        String errorLine = spaces + "!error for attribute: " +
                                htmlAttribute.getName() + "; invalid value: " +
                                htmlAttribute.getValue() + '\n';
                        tagData.append(errorLine);
                    }
                }
            }
            // if it is text
            else {
                String tagLine = spaces + "text contents: " + node.getName() + "\n";
                tagData.append(tagLine);
            }
        }

        // append the information to the file
        FILE_WRITER_UTILITY.appendStringToFile(tagData.toString(), OUTPUT_FILE);

        node.getChildren().forEach(child -> {
            print(child, numberOfSpaces + increment, increment);
        });
    }
}