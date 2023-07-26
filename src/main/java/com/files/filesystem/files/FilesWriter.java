package com.files.filesystem.files;

import java.util.List;

import com.files.filesystem.exceptions.FileException;

public interface FilesWriter {
	public boolean writeInAFile(List<?> content ,String path, boolean overwrite) throws FileException;
	public boolean writeInAFileFromOtherFile(String path1,String path2)throws FileException;
}
