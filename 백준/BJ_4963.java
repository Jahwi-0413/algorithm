import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//섬의 개수
public class BJ_4963 {
	static int H, W;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
	static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();
		
		while(!input.equals("0 0")) {
			StringTokenizer st = new StringTokenizer(input, " ");
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			map = new int[H][W];
			visited = new boolean[H][W];
			
			for(int i=0; i<H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j=0; j<W; j++) {
					int value= Integer.parseInt(st.nextToken());
					map[i][j] = value;
				}
			}
			
			int res = 0;
			for(int i=0; i<H; i++) {
				for(int j=0; j<W; j++) {
					if(!visited[i][j] && map[i][j]==1) {		//아직 방문 안 한 섬만 bfs
						bfs(i, j);
						res++;
					}
				}
			}
			
			bw.write(res + "\n");
			input = br.readLine();		//0 0 나올때까지 받아야하므로
		}//end of while
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(c, r));
		visited[r][c] = true;
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			for(int i=0, size=dr.length; i<size; i++) {
				int nr = now.y + dr[i];
				int nc = now.x + dc[i];
				
				if(0>nr | nr>=H | 0>nc | nc>=W) continue;		//범위를 벗어나는곳
				if(visited[nr][nc] || map[nr][nc]==0) continue;	//이미 방문했거나 바다인 곳
				
				q.offer(new Point(nc, nr));
				visited[nr][nc] = true;
			}
		}//end of while
	}
}
