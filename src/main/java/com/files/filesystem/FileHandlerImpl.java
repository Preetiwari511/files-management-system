package com.files.filesystem;

import java.io.File;
import java.io.IOException;

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

}
