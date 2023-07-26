package com.files.filesystem.directories.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.files.filesystem.directories.FileHandler;
import com.files.filesystem.exceptions.FileException;

public class FileHandlerImpl implements FileHandler {

	@Override
	public boolean isExists(String fileName) {
		File file = new File(fileName);
		return file.isFile();
	}

	@Override
	public boolean createIfNotExist(String fileName) {
		File file = new File(fileName);
		if(!file.isFile()) {
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
	public List<String> listFiles(String dirName) throws FileException {
		File file = new File (dirName);	
		if(file.isFile()) {
			String[] nameList = file.list();
			List<String> fileList = new ArrayList<>(0);
			
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
