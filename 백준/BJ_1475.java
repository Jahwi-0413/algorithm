import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//방 번호
//구현
public class BJ_1475 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = br.readLine();
		int[] numCnt = new int[10];		//0~9
		
		for(int i=0,size=input.length(); i<size; i++) {
			int value = input.charAt(i)-'0';
			numCnt[value]++;
		}
		
		int sixNineSum = numCnt[6] + numCnt[9];
		numCnt[9] = 0;
		sixNineSum = sixNineSum/2 + sixNineSum%2;
		numCnt[6] = sixNineSum;
		
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<10; i++) {
			if(max < numCnt[i]) {
				max = numCnt[i];
			}
		}
		
		bw.write(max + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
