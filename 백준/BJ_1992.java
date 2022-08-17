import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//쿼드트리
public class BJ_1992 {
	static int N;
	static int[][] map;
	static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			char[] input = br.readLine().toCharArray();
			for(int j=0; j<N; j++) {
				map[i][j] = input[j] - '0';
			}
		}
		
		sb = new StringBuilder();
		makeQuardTree(0, 0, N);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	private static void makeQuardTree(int r, int c, int size) {
		if(isPossible(r, c, size)) {
			sb.append(map[r][c]);		//압축 결과 더하기
			return;
		}
		
		sb.append('(');
		int half = size / 2;
		
		makeQuardTree(r, c, half);	//윈쪽 위
		makeQuardTree(r, c+half, half);		//오른쪽 위
		makeQuardTree(r+half, c, half);
		makeQuardTree(r+half, c+half, half);
		sb.append(')');
	}
	private static boolean isPossible(int r, int c, int size) {
		int first = map[r][c];
		
		for(int i=r; i<r+size; i++) {
			for(int j=c; j<c+size; j++) {
				if(first!=map[i][j]) {
					return false;			//압축 불가
				}
			}
		}
		return true;	//압축 가능
	}
}
