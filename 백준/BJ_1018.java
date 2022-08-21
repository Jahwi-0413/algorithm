import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//체스판 다시 칠하기
public class BJ_1018 {
	static int N;
	static int M;
	static char[][] map;
	static int minResult = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		
		 N = Integer.parseInt(st.nextToken());
		 M = Integer.parseInt(st.nextToken());
		
		map = new char[N][N];
		
		for(int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i=0; i<=N-8; i++) {
			for(int j=0; j<=M-8; j++) {
				checkMap(i, j, 'W');
				checkMap(i, j, 'B');
			}
		}
		
		bw.write(minResult + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void checkMap(int r, int c, char first) {
		char second = first=='W' ? 'B' : 'W';
		
		int cnt = 0;
		int toggle = 0;
		
		for(int i=r; i<r+8; i+=2) {		//시작  r, c에서 짝수 행만 체크 -> 똑같은 형태가 반복되는 행만 체크
			toggle = 0;
			for(int j=c; j<c+8; j++) {
				if(toggle%2==0) {
					if(map[i][j]!=first)
						cnt++;
				}
				else {
					if(map[i][j]!=second)
						cnt++;
				}
				toggle++;
			}
		}
		for(int i=r+1; i<r+8; i+=2) {	//시작  r,c에서 홀수 행만 체크
			toggle = 0;
			for(int j=c; j<c+8; j++) {
				if(toggle%2==0) {
					if(map[i][j]!=second)
						cnt++;
				}
				else {
					if(map[i][j]!=first)
						cnt++;
				}
				
				toggle++;
			}
		}
		
		minResult = Math.min(cnt, minResult);
	}
}
