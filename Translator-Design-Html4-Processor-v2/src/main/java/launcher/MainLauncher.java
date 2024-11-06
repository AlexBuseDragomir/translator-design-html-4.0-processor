package launcher;

import lexer.Html4Lexer;
import tree.Node;
import parser.Html4Parser;
import tree.DomTree;
import utility.FileUtility;
import utility.ParserUtility;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

public class MainLauncher {

    private static final FileUtility FILE_UTILITY = new FileUtility();
    private static final ParserUtility PARSER_UTILITY = new ParserUtility();

    private static final String INPUT_FILE = "simple_input.html";
    private static final String NORMALIZED_FILE = "normalized.html";
    private static final String OUTPUT_FILE = "output.txt";

    private static final int INDENTATION_VALUE = 4;

    public static void main(String[] args) throws java.io.IOException {

        FILE_UTILITY.eraseContentFromFile(NORMALIZED_FILE);
        File normalizedInput = PARSER_UTILITY.getNormalizedFile(INPUT_FILE, NORMALIZED_FILE);

        Reader reader = new FileReader(normalizedInput.getAbsolutePath());

        try {

            Html4Parser parser = new Html4Parser(new Html4Lexer(reader));
            parser.parse();

            Node documentNode = parser.getDocumentNode();

            DomTree domTree = new DomTree(documentNode);
            domTree.writeTreeToFile(OUTPUT_FILE, INDENTATION_VALUE);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}