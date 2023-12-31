package com.files.filesystem.directories;

import java.util.List;

import com.files.filesystem.exceptions.FileException;

public interface FileHandler {
	public boolean isExists(String fileName);
	public boolean createIfNotExist(String fileName);
	public boolean delete(String fileName);
	public List<String> listFiles(String dirName) throws FileException;
}
