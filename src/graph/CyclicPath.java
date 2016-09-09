package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class CyclicPath {
	private Map<Integer, LinkedList<Integer>> adjacency_list;
	private static final Integer INFINITY = -999;
	private LinkedList<Integer> indegreeList;
	private Queue<Integer> queue;
	private Stack<Integer> stack;
	private int number_of_nodes;

	public CyclicPath(int number_of_nodes) {
		adjacency_list = new HashMap<Integer, LinkedList<Integer>>();
		indegreeList = new LinkedList<Integer>();
		queue = new LinkedList<Integer>();
		stack = new Stack<Integer>();
		this.number_of_nodes = number_of_nodes;

	}

	public void addEdge(int source, int destination) {
		LinkedList<Integer> edgeList = adjacency_list.get(source);

		if (edgeList == null) {

			LinkedList<Integer> list = new LinkedList<Integer>();
			if (destination != INFINITY)
				list.add(destination);

			adjacency_list.put(source, list);
		} else {
			if (destination != INFINITY)
				(adjacency_list.get(source)).add(destination);
		}
	}

	private void constructIndegree() {
		int indegree = 0;
		for (Integer vertex : adjacency_list.keySet()) {
			indegree = 0;
			// System.out.println("the vertex is " + vertex);

			for (Integer key : adjacency_list.keySet())
				if ((adjacency_list.get(key)).contains(vertex))
					indegree++;

			indegreeList.set(vertex, indegree);
		}
	}

	private Set<Integer> retrieveZeroIndegreeVertex() {
		Set<Integer> zeroIndegreeSet = new HashSet<Integer>();

		for (int vertex = 0; vertex < indegreeList.size(); vertex++)
			if (indegreeList.get(vertex).equals(0))
				zeroIndegreeSet.add(vertex);

		return zeroIndegreeSet;
	}

	public void findCyclicPath(int source) {

		boolean visited[] = new boolean[number_of_nodes];
		int parent[] = new int[number_of_nodes];

		stack.push(source);
		visited[source] = true;
		parent[source] = source;
		int element = source;
		boolean traversedAll = true;

		while (!stack.isEmpty()) {
			element = stack.peek();

			List<Integer> edgeNode = adjacency_list.get(element);
			traversedAll = true;

			for (Integer node : edgeNode) {
				if (!visited[node]) {
					stack.push(node);
					visited[node] = true;
					parent[node] = element;

					// remove the undirected edge.
					(adjacency_list.get(node)).remove((Integer) element);

					element = node;
					traversedAll = false;
					break;
				} else if (visited[node]) {
					System.out.println("The graph contains an cycle");

					System.out.println(node);
					node = element;
					while (node != source) {
						System.out.println(node);
						node = parent[node];
					}
					System.out.println(source);

					return;
				}
			}

			if (traversedAll) {
				stack.pop();
			}
		}

	}

	public static void main(String[] arg) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter number of nodes");

		int number_of_nodes = scanner.nextInt();
		CyclicPath cyclicPath = new CyclicPath(number_of_nodes);

		int source = 0, destination = 0;

		System.out.println("Enter the graph :<format> source destination");
		while (true) {
			source = scanner.nextInt();
			destination = scanner.nextInt();

			if (source == -999 && destination == -999)
				break;

			cyclicPath.addEdge(source, destination);
		}

		cyclicPath.findCyclicPath(4);
		System.out.println();
	}

}
