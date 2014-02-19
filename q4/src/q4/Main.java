package q4;

public class Main {

	public static void main(String[] args) {
		
		System.out.println(getLastPalindromePrime());

	}
	
	private static int getLastPalindromePrime()
	{
		int i = 0;
		int count = 0;
		int sum = 0;

		while(count < 1000)
		{
			if(checkPrime(i))
			{
				count++;
				sum += i;
			}
			
			i++;
		}
		
		return sum;
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
