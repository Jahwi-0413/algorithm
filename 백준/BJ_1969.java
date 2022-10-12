import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//DNA
public class BJ_1969 {
	static int N, M;
	static int[][] cnt;		//행-N, 열-A,C,G,T 카운트
	static char[][] dna;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=  new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		cnt = new int[M][4];
		dna = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			dna[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				char c = dna[i][j];
				
				switch(c) {
				case 'A' : cnt[j][0]++; break;
				case 'C' : cnt[j][1]++; break;
				case 'G' : cnt[j][2]++; break;
				case 'T' : cnt[j][3]++; break;
 				}
			}
		}
		
		int hammingDistance = 0;
		
		for(int i=0; i<M; i++) {
			int maxValue = cnt[i][0];
			int maxIndex = 0;
			
			for (int j = 1; j < 4; j++) {
				if(cnt[i][j] > maxValue) {
					maxValue = cnt[i][j];
					maxIndex = j;
				}
			}
			
			hammingDistance += N - cnt[i][maxIndex];
			
			switch(maxIndex) {
				case 0: bw.write('A'); break;
				case 1: bw.write('C'); break;
				case 2: bw.write('G'); break;
				case 3: bw.write('T'); break;
			}
		}
		
		bw.write("\n");
		bw.write(hammingDistance + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
