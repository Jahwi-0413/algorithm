import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//기상캐스터
public class BJ_10709 {
	
	static class Cloud{
		int r,c;

		public Cloud(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	static int H,W;
	static int[][] map;
	static boolean[][] clouded;
	static Queue<Cloud> clouds;
	
	static int dc = 1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		clouded = new boolean[H][W];
		clouds = new LinkedList<>();
		
		for(int i=0; i<H; i++) {
			char[] input = br.readLine().toCharArray();
			
			for(int j=0; j<W; j++) {
				if(input[j]=='c') {
					map[i][j] = 0;
					clouded[i][j] = true;
					clouds.add(new Cloud(i, j));
				}
				else map[i][j] = -1;
			}
		}
		
		int time=0;
		while(!clouds.isEmpty()) {
			time++;
			for(int i=0, size=clouds.size(); i<size; i++) {
				Cloud now = clouds.poll();
				
				int nr = now.r;
				int nc = now.c + dc;
				if(nc >= W || clouded[nr][nc] || map[nr][nc]>=0) continue;
				clouded[now.r][now.c] = false;
				clouded[nr][nc] = true;
				map[nr][nc] = time;
				clouds.add(new Cloud(nr, nc));
			}
		}
		
		
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				bw.write(map[i][j] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
		
	}
}
