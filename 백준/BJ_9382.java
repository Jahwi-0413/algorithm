import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//상근이의 여행 -> dfs, mst
public class BJ_9382 {
	static int N, M, cnt, res;
	static List<Integer>[] adjList;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0; t<tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			res = Integer.MAX_VALUE;

			adjList = new ArrayList[N+1];
			for(int i=1; i<=N; i++) {
				adjList[i] = new ArrayList<>();
			}
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				adjList[from].add(to);
				adjList[to].add(from);
			}

			for(int i=1; i<=N; i++) {
				visited = new boolean[N+1];
				cnt = 0;
				dfs(i);
				res = Math.min(res, cnt-1);
			}
			bw.write(cnt + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dfs(int v) {
		visited[v] = true;
		
		for(int i=0, size=adjList[v].size(); i<size; i++) {
			int to = adjList[v].get(i);
			if(visited[to]) continue;
			
			cnt++;
			dfs(to);
		}
	}
}
