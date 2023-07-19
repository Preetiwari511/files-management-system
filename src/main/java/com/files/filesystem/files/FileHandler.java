package com.files.filesystem.files;

public interface FileHandler {
	public boolean isExists(String fileName);
	public boolean createIfNotExist(String fileName);
	public boolean delete(String fileName);
}
