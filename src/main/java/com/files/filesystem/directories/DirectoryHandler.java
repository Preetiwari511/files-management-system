package com.files.filesystem.directories;

import java.util.List;

import com.files.filesystem.exceptions.FileException;

public interface DirectoryHandler {
	public boolean isExists(String dirName);
	public boolean createIfNotExist(String dirName);
	public boolean delete(String dirName);
	public List<String> listSubDirectories(String dirName) throws FileException; 
	// TODO:	change return type to List<String>
	public String[] listFilesAndSubDirectories(String dirName) throws FileException;
	
}
