package com.files.filesystem.directories.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

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
		if (!isFileExists(fileName)) {
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
		if (isFileExists(fileName)) {
			File file = new File(fileName);
			boolean result = file.delete();
			return result;
		}
		return false;
	}

	@Override
	public List<String> listFiles(String dirName) throws FileException {
		File file = new File(dirName);
		if (file.isDirectory()) {
			String[] nameList = file.list();
			List<String> fileList = new ArrayList<>(0);

			for (String name : nameList) {
				if (isFileExists(dirName + File.separator + name)) {
					fileList.add(name);
				}
			}
			return fileList;
		} else
			throw new FileException("Directory doesn't exists ", new RuntimeException());
	}

	@Override
	public boolean copyFile(String sourcePath, String destinationPath) throws FileException {
		System.out.println(sourcePath);
		System.out.println(destinationPath);

		Path sourceFile = Paths.get(sourcePath);
		Path desFile = Paths.get(destinationPath + sourceFile.getFileName().toString() + "-copy");
		try {
			Files.copy(sourceFile, desFile);
			return true;
		} catch (IOException e) {
			throw new FileException("error occurred to copy a file ", e);
		}
	}

	@Override
	public boolean zipFile(String sourcePath) throws FileException {
		FileOutputStream fos = null;
		ZipOutputStream zipOut = null;
		FileInputStream fis = null;
		String zipPath = sourcePath.substring(0, sourcePath.lastIndexOf(".")) + ".zip";
		if(isFileExists(sourcePath)) {
		try {
			File file = new File(zipPath);
			fos = new FileOutputStream(file);
			zipOut = new ZipOutputStream(fos);
			File fileToZip = new File(sourcePath);
			fis = new FileInputStream(fileToZip);
			ZipEntry zipEntry = new ZipEntry(fileToZip.getName());
			zipOut.putNextEntry(zipEntry);

			byte[] bytes = new byte[1024];
			int length;
			while ((length = fis.read(bytes)) >= 0) {
				zipOut.write(bytes, 0, length);
			}
			
			//System.out.println(file.getAbsolutePath());
			return true;

		}
		 catch (FileNotFoundException e) {
			throw new FileException(sourcePath, e);
		} catch (IOException e) {
			throw new FileException(sourcePath, e);
		} finally {
			try {
				zipOut.close();
				fis.close();
				fos.close();
			} catch (IOException e) {
				throw new FileException(sourcePath, e);
			}

		}
	}
		else throw new FileException("Cannot zip the given file", new FileNotFoundException());
	}
}
