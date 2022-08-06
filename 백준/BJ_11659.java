import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//구간 합 구하기4
public class BJ_11659{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String first = br.readLine();
		StringTokenizer st = new StringTokenizer(first, " ");
		int arrSize = Integer.parseInt(st.nextToken());
		int testCaseCnt = Integer.parseInt(st.nextToken());
		
		int[] list =new int[arrSize];
		String arrTmp = br.readLine();
		st = new StringTokenizer(arrTmp, " ");
		
		int x=0; 
		while(st.hasMoreTokens()) {
			list[x++] = Integer.parseInt(st.nextToken());
		}
		
		//메모이제이션
		int[] sums = new int[arrSize];
		sums[0] = list[0];
		
		for(int s=1; s<sums.length; s++) {
			sums[s] = sums[s-1] + list[s];
		}
		
		int sum = 0;
		for(int i=0; i<testCaseCnt; i++) {
			String tmp = br.readLine();
			st = new StringTokenizer(tmp, " ");

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			if(start-2 >=0) {
				sum = sums[end-1] - sums[start-2];
			}
			else
				sum = sums[end-1];
			
			bw.write(sum + "\n");
			sum = 0;
		}
		
		bw.flush();
		bw.close();
	}
}

//4 + 3 +2
//5 + 4
//5 + 4 + 3 + 2

/*
5 3
5 4 3 2 1
1 3
2 4
5 5
 */