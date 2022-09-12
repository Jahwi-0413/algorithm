import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

//대칭 차집합
public class BJ_1269 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int res = 0;
		
		Set<String> a = new HashSet<>();
		Set<String> b = new HashSet<>();
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			String value = st.nextToken();
			a.add(value);
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<M; i++) {
			String value = st.nextToken();
			b.add(value);
			if(!a.contains(value)) res++;			//b-a
		}
		
		Iterator<String> iterator = a.iterator();
		
		while(iterator.hasNext()) {		//a-b
			String value = iterator.next();
			if(!b.contains(value)) res++;
		}
		
		bw.write(res + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
