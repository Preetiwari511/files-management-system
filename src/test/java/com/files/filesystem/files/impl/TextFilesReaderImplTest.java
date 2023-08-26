package com.files.filesystem.files.impl;

import java.io.File;
import java.util.List;

import org.junit.Test;

import com.files.filesystem.enums.FileType;
import com.files.filesystem.exceptions.FileException;
import com.files.filesystem.files.FilesReader;
import com.files.filesystem.files.FilesReaderFactory;
import com.files.filesystem.utils.FilesUtil;

public class TextFilesReaderImplTest {
	private final static String ROOT = "src/test/resources";
	private final static String FILE_PATH = "data/sample_text_file.txt";
	private final static String SAMPLE_DATA = ROOT + File.separator + FILE_PATH;

	@Test
	public void testReadFile() throws FileException {
		FileType fileType = FilesUtil.getFileType(SAMPLE_DATA);
		FilesReader fileReader = FilesReaderFactory.getFilesReader(fileType);
		List<?> list = fileReader.readFile(SAMPLE_DATA);
		for (Object obj : list) {
			System.out.println(obj);
		}
	}
	
}
