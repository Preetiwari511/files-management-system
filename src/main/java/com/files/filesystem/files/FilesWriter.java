package com.files.filesystem.files;

import java.util.List;

import com.files.filesystem.exceptions.FileException;

public interface FilesWriter {
	
	public boolean writeFile(List<?> data, String filePath, boolean append) throws FileException;

	public boolean copyFile(String sourceFile, String destFile) throws FileException;
}
