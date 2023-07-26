package com.files.filesystem.files.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.files.filesystem.directories.FileHandler;
import com.files.filesystem.directories.impl.FileHandlerImpl;
import com.files.filesystem.exceptions.FileException;
import com.files.filesystem.files.FilesReader;

public class CSVFilesReaderImpl implements FilesReader {
	FileHandler fileHandler = new FileHandlerImpl();

	@Override
	public List<?> readFile(String fileName) throws FileException {
		BufferedReader bufferedReader = null;
		FileReader reader = null;
		if (fileHandler.isExists(fileName)) {
			String line = "";
			String splitBy = ",";
			List<LinkedHashMap<String, String>> list = new ArrayList<LinkedHashMap<String, String>>();
			try {
				reader = new FileReader(fileName);
				bufferedReader = new BufferedReader(reader);
				
				if ((line = bufferedReader.readLine()) != null) {
					String[] headers = line.split(splitBy);
					while ((line = bufferedReader.readLine()) != null) {
						String[] data = line.split(splitBy);
						LinkedHashMap<String, String> map = new LinkedHashMap<>();
						for (int i = 0; i<headers.length; i++) {
							map.put(headers[i], data[i]);
						}
						list.add(map);
					}
				}
			} catch (IOException e) {
				throw new FileException("Failed to read file - " + fileName , e  );
			}finally {
				try {
					bufferedReader.close();
					reader.close();
				} catch (IOException e) {
					throw new FileException("Failed to read file - " + fileName , e  );
				}
			}
			return list;
		}
		else {
			throw new FileException("File Not Found!", new RuntimeException()); 
		}
		
	}

}
