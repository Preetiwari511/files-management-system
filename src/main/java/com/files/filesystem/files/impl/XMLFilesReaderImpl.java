package com.files.filesystem.files.impl;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.files.filesystem.exceptions.FileException;
import com.files.filesystem.files.FilesReader;

public class XMLFilesReaderImpl implements FilesReader {

	@Override
	public List<?> readFile(String fileName) throws FileException {

		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			XMLFilesReaderImpl.CustomHandler customHandler = new XMLFilesReaderImpl.CustomHandler();
			SAXParser saxParser = factory.newSAXParser();
			saxParser.parse(fileName, customHandler);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public class CustomHandler extends DefaultHandler {

		private StringBuilder currentValue = new StringBuilder();

		@Override
		public void startDocument() {
			System.out.println("Start Document");
		}

		@Override
		public void endDocument() {
			System.out.println("End Document");
		}

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			// TODO Auto-generated method stub
			// reset the tag value
			currentValue.setLength(0);

			System.out.printf("Start Element : %s%n", qName);

		}

		@Override
		public void endElement(String uri, String localName, String qName) {

			System.out.println("End Element : "+ qName + " --  currentValue : " + currentValue);

		}

		// http://www.saxproject.org/apidoc/org/xml/sax/ContentHandler.html#characters%28char%5B%5D,%20int,%20int%29
		// SAX parsers may return all contiguous character data in a single chunk,
		// or they may split it into several chunks
		@Override
		public void characters(char ch[], int start, int length) {

			// The characters() method can be called multiple times for a single text node.
			// Some values may missing if assign to a new string

			// avoid doing this
			// value = new String(ch, start, length);

			// better append it, works for single or multiple calls
			
			currentValue.append(ch, start, length);

		}

	}

}
