package q22;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		try {
			File file = new File(args[0]);
			Scanner sc = new Scanner(file);

			String line;

			while (sc.hasNextLine() && (line = sc.nextLine()) != null) {
				
				System.out.println(fibonacci(Integer.parseInt(line)));
				
			}

			sc.close();

		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		
	}
	
	private static int fibonacci(int index)
	{
		switch(index){
			case 0:
				return 0;
				
			case 1:
				return 1;
				
			default:
				return fibonacci(index - 1) + fibonacci(index-2);
		}
	}

}
