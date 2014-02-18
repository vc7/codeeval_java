package q3;

public class Main_2 {

	public static void main(String[] args) {
		
		System.out.println(getLastPalindromePrime());
		
	}
	
	private static int getLastPalindromePrime()
	{
		int i = 1000;
		int target = 0;

		while(i >= 0)
		{
			if(checkPrime(i) && checkPalindrome(i))
			{
				target = i;
				break;
			}
			
			i--;
		}
		
		return target;
	}
	
	private static boolean checkPalindrome(int number)
	{
		if (number == 11 || (number / 100 >= 1 && number / 100 == number % 10))
		{
			return true;
		}

		return false;
	}
	
	private static boolean checkPrime(int number)
	{
		if (number <= 1) return false;
		
		for (int i = 2; i*i <= number; i ++)
		{
			if (number % i == 0) return false;
		}
		
		return true;
	}
}
