package com.files.filesystem.files;

import java.util.List;

import com.files.exceptions.FileException;

public interface FileHandler {
	public boolean isExists(String fileName);
	public boolean createIfNotExist(String fileName);
	public boolean delete(String fileName);
	public List<String> getFileNamesInDirectory(String dirName) throws FileException;
}
