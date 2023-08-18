package com.files.filesystem.files.impl;

import java.io.File;
import java.util.List;

import org.junit.Test;

import com.files.filesystem.exceptions.FileException;
import com.files.filesystem.files.FilesReader;

public class TextFilesReaderImplTest {
	private final static String ROOT = "src/test/resources";
	private final static String FILE_PATH = "data/sample_text_file.txt";
	private final static String SAMPLE_DATA = ROOT + File.separator + FILE_PATH;

	@Test
	public void testReadFile() throws FileException {
		FilesReader filesReader = new TextFilesReaderImpl();
		List<?> list = filesReader.readFile(SAMPLE_DATA);
		for (Object obj : list) {
			System.out.println(obj);
		}
	}
	
}
