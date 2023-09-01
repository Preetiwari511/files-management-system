package com.files.filesystem.files.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.files.filesystem.directories.FileHandler;
import com.files.filesystem.directories.impl.FileHandlerImpl;
import com.files.filesystem.exceptions.FileException;
import com.files.filesystem.files.FilesWriter;

public class XLSXFilesWriterImpl implements FilesWriter {
	private FileHandler fileHandler = new FileHandlerImpl();
	private String sheetName = "sheet1";
	
	public XLSXFilesWriterImpl(String sheetName) {
		this.sheetName = sheetName;
	}
	
	@Override
	public boolean writeFile(List<?> data, String filePath, boolean append) throws FileException {
		FileOutputStream fileOutputStream = null;
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet(sheetName);
		if(!fileHandler.isFileExists(filePath)|| !append) {
			fileHandler.delete(filePath);
			fileHandler.createIfNotExist(filePath);
		}	
		writeHeader(data,sheet,workbook);
		writeValuesinCells(data,sheet);
		try {
			 fileOutputStream= new FileOutputStream(filePath);
			workbook.write(fileOutputStream);
			return true;
		} catch (IOException e) {
			throw new FileException("Failed to write in the file -" + filePath, e);
		}finally {
			try {
				fileOutputStream.close();
			} catch (IOException e) {
				throw new FileException("Failed to write in the file -" + filePath, e);
			}
		}
	}
	
	
	private static void writeHeader(List<?> data, XSSFSheet sheet,XSSFWorkbook workbook  ) {
		Row header = sheet.createRow(0);
		System.out.println(header.getRowNum());
		CellStyle headerStyle = workbook.createCellStyle();
		XSSFFont font = ((XSSFWorkbook) workbook).createFont();
		font.setFontName("Arial");
		font.setFontHeightInPoints((short) 10);
		font.setBold(true);
		headerStyle.setFont(font);
		Map<String,?> map = (Map<String,?>)data.get(0);
		System.out.println(map);
		System.out.println(map.keySet().size());
		int i =0;
			for(String value : map.keySet()) {
				Cell headerCell = header.createCell(i);
				System.out.println(headerCell.getColumnIndex());
				System.out.println(value);
				headerCell.setCellValue(value);
				headerCell.setCellStyle(headerStyle);
				i=i+1;
			}
	}
	private static void writeValuesinCells(List<?>data,XSSFSheet sheet){
		Map<String,?> map = null;
		Row row = null;
		for(int i=1;i<=data.size();i++) {
			row = sheet.createRow(i);
			System.out.println(row.getRowNum());
			map = (Map<String,?>)data.get(i-1);
			int colmNo = 0;
			for(String key : map.keySet()) {
				XSSFCell cell = (XSSFCell) row.createCell(colmNo);
				Object value = map.get(key);
				if(value instanceof String )
					cell.setCellValue((String)value);
				if(value instanceof Integer )
					cell.setCellValue((Integer)value);
				if(value instanceof Boolean)
					cell.setCellValue((Boolean)value);
				colmNo = colmNo+1 ;
			}
		}	
	}
	
	
	

}
