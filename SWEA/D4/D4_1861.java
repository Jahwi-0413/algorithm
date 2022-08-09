package ws0809;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//정사각형 방
public class D4_1861 {
	static int[][] map;
	static int maxCnt;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N;
	static int maxRoom;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			boolean[][] isChecked = new boolean[N][N];
			maxCnt = 0;
			maxRoom = Integer.MAX_VALUE;

			for (int r = 0; r < N; r++) {
				String[] row = br.readLine().split(" ");
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(row[c]);
				}
			}

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					isChecked[r][c] = true;
					getInRoom(r, c, 1, isChecked, map[r][c]);
					isChecked[r][c] = false;

				}
			}
			bw.write("#" + t + " " + maxRoom + " " + maxCnt + "\n");
		} // end of tc for
		bw.flush();
		bw.close();
	}

	static void getInRoom(int r, int c, int cnt, boolean[][] wentRoom, int index) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr >= 0 && nc >= 0 && nr < N && nc < N) { // 방의 범위 안에서만
				if (wentRoom[nr][nc])
					continue;
				int diff = map[r][c] - map[nr][nc];
				if (Math.abs(diff) != 1)
					continue;

				wentRoom[nr][nc] = true;
				getInRoom(nr, nc, cnt + 1, wentRoom, index);
				wentRoom[nr][nc] = false;
			}
		}
		if (maxCnt < cnt) {
			maxCnt = cnt;
			maxRoom = index;
		}
		else if (maxCnt == cnt) {
			if (maxRoom > index)
				maxRoom = index;
		}
	}
}

/*
2
2
1 2
3 4
3
9 3 4
6 1 5
7 8 2

#1 1 2
#2 3 3
 */