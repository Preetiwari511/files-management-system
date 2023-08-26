package com.files.filesystem.files.impl;

	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;

import com.files.filesystem.exceptions.FileException;

	public class XMLFilesWriterImplTest {

	    public static void main(String[] args) {
	        List<Map<String, String>> dataList = createSampleData();
	        String filePath = "C:\\Users\\preeti.tiwari\\Documents\\Files\\output.xml";

	        XMLFilesWriterImpl xmlWriter = new XMLFilesWriterImpl();
	        try {
	            xmlWriter.writeFile(dataList, filePath, false);
	            System.out.println("XML file written successfully!");
	        } catch (FileException e) {
	            e.printStackTrace();
	        }
	    }

	    private static List<Map<String, String>> createSampleData() {
	        List<Map<String, String>> dataList = new ArrayList<>();

	        Map<String, String> element1 = new HashMap<>();
	        element1.put("id","1");
	        element1.put("name","John");
	        dataList.add(element1);

	        Map<String, String> element2 = new HashMap<>();
	        element2.put("id","2");
	        element2.put("name","Jane");
	        dataList.add(element2);

	        return dataList;
	    }
	}
