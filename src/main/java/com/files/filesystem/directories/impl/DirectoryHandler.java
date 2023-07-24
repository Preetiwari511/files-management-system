package com.files.filesystem.directories.impl;

import java.util.List;

import com.files.exceptions.FileException;

public interface DirectoryHandler {
	public boolean isExists(String dirName);
	public boolean createIfNotExist(String dirName);
	public boolean delete(String dirName);
	public List getListOfSubDirectories(String dirName) throws FileException; 
	public String[] getListOfDirAndFilesUnderDirectory(String dirName) throws FileException;
	
}
