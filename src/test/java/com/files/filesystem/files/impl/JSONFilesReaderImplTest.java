package com.files.filesystem.files.impl;

import java.io.File;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import com.files.filesystem.exceptions.FileException;
import com.files.filesystem.files.FilesReader;

public class JSONFilesReaderImplTest {
	
	private final static String ROOT = "src/test/resources";
	private final static String FILE_PATH = "data/sample_data_json.json";
	private final static String SAMPLE_DATA = ROOT + File.separator + FILE_PATH;

	@SuppressWarnings("unchecked")
	@Test
	public void readFileTest() throws FileException {

		FilesReader fileReader = new JSONFilesReaderImpl();
		List<Map<String, String>> list = (List<Map<String, String>>) fileReader
				.readFile(SAMPLE_DATA);
		for (Map<String, String> map : list) {
			System.out.println(map.entrySet());
		}

	}

}
