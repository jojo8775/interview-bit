package com.interview.intterviewbit.dynamicprogram;

/**
 * Given expression with operands and operators (OR , AND , XOR) , in how many
 * ways can you evaluate the expression to true, by grouping in different ways?
 * Operands are only true and false. Input: string : T|F&T^T here '|' will
 * represent or operator '&' will represent and operator '^' will represent xor
 * operator 'T' will represent true operand 'F' will false
 * 
 * Output: different ways % MOD where MOD = 1003
 * 
 * Example: string : T|F only 1 way (T|F) => T so output will be 1 % MOD = 1
 * 
 * @author jojo
 *
 */
public class EvaluateExpresstionToTrue
{
	private static final int MOD = 1003;

	public int cnttrue(String a)
	{
		// separate out T/F and operator
		// for a given expression length of T/F == length of operator + 1
		StringBuilder symbol = new StringBuilder(), operator = new StringBuilder();
		for (int i = 0; i < a.length(); i++)
		{
			if (a.charAt(i) == 'T' || a.charAt(i) == 'F')
			{
				symbol.append(a.charAt(i));
			}
			else
			{
				operator.append(a.charAt(i));
			}
		}

		return findCount(symbol.toString(), operator.toString());
	}

	private int findCount(String symbol, String operator)
	{
		int[][] t = new int[symbol.length()][symbol.length()];
		int[][] f = new int[symbol.length()][symbol.length()];

		// representing relative position of T and F for each row
		// so that later we can use this to represent T and F combination
		for (int i = 0; i < symbol.length(); i++)
		{
			if (symbol.charAt(i) == 'T')
			{
				t[i][i] = 1;
			}
			else
			{
				f[i][i] = 1;
			}
		}

		for (int gap = 1; gap < symbol.length(); gap++)
		{
			for (int i = 0, j = gap; j < symbol.length(); i++, j++)
			{
				for (int opIdx = 0; opIdx < gap; opIdx++)
				{
					int actualOpIdx = i + opIdx;

					// if operator is OR
					if (operator.charAt(actualOpIdx) == '|')
					{
						// T = T|T, T|F, F|F
						t[i][j] += t[i][actualOpIdx] * t[actualOpIdx + 1][j] + t[i][actualOpIdx] * f[actualOpIdx + 1][j]
								+ f[i][actualOpIdx] * t[actualOpIdx + 1][j];
						// F = F|F
						f[i][j] += f[i][actualOpIdx] * f[actualOpIdx + 1][j];
					}
					// if operator is AND
					else if (operator.charAt(actualOpIdx) == '&')
					{
						// T = T|T
						t[i][j] += t[i][actualOpIdx] * t[actualOpIdx + 1][j];

						// F = F|F, F|T, T|F
						f[i][j] += f[i][actualOpIdx] * f[actualOpIdx + 1][j] + f[i][actualOpIdx] * t[actualOpIdx + 1][j]
								+ t[i][actualOpIdx] * f[actualOpIdx + 1][j];
					}
					// if operator is XOR
					else if (operator.charAt(actualOpIdx) == '^')
					{
						// T = T|F, F|T
						t[i][j] += t[i][actualOpIdx] * f[actualOpIdx + 1][j]
								+ f[i][actualOpIdx] * t[actualOpIdx + 1][j];

						// F = F|F, T|T
						f[i][j] += f[i][actualOpIdx] * f[actualOpIdx + 1][j]
								+ t[i][actualOpIdx] * t[actualOpIdx + 1][j];
					}

					t[i][j] %= MOD;
					f[i][j] %= MOD;
				}
			}
		}

		return t[0][symbol.length() - 1] % MOD;
	}
}
