package com.files.filesystem.directories.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import com.files.filesystem.directories.FileHandler;
import com.files.filesystem.exceptions.FileException;

public class FileHandlerImpl implements FileHandler {

	@Override
	public boolean isFileExists(String fileName) {
		File file = new File(fileName);
		return file.isFile();
	}

	@Override
	public boolean createIfNotExist(String fileName) {
		if(!isFileExists(fileName)) {
			try {
				File file = new File(fileName);
				return file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		return false;
	}

	@Override
	public boolean delete(String fileName) {
		if(isFileExists(fileName)) {
		File file = new File(fileName);	
		 boolean result = file.delete();
		 return result;
		}
		return false;
	}

	@Override
	public List<String> listFiles(String dirName) throws FileException {
		File file = new File (dirName);	
		if(file.isDirectory()) {
			String[] nameList = file.list();
			List<String> fileList = new ArrayList<>(0);
			
			for(String name : nameList) {
				if(isFileExists(dirName+File.separator+name)) {
					fileList.add(name);
				}
			}
			return fileList;
		}
		else throw new FileException("Directory doesn't exists ", new RuntimeException());
	}
	
	@Override
	public boolean copyFile(String sourcePath, String destinationPath) throws FileException {
		System.out.println(sourcePath);
		System.out.println(destinationPath);
		
		Path sourceFile = Paths.get(sourcePath);
		Path desFile = Paths.get(destinationPath + sourceFile.getFileName().toString() + "-copy");
	    try {
	        Files.copy(sourceFile, desFile);
	        return true ; 
	    } catch (IOException e) {
	    	throw new FileException("error occurred to copy a file ", e  );
	    }
	}

}
