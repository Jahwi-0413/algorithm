import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//창용 마을 무리의 개수
public class D4_7465 {
	static int N, M;

	static int[] parents;
	
	static void make() {
		parents = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		if(parents[a]==a) return a;
		
		parents[a] = find(parents[a]);
		return parents[a];
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot==bRoot) return false;
		parents[bRoot] = aRoot;
		return true;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			make();
			
			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				union(a,b);
			}
			
			for(int i=1; i<=N; i++) {	//제대로 업데이트 되지 않은 것들을 업데이트
				find(i);
			}
			
			Arrays.sort(parents);
			int current = parents[1];
			int result = 1;
			for(int i=1; i<=N; i++) {
				if(current!=parents[i]) {
					result++;
					current = parents[i];
				}
			}
			
			bw.write("#" + t + " " + result + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
