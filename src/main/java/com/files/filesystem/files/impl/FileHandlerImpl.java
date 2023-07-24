package com.files.filesystem.files.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.files.exceptions.FileException;
import com.files.filesystem.files.FileHandler;

public class FileHandlerImpl implements FileHandler {

	@Override
	public boolean isExists(String fileName) {
		File file = new File(fileName);
		return file.isFile();
	}

	@Override
	public boolean createIfNotExist(String fileName) {
		if(!isExists(fileName)) {
			File file = new File(fileName);
			try {
				return file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		return false;
	}

	@Override
	public boolean delete(String fileName) {
		File file = new File(fileName);	
		return file.delete();
	}

	@Override
	public List<String> getFileNamesInDirectory(String dirName) throws FileException {
		if(isExists(dirName)) {
			File file = new File (dirName);	
			String[] nameList = file.list();
			List<String> fileList = new ArrayList<>();
			
			for(String name : nameList) {
				if(isExists(name)) {
					fileList.add(name);
				}
			}
			return fileList;
		}
		else throw new FileException("Directory doesn't exists ", new RuntimeException());
	}

}
