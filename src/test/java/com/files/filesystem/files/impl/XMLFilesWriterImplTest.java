package com.files.filesystem.files.impl;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;
import java.util.Map;

import com.files.filesystem.enums.FileType;
import com.files.filesystem.exceptions.FileException;
import com.files.filesystem.files.FilesReaderFactory;
import com.files.filesystem.files.FilesWriter;
import com.files.filesystem.files.FilesWriterFactory;
import com.files.filesystem.utils.FilesUtil;


public class XMLFilesWriterImplTest{
	private final static String ROOT = "src/test/resources";
	private final static String FILE_PATH = "data/sample_data_xml.xml";
	private final static String SAMPLE_DATA = ROOT + File.separator + FILE_PATH;
	
	@org.junit.Test
	public void writeFileTest() throws FileException {
		FileType fileType =FilesUtil.getFileType(SAMPLE_DATA);
		FilesWriter fileWriter = FilesWriterFactory.getFilesWriter(fileType);
		List<Map<String, String>> dataList = (List<Map<String, String>>) new XMLFilesReaderImpl().readFile(SAMPLE_DATA);	
		boolean result = fileWriter.writeFile(dataList,"C:\\Users\\preeti.tiwari\\Documents\\Files\\sample_xml_file.xml", false);
		assertTrue(result);
	}	

}

