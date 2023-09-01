package com.files.filesystem.enums;

public enum FileType {
	TEXT("txt"), CSV("csv"),JSON("json"), XML("xml"), XLSX("xlsx");
	
	private String fileType;

	FileType(String string) {
		this.fileType = string;
	}
	
	public String getFileType() {
		return this.fileType;
	}
	

}
