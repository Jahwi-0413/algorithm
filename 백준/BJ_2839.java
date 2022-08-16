package ws0816;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BJ_2839 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int fiveCnt = 0, threeCnt = 0;

		threeCnt = N / 3;				//3kg 자루의 최대값
		N = N % 3;

		if(N != 0) {					//3kg 자루로 담고 남은게 있을 경우
			while(true) {
				if(threeCnt > 0 ) {		//3kg 자루들과 나머지를 합쳐서 5의 배수를 만들수 있는지 확인
					threeCnt --;
					N += 3;
					
					if(N % 5 ==0) {
						fiveCnt += N/5;
						N = N%5;
						break;
					}
				}
				else
					break;
			}
		}
		
		if(threeCnt > 0 && threeCnt / 5 > 0) {		//3kg짜리를 5kg짜리로 환산할 수 있는지
			int tmp = threeCnt / 5;
			
			fiveCnt += tmp * 3;
			threeCnt -= tmp * 5;
		}
		
		if(N != 0)
			bw.write(-1 + "");
		else
			bw.write((fiveCnt + threeCnt) + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
