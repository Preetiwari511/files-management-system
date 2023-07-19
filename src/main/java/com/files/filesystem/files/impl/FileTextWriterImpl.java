package com.files.filesystem.files.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.files.exceptions.FileException;
import com.files.filesystem.files.FileHandler;
import com.files.filesystem.files.FilesWriter;

public class FileTextWriterImpl implements FilesWriter {
	FileHandler fileHandler = new FileHandlerImpl();

	@Override
	public boolean writeInAFile(String[] content, String path, boolean overwrite) throws FileException {
		if (fileHandler.isExists(path)) {
			FileWriter writer = null;
			PrintWriter printWriter = null;
			try {
				writer = new FileWriter(path);
				printWriter = new PrintWriter(writer);
				if (content != null) {
					for (String str : content) {
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
			throw new FileException("File not Found -" + path, new RuntimeException());
	}

	@Override
	public boolean writeInAFileFromOtherFile(String path1, String path2) throws FileException 
	{
		if (fileHandler.isExists(path1) && fileHandler.isExists(path2)) 
		{
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
				while (line != null) 
				{
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
			throw new FileException("File not found ", new RuntimeException());
	}

}

