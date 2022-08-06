import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//농작물 수확하기
public class D3_2805 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int tc = Integer.parseInt(br.readLine());
		for(int t=1; t<=tc; t++) {
			int N =  Integer.parseInt(br.readLine());
			int[][] farm = new int[N][N];
			
			for(int i=0; i<N; i++) {		//배열 입력받기
				char[] tmp = br.readLine().toCharArray();
				for(int j=0; j<N; j++) {
					farm[i][j] = tmp[j] - '0';
				}
			}
			
			int sum = 0;
			boolean isReduce = false;
			int sumCnt = 1;					//한 줄당 더해야하는 더해야 하는 
			
			for(int i=0; i<N; i++) {
				if(sumCnt >= N)
					isReduce = true;
				
				int start = (N - sumCnt)/2;
				int end = start + sumCnt-1;
					
				for(int j=start; j<=end; j++) {
					sum += farm[i][j];
				}
				if(!isReduce)
					sumCnt += 2;
				else
					sumCnt -= 2;
			}
			
			bw.write("#" + t + " " + sum + "\n");
		}
		bw.flush();
		bw.close();
	}
}

/*
5
14054
44250
02032
51204
52212
 */
