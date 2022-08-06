import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//구간 합 구하기5
public class BJ_11660 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] first = br.readLine().split(" ");
		int arrSize = Integer.parseInt(first[0]);
		int testCaseCnt = Integer.parseInt(first[1]);
		
		int[][] sums = new int[arrSize][arrSize];
		
		for(int i=0; i<arrSize; i++) {				//배열 입력
			String[] tmp = br.readLine().split(" ");
			sums[i][0] = Integer.parseInt(tmp[0]);

			for(int j=1; j<arrSize; j++) {			//
				sums[i][j] = Integer.parseInt(tmp[j]) + sums[i][j-1];
			}
		}

		for(int i=0; i<testCaseCnt; i++) {
			int sum=0;
			String[] tmp1 = br.readLine().split(" ");
			int x1 = Integer.parseInt(tmp1[0])-1;
			int y1 = Integer.parseInt(tmp1[1])-1;
			int x2 = Integer.parseInt(tmp1[2])-1;
			int y2 = Integer.parseInt(tmp1[3])-1;
			
			//더하기
			
			for(int x=x1; x<=x2; x++) {
				if(y1-1 >= 0) {
					int end = sums[x][y2];
					int start = sums[x][y1-1];
					sum += end - start;
				}
				else
					sum +=sums[x][y2];
			}
			bw.write(sum + "\n");
		}
		bw.flush();
		bw.close();
	}
}

/*
4 3
1 2 3 4
2 3 4 5
3 4 5 6
4 5 6 7
2 2 3 4
3 4 3 4
1 1 4 4

-----------

2 1
1 2
1 1
1 2 2 2
*/