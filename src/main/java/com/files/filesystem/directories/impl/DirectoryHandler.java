package com.files.filesystem.directories.impl;

public interface DirectoryHandler {
	public boolean isExists(String dirName);
	public boolean createIfNotExist(String dirName);
	public boolean delete(String dirName);
	public String[] getFileNamesInDirectory(String dirName);
	
}
