import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//평균
public class BJ_1546 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input = br.readLine();
		StringTokenizer st = new StringTokenizer(input, " ");
		
		int size = Integer.parseInt(st.nextToken());
		double[] arr = new double[size];
		
		double M = 0;
		input = br.readLine();
		st = new StringTokenizer(input, " ");
		
		for(int i=0; i<size; i++) {
			arr[i] = Double.parseDouble(st.nextToken());
			if(M < arr[i]) M = arr[i];
		}
		
		double sum = 0;
		for(int i=0; i<size; i++) {
			arr[i] = arr[i]/M * 100;
			sum += arr[i];
		}
		
		bw.write(sum/size + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
