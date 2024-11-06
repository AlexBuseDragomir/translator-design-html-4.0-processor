package file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tuple.SimpleTuple;
import utility.FileUtility;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileWriterUtility {

    private static final FileUtility FILE_UTILITY = new FileUtility();
    private static final Logger LOGGER =
            LoggerFactory.getLogger(FileWriterUtility.class);

    public <T> void writeListOfDataToFile(List<T> content, String fileName) {
        // first erase the old content from the file
        FILE_UTILITY.eraseContentFromFile(fileName);

        for (T line: content) {
            appendStringToFile(line.toString() + "\n", fileName);
        }
    }

    public <T> File writeAndReturnDataAsFile(List<T> content, String fileName) {
        // first erase the old content from the file
        FILE_UTILITY.eraseContentFromFile(fileName);

        for (T line: content) {
            appendStringToFile(line.toString() + "\n", fileName);
        }

        return FILE_UTILITY.getPathToFileFromResources(fileName).toFile();
    }

    // write with default charset
    public SimpleTuple<Boolean, Path> writeStringToFile(String content, String fileName) {
        return writeStringToFile(content, fileName, Charset.defaultCharset().name());
    }

    // append with default charset
    public SimpleTuple<Boolean, Path> appendStringToFile(String content, String fileName) {
        return appendStringToFile(content, fileName, Charset.defaultCharset().name());
    }

    // fileName should also contain the path towards the file
    // returns a tuple that states if the file was written and the path
    // if operation failed, the path will be null
    // charset has to be provided
    private SimpleTuple<Boolean, Path> writeStringToFile(String content, String fileName, String charsetName) {
        // first erase the old content from the file
        FILE_UTILITY.eraseContentFromFile(fileName);
        Path filePath = FILE_UTILITY.getPathToFileFromResources(fileName);

        try {
            Path pathToWrittenFile =
                    Files.write(filePath, content.getBytes(Charset.forName(charsetName)));

            return new SimpleTuple<>(true, pathToWrittenFile);
        } catch (IOException ioe) {
            LOGGER.error("Could not write file\n");
            LOGGER.error(ioe.getMessage());
        }

        return new SimpleTuple<>(false, null);
    }

    // fileName should also contain the path towards the file
    // returns a tuple that states if the string has been appended
    // if operation failed, the path will be null
    // default charset, appends data at the end of file
    private SimpleTuple<Boolean, Path> appendStringToFile(String content, String fileName, String charsetName) {
        Path filePath = FILE_UTILITY.getPathToFileFromResources(fileName);

        try {
            Path pathToWrittenFile =
                    Files.write(filePath, content.getBytes(Charset.forName(charsetName)),
                            StandardOpenOption.APPEND);

            return new SimpleTuple<>(true, pathToWrittenFile);
        } catch (IOException ioe) {
            LOGGER.error("Could not append string to file\n");
            LOGGER.error(ioe.getMessage());
        }

        return new SimpleTuple<>(false, null);
    }
}