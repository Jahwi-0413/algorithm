import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

//듣보잡
public class BJ_1764 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Set<String> names = new HashSet<>();
		List<String> result = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			names.add(br.readLine());
		}
		
		for(int i=0; i<M; i++) {
			String str = br.readLine();
			if(names.contains(str))
				result.add(str);
		}
		
		Collections.sort(result);
		
		bw.write(result.size() + "\n");
		for(String str: result) {
			bw.write(str + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
