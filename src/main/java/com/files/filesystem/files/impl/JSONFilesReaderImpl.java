package com.files.filesystem.files.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.files.filesystem.directories.FileHandler;
import com.files.filesystem.directories.impl.FileHandlerImpl;
import com.files.filesystem.exceptions.FileException;
import com.files.filesystem.files.FilesReader;

public class JSONFilesReaderImpl implements FilesReader {
	FileHandler fileHandler = new FileHandlerImpl();

	@Override
	public List<?> readFile(String fileName) throws FileException {
		if (fileHandler.isExists(fileName)) {
			ObjectMapper objectMapper = new ObjectMapper();
			try {
				File file = new File(fileName);
				List<Map<String, String>> dataList = objectMapper.readValue(file,
						new TypeReference<List<Map<String, String>>>() {
						});
				return dataList;
			} catch (IOException e) {
				throw new FileException("Cannot read file", e);
			}
		} else
			throw new FileException("File Not Found!", new RuntimeException());
	}

}
