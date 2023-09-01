package com.files.filesystem.files.impl;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.junit.Test;

import com.files.filesystem.enums.FileType;
import com.files.filesystem.exceptions.FileException;
import com.files.filesystem.files.FilesReader;
import com.files.filesystem.files.FilesReaderFactory;
import com.files.filesystem.utils.FilesUtil;

public class XLSXFilesReaderImplTest {
	private final static String ROOT = "src/test/resources";
	private final static String FILE_PATH = "data/MOCK_DATA.xlsx";
	private final static String SAMPLE_DATA = ROOT + File.separator + FILE_PATH;
	
	@Test
	public void testReadFile() throws FileException {
		FileType fileType = FilesUtil.getFileType(SAMPLE_DATA);
		FilesReader fileReader = FilesReaderFactory.getFilesReader(fileType);
		List<Map<String,?>> list = (List<Map<String, ?>>) fileReader.readFile(SAMPLE_DATA);
		Iterator itr = list.iterator();
		while(itr.hasNext()) {
			Map<String,?> data = (Map<String, ?>) itr.next();
			for(String key : data.keySet()) {
				System.out.print(key + " : "+ data.get(key));
			}
			System.out.println();
		}
	}

}
