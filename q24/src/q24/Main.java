package q24;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try {
			File file = new File(args[0]);
			Scanner sc = new Scanner(file);

			String line;
			int result = 0;

			while (sc.hasNextLine() && (line = sc.nextLine()) != null) {
				
				result += Integer.parseInt(line);
				
			}
			
			System.out.println(result);
			
			sc.close();

		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
	}

}
