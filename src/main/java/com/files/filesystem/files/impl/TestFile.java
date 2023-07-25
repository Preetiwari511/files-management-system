package com.files.filesystem.files.impl;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.files.exceptions.FileException;
import com.files.filesystem.files.FileHandler;
import com.files.filesystem.files.FilesReader;
import com.files.filesystem.files.FilesWriter;

public class TestFile {

	public static void main(String[] args) throws FileException {
		FilesWriter filesWriter = new FilesCSVWriterImpl();
		List list = new ArrayList();
		Map map1 = new LinkedHashMap();
		map1.put("S_no.","01");
		map1.put("Name","Riya Tiwari");
		map1.put("Class", "I");
		list.add(map1);
	    boolean isWritten = filesWriter.writeInAFile(list,"C:\\Users\\preeti.tiwari\\Documents\\Files\\mock_data1.csv",false);
	    System.out.println(isWritten);
		
		FilesReader filesReader = new FilesCSVReaderImpl();
		List isRead = filesReader.readFile("C:\\Users\\preeti.tiwari\\Documents\\Files\\mock_data.csv");
		for(Object data :isRead ) {
			System.out.println(data);
		}
		
	}

}
