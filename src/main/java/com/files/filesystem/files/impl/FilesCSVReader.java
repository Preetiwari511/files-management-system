package com.files.filesystem.files.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.files.exceptions.FileException;
import com.files.filesystem.files.FileHandler;
import com.files.filesystem.files.FilesReader;

public class FilesCSVReader implements FilesReader {
	FileHandler fileHandler = new FileHandlerImpl();

	@Override
	public List readFile(String fileName) throws FileException {
		BufferedReader bufferedReader = null;
		FileReader reader = null;
		if (fileHandler.isExists(fileName)) {
			String line = "";
			String splitBy = ",";
			List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
			try {
				reader = new FileReader(fileName);
				bufferedReader = new BufferedReader(reader);
				HashMap<String, String> map = new HashMap<>();
				if ((line = bufferedReader.readLine()) != null) {
					String[] headers = line.split(splitBy);
					while ((line = bufferedReader.readLine()) != null) {
						String[] data = line.split(splitBy);
						for (int i = 0; i < headers.length; i++) {
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
