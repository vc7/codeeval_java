package q91;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
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

				sorting("[^ ]+",line);
				
			}

			sc.close();

		} catch (IOException e) {
			System.out.println("File Read Error: " + e.getMessage());
		}
		
	}
	
	private static void sorting(String regex, String content)
	{
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(content);

		boolean matchFound = matcher.find();
		LinkedList<Double> list = new LinkedList<Double>();

		while(matchFound)
		{
			for(int i = 0; i <= matcher.groupCount(); i++) {
				String groupStr = matcher.group(i);
				list.add(Double.valueOf(groupStr));
			}
			if(matcher.end() + 1 <= content.length()) {
				matchFound = matcher.find(matcher.end());
			}else{
				break;
			}
		}
		
		double[] resultArray = new double[list.size()];
		int i = 0; 
		
		for(Double d : list)
		{
			resultArray[i++] = d.doubleValue();
		}
		
		Arrays.sort(resultArray);
		i = 0;
		
		for(double d : resultArray)
		{
			i++;
			
			if(i == resultArray.length)
			{
				System.out.print(d);
			}
			else
			{
				System.out.print(d+" ");
			}
		}
		
		System.out.println();

	}

}
