import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//BABBA
public class BJ_9625 {
	static int[] a;
	static int[] b;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		a = new int[N+1];
		b = new int[N+1];
		
		fibo(N);
		
		bw.write(a[N] + " " + b[N]);
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void fibo(int n) {
		a[1] = 0;
		b[1] = 1;
		
		for(int i=2; i<=N; i++) {
			if(i==2) a[i] = 1;
			else
				a[i] = a[i-1] + a[i-2];
			b[i] = a[i-1] + b[i-1];
		}
	}
}
