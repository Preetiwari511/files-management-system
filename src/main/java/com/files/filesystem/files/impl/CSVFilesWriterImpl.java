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
	public boolean writeInAFile(List<?> content, String path, boolean overwrite) throws FileException {
		if (!fileHandler.isExists(path)|| overwrite) {
			FileWriter writer = null;
			PrintWriter printWriter = null;
			fileHandler.delete(path);
			fileHandler.createIfNotExist(path);
			try {
				writer = new FileWriter(path);
				printWriter = new PrintWriter(writer);
				if (!content.isEmpty()) {
					writeDataToPrintWriter(content, printWriter);
				}
				return true;
			} catch (IOException e) {
				throw new FileException("Failed to write in the file -" + path, e);
			} finally {
				printWriter.close();
			}
			
		} else if (!overwrite) {
			FileWriter writer = null;
			PrintWriter printWriter = null;
			try {
				writer = new FileWriter(path,true);
				printWriter = new PrintWriter(writer);
				if (!content.isEmpty()) {
					 writeDataToPrintWriter(content, printWriter);
				}
			} catch (IOException e) {
				throw new FileException("Failed to write in the file -" + path, e);
			} finally {
				printWriter.close();
			}
			return true;

		}
		else throw new FileException("Cannot overwite the file- " + path, new RuntimeException()) ;
	}

	@Override
	public boolean writeInAFileFromOtherFile(String path1, String path2) throws FileException {
		// TODO Auto-generated method stub
		return false;
	}
	
	private void writeDataToPrintWriter(List<?> content, PrintWriter printWriter) {
		Map<?,?> data = (Map<?, ?>) content.get(0);
		Set<?> keys = data.keySet();
		for (Object header : keys) {
			printWriter.print(header);
			printWriter.print(",");	
		}
		printWriter.println();
		for (int j = 0; j < content.size(); j++) {
			Map<?,?> values = (Map<?,?>) content.get(j);
			for (Object entity : values.values()) {
				printWriter.print(entity);
				printWriter.print(",");
			}
			printWriter.println();
		}

		printWriter.flush();
	}

}
