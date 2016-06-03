package com.interview.intterviewbit.dynamicprogram;

import java.util.List;

/**
 * Best Time to Buy and Sell Stocks IIBookmark
 * 
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many
 * transactions as you like (ie, buy one and sell one share of the stock
 * multiple times). However, you may not engage in multiple transactions at the
 * same time (ie, you must sell the stock before you buy again).
 * 
 * @author jojo
 *
 */
public class BuyAndSellStockII
{
	public int maxProfit(final List<Integer> a)
	{
		if (a.size() < 2)
		{
			return 0;
		}

		int profit = 0, buy = a.get(0);

		for (int i = 1; i < a.size(); i++)
		{
			if (buy < a.get(i))
			{
				profit += a.get(i) - buy;

			}

			buy = a.get(i);
		}

		return profit;
	}
}
