package com.files.filesystem.files.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.files.exceptions.FileException;
import com.files.filesystem.files.FileHandler;
import com.files.filesystem.files.FilesWriter;
import com.opencsv.CSVWriter;

public class FilesCSVWriterImpl implements FilesWriter {
	FileHandler fileHandler = new FileHandlerImpl();

	@Override
	public boolean writeInAFile(List<String[]> content, String path, boolean overwrite) throws FileException {
		if (!fileHandler.isExists(path)) {
			FileWriter writer = null;
			PrintWriter printWriter = null;
			CSVWriter csvWriter = null;
			try {
				writer = new FileWriter(path);
				printWriter = new PrintWriter(writer);
				csvWriter = new CSVWriter(printWriter);
				if (content.isEmpty()) {
					for (String[] str : content) {
						csvWriter.writeNext(str);
					}
					csvWriter.flush();
				}

			} catch (IOException e) {
				throw new FileException("Failed to write in the file -" + path, e);
			} finally {
				try {
					csvWriter.close();
				} catch (IOException e) {
					throw new FileException("error occurred", e);
				}
			}
			return true;
		} else if (overwrite) {
			FileWriter writer = null;
			PrintWriter printWriter = null;
			CSVWriter csvWriter = null;
			try {
				fileHandler.delete(path);
				fileHandler.createIfNotExist(path);
				writer = new FileWriter(path);
				printWriter = new PrintWriter(writer);
				csvWriter = new CSVWriter(printWriter);
				if (!content.isEmpty()) {
					for (String[] str : content) {
						csvWriter.writeNext(str);
					}
					csvWriter.flush();
				}
			} catch (IOException e) {
				throw new FileException("Failed to write in the file -" + path, e);
			} finally {
				try {
					csvWriter.close();
				} catch (IOException e) {
					throw new FileException("error occurred", e);
				}
			}
			return true;
		} else
			throw new FileException("File not Found -" + path, new RuntimeException());
	}

	@Override
	public boolean writeInAFileFromOtherFile(String path1, String path2) throws FileException {
		// TODO Auto-generated method stub
		return false;
	}

}
