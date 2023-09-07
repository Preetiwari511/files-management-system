package com.files.filesystem.directories.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.files.filesystem.directories.DirectoryHandler;
import com.files.filesystem.exceptions.FileException;

public class DirectoryHandlerImpl implements DirectoryHandler {

	@Override
	public boolean isDirectoryExists(String dirName) {
		File file = new File(dirName);
		return file.isDirectory();
	}

	@Override
	public boolean createIfNotExist(String dirName) {
		if (!isDirectoryExists(dirName)) {
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
		if (isDirectoryExists(dirName)) {
			File file = new File(dirName);
			List<String> list = new ArrayList<>();
			String[] allFiles = file.list();
			for (String name : allFiles) {
				if (isDirectoryExists(dirName + File.separator + name)) {
					list.add(name);
				}
			}
			return list;
		} else
			throw new FileException("Directory Not Found!", new RuntimeException());
	}

	@Override
	public List<String> listFilesAndSubDirectories(String dirName) throws FileException {
		if (isDirectoryExists(dirName)) {
			File file = new File(dirName);
			String[] stringStore = file.list();
			List<String> list = Arrays.asList(stringStore);
			return list;
		} else
			throw new FileException("Directory doesn't exists", new RuntimeException());
	}

	@Override
	public boolean zipDirectory(String sourcePath) {
		
		try {
			File file = new File(sourcePath + ".zip");
			FileOutputStream fos = new FileOutputStream(file);
			ZipOutputStream zipOut = new ZipOutputStream(fos);
			File fileToZip = new File(sourcePath);
			zipFile(fileToZip,fileToZip.getName(), zipOut);
	        zipOut.close();
	        fos.close();
	        System.out.println(file.getAbsolutePath());
	        return true;
				
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	return false;
	}
	
	
	 private static void zipFile(File fileToZip, String fileName, ZipOutputStream zipOut) throws IOException {
	        if (fileToZip.isHidden()) {
	            return;
	        }
	        if (fileToZip.isDirectory()) {
	            if (fileName.endsWith("/")) {
	                zipOut.putNextEntry(new ZipEntry(fileName));
	                zipOut.closeEntry();
	            } else {
	                zipOut.putNextEntry(new ZipEntry(fileName + "/"));
	                zipOut.closeEntry();
	            }
	            File[] children = fileToZip.listFiles();
	            for (File childFile : children) {
	                zipFile(childFile, fileName + "/" + childFile.getName(), zipOut);
	            }
	            return;
	        }
	        FileInputStream fis = new FileInputStream(fileToZip);
	        ZipEntry zipEntry = new ZipEntry(fileName);
	        zipOut.putNextEntry(zipEntry);
	        byte[] bytes = new byte[1024];
	        int length;
	        while ((length = fis.read(bytes)) >= 0) {
	            zipOut.write(bytes, 0, length);
	        }
	        fis.close();
	   }
	



}
