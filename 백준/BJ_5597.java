import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

//과제 안 내신 분..?
public class BJ_5597 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = 30;
		Set<Integer> students = new HashSet<>();
		
		for(int i=1; i<=N-2; i++) {
			int num = Integer.parseInt(br.readLine());
			students.add(num);
		}
		
		for(int i=1; i<=N; i++) {
			if(students.contains(i)) continue;
			bw.write(i + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
