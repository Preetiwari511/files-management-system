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
import com.files.filesystem.files.FilesReader;
import com.files.filesystem.files.FilesWriter;
import com.files.filesystem.files.FilesWriterFactory;
import com.files.filesystem.utils.FilesUtil;

public class XLSXFilesWriterImplTest {
	private final static String ROOT = "C:\\Users\\preeti.tiwari\\Documents\\Files";
	private final static String FILE_PATH = "sample_xlsx_file1.xlsx";
	private final static String SAMPLE_FILE = ROOT + File.separator + FILE_PATH;
	private final static String ROOTPATH = "src/test/resources";
	private final static String FILE_PATH2 = "data/MOCK_DATA.xlsx";

	@Test
	public void testWriteFileWhenFileNotExist() throws FileException {
		FileType fileType =FilesUtil.getFileType(SAMPLE_FILE);
		FilesWriter fileWriter = FilesWriterFactory.getFilesWriter(fileType);
		FilesReader reader = new XLSXFilesReaderImpl();
		//List<Map<String,Object>> list= (List<Map<String, Object>>) reader.readFile(SAMPLE_DATA);
		boolean result = fileWriter.writeFile(data(), SAMPLE_FILE, false);
		assertTrue(result);
	}

	@Test
	public void testWriteFileWithoutAppend() throws FileException {
		FileType fileType =FilesUtil.getFileType(SAMPLE_FILE);
		FilesWriter fileWriter = FilesWriterFactory.getFilesWriter(fileType);
		FilesReader reader = new XLSXFilesReaderImpl();
		boolean result = fileWriter.writeFile(data(), SAMPLE_FILE, false);
		assertTrue(result);
	}

	@Test
	public void testWriteFileWithAppend() throws FileException {
		FileType fileType =FilesUtil.getFileType(SAMPLE_FILE);
		FilesWriter fileWriter = FilesWriterFactory.getFilesWriter(fileType);
		FilesReader reader = new XLSXFilesReaderImpl();
		//List<Map<String,Object>> list= (List<Map<String, Object>>) reader.readFile(SAMPLE_DATA);
		boolean result = fileWriter.writeFile(data(), SAMPLE_FILE, true);
		assertTrue(result);
	}
	
	private static List<List<Map<String, String>>> data() {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		List<List<Map<String,String>>> sheet = new ArrayList<>();
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
		sheet.add(list);
		return sheet;
	}
}


