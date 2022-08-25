import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//외판원 순회2
public class BJ_10971 {
	static int N;
	static int[][] cities;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		cities = new int[N][N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				cities[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited[0] = true;
		dfs(0, 0, 0, 0);	//모든 정점을 도는 mst는 어느 도시에서 시작하던지 모두 동일

		System.out.println(min);
	}

	public static void dfs(int start, int before, int cnt, int cost) {	//start 시작 정점, before 이전에 돌았던 지점
		if (before == start && cost > 0) {
			min = Math.min(min, cost);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (cities[before][i] == 0) continue;
			if (i == start && cnt == N-1) { // 출발지역은 visited가 true기 때문에
				cost += cities[before][i];
				dfs(start, i, cnt + 1, cost);
			}
			if (!visited[i]) {
				visited[i] = true;
				cost += cities[before][i];
				dfs(start, i, cnt + 1, cost);
				cost -= cities[before][i];
				visited[i] = false;
			}
		}
	}
}