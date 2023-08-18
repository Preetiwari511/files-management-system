package com.files.filesystem.files.impl;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.files.filesystem.exceptions.FileException;
import com.files.filesystem.files.FilesWriter;

public class TextFileWriterImplTest {
	private final static String ROOT = "src/test/resources";
	private final static String FILE_PATH = "data/sample_text_file_write5.txt";
	private final static String SAMPLE_FILE = ROOT + File.separator + FILE_PATH;
	private final static List<String> list = data();

	
	@Test
	public void testWriteFileWhenFileNotExist() throws FileException {
		FilesWriter fileWriter = new TextFileWriterImpl();
		boolean result = fileWriter.writeFile(list, SAMPLE_FILE, false);
		assertTrue(result);
	}
	
	@Test
	public void testWriteFileWithoutAppend() throws FileException {
		FilesWriter fileWriter = new TextFileWriterImpl();
		boolean result = fileWriter.writeFile(list, SAMPLE_FILE, false);
		assertTrue(result);
	}
	
	@Test
	public void testWriteFileWithAppend() throws FileException {
		FilesWriter fileWriter = new TextFileWriterImpl();
		boolean result = fileWriter.writeFile(list, SAMPLE_FILE, true);
		assertTrue(result);
	}
	
	
	private static List<String> data(){
		List<String> list = new ArrayList<String>();
		list.add("Hello Jiya22!");
		list.add("Please,write here also.");
		list.add("you know this");
		return list;
	}
}
