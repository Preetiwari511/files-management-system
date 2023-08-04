package files_management_system;

import java.util.List;
import java.util.Map;

import com.files.filesystem.exceptions.FileException;
import com.files.filesystem.files.FilesReader;
import com.files.filesystem.files.impl.JSONFilesReaderImpl;

public class TestJSONFilesReaderImpl {

	public static void main(String[] args) throws FileException {
		FilesReader fileReader = new JSONFilesReaderImpl();
		List<Map<String,String>> list = (List<Map<String, String>>) fileReader.readFile("C:\\Users\\preeti.tiwari\\Documents\\Files\\file.json");
		for(Map<String,String> map : list) {
			System.out.println(map.entrySet());
		}
	}

}
