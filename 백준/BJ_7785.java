import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

//회사에 있는 사람
public class BJ_7785 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		Comparator<String> comparator = (s1, s2)-> s2.compareTo(s1);
		Map<String, String> employees = new TreeMap<>(comparator);
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String name = st.nextToken();
			String state = st.nextToken();
			if(!employees.containsKey(name))
				employees.put(name, state);
			else {
				employees.remove(name);
				employees.put(name, state);
			}
		}
		
		for(Map.Entry<String, String> person : employees.entrySet()) {
			if(person.getValue().equals("enter")) {
				bw.write(person.getKey() + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
