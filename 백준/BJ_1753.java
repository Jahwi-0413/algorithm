import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//최단경로
public class BJ_1753 {
	static class Edge implements Comparable<Edge> {
		int to, weight;

		public Edge(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

	static int V, E, start;
	static ArrayList<Edge>[] adjList;
	static int[] D;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		start = Integer.parseInt(br.readLine());
		adjList = new ArrayList[V + 1];

		for (int i = 1; i <= V; i++)
			adjList[i] = new ArrayList<>();

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			adjList[from].add(new Edge(to, weight));
		}

		dijkstra();
		for(int j=1; j<=V; j++) {
			if(D[j]!=Integer.MAX_VALUE) {
				System.out.println(D[j]);
				continue;
			}
			System.out.println("INF");
		}
	}

	static void dijkstra() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(start, 0));
		D = new int[V + 1];
		Arrays.fill(D, Integer.MAX_VALUE);
		D[start] = 0;
		visited = new boolean[V+1];

		while (!pq.isEmpty()) {
			Edge tmp = pq.poll();
			int d = tmp.to;

			if (visited[d]) continue;
			visited[d] = true;
			
			for (Edge edge : adjList[d]) {
				if (D[edge.to] >= D[d] + edge.weight) {
					D[edge.to] = D[d] + edge.weight;
					pq.add(new Edge(edge.to, D[edge.to]));
				}
			}
		}
	}
}
