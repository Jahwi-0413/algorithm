package ws0819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//DFS와 BFS
public class BJ_1260 {
	
	static int N, M, V;
	static List<List<Integer>> adjList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		adjList = new ArrayList<>();
		
		for(int i=0; i<N+1; i++) {
			adjList.add(new ArrayList<>()); 
		}
		
		for(int i=0; i<M; i++) {
			input = br.readLine();
			st = new StringTokenizer(input, " ");
			
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjList.get(from).add(to);
			adjList.get(to).add(from);
		}
		
		for(int i=0; i<N+1; i++) {
			adjList.get(i).sort((o1, o2) -> o1 - o2); 
		}
		
		dfs(V, new boolean[N+1]);
		System.out.println();
		bfs(new boolean[N+1]);
		System.out.println();
	}
	
	static void dfs(int vertex, boolean[] visited) {
		visited[vertex] = true;
		System.out.print(vertex + " ");
		
		List<Integer> list = adjList.get(vertex);
		int size = list.size();
		
		for(int to : list) {
			if(visited[to])continue;
			dfs(to, visited);
		}
	}
	
	static void bfs(boolean[] visited) {
		Queue<Integer> que = new LinkedList<>();
		que.add(V);
		visited[V] = true;
		
		while(!que.isEmpty()) {
			int from = que.poll();
			System.out.print(from + " ");
			
			List<Integer> fromList = adjList.get(from);
			for(int to : fromList) {
				if(visited[to]) continue;
				que.offer(to);
				visited[to] = true;
			}
		}
	}
}
