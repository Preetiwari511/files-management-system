package com.files.filesystem;

import java.util.List;

import com.files.exceptions.FileException;

public interface FileReaders {
	public List<String> readFile(String fileName) throws FileException;
}
