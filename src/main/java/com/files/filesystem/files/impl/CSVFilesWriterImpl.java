package com.files.filesystem.files.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.files.filesystem.directories.FileHandler;
import com.files.filesystem.directories.impl.FileHandlerImpl;
import com.files.filesystem.exceptions.FileException;
import com.files.filesystem.files.FilesWriter;

public class CSVFilesWriterImpl implements FilesWriter {
	FileHandler fileHandler = new FileHandlerImpl();

	// Re-factored the code.
	@Override
	public boolean writeFile(List<?> content, String path, boolean append) throws FileException {

		FileWriter writer = null;
		PrintWriter printWriter = null;

		if (!fileHandler.isFileExists(path) || !append) {
			fileHandler.delete(path);
			fileHandler.createIfNotExist(path);
		}
		try {
			writer = new FileWriter(path, append);
			printWriter = new PrintWriter(writer);
			if (!content.isEmpty()) {
				writeData(content, printWriter);
			}
			return true;
		} catch (IOException e) {
			throw new FileException("Failed to write in the file -" + path, e);
		} finally {
			printWriter.close();
		}
	}



	private void writeData(List<?> content, PrintWriter printWriter) {
		Map<?, ?> data = (Map<?, ?>) content.get(0);
		Set<?> keys = data.keySet();
		for (Object header : keys) {
			printWriter.print(header);
			printWriter.print(",");
		}
		printWriter.println();
		for (int j = 0; j < content.size(); j++) {
			Map<?, ?> values = (Map<?, ?>) content.get(j);
			for (Object entity : values.values()) {
				printWriter.print(entity);
				printWriter.print(",");
			}
			printWriter.println();
		}

		printWriter.flush();
	}

}
