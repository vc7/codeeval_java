package q99;
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Main {
	public static void main(String[] args)
	{
		//		try {
		//	        File file = new File(args[0]);
		//	        Scanner sc = new Scanner(file);
		//	        
		//	    } catch (IOException e) {
		//	        System.out.println("File Read Error: " + e.getMessage());
		//	    }

		String text = "(25, 4) (1, -6)";
		String regex = "[^\\(,\\) \\(,\\)]+";
		
		LinkedList<String> resultList = find(regex, text);
		
		System.out.println(calculateDistance(resultList));
	}
	
	private static LinkedList<String> find(String regex, String content)
	{
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(content);

		boolean matchFound = matcher.find();
		LinkedList<String> list = new LinkedList<String>();

		while(matchFound)
		{
			for(int i = 0; i <= matcher.groupCount(); i++) {
				String groupStr = matcher.group(i);
				list.add(groupStr);
			}
			if(matcher.end() + 1 <= content.length()) {
				matchFound = matcher.find(matcher.end());
			}else{
				break;
			}
		}
		
		return list;
	}
	
	private static double calculateDistance(LinkedList<String> list)
	{
		return Math.sqrt(Math.pow((Integer.parseInt(list.get(2))) - (Integer.parseInt(list.get(0))),2) + Math.pow((Integer.parseInt(list.get(3))) - (Integer.parseInt(list.get(1))),2)); 
	}
}