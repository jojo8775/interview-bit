package com.interview.intterviewbit.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Given any source point and destination point on a chess board, we need to
 * find whether Knight can move to the destination or not.
 * 
 * @author jojo
 *
 */
public class KnightOnChessBoard
{
	int[] dx = { -2, -1, -2, -1, 1, 2, 1, 2 };
	int[] dy = { -1, -2, 1, 2, -2, -1, 2, 1 };

	public int moves(int M, int N, int x1, int y1, int x2, int y2)
	{
		Map<int[], Integer> visited = new HashMap<int[], Integer>();
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] { x1, y1 });
		visited.put(queue.peek(), 0);

		while (!queue.isEmpty())
		{
			int[] point = queue.poll();

			if (point[0] == x2 && point[1] == y2)
			{
				return visited.get(point);
			}

			int px = point[0], py = point[1];

			for (int i = 0; i < 8; i++)
			{
				if (isValid(px + dx[i], py + dy[i], M, N))
				{
					int[] pos = new int[] { px + dx[i], py + dy[i] };
					if (!visited.containsKey(pos))
					{
						visited.put(pos, visited.get(point) + 1);
						queue.add(pos);
					}
				}
			}
		}

		return -1;
	}

	private boolean isValid(int x, int y, int m, int n)
	{
		if (x <= 0 || y <= 0 || x > n || y > m)
		{
			return false;
		}

		return true;
	}

	public static void main(String[] args)
	{
		int result = new KnightOnChessBoard().moves(2, 20, 1, 18, 1, 5);
		System.out.println(result);
	}
}
