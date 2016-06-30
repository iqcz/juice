package other;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadData {

	public static void main(String... args) throws IOException {
		System.out.println("Hello, java 8.");

		
		String readOne = processFile(reader -> reader.readLine());
		System.out.println(readOne);
		
		/*
		List<String> strList = new ArrayList<>();
		strList.add("one");
		strList.add("Two");
		strList.add("three");
		*/
		
		
		// System.out.println(filter(strList, (s) -> s.startsWith("o", 0)));
	}

	public static String processFile(BufferedReaderProcessor processor) {
		String result = "";
		try(BufferedReader reader = new BufferedReader(new FileReader("src/other/Apple.java"))) {
			result = processor.process(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	/*
	public static <T> List<T> filter(List<T> list, Predicate<T> p) {
		List<T> result = new ArrayList<>();
		for (T e : list) {
			if (p.test(e)) {
				result.add(e);
			}
		}
		return result;

	}
	*/
}
