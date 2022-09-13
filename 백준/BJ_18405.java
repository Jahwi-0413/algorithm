import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//경쟁적 전염
public class BJ_18405 {
	static class Virus implements Comparable<Virus>{
		int r, c, num;
		
		public Virus(int r, int c, int num) {
			super();
			this.r = r;
			this.c = c;
			this.num = num;
		}

		@Override
		public int compareTo(Virus o) {
			return this.num - o.num;
		}
	}
	static int N, K, S, X, Y;
	static int[][] map;
	static Queue<Virus> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		q = new LinkedList<>();
		
		List<Virus> virusList = new ArrayList<>();
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				int value = Integer.parseInt(st.nextToken());
				map[i][j] = value;
				
				if(value > 0) {
					virusList.add(new Virus(i, j, value));
				}
			}
		}
		
		Collections.sort(virusList);
		for(int i=0, size=virusList.size(); i<size; i++) {
			q.add(virusList.get(i));
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		S = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken())-1;
		Y = Integer.parseInt(st.nextToken())-1;
		
		bfs();
		
		bw.write(map[X][Y] + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void bfs() {
		int time = 0;
		int[] dr = {-1, 1, 0, 0};		//상 하 좌 우
		int[] dc = {0, 0, -1, 1};
		
		while(!q.isEmpty()) {
			if(time==S) return;
			
			for(int i=0,size=q.size(); i<size; i++) {
				Virus now = q.poll();
				
				for(int j=0; j<4; j++) {
					int nr = now.r + dr[j];
					int nc = now.c + dc[j];
					
					if(0<=nr && nr<N && 0<=nc && nc<N && map[nr][nc]==0) {
						map[nr][nc] = now.num;
						q.offer(new Virus(nr, nc, now.num));
					}
				}
			}
			time++;
		}
	}
}
