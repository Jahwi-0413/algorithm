import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

//최대공약수와 최소공배수
public class BJ_2609 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int result1 = Integer.MIN_VALUE, result2 = 0;	//1 최소공약수, 2최대공배수
		
		Set<Integer> aSet = new HashSet<>();
		
		for(int i=a; i>=1; i--) {
			if(a%i==0) aSet.add(i);
		}
		
		Iterator<Integer> iterator = aSet.iterator();
		while(iterator.hasNext()) {
			int value = iterator.next();
			if(b%value==0) {
				result1 = Math.max(result1, value);
			}
		}
		
		int i=1;
		while(true) {
			int value = result1 * i++;
			if(value%a==0 && value%b==0) {
				result2 = value;
				break;
			}
		}
		bw.write(result1 + "\n" + result2 + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
