package com.files.filesystem.files.impl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import com.files.filesystem.directories.FileHandler;
import com.files.filesystem.directories.impl.FileHandlerImpl;
import com.files.filesystem.exceptions.FileException;
import com.files.filesystem.files.FilesWriter;

public class XMLFilesWriterImpl implements FilesWriter {
	FileHandler fileHandler = new FileHandlerImpl();

	@Override
	public boolean writeFile(List<?> data, String filePath, boolean append) throws FileException {
		if (!fileHandler.isFileExists(filePath)) {
			fileHandler.delete(filePath);
			fileHandler.createIfNotExist(filePath);
		}
		try (FileOutputStream out = new FileOutputStream(filePath)) {
			writeXml(out, data);
			return true;
		} catch (IOException e) {
			throw new FileException("Failed to write in the file -" + filePath, e);
		} catch (XMLStreamException e) {
			throw new FileException("Failed to write XML content to the file - " + filePath, e);
		}
	}

	private void writeXml(FileOutputStream out, List<?> data) throws XMLStreamException {
		XMLOutputFactory output = XMLOutputFactory.newInstance();
		XMLStreamWriter writer = output.createXMLStreamWriter(out);
		writer.writeStartDocument("utf-8", "1.0");
		writer.writeStartElement("Dataset");
		for (int i = 0; i < data.size(); i++) {
			writer.writeStartElement("record");
			Map<String, String> mapData = (Map<String, String>) data.get(i);
			for (String key : mapData.keySet()) {
				String value = mapData.get(key);
				writer.writeStartElement(key);
				writer.writeCharacters(value);
				writer.writeEndElement();
			}
			writer.writeEndElement();
		}
		writer.writeEndElement();
		writer.writeEndDocument();
		writer.flush();
		writer.close();
	}
}
