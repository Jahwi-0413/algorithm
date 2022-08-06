import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//배열 합치기
public class BJ_11728 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] first = br.readLine().split(" ");
		int n = Integer.parseInt(first[0]), m = Integer.parseInt(first[1]);
		int size = n+m;
		int[] result = new int[size];
		
		String[] second = br.readLine().split(" ");
		String[] third = br.readLine().split(" ");

		int j=0;
		for(int i=0; i<n; i++) {
			result[j++] = Integer.parseInt(second[i]);
		}
		for(int i=0; i<m; i++) {
			result[j++] = Integer.parseInt(third[i]);
		}
		Arrays.sort(result);

		int tmp = result[0];
		
		for(int i : result){
			bw.write(String.valueOf(i) + " ");
		}
		bw.flush();
		bw.close();
	}
}
