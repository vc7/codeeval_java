package q31;
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Main {
	public static void main(String[] args) throws IOException
	{
		File file = new File(args[0]);
		Scanner sc = new Scanner(file);
		String line;

		while (sc.hasNextLine() && (line = sc.nextLine()) != null) {

			Pattern pattern = Pattern.compile("[^,]+");
			Matcher matcher = pattern.matcher(line);

			boolean matchFound = matcher.find();
			LinkedList<String> list = new LinkedList<String>();
			
			while(matchFound)
			{
				//System.out.println(matcher.start() + "-" + matcher.end());
				for(int i = 0; i <= matcher.groupCount(); i++) {
					String groupStr = matcher.group(i);
					list.push(groupStr);
				}
				if(matcher.end() + 1 <= line.length()) {
					matchFound = matcher.find(matcher.end());
				}else{
					break;
				}
			}
			
			String targetString = list.removeFirst();
			String mainString = list.removeFirst();
			
			// lastIndexOf will return -1 if not found
			int pointer = mainString.lastIndexOf(targetString);
			System.out.println(pointer);

		}
		sc.close();
	}
}