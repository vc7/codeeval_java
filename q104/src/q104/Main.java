package q104;
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Main {

	public static List<String> numberList = new ArrayList<String>(){{
		add("zero");
		add("one");
		add("two");
		add("three");
		add("four");
		add("five");
		add("six");
		add("seven");
		add("eight");
		add("nine");
	}};

	public static void main(String[] args)
	{
		try {
			File file = new File(args[0]);
			Scanner sc = new Scanner(file);

			String line;

			while (sc.hasNextLine() && (line = sc.nextLine()) != null) {

				String regex = "[^;]+";

				LinkedList<String> resultList = find(regex, line);
				ListIterator<String> iterator = resultList.listIterator();

				while(iterator.hasNext())
				{
					System.out.print(iterator.next());
				}

				System.out.println();
			}
			sc.close();

		} catch (IOException e) {
			System.out.printf("File Read Error: " + e.getMessage());
		}
	}

	// Find results and add to result linked-list.

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
				list.add(convert(groupStr));
			}
			if(matcher.end() + 1 <= content.length()) {
				matchFound = matcher.find(matcher.end());
			}else{
				break;
			}
		}

		return list;
	}

	private static String convert(String source)
	{
		return String.valueOf(numberList.indexOf(source));
	}
}