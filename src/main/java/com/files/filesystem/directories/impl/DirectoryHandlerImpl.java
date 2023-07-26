package com.files.filesystem.directories.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.files.filesystem.directories.DirectoryHandler;
import com.files.filesystem.exceptions.FileException;

public class DirectoryHandlerImpl implements DirectoryHandler {

	@Override
	public boolean isExists(String dirName) {
		File file = new File(dirName);
		return file.isDirectory();
	}

	@Override
	public boolean createIfNotExist(String dirName) {
		if(!isExists(dirName)) {
			File file = new File(dirName);
			return file.mkdir();
		}
		return false;
	}

	@Override
	public boolean delete(String dirName) {
		File file = new File(dirName);
		return file.delete();
	}

	@Override
	public List<String> listSubDirectories(String dirName) throws FileException {
		if(isExists(dirName)) {
			File file = new File(dirName);
			List<String> list = new ArrayList<>();
			String[] allFiles = file.list();
			for(String name : allFiles) {
				if(isExists(name)) {
					list.add(name);
				}
			}
			return list;
		}
		else throw new FileException("Directory Not Found!", new RuntimeException());
	}

	@Override
	public String[] listFilesAndSubDirectories(String dirName) throws FileException {
		if(isExists(dirName)) {
			File file = new File (dirName);
			return file.list();
		}
		else throw new FileException("Directory doesn't exists",new RuntimeException());
		}
}
