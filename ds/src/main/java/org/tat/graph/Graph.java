package org.tat.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {
	private int size;
	private LinkedList<Integer> adj[];

	public Graph(int size) {
		this.size = size;
		adj = new LinkedList[size];
		for (int i = 0; i < size; i++) {
			adj[i] = new LinkedList<Integer>();
		}
	}

	public void addEdge(int vertex, Integer edge) {
		adj[vertex].add(edge);
	}

	public void BFT(int s) {
		// Mart all the vertex not visited(by default)
		boolean visited[] = new boolean[this.size];

		// Create a queue for BFS
		LinkedList<Integer> queue = new LinkedList<>();

		// Mark the current vertex as visited and enque it
		visited[s] = true;

		queue.add(s);

		while (queue.size() != 0) {
			// dqueue a vertex from the queue and print it
			s = queue.poll();
			System.out.print(s + " ");

			// get all the adjacent vertices of dequed vertex s
			// if adjacent has not been visited, mark it and enqueue it
			Iterator<Integer> i = adj[s].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}

		}
	}

	// A function used by DFS
	void DFSUtil(int v, boolean visited[]) {
		// Mark the current node as visited and print it
		visited[v] = true;
		System.out.print(v + " ");

		// Recur for all the vertices adjacent to this vertex
		Iterator<Integer> i = adj[v].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n])
				DFSUtil(n, visited);
		}
	}

	// The function to do DFS traversal. It uses recursive DFSUtil()
	void DFS(int v) {
		// Mark all the vertices as not visited(set as
		// false by default in java)
		boolean visited[] = new boolean[size];

		// Call the recursive helper function to print DFS traversal
		DFSUtil(v, visited);
	}

	public static void main(String args[]) {
		Graph g = new Graph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal "
				+ "(starting from vertex 2)");

		g.BFT(2);

		System.out.println();

		System.out.println("Following is Depth First Traversal "
				+ "(starting from vertex 2)");

		g.DFS(2);
	}
}
