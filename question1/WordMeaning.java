package co.AssessmentsQuestions.question1;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class WordMeaning {

	public static void doesFileExist(String filepath) throws IOException {
		List<String> lines;
		File file = new File(filepath);
		if (file.exists()) {
			System.out.println("File exist");
			Path path = Paths.get(filepath);
			lines = Files.readAllLines(path, Charset.defaultCharset());

			for(String line : lines) {
				String [] lineArry = line.split("–");
				System.out.println(lineArry[0]);
				String [] meaningArry = lineArry[1].split(",");
				for(int i=0 ; i< meaningArry.length ; i++) {
					System.out.println(meaningArry[i].trim());
				}
			}
		} else {
			System.out.println("file does not exist");
		}
	}

	public static void main(String[] args) {
		String filepath = "C:\\Users\\JohnSonia\\eclipse-workspace\\AssessmentQuestions\\src\\co\\AssessmentsQuestions\\question1\\WordMeaning.txt";
		try {
			doesFileExist(filepath);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
