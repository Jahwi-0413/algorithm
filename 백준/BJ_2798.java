package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//블랙잭
public class BJ_2798 {
	static int N,M,diff = Integer.MAX_VALUE;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<N; i++) {
			for(int j=i+1; j<N;j++) {
				for(int k=j+1; k<N; k++) {
					int sum = arr[i] + arr[j] + arr[k];
					if(sum <= M) {
						diff = Math.min(diff, M-sum);
					}
				}
			}
		}
	
		bw.write((M-diff) + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
