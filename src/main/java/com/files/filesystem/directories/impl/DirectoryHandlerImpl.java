package com.files.filesystem.directories.impl;

import java.io.File;

public class DirectoryHandlerImpl implements DirectoryHandler {

	@Override
	public boolean isExists(String dirName) {
		File file = new File(dirName);
		return file.isDirectory();
	}

	@Override
	public boolean createIfNotExist(String dirName) {
		if(!isExists(dirName)) {
			File file = new File(dirName);
			return file.mkdir();
		}
		return false;
	}

	@Override
	public boolean delete(String dirName) {
		File file = new File(dirName);
		return file.delete();
	}

	@Override
	public String[] getFileNamesInDirectory(String dirName) {
		File file = new File (dirName);
		return file.list();
	}

}
