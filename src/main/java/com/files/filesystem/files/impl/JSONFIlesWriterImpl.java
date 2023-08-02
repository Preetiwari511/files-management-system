package com.files.filesystem.files.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.files.filesystem.directories.FileHandler;
import com.files.filesystem.directories.impl.FileHandlerImpl;
import com.files.filesystem.exceptions.FileException;
import com.files.filesystem.files.FilesWriter;

public class JSONFIlesWriterImpl implements FilesWriter {
	FileHandler filesHandler = new FileHandlerImpl();

	@Override
	public boolean writeInAFile(List<?> content, String path, boolean overwrite) throws FileException {
		if (!filesHandler.isExists(path) || overwrite) {
			JSONArray dataArray = putDataToJSONarray(content);
			FileWriter fileWriter = null;
			PrintWriter printWriter = null;
			filesHandler.delete(path);
			filesHandler.createIfNotExist(path);
			try {
				fileWriter = new FileWriter(path);
				printWriter = new PrintWriter(fileWriter);
				printWriter.write(dataArray.toJSONString());
				printWriter.flush();
			} catch (IOException e) {
				throw new FileException("Failed to write in the file -" + path, e);
			} finally {
				printWriter.close();
			}
			return true;
		} else if (!overwrite) {
			JSONArray dataArray = putDataToJSONarray(content);
			FileWriter fileWriter = null;
			PrintWriter printWriter = null;
			try {
				fileWriter = new FileWriter(path, true);
				printWriter = new PrintWriter(fileWriter);
				printWriter.write(dataArray.toJSONString());
				printWriter.flush();
			} catch (IOException e) {
				throw new FileException("Failed to write in the file -" + path, e);
			} finally {
				printWriter.close();
			}
			return true;
		} else
			throw new FileException("Cannot overwite the file- " + path, new RuntimeException());
	}

	@Override
	public boolean writeInAFileFromOtherFile(String path1, String path2) throws FileException {

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
