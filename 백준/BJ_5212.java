import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

//지구 온난화
public class BJ_5212 {
	static class Point {
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	static Deque<Point> deq = new ArrayDeque<>();
	static int R, C;
	static char[][] map;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			char[] arr = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				char c = arr[j];
				map[i][j] = c;
				if (c == 'X') {
					deq.addLast(new Point(i, j));
				}
			}
		}

		for (int i = 0, size = deq.size(); i < size; i++) {
			Point now = deq.pollFirst();
			int cnt = 0;

			for (int d = 0; d < 4; d++) {
				int nr = now.r + dr[d];
				int nc = now.c + dc[d];

				if (0 <= nr && nr < R && 0 <= nc && nc < C) {
					if (map[nr][nc] == '.')
						cnt++;
				}
				else cnt++;
			}
			if (cnt >= 3)
				map[now.r][now.c] = '-';
			else
				deq.addLast(now);
		}
		
		List<Point> list = new ArrayList<>(deq);
		
		int minR=R, maxR=0, minC=C, maxC=0;
		for(int i=0, size=list.size(); i<size; i++) {
			Point now = list.get(i);
			minR = Math.min(now.r, minR);
			maxR = Math.max(now.r, maxR);
			minC = Math.min(now.c, minC);
			maxC = Math.max(now.c, maxC);
		}
		
		for(int i=minR; i<=maxR; i++) {
			for(int j=minC; j<=maxC; j++) {
				char c = map[i][j];
				if(c=='-') {
					bw.write('.');
				}
				else {
					bw.write(c);
				}
			}
			bw.write("\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
