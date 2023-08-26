package com.files.filesystem.files.impl;

import com.files.filesystem.directories.FileHandler;
import com.files.filesystem.directories.impl.FileHandlerImpl;
import com.files.filesystem.enums.FileType;
import com.files.filesystem.exceptions.FileException;
import com.files.filesystem.utils.FilesUtil;

public class Test {
	private final static String ROOT = "src/test/resources";
	private final static String FILE_PATH = "data/sample_text_file_write5.csv";
	private final static String SAMPLE_FILE = ROOT + '/' + FILE_PATH;
	
	private final static String ROOT1 = "src/test/resources";
	private final static String FILE_PATH1 = "data4";
	private final static String SAMPLE_FILE1 = ROOT1 + '/' + FILE_PATH1 + '/';
	public static void main(String[] args) throws FileException {
		
		FilesUtil u = new FilesUtil();
		FileType type = u.getFileType(FILE_PATH);
		System.out.println(type);
		
	}

}
