package com.files.filesystem.files.impl;

import java.io.File;

import com.files.filesystem.directories.impl.FileHandlerImpl;
import com.files.filesystem.enums.FileType;
import com.files.filesystem.exceptions.FileException;
import com.files.filesystem.files.FilesConverters;
import com.files.filesystem.utils.FilesUtil;

public class Test {
	private final static String ROOT = "C:/Users/preeti.tiwari/Documents/Files";
	private final static String FILE_PATH = "sample_json_file.json";
	private final static String SAMPLE_FILE = ROOT + File.separator + FILE_PATH;
//	
//	private final static String ROOT1 = "src/test/resources";
//	private final static String FILE_PATH1 = "data4";
//	private final static String SAMPLE_FILE1 = ROOT1 + '/' + FILE_PATH1 + '/';
	public static void main(String[] args) throws FileException {
//		FilesConverters fConvertors = new CSVtoXMLfileConverter();
//		boolean result = fConvertors.convertFileFormat(SAMPLE_FILE,"C:\\Users\\preeti.tiwari\\Documents\\Files\\covertedXML.xml");
//		System.out.println(result);
		FilesConverters filesConverters = new FileFormatCoverter();
		boolean result = filesConverters.convertFileFormat(SAMPLE_FILE,"xlsx");
		System.out.println(result);
	}

	
	
}
