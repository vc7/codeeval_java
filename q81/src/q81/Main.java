package q81;

import java.util.*;

public class Main {
	
	static int flag = 0;
	static int chosen = 4;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] stringArray = new String[]{"A","B","C","D","E","F"};
		
		fix(stringArray, 0, 0);
	}
	
	private static void fix(String[] array, int startIndex, int flag)
	{
		for(int i = flag; i <= array.length - chosen; i++)
		{
			choose(array, i);
			System.out.println();
		}
	}
	
	private static void choose(String[] array, int currentIndex)
	{
		if(flag < chosen && currentIndex < array.length )
		{
			flag ++;
			System.out.print("{"+array[currentIndex]+"},");
			choose(array, currentIndex+1);
		}
		else
		{
			flag = 0;
			System.out.println();
			
		}
	}

}
