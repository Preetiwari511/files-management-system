package com.files.filesystem.directories;

import java.util.List;

import com.files.filesystem.exceptions.FileException;

public interface DirectoryHandler {
	
	public boolean isDirectoryExists(String dirName);

	public boolean createIfNotExist(String dirName);

	public boolean delete(String dirName);

	public List<String> listSubDirectories(String dirName) throws FileException;

	public List<String> listFilesAndSubDirectories(String dirName) throws FileException;

}
