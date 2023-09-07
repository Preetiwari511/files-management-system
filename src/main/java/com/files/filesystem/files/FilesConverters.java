package com.files.filesystem.files;

import com.files.filesystem.enums.FileType;
import com.files.filesystem.exceptions.FileException;

public interface FilesConverters {
	public boolean convertFileFormat(String sourcePath,String destinationPath) throws FileException;
}
