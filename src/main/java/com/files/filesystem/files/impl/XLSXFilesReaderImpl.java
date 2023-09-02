package com.files.filesystem.files.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.files.filesystem.directories.FileHandler;
import com.files.filesystem.directories.impl.FileHandlerImpl;
import com.files.filesystem.exceptions.FileException;
import com.files.filesystem.files.FilesReader;

public class XLSXFilesReaderImpl implements FilesReader {
	private FileHandler fileHandler = new FileHandlerImpl();

	@Override
	public List<?> readFile(String fileName) throws FileException {
		if (fileHandler.isFileExists(fileName)) {
			FileInputStream fileInputStream = null;
			List<List<Map<?,?>>> workbookData = new LinkedList<>();
			try {
				fileInputStream = new FileInputStream(fileName);
				XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
				XSSFSheet sheet = null;
				Iterator rows = null;
				List<String> headers =null;
				for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
					sheet = workbook.getSheetAt(i);
					rows = sheet.iterator();
					headers = new LinkedList<>();
					List<Map<?,?>> sheetData = new LinkedList<Map<?,?>>();
					while (rows.hasNext()) {
						XSSFRow row = (XSSFRow) rows.next();
						if (row.getRowNum() == 0) {
							headers = getListOfHeaders(row);
							continue;
						}
						Iterator columns = row.iterator();
						Map<String, Object> map = new LinkedHashMap<>();
						while (columns.hasNext()) {
							XSSFCell column = (XSSFCell) columns.next();
							switch (column.getCellType()) {
							case STRING: {
								String string = column.getStringCellValue();
								
								map.put(headers.get(column.getColumnIndex()), string);

							}
								break;
							case NUMERIC: {
								double num = column.getNumericCellValue();
								map.put(headers.get(column.getColumnIndex()), (int) num);
							}
								break;
							case BOOLEAN: {
								boolean value = column.getBooleanCellValue();
								map.put(headers.get(column.getColumnIndex()), value);
							}
								break;
							}
							
						}
						sheetData.add(map);
					}
					workbookData.add(sheetData);
				}

			} catch (FileNotFoundException e) {
				throw new FileException("Failed to read file - " + fileName, e);
			} catch (IOException e) {
				throw new FileException("Failed to read file - " + fileName, e);
			}finally {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					throw new FileException("Failed to read file - " + fileName, e);
				} 
			}
			return workbookData;
		} else
			throw new FileException("File not found", new RuntimeException());

	}

	private static List<String> getListOfHeaders(XSSFRow row) {
		List<String> headers = new LinkedList<>();
		Iterator columns = row.iterator();
		while (columns.hasNext()) {
			XSSFCell column = (XSSFCell) columns.next();
			String columnName = column.getStringCellValue();
			headers.add(columnName);
		}
		return headers;
	}

}
