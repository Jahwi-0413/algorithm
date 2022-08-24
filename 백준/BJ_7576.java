import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int r, c;

	public Point(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}

//토마토
public class BJ_7576 {
	static int N, M;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 }; // 상우하좌
	static int[] dc = { 0, 1, 0, -1 };
	static int days;
	static Queue<Point> que = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		
		boolean allDone = true;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int value = Integer.parseInt(st.nextToken());

				map[i][j] = value;
				if (value == 1) {
					que.add(new Point(i, j));
					continue;
				}
				allDone = false;
			}
		}

		if(allDone) {
			System.out.println(0);
			return;
		}
		bfs();

		boolean check = checkTomato();
		if (!check) { // 덜 익은게 있음
			System.out.println(-1);
			return;
		}
		System.out.println(days - 1);

	}

	static void bfs() {
		while (!que.isEmpty()) {
			days++;
			for (int j = 0, size = que.size(); j < size; j++) { // 단계별 탐색
				Point poll = que.poll();

				for (int d = 0; d < 4; d++) { // 다음 단계가 될 토마토들을 골라서 넣음
					int nr = poll.r + dr[d];
					int nc = poll.c + dc[d];

					if (nr >= 0 && nc >= 0 && nr < M && nc < N && map[nr][nc] == 0) {
						map[nr][nc] = 1;
						que.add(new Point(nr, nc));
					}
				}
			}
		} // end of while
	}

	static boolean checkTomato() {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				int value = map[i][j];
				if (value == 0)
					return false; // 덜 익은게 있음
			}
		}
		return true; // 다 익음
	}
}