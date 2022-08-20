import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//나머지
public class BJ_3052 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] remainder = new int[42];
		for(int i=0; i<10; i++) {
			int value = Integer.parseInt(br.readLine());
			remainder[value%42]++;
		}
		
		int result=0;
		for(int i=0; i<42; i++) {
			if(remainder[i]!=0)
				result++;
		}
		
		bw.write(result+"");
		bw.flush();
		bw.close();
		br.close();
	}
}
