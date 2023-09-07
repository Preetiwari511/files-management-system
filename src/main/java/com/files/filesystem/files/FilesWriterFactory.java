package com.files.filesystem.files;

import com.files.filesystem.enums.FileType;
import com.files.filesystem.files.impl.CSVFilesWriterImpl;
import com.files.filesystem.files.impl.JSONFilesWriterImpl;
import com.files.filesystem.files.impl.TextFilesWriterImpl;
import com.files.filesystem.files.impl.XLSXFilesWriterImpl;
import com.files.filesystem.files.impl.XMLFilesWriterImpl;

public class FilesWriterFactory {
	public static FilesWriter getFilesWriter(FileType fileType) {
		switch (fileType) {
		case TEXT:
			return new TextFilesWriterImpl();
		case CSV:
			return new CSVFilesWriterImpl();
		case JSON:
			return new JSONFilesWriterImpl();
		case XML :
			return new XMLFilesWriterImpl();
		case XLSX:
			return new XLSXFilesWriterImpl("Employees");
		}
		return null;
	}
}
