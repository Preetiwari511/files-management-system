package com.files.filesystem;

import com.files.exceptions.FileException;

public interface FileWriters {
	public boolean writeInAFile(String[] content ,String path ) throws FileException;
	public boolean writeInAFileFromOtherFile(String path1,String path2)throws FileException;
}
