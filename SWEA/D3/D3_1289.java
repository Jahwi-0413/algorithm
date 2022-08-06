import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//원재의 메모리 복구하기
public class D3_1289 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t=0; t<testCase; t++) {
			char[] input = br.readLine().toCharArray();
			int length = input.length;
			
			char[] changing = new char[length]; 
			Arrays.fill(changing, '0');

			int diffCnt = 0;
			int i=0;
			StringBuilder tmp = new StringBuilder();
			tmp.append(changing);
			
			while(true) {
				if(input[i]!=tmp.charAt(i)) {				//규칙에 따라 tmp 배열 변경
					for(int j=i; j<length; j++) {
						tmp.replace(j, length, input[i] + "");
					}
					diffCnt++;
				}
				boolean isSame = String.valueOf(input).equals(tmp.toString()) ? true : false;	//바꾸고 있는 메모리값이 복구되었나
				if(isSame) break;
				i++;
			}
			
			bw.write("#" + (t+1) + " " + diffCnt + '\n');
		}
		bw.flush();
		bw.close();
	}
}

/*
2
0011
100
 */
