package com.files.filesystem.files;

import java.io.IOException;
import java.util.List;

import com.files.exceptions.FileException;

public interface FilesWriter {
	public boolean writeInAFile(List<String[]> content ,String path, boolean overwrite) throws FileException;
	public boolean writeInAFileFromOtherFile(String path1,String path2)throws FileException;
}
