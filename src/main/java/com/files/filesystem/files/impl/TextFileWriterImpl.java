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
	@Override
	public boolean writeFile(List<?> content, String path, boolean append) throws FileException {
		if (!fileHandler.isFileExists(path) || !append) {
			FileWriter writer = null;
			PrintWriter printWriter = null;
			fileHandler.delete(path);
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

		} else if (append) {
			FileWriter writer = null;
			PrintWriter printWriter = null;
			try {
				writer = new FileWriter(path, true);
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
	public boolean copyFile(String path1, String path2) throws FileException {
		
		return false;

	}
}
