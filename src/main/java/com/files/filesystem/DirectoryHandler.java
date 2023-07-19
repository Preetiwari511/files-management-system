package com.files.filesystem;

public interface DirectoryHandler {
	public boolean isExists(String dirName);
	public boolean createIfNotExist(String dirName);
	public boolean delete(String dirName);
	public String[] getFileNamesInDirectory(String dirName);
	
}
