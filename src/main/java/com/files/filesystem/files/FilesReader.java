package com.files.filesystem.files;

import java.util.List;

import com.files.exceptions.FileException;

public interface FilesReader {
	public List<String> readFile(String fileName) throws FileException;
}
