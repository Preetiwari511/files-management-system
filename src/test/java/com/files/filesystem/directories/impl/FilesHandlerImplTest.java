package com.files.filesystem.directories.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.io.File;
import java.util.List;

import org.junit.Test;

import com.files.filesystem.directories.FileHandler;
import com.files.filesystem.directories.impl.FileHandlerImpl;
import com.files.filesystem.exceptions.FileException;

public class FilesHandlerImplTest {
	private final static String ROOT = "src/test/resources";
	private final static String FILE_PATH = "data/sample_text_file1.txt";
	private final static String SAMPLE_DATA = ROOT + File.separator + FILE_PATH;
	
	
	@Test
	public void testIsFileExists() {
		FileHandler fileHandler = new FileHandlerImpl();
		boolean result = fileHandler.isFileExists(SAMPLE_DATA);
		assertTrue(result);
	}

	@Test
	public void testDelete() {
		FileHandler fileHandler = new FileHandlerImpl();
		boolean result = fileHandler.delete(SAMPLE_DATA);
		assertTrue(result);
	}

	@Test
	public void testCreateIfNotExist() {
		FileHandler fileHandler = new FileHandlerImpl();
		boolean result = fileHandler.createIfNotExist(SAMPLE_DATA);
		assertTrue(result);
	}
	@Test
	public void testListFiles() throws FileException {
		FileHandler fileHandler = new FileHandlerImpl();
		List<String> filesName = fileHandler.listFiles(ROOT + File.separator + "data" );
		for(String str : filesName) {
			System.out.println(str);
		}

	}
}
