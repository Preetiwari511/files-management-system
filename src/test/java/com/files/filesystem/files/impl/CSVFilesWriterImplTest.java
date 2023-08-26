package com.files.filesystem.files.impl;

import static org.junit.Assert.assertTrue;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

import com.files.filesystem.enums.FileType;
import com.files.filesystem.exceptions.FileException;
import com.files.filesystem.files.FilesReaderFactory;
import com.files.filesystem.files.FilesWriter;
import com.files.filesystem.utils.FilesUtil;

public class CSVFilesWriterImplTest {
	private final static String ROOT = "C:\\Users\\preeti.tiwari\\Documents\\Files";
	private final static String FILE_PATH = "sample_csv_file.csv";
	private final static String SAMPLE_FILE = ROOT + File.separator + FILE_PATH;
	private final static List<Map<String,String>> list = data();

	@Test
	public void testWriteFileWhenFileNotExist() throws FileException {
		FileType fileType =FilesUtil.getFileType(SAMPLE_FILE);
		FilesWriter fileWriter = FilesReaderFactory.getFilesWriter(fileType);
		boolean result = fileWriter.writeFile(list, SAMPLE_FILE, false);
		assertTrue(result);
	}

	@Test
	public void testWriteFileWithoutAppend() throws FileException {
		FileType fileType =FilesUtil.getFileType(SAMPLE_FILE);
		FilesWriter fileWriter = FilesReaderFactory.getFilesWriter(fileType);
		boolean result = fileWriter.writeFile(list, SAMPLE_FILE, false);
		assertTrue(result);
	}

	@Test
	public void testWriteFileWithAppend() throws FileException {
		FileType fileType =FilesUtil.getFileType(SAMPLE_FILE);
		FilesWriter fileWriter = FilesReaderFactory.getFilesWriter(fileType);
		boolean result = fileWriter.writeFile(list, SAMPLE_FILE, true);
		assertTrue(result);
	}

	private static List<Map<String, String>> data() {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Map<String, String> map1 = new LinkedHashMap<String, String>();
		map1.put("S_no.","01");
		map1.put("Name","Kiya Tiwari");
		map1.put("Class", "I");
		Map<String, String> map2 = new LinkedHashMap<String, String>();
		map2.put("S_no","02");
		map2.put("Name","Sima Shah");
		map2.put("Class", "II");
		list.add(map1);
		list.add(map2);
		return list;
	}
}
