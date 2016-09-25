package graph;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Kruskal {

	private int[][] adjacency_list;
	private int find[];
	private HashMap<Integer, Set<Integer>> union;

	public Kruskal(int[][] adjacency_list) {
		this.adjacency_list = adjacency_list;
		find = new int[adjacency_list.length];
		union = new HashMap<>();

		for (int node = 0; node < adjacency_list.length; node++) {
			find[node] = node;
			union.put(node, new HashSet<Integer>());
		}

	}

	private int find(int node) {
		return find[node];
	}

	private void union(int node, int another_node) {
		(union.get(node)).addAll(union.get(another_node));
		find[another_node] = node;
	}

	public int constructMST() {

		List<Edge> edges = new LinkedList<Edge>();
		int cost = 0;

		for (int i = 0; i < adjacency_list.length; i++) {
			for (int j = 0; j < adjacency_list.length; j++)

				if (adjacency_list[i][j] > 0) {
					Edge edge = new Edge();
					edge.setCost(adjacency_list[i][j]);
					edge.setTo(j);
					edge.setFrom(i);

					edges.add(edge);

				}
		}

		Collections.sort(edges);

		for (Edge edge : edges) {
			if (find(edge.getTo()) != find(edge.getFrom())) {
				union(edge.getTo(), edge.getFrom());
				cost += edge.getCost();
				System.out.println("Adding " + edge.getCost());
			}
		}

		return cost;
	}

	class Edge implements Comparable<Edge> {
		private int from;
		private int to;
		private Integer cost;

		public int getFrom() {
			return from;
		}

		public void setFrom(int from) {
			this.from = from;
		}

		public int getTo() {
			return to;
		}

		public void setTo(int to) {
			this.to = to;
		}

		public Integer getCost() {
			return cost;
		}

		public void setCost(int cost) {
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return getCost().compareTo(o.getCost());
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int adjacency_list[][] = new int[n][n];
		for (int i = 0; i < adjacency_list.length; i++) {
			for (int j = 0; j < adjacency_list.length; j++)
				adjacency_list[i][j] = sc.nextInt();

		}

		Kruskal kruskal = new Kruskal(adjacency_list);
		System.out.println("The MST Cost is " + kruskal.constructMST());

	}

}
