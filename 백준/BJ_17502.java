import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//클레어와 팰린드롬
public class BJ_17502 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		char[] input = br.readLine().toCharArray();
		
		int left = 0;
		int right = N-1;
		char c = 'a';
		
		while(right >= left) {
			if(input[left]=='?' & input[right]=='?') {
				input[left] = c;
				input[right] = c;
			}
			else if(input[left]=='?') {
				input[left] = input[right];
			}
			else if(input[right]=='?') {
				input[right] = input[left];
			}
			
			left++;
			right--;
		}
		
		for(int i=0; i<N; i++) {
			bw.write(input[i]);
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
