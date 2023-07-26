package com.files.filesystem.files.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.files.filesystem.directories.FileHandler;
import com.files.filesystem.directories.impl.FileHandlerImpl;
import com.files.filesystem.exceptions.FileException;
import com.files.filesystem.files.FilesWriter;

public class TextFileWriterImpl implements FilesWriter {
	FileHandler fileHandler = new FileHandlerImpl();

	// TODO:	Duplicate/Redundant code  
	@Override
	public boolean writeInAFile(List<?> content, String path, boolean overwrite) throws FileException {
		if (!fileHandler.isExists(path)) {
			FileWriter writer = null;
			PrintWriter printWriter = null;
			fileHandler.createIfNotExist(path);
			try {
				writer = new FileWriter(path);
				printWriter = new PrintWriter(writer);
				if (!content.isEmpty()) {
					for (Object str : content) {
						printWriter.println(str);
					}
					printWriter.flush();
				}

			} catch (IOException e) {
				throw new FileException("Failed to write in the file -" + path, e);
			} finally {
				printWriter.close();
			}
			return true;
			
		} else if (overwrite) {
			FileWriter writer = null;
			PrintWriter printWriter = null;
			try {
				fileHandler.delete(path);
				fileHandler.createIfNotExist(path);
				writer = new FileWriter(path);
				printWriter = new PrintWriter(writer);
				if (!content.isEmpty()) {
					for (Object str : content) {
						printWriter.println(str);
					}
					printWriter.flush();
				}
			} catch (IOException e) {
				throw new FileException("Failed to write in the file -" + path, e);
			} finally {
				printWriter.close();
			}
			return true;
			

		} else
			throw new FileException("Cannot overwrite in the file -" + path, new RuntimeException());
	}

	@Override
	public boolean writeInAFileFromOtherFile(String path1, String path2) throws FileException {
		if (fileHandler.isExists(path1) && fileHandler.isExists(path2)) {
			FileWriter writer = null;
			PrintWriter printWriter = null;
			FileReader fileReader = null;
			BufferedReader bufferedReader = null;
			try {
				writer = new FileWriter(path1);
				printWriter = new PrintWriter(writer);
				fileReader = new FileReader(path2);
				bufferedReader = new BufferedReader(fileReader);
				String line = bufferedReader.readLine();
				while (line != null) {
					printWriter.println(line);
					line = bufferedReader.readLine();
				}
				printWriter.flush();

			} catch (IOException e) {
				throw new FileException("Failed to write in the file - " + path2, e);
			} finally {
				printWriter.close();
				try {
					bufferedReader.close();
					fileReader.close();
				} catch (IOException e) {
					throw new FileException("Failed to read file - " + path1, e);
				}
			}
			return true;
		} else
			throw new FileException("Cannot overwrite in the file ", new RuntimeException());
	}

}
