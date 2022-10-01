import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//보물섬
public class BJ_2589 {
	static class Land {
		int r, c;

		public Land(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	static int R, C;
	static char[][] map;
	static int max = Integer.MIN_VALUE;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		Queue<Land> q = new LinkedList<>();

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'L')
					q.add(new Land(i, j));
			}
		}

		while (!q.isEmpty()) {
			bfs(q.poll());
		}

		bw.write(max + "");
		bw.flush();
		bw.close();
		br.close();
	}

	static void bfs(Land first) {
		Queue<Land> q = new LinkedList<>();
		q.add(first);
		boolean[][] visited = new boolean[R][C];
		visited[first.r][first.c] = true;

		int cnt = 0;

		while (!q.isEmpty()) {
			cnt++;
			for (int i = 0, size = q.size(); i < size; i++) {
				Land now = q.poll();

				for (int d = 0; d < 4; d++) {
					int nr = now.r + dr[d];
					int nc = now.c + dc[d];

					if (!isValidPosition(nr, nc) || visited[nr][nc] || map[nr][nc] == 'W')
						continue;
					visited[nr][nc] = true;
					q.add(new Land(nr, nc));
				}
			}
		} // end of while

		max = Math.max(max, cnt-1);
	}

	static boolean isValidPosition(int r, int c) {
		if (0 <= r && r < R && 0 <= c && c < C)
			return true;
		return false;
	}
}