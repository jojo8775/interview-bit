package com.interview.intterviewbit.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list
 * of its neighbors.
 *  @author jojo
 *
 */
public class CloneGraph
{
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode root)
	{
		Map<UndirectedGraphNode, UndirectedGraphNode> nodeMap = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		Queue<UndirectedGraphNode> nodeQueue = new LinkedList<UndirectedGraphNode>();
		nodeQueue.add(root);
		nodeMap.put(root, new UndirectedGraphNode(root.label));

		while (!nodeQueue.isEmpty())
		{
			UndirectedGraphNode node = nodeQueue.poll();
			UndirectedGraphNode cloneNode = nodeMap.get(node);

			for (UndirectedGraphNode neighbourNode : node.neighbors)
			{
				if (!nodeMap.containsKey(neighbourNode))
				{
					nodeMap.put(neighbourNode, new UndirectedGraphNode(neighbourNode.label));
					nodeQueue.add(neighbourNode);
				}

				cloneNode.neighbors.add(nodeMap.get(neighbourNode));
			}
		}

		return nodeMap.get(root);
	}

	private static class UndirectedGraphNode
	{
		int label;
		List<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x)
		{
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	}
}
