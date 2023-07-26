package com.files.filesystem.files.impl;

import java.util.List;

import com.files.filesystem.exceptions.FileException;
import com.files.filesystem.files.FilesReader;

public class TestFile {

	// TODO: Move this class to test source directory
	public static void main(String[] args) throws FileException {
//		FilesWriter filesWriter = new FilesCSVWriterImpl();
//		List list = new ArrayList();
//		Map map1 = new LinkedHashMap();
//		map1.put("S_no.","01");
//		map1.put("Name","Riya Tiwari");
//		map1.put("Class", "I");
//		list.add(map1);
//	    boolean isWritten = filesWriter.writeInAFile(list,"C:\\Users\\preeti.tiwari\\Documents\\Files\\mock_data1.csv",false);
//	    System.out.println(isWritten);
//		
//		FilesReader filesReader = new FilesCSVReaderImpl();
//		List isRead = filesReader.readFile("C:\\Users\\preeti.tiwari\\Documents\\Files\\mock_data.csv");
//		for(Object data :isRead ) {
//			System.out.println(data);
		
//		FilesWriter filesWriter = new FileTextWriterImpl();
//		List list = new ArrayList();
//		list.add("Hello Riya!");
//		list.add("Please,write here.");
//		boolean isWrite= filesWriter.writeInAFile(list, "C:\\Users\\preeti.tiwari\\Documents\\Files\\textFile.txt", true);
//		System.out.println(isWrite);
//		
		FilesReader filesReader = new TextFilesReaderImpl();
		List list2 = filesReader.readFile("C:\\Users\\preeti.tiwari\\Documents\\Files\\textFile.txt");
		for(Object obj: list2) {
			System.out.println(obj);
		}
		
		}
		
	}


