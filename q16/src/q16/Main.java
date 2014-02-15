package q16;

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

				System.out.println(countOfOne(line));

			}

			sc.close();

		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}

	}
	
	private static int countOfOne(String content)
	{
		String str = Integer.toBinaryString(Integer.parseInt(content));
		String findStr = "1";
		int lastIndex = 0;
		int count =0;

		while(lastIndex != -1){

		       lastIndex = str.indexOf(findStr,lastIndex);

		       if( lastIndex != -1){
		             count ++;
		             lastIndex+=findStr.length();
		      }
		}
		
		return count;
	}

}
