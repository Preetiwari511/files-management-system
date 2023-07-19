package com.files.filesystem.files;

import com.files.exceptions.FileException;

public interface FilesWriter {
	public boolean writeInAFile(String[] content ,String path, boolean overwrite	 ) throws FileException;
	public boolean writeInAFileFromOtherFile(String path1,String path2)throws FileException;
}
