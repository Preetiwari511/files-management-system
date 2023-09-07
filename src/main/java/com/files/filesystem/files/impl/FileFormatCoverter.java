package com.files.filesystem.files.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.files.filesystem.directories.DirectoryHandler;
import com.files.filesystem.directories.impl.DirectoryHandlerImpl;
import com.files.filesystem.enums.FileType;
import com.files.filesystem.exceptions.FileException;
import com.files.filesystem.files.FilesConverters;
import com.files.filesystem.files.FilesReader;
import com.files.filesystem.files.FilesReaderFactory;
import com.files.filesystem.files.FilesWriter;
import com.files.filesystem.files.FilesWriterFactory;
import com.files.filesystem.utils.FilesUtil;

public class FileFormatCoverter implements FilesConverters {

	@SuppressWarnings("unchecked")
	@Override
	public boolean convertFileFormat(String sourcePath, String format) throws FileException {
		FileType filetypeSource = FilesUtil.getFileType(sourcePath);
		FileType filetypeDest = FilesUtil.getFileType("." + format);
		String destPath = new File(sourcePath).getParent();
		System.out.println(destPath);
		FilesReader sourceFilesReader = FilesReaderFactory.getFilesReader(filetypeSource);
		List<?> data = getDataList(filetypeSource, sourceFilesReader, sourcePath);
		if (filetypeSource == FileType.XLSX && filetypeDest != FileType.XLSX) {
			FilesWriter destFilesWriter = FilesWriterFactory.getFilesWriter(filetypeDest);
			if (data.size() > 1) {
				DirectoryHandler dirHandler = new DirectoryHandlerImpl();
				dirHandler.createIfNotExist(destPath + File.separator + "convert" + format);

			}
			for (int i = 0; i < data.size(); i++) {
				for (Object sheetData : data) {
					return destFilesWriter.writeFile((List<Map<?, ?>>) sheetData, destPath + File.separator + "convert"
							+ format + File.separator + "sheet" + i + "." + format, false);
				}
			}
		} else if (filetypeSource == FileType.CSV || filetypeSource == FileType.XML
				|| filetypeSource == FileType.JSON) {
			return convertFiles(filetypeDest, (List<Map<?, ?>>) data, destPath);
		}

		else {
			throw new FileException("File cannot be converted.", new FileNotFoundException());
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	private static List<?> getDataList(FileType type, FilesReader reader, String path) throws FileException {
		switch (type) {
		case CSV:
			return (List<Map<?, ?>>) reader.readFile(path);
		case JSON:
			System.out.println();
			return (List<Map<?, ?>>) reader.readFile(path);
		case XML:
			return (List<Map<?, ?>>) reader.readFile(path);
		case XLSX:
			return (List<List<Map<?, ?>>>) reader.readFile(path);
		default:
			throw new FileException("File cannot be converted to given format", new FileNotFoundException());
		}

	}

	private static boolean convertFiles(FileType filetypeDest, List<Map<?, ?>> data, String destPath)
			throws FileException {
	   String path = destPath +File.separator+"convertedFile"+"."+ filetypeDest.toString();
		switch (filetypeDest) {
		case CSV:
		case JSON:
		case XML:
			FilesWriter xmlFilesWriter = FilesWriterFactory.getFilesWriter(filetypeDest);
			return xmlFilesWriter.writeFile((List<Map<?, ?>>) data, path, false);
		case XLSX:
			FilesWriter xlsxWriter = FilesWriterFactory.getFilesWriter(filetypeDest);
			List<List<Map<?, ?>>> list = new ArrayList<>();
			list.add(data);
			return xlsxWriter.writeFile((List<List<Map<?, ?>>>) list, path, false);
		default:
			throw new FileException("File cannot be converted to given format", new FileNotFoundException());
		}

	}

}
