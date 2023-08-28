package com.files.filesystem.files.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
		List<Map<String, String>> resultList = new ArrayList<>();
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			XMLFilesReaderImpl.CustomHandler customHandler = new XMLFilesReaderImpl.CustomHandler(resultList);
			SAXParser saxParser = factory.newSAXParser();
			saxParser.parse(fileName, customHandler);

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return resultList;
	}

	public class CustomHandler extends DefaultHandler {

		private StringBuilder currentValue = new StringBuilder();
		private Map<String, String> currentMap;
		private List<Map<String, String>> resultMapList;

		private CustomHandler(List<Map<String, String>> resultMapList) {
			this.resultMapList = resultMapList;
		}

		@Override
		public void startElement(String uri, String localName, String qName, Attributes attributes)
				throws SAXException {
			currentValue.setLength(0);

			if ("record".equalsIgnoreCase(qName)) {
				currentMap = new LinkedHashMap<String, String>();
			}

		}

		@Override
		public void endElement(String uri, String localName, String qName) {
			if (currentMap != null) {

				if ("record".equalsIgnoreCase(qName)) {
					resultMapList.add(currentMap);
					currentMap = null;
				} else {
					currentMap.put(qName, currentValue.toString());
				}
				currentValue.setLength(0);
			}
		}

		@Override
		public void characters(char ch[], int start, int length) {
			currentValue.append(ch, start, length);

		}

	}

}
