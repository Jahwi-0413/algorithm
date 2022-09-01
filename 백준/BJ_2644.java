import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//촌수 계산
public class BJ_2644 {
	static int N, X, Y, M, res;
	static List<Integer>[] adjList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		adjList = new ArrayList[N+1];
		
		for(int i=1; i<=N; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(br.readLine());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			adjList[from].add(to);
			adjList[to].add(from);
		}
		if(bfs()) {
			bw.write(res-1 + "");
		}
		else {
			bw.write(-1 + "");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	static boolean bfs() {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		q.add(X);
		
		while(!q.isEmpty()) {
			res++;
			for(int i=0, qSize=q.size(); i<qSize; i++) {		//초기 q size를 다 도는것이 한 레벨
				int now = q.poll();
				visited[now] = true;
				if(now==Y) return true;
				
				for(int j=0, size=adjList[now].size(); j<size; j++) {		//한 레벨
					int to = adjList[now].get(j);
					if(visited[to]) continue;
					q.add(to);
				}
			}
		}
		return false;
	}
}
