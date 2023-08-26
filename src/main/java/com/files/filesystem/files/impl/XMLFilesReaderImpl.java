package com.files.filesystem.files.impl;

import java.util.List;
import java.util.jar.Attributes;

import org.xml.sax.helpers.DefaultHandler;

import com.files.filesystem.exceptions.FileException;
import com.files.filesystem.files.FilesReader;

public class XMLFilesReaderImpl implements FilesReader {

	@Override
	public List<?> readFile(String fileName) throws FileException {
		
		return null;
	}
	
	
	
	class CustomHandler extends DefaultHandler{
		private StringBuilder currentValue = new StringBuilder();
		public void startDocument() {
			 System.out.println("Start Document");
		}
		public void endDocument() {
			System.out.println("End Document");
		}
		
		public void startElement(String uri,
		          String localName,
		          String qName,
		          Attributes attributes) {
				
		}
		
	}

}
