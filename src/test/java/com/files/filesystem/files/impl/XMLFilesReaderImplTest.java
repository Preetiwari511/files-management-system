package com.files.filesystem.files.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.files.filesystem.exceptions.FileException;

public class XMLFilesReaderImplTest {

	private final static String ROOT = "src/test/resources";
	private final static String FILE_PATH = "data/sample_data_xml.xml";
	private final static String SAMPLE_DATA = ROOT + File.separator + FILE_PATH;

	@org.junit.Test
	public void test() {
		List<Map<String, String>> dataList = createSampleData();

		XMLFilesReaderImpl xmlReader = new XMLFilesReaderImpl();
		try {
			xmlReader.readFile(SAMPLE_DATA);
			System.out.println("XML file read successfully!");
		} catch (FileException e) {
			e.printStackTrace();
		}
	}

	private static List<Map<String, String>> createSampleData() {
		List<Map<String, String>> dataList = new ArrayList<>();

		Map<String, String> element1 = new HashMap<>();
		element1.put("id", "1");
		element1.put("name", "John");
		dataList.add(element1);

		Map<String, String> element2 = new HashMap<>();
		element2.put("id", "2");
		element2.put("name", "Jane");
		dataList.add(element2);

		return dataList;
	}
}
