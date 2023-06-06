import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//탈출
public class BJ_3055 {
	static class Point {
		int r, c;
		boolean isWater;

		public Point(int r, int c, boolean isWater) {
			super();
			this.r = r;
			this.c = c;
			this.isWater = isWater;
		}
	}

	static int R, C;
	static char[][] map;
	static Point S;
	static Queue<Point> q;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		q = new LinkedList<>();

		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'S') {
					S = new Point(i, j, false);
				} else if (map[i][j] == '*') {
					q.add(new Point(i, j, true));
				}
			}
		} // end of input

		int result = bfs();

		if (result == -1) {
			bw.write("KAKTUS");
		} else {
			bw.write(result + "");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	static int bfs() {
		q.add(S);

		int cnt = 0;
		while (!q.isEmpty()) {
			for (int i = 0, size = q.size(); i < size; i++) {
				Point now = q.poll();

				for (int d = 0; d < 4; d++) {
					int nr = now.r + dr[d];
					int nc = now.c + dc[d];

					if (!isValidPosition(nr, nc))
						continue;

					if (now.isWater) { // 물이 퍼지는 경우
						if (map[nr][nc] == 'D' || map[nr][nc] == 'X' || map[nr][nc]=='*') continue;
						map[nr][nc] = '*';
						q.add(new Point(nr, nc, true));
						continue;
					}

					// 고슴도치가 이동하는 경우
					if (map[nr][nc] == '*' || map[nr][nc] == 'X' || map[nr][nc]=='-')
						continue;
					if (map[nr][nc] == 'D')
						return cnt + 1;
					map[nr][nc] = '-';
					q.add(new Point(nr, nc, false));
				}
			}
			cnt++;
		} // end of while
		return -1;
	}

	static boolean isValidPosition(int r, int c) {
		return 0 <= r && r < R && 0 <= c && c < C;
	}
}
