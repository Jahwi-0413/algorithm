import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//상범 빌딩
public class BJ_6593 {
	static class Point{
		int z, r, c;

		
		public Point(int z, int r, int c) {
			super();
			this.z = z;
			this.r = r;
			this.c = c;
		}
	}
	static int L, R, C, cnt;		//z, y, x
	static char map[][][];
	static boolean visited[][][];
	
	static int[] dr = {0, 0, 1, -1, 0, 0};	//동서남북상하
	static int[] dc = {1, -1, 0, 0, 0, 0};
	static int[] dz = {0, 0, 0, 0, -1, 1};
	
	static Point start, end;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		while(!input.equals("0 0 0")) {
			StringTokenizer st = new StringTokenizer(input, " ");
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			cnt = 0;
			
			map = new char[L][R][C];
			visited = new boolean[L][R][C];
			
			for(int l=0; l<L; l++) {
				for (int r = 0; r < R; r++) {
					map[l][r] = br.readLine().toCharArray();
					for (int c = 0; c < C; c++) {
						if(map[l][r][c]=='#') {
							visited[l][r][c] = true;
						} 
						if(map[l][r][c]=='S') {
							start = new Point(l, r, c);
						}
						else if(map[l][r][c]=='E') {
							end = new Point(l, r, c);
						}
					}
				}
				br.readLine();
			}//end of input
			
			if(bfs()) {		//탈출 성공
				sb.append(String.format("Escaped in %d minute(s).\n", cnt));
			}
			else {
				sb.append("Trapped!\n");
			}
			input = br.readLine();
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static boolean bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(start);
		visited[start.z][start.r][start.c] = true;
		
		while(!q.isEmpty()) {
			cnt++;
			for (int i = 0, size=q.size(); i < size; i++) {
				Point now = q.poll();
				
				for(int d=0; d<6; d++) {
					int nz = now.z + dz[d];
					int nr = now.r + dr[d];
					int nc = now.c + dc[d];
					
					if(isValidPosition(nz, nr, nc) && !visited[nz][nr][nc]) {
						if(nz==end.z && nr==end.r && nc==end.c) {		//E에 도착
							return true;
						}
						q.add(new Point(nz, nr, nc));
						visited[nz][nr][nc] = true;
					}
				}
			}
		}//end of while
		
		return false;
	}

	static boolean isValidPosition(int z, int r, int c) {
		return 0<=z && z<L && 0<=r && r<R && 0<=c && c<C; 
	}
}
