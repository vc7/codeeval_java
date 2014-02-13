package q67;
import java.io.*;
import java.util.*;
 
public class Main {
        public static void main(String[] args) throws IOException
        {
                File file = new File(args[0]);
                Scanner sc = new Scanner(file);
                String line;

                while (sc.hasNextLine() && (line = sc.nextLine()) != null) {
                	
                	System.out.println(Integer.parseInt(line, 16));
                	
                }
                sc.close();
        }
 
}