
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.files.filesystem.directories.DirectoryHandler;
import com.files.filesystem.directories.FileHandler;
import com.files.filesystem.directories.impl.DirectoryHandlerImpl;
import com.files.filesystem.directories.impl.FileHandlerImpl;
import com.files.filesystem.exceptions.FileException;
import com.files.filesystem.files.FilesWriter;
import com.files.filesystem.files.impl.CSVFilesWriterImpl;

public class TestFile {

	public static void main(String[] args) throws FileException {
		// test method of CSVFilesWriterImpl
//		FilesWriter filesWriter = new CSVFilesWriterImpl();
//		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
//		Map<String, String> map1 = new LinkedHashMap<String, String>();
//		map1.put("S_no.","01");
//		map1.put("Name","Kiya Tiwari");
//		map1.put("Class", "I");
//		list.add(map1);
//	    boolean isWritten = filesWriter.writeInAFile(list,"C:\\Users\\preeti.tiwari\\Documents\\Files\\mock_data1.csv",false);
//	    System.out.println(isWritten);

//		test method of CSVFilesReaderImpl
//		FilesReader filesReader = new CSVFilesReaderImpl();
//		List isRead = filesReader.readFile("C:\\Users\\preeti.tiwari\\Documents\\Files\\mock_data.csv");
//		for(Object data :isRead ) {
//			System.out.println(data);

//	    test method of TextFileWriterImpl
//		FilesWriter filesWriter = new TextFileWriterImpl();
//		List list = new ArrayList();
//		list.add("Hello Jiya22!");
//		list.add("Please,write here also.");
//		list.add("you don't know this");
//		boolean isWrite= filesWriter.writeInAFile(list, "C:\\Users\\preeti.tiwari\\Documents\\Filess\\textFile2.txt",false);
//		System.out.println(isWrite);

//		test method of TextFilesReaderImpl
//		FilesReader filesReader = new TextFilesReaderImpl();
//		List list2 = filesReader.readFile("C:\\Users\\preeti.tiwari\\Documents\\Files\\textFile.txt");
//		for(Object obj: list2) {
//			System.out.println(obj);

		// Test DirectoryHandlerImpl
		DirectoryHandler directoryHandler = new DirectoryHandlerImpl();
//	    boolean result = directoryHandler.isExists("C:\\Users\\preeti.tiwari\\Documents\\Files\\Directory1");
//	    System.out.println(result);
//	    boolean isCreated = directoryHandler.createIfNotExist("C:\\Users\\preeti.tiwari\\Documents\\Files\\Directory1");
//	    System.out.println(isCreated);
//	    boolean isDeleteDir = directoryHandler.delete("C:\\Users\\preeti.tiwari\\Documents\\Files\\Directory1");
//	    System.out.println(isDeleteDir);
//	    List<String> list = directoryHandler.listSubDirectories("C:\\Users\\preeti.tiwari\\Documents\\Files");
//	    for(String str :list) {
//	    	System.out.println(str);
//	    }
	    List<String> listAll =  directoryHandler.listFilesAndSubDirectories("C:\\Users\\preeti.tiwari\\Documents\\Files");
	    for(String str: listAll) {
	    	System.out.println(str);
	    }
		
		//Test FileHonadlerImpl
//		FileHandler fileHandler = new FileHandlerImpl();
//		boolean result1 = fileHandler.isExists("C:\\Users\\preeti.tiwari\\Documents\\Files\\textfile.txt");
//		System.out.println(result1);
//		boolean isCreated1 = fileHandler.createIfNotExist("C:\\Users\\preeti.tiwari\\Documents\\Files\\newText.txt");
//		System.out.println(isCreated1);
//		boolean isDeleted = fileHandler.delete("C:\\Users\\preeti.tiwari\\Documents\\Files\\newText.txt");
//		System.out.println(isDeleted);
//		List<String> list1 = fileHandler.listFiles("C:\\Users\\preeti.tiwari\\Documents\\Files");
//		for(String str : list1) {
//			System.out.println(str);
//	    }
	}

}


