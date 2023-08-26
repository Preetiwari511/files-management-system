package com.files.filesystem.files.impl;

import java.util.List;
import java.util.Map;
import java.util.jar.Attributes;
import java.io.FileWriter;
import java.io.StringReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.files.filesystem.exceptions.FileException;
import com.files.filesystem.files.FilesWriter;

public class XMLFilesWriterImpl implements FilesWriter {

	@Override
	public boolean writeFile(List<?> data, String filePath, boolean append) throws FileException {
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			CustomHandler handler = new CustomHandler((List<Map<String, String>>) data);
			parser.parse(new InputSource(new StringReader("")), handler);
			FileWriter fileWriter = new FileWriter(filePath, append);
			fileWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
	        fileWriter.write(handler.getResult());
	        fileWriter.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	class CustomHandler extends DefaultHandler {
		private StringBuilder xmlResult = new StringBuilder();
		private List<Map<String, String>> data;
		private int indentLevel = 0;

		public CustomHandler(List<Map<String, String>> data) {
			this.data = data;
		}

		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
			addIndent();
			xmlResult.append("<").append(qName);
			if (data != null && !data.isEmpty()) {
				Map<String, String> attributesMap = data.get(0);
				for (Map.Entry<String, String> entry : attributesMap.entrySet()) {
					xmlResult.append(" ").append(entry.getKey()).append("=\"").append(entry.getValue()).append("\"");
				}
			}
			xmlResult.append(">").append("\n");
			indentLevel++;
		}

		public void endElement(String uri, String localName, String qName) throws SAXException {
			indentLevel--;
			addIndent();
			xmlResult.append("</").append(qName).append(">").append("\n");
		}

		private void addIndent() {
			for (int i = 0; i < indentLevel; i++) {
				xmlResult.append(" ");
			}
		}

		public String getResult() {
			return xmlResult.toString();
		}

	}
}


