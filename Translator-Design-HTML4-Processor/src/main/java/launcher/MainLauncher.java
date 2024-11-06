package launcher;

import parser.Html4ParserJs;
import parser.ParserUtility;

public class MainLauncher {
    private static final String INPUT_FILE_PATH1 = "html_input.html";
    //private static final String INPUT_FILE_PATH2 = "html_frames_input.html";

    private static final String NORMALIZED_FILE_PATH = "normalized_input.html";

    private static final String OUTPUT_FILE_PATH_LEX = "output_lex.txt";
    //private static final String OUTPUT_FILE_PATH_PARSER = "output_parser.txt";

    public static void main(String[] args) {

        ParserUtility parserUtility = new ParserUtility();
        Html4ParserJs html4ParserJS = new Html4ParserJs();

        parserUtility.getNormalizedFile(INPUT_FILE_PATH1, NORMALIZED_FILE_PATH);

        html4ParserJS.extractHtmlDataAndLiteralsToFile(NORMALIZED_FILE_PATH, OUTPUT_FILE_PATH_LEX);
    }
}
