package input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TextInput {
	private static ArrayList<String> inputData = new ArrayList<String>();
	
	public static boolean ReadFile(String fileName) {
		Path p = Paths.get(fileName);
		List<String> list;
		try {
			list = Files.readAllLines(p);
			inputData.addAll(list);
		}
		catch(IOException e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	public static ArrayList<String> getInputData() {
		return inputData;
	}
	
	//Regex from: https://stackoverflow.com/questions/
		//7384791/splitting-strings-through-regular
			//-expressions-by-punctuation-and-whitespace-etc
	public static ArrayList<String> cutAndFormat() {
		ArrayList<String> listBuffer = new ArrayList<String>();
		String[] arrayBuffer;
		for(String s: inputData) {
			arrayBuffer = s.split("[\\p{Punct}\\s]+");
			for(int i = 0; i <arrayBuffer.length; i++) {
				arrayBuffer[i].toUpperCase();
				listBuffer.add(arrayBuffer[i]);
			}
		}
		return listBuffer;
	}
}
