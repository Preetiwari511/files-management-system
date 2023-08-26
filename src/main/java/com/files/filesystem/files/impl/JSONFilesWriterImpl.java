package com.files.filesystem.files.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.files.filesystem.directories.FileHandler;
import com.files.filesystem.directories.impl.FileHandlerImpl;
import com.files.filesystem.exceptions.FileException;
import com.files.filesystem.files.FilesWriter;

public class JSONFilesWriterImpl implements FilesWriter {
	FileHandler filesHandler = new FileHandlerImpl();

	@Override
	public boolean writeFile(List<?> data, String path, boolean append) throws FileException {
		if (!filesHandler.isFileExists(path)) {
			filesHandler.delete(path);
			filesHandler.createIfNotExist(path);
			JSONArray dataArray = putDataToJSONarray(data);
			
			FileWriter fileWriter = null;
			PrintWriter printWriter = null;
			try {
				fileWriter = new FileWriter(path);
				printWriter = new PrintWriter(fileWriter);
				printWriter.write(dataArray.toJSONString());
				printWriter.flush();
				//String dataAsJSONString = new ObjectMapper().writeValueAsString(data);
				// printWriter.write(dataAsJSONString);
				
				
			} catch (IOException e) {
				throw new FileException("Failed to write in the file -" + path, e);
			} finally {
				printWriter.close();
			}
			return true;
		
		}
		return false;
}



	private JSONArray putDataToJSONarray(List<?> content) {
		JSONArray dataList = new JSONArray();
		for (int j = 0; j < content.size(); j++) {
			Map<?, ?> values = (Map<?, ?>) content.get(j);
			JSONObject jsonObject = new JSONObject();
			for (Entry<?, ?> entry : values.entrySet()) {
				Object key = entry.getKey();
				Object value = entry.getValue();
				jsonObject.put(key, value);
			}
			dataList.add(jsonObject);
		}
		return dataList;
		
		
	}
   
}
