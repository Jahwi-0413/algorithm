package ws0810;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

//다리 놓기
public class BJ_1010 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int t=0; t<tc; t++) {
			//초기화
			String[] input = br.readLine().split(" ");
			int N = Integer.parseInt(input[0]);
			int M = Integer.parseInt(input[1]);
			
			BigInteger Mp = new BigInteger("1");	//n!
			for(int i=M; i>0; i--) {
				Mp = Mp.multiply(new BigInteger(Integer.toString(i)));
			}
			
			BigInteger Np = new BigInteger("1"); 	//r!
			for(int i=N; i>0; i--) {
				Np = Np.multiply(new BigInteger(Integer.toString(i)));
			}
			
			BigInteger NminusMp = new BigInteger("1");	//(n-r)!
			for(int i=M-N; i>0; i--) {
				NminusMp = NminusMp.multiply(new BigInteger(Integer.toString(i)));
			}
			
			BigInteger total = Mp.divide(Np.multiply(NminusMp));
			bw.write(total.toString() + "\n");
		}
		bw.flush();
		bw.close();
	}//end of main
}