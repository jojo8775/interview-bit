package com.interview.intterviewbit.string;

public class AtoI
{
	public int covert(String a)
	{
		String s = a.trim();
		if (s.isEmpty())
		{
			return 0;
		}

		int count = 0;
		char flag = '+';
		if (s.charAt(0) == '-')
		{
			flag = '-';
			count++;
		} else if (s.charAt(0) == '+')
		{
			flag = '+';
			count++;
		}

		long result = 0;
		while (count < s.length())
		{
			char ch = s.charAt(count);
			if (ch >= '0' && ch <= '9')
			{
				result = result * 10 + (ch - '0');
				System.out.println(result);
				// Checking if there is an overflow;
				if (result < 0)
				{
					result = Integer.MAX_VALUE;
					result++; 
					break;
				}
			} else
			{
				break;
			}
			count++;
		}

		if (flag == '-')
		{
			result *= -1;
		}

		if (result < Integer.MIN_VALUE)
		{
			return Integer.MIN_VALUE;
		} else if (result > Integer.MAX_VALUE)
		{
			return Integer.MAX_VALUE;
		}

		return (int) result;
	}
	
	public static void main(String[] args){
		new AtoI().covert("-999999999999999999999 4 54");
	}
	// -54332872018247709407 4 54
}
