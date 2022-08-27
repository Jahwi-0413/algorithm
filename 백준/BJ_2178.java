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

//미로 탐색
public class BJ_2178 {
	static class Point {
		int r, c, value;

		public Point(int r, int c, int value) {
			super();
			this.r = r;
			this.c = c;
			this.value = value;
		}
	}

	static int N, M, res = 0;
	static Point[][] map;
	static boolean[][] visited;

	static int[] dr = { -1, 0, 1, 0 }; // 상우하좌
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new Point[N + 1][M + 1];
		visited = new boolean[N + 1][M + 1];

		for (int i = 1; i <= N; i++) { // 맵 입력
			char[] input = br.readLine().toCharArray();
			for (int j = 1; j <= M; j++) {
				int c = input[j - 1] - '0';
				map[i][j] = new Point(i, j, c);
			}
		}
		visited[1][1] = true;
		bfs(1, 1);
		bw.write(res + "");
		bw.flush();
		bw.close();
		br.close();
	}

	static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.add(map[r][c]);

		while (!q.isEmpty()) {
			res++;				//레벨 탐색
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Point now = q.poll();
				if(now.r==N && now.c==M) {
					return;
				}
				for (int j = 0; j < 4; j++) {
					int nr = now.r + dr[j];
					int nc = now.c + dc[j];

					if (1 <= nr && nr <= N && 1 <= nc && nc <= M && map[nr][nc].value == 1) {
						if (visited[nr][nc] || map[nr][nc].value == 0) continue;
							q.add(map[nr][nc]);
							visited[nr][nc] = true;
					}
				}
			}
		} // end of while
	}
}
