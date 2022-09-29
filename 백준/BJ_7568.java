import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//덩치
public class BJ_7568 {
	static class Person{
		int kg, cm, grade;

		public Person(int kg, int cm) {
			super();
			this.kg = kg;
			this.cm = cm;
			grade = 1;
		}
	}
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		Person[] list = new Person[N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int kg = Integer.parseInt(st.nextToken());
			int cm = Integer.parseInt(st.nextToken());
			
			list[i] = new Person(kg, cm);
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(list[j].kg > list[i].kg && list[j].cm > list[i].cm) {
					list[i].grade++;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			bw.write(list[i].grade + " ");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
