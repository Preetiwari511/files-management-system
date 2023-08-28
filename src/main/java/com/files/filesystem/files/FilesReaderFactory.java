package com.files.filesystem.files;

import com.files.filesystem.enums.FileType;
import com.files.filesystem.files.impl.CSVFilesReaderImpl;
import com.files.filesystem.files.impl.CSVFilesWriterImpl;
import com.files.filesystem.files.impl.JSONFilesReaderImpl;
import com.files.filesystem.files.impl.JSONFilesWriterImpl;
import com.files.filesystem.files.impl.TextFilesWriterImpl;
import com.files.filesystem.files.impl.XMLFilesReaderImpl;
import com.files.filesystem.files.impl.XMLFilesWriterImpl;
import com.files.filesystem.files.impl.TextFilesReaderImpl;

public final class FilesReaderFactory {

	public static FilesReader getFilesReader(FileType fileType) {
		switch (fileType) {
		case TEXT:
			return new TextFilesReaderImpl();
		case CSV:
			return new CSVFilesReaderImpl();
		case JSON:
			return new JSONFilesReaderImpl();
		case XML :
			 return new XMLFilesReaderImpl();
		}
		return null;
	}
	
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
		}
		return null;
	}

}
