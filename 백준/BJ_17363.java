import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//우유가 넘어지면?
public class BJ_17363 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		for(int i=M-1; i>=0; i--) {
			for(int j=0; j<N; j++) {
				char c = '.';
				
				switch(map[j][i]) {
					case 79  : c = 79; break;
					case 124 : c = 45; break;
					case 45  : c = 124; break;
					case 92  : c = 47; break;
					case 47  : c = 92; break;
					case 62  : c = 94; break;
					case 94  : c = 60; break;
					case 60  : c = 118; break;
					case 118 : c = 62; break;
				}
				bw.write(c);
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
