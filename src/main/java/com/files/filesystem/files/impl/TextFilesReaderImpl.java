package com.files.filesystem.files.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.files.filesystem.directories.FileHandler;
import com.files.filesystem.directories.impl.FileHandlerImpl;
import com.files.filesystem.exceptions.FileException;
import com.files.filesystem.files.FilesReader;

public class TextFilesReaderImpl implements FilesReader {
	FileHandler fileHandler = new FileHandlerImpl();
	@Override
	public List<String> readFile(String fileName) throws  FileException {
		BufferedReader bufferedReader = null;
		FileReader reader = null;
		if (fileHandler.isExists(fileName)) {
			List<String> list = new ArrayList<String>(); 
			try  {
			    reader = new FileReader(fileName);
				bufferedReader = new BufferedReader(reader);
				String line = bufferedReader.readLine();
				while (line != null) {
					list.add(line);
					line = bufferedReader.readLine();
				}

			} catch (IOException e) {
				throw new FileException("Failed to read file - " + fileName , e  );
			} finally {
				try {
					bufferedReader.close();
					reader.close();
				} catch (IOException e) {
					throw new FileException("Failed to read file - " + fileName , e  );
				}
			}
			return list;
		}
		else throw new FileException("File Not Found!", new RuntimeException());  
	}

}
