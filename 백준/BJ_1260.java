package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//DFS와 BFS
public class BJ_1260 {
	static int N, M, V;
	static List<Integer>[] adjList;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V= Integer.parseInt(st.nextToken());		//시작 정점
		
		adjList = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {		//정점 입력
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjList[from].add(to);
			adjList[to].add(from);
		}
		
		for(int i=1; i<=N; i++) {		//적은 번호 먼저 탐색
			Collections.sort(adjList[i]);
		}
		
		visited = new boolean[N+1];
		dfs(V);
		System.out.println();
		
		visited = new boolean[N+1];
		bfs(V);
	}
	
	static void dfs(int v) {
		visited[v] = true;
		System.out.print(v + " ");
		
		for(int i=0, size=adjList[v].size(); i<size; i++) {
			int to = adjList[v].get(i);
			if(visited[to]) continue;
			dfs(to);
		}
	}
	static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		visited[v] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			System.out.print(now + " ");
			
			for(int i=0, size=adjList[now].size(); i<size; i++) {
				int to = adjList[now].get(i);
				if(visited[to]) continue;
				visited[to] = true;
				q.add(to);
			}
		}
	}
}
