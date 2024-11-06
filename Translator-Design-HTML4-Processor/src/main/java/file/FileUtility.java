package file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtility {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(FileUtility.class);

    public Path getPathToFileFromResources(String fileName) {
        URL fileUrl = this.getClass().getClassLoader().getResource(fileName);
        Path pathToFile = null;

        try {
            pathToFile = Paths.get(fileUrl.toURI());
        } catch (URISyntaxException e) {
            LOGGER.error("Could not obtain file URI\n");
            LOGGER.error(e.getMessage());
        }

        return pathToFile;
    }

    public void eraseContentFromFile(String fileName) {
        try {
            Path pathToFile = getPathToFileFromResources(fileName);
            BufferedWriter writer = Files.newBufferedWriter(pathToFile);
            writer.write("");
            writer.flush();
        } catch (IOException ioe) {
            LOGGER.error("Could not process the file: " + fileName + '\n');
            LOGGER.error(ioe.getMessage());
        }
    }
}
