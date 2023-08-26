package com.files.filesystem.directories.impl;

import static org.junit.Assert.assertTrue;
import java.io.File;
import java.util.List;
import org.junit.Test;
import com.files.filesystem.directories.DirectoryHandler;
import com.files.filesystem.exceptions.FileException;

public class DirectoryHandlerImplTest {
	private final static String ROOT = "src/test/resources";
	private final static String FILE_PATH = "data";
	private final static String FILE_PATH2 = "data2";
	private final static String SAMPLE_DATA = ROOT + File.separator + FILE_PATH ;
	private final static String SAMPLE_DATA2 = ROOT + File.separator + FILE_PATH2 ;
	
	@Test
	public void testIsDirectoryExists() {
		DirectoryHandler directoryHandler = new DirectoryHandlerImpl();
		boolean result = directoryHandler.isDirectoryExists(SAMPLE_DATA);
		assertTrue(result);
	}
	
	@Test
	public void testDelete() {
		DirectoryHandler directoryHandler = new DirectoryHandlerImpl();
		boolean result = directoryHandler.delete(SAMPLE_DATA2);
		assertTrue(result);
	}
	
	@Test
	public void testCreateIfNotExist() {
		DirectoryHandler directoryHandler = new DirectoryHandlerImpl();
		boolean result = directoryHandler.createIfNotExist(SAMPLE_DATA);
		assertTrue(result);
	}
	
	@Test
	public void testListSubDirectories() throws FileException{
		DirectoryHandler directoryHandler = new DirectoryHandlerImpl();
		List<String> list = directoryHandler.listSubDirectories(SAMPLE_DATA2);
		for(String str : list) {
			System.out.println(str);
		}
		
	}
	
	@Test
	public void testListFilesAndSubDirectories() throws FileException {
		DirectoryHandler directoryHandler = new DirectoryHandlerImpl();
		List<String> list = directoryHandler.listFilesAndSubDirectories(SAMPLE_DATA2);
		for(String str : list) {
			System.out.println(str);
		}
	}

}
