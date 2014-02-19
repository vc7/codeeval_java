package q18;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	
	public static void main(String[] args) {
		
		try {
			File file = new File(args[0]);
			Scanner sc = new Scanner(file);

			String line;

			while (sc.hasNextLine() && (line = sc.nextLine()) != null) {
				
				int[] numbersArray = findNumber("[^,]+", line);
				
				printResult(numbersArray[1], numbersArray[0]);
				
			}

			sc.close();

		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		
	}
	
	public static void printResult(int original, int target)
	{
		int times = 0;
		int tmpResult = 0;
		
		do
		{
			times ++;
			tmpResult = original * times;
		} while(tmpResult < target);
		
		System.out.println(tmpResult);
	}
	
	private static int[] findNumber(String regex, String content)
	{
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(content);

		boolean matchFound = matcher.find();
		LinkedList<Integer> list = new LinkedList<Integer>();

		while(matchFound)
		{
			for(int i = 0; i <= matcher.groupCount(); i++) {
				String groupStr = matcher.group(i);
				list.add(Integer.parseInt(groupStr));
			}
			if(matcher.end() + 1 <= content.length()) {
				matchFound = matcher.find(matcher.end());
			}else{
				break;
			}
		}
		
		return new int[]{list.getFirst(),list.getLast()};
		
	}

}
