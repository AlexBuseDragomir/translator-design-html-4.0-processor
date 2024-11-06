package file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class FileReaderUtility {

	private static final FileUtility FILE_UTILITY = new FileUtility();
	private static final Logger LOGGER =
			LoggerFactory.getLogger(FileReaderUtility.class);

	// reads a file into a linked list
	// each row is a string in the list
	public List<String> readFileAsList(String fileName) {
		Path filePath = FILE_UTILITY.getPathToFileFromResources(fileName);

		List<String> textList = new LinkedList<>();
		try {
			return Files
					.readAllLines(filePath);

		} catch (IOException ioe) {
			LOGGER.error("Could not read file\n");
			LOGGER.error(ioe.getMessage());
		}

		return null;
	}

	// reads a file into a stream optional
	// each row is a stream element
	// useful for stream filtering on data
	public Optional<Stream<String>> readFileAsStream(String fileName) {
		Path filePath = FILE_UTILITY.getPathToFileFromResources(fileName);

		try {
			return Optional.of(Files.lines(filePath));

		} catch (IOException ioe) {
			LOGGER.error("Could not read file\n");
			LOGGER.error(ioe.getMessage());
		}

		return Optional.empty();
	}

	// rows are counted from 1 to list.size()
	// in order to be consistent with the natural
	// human counting in such situations
	public String readLineFromFile (String fileName, int rowNumber) {
		List<String> fileText = readFileAsList(fileName);

		if (rowNumber > fileText.size() || rowNumber <= 0) {
			LOGGER.warn("The file does not contain row " + rowNumber + '\n');
			LOGGER.warn("The file contains " + fileText.size() + " rows");
		}

		return fileText.get(rowNumber - 1);
	}
}
