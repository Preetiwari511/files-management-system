package com.files.filesystem.files.impl;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import com.files.filesystem.enums.FileType;
import com.files.filesystem.exceptions.FileException;
import com.files.filesystem.files.FilesReader;
import com.files.filesystem.files.FilesReaderFactory;
import com.files.filesystem.utils.FilesUtil;

public class JSONFilesReaderImplTest {
	
	private final static String ROOT = "src/test/resources";
	private final static String FILE_PATH = "data/sample_data_json.json";
	private final static String SAMPLE_DATA = ROOT + File.separator + FILE_PATH;

	@SuppressWarnings("unchecked")
	@Test
	public void readFileTest() throws FileException {
		FileType fileType = FilesUtil.getFileType(SAMPLE_DATA);
		FilesReader fileReader = FilesReaderFactory.getFilesReader(fileType);
		List<Map<String, String>> list = (List<Map<String, String>>) fileReader
				.readFile(SAMPLE_DATA);
		for (Map<String, String> map : list) {
			System.out.println(map.entrySet());
		}

	}

}
