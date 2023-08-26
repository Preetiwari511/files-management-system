package com.files.filesystem.utils;

import com.files.filesystem.enums.FileType;

public class FilesUtil {
	public static FileType getFileType(String filePath) {
		String fileType = filePath.substring(filePath.lastIndexOf(".")+1);
		switch(fileType) {
		case "txt" :
			return FileType.TEXT;
		case "csv" : 
			return FileType.CSV;
		case "json" :
			return FileType.JSON;
		}
		return null;
	}

}
