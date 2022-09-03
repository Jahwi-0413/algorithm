import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

//나는야 포켓몬 마스터 이다솜
public class BJ_1620 {
	static int N, M;
	static Map<String, Integer> pokemonNames;
	static Map<Integer, String> pokemonIndexes;

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		pokemonNames = new HashMap<>();
		pokemonIndexes = new HashMap<>();
		
		for(int i=1; i<=N; i++) {
			String name = br.readLine();
			pokemonNames.put(name, i);
			pokemonIndexes.put(i, name);
			
		}
		
		for(int i=0; i<M; i++) {
			String question = br.readLine();
			
			int firstChar = question.charAt(0)-'0';		//숫자인지 확인
			if(0<=firstChar && firstChar<=9) {			//숫자면 포켓몬 이름
				int index = Integer.parseInt(question);
				bw.write(pokemonIndexes.get(index) + "\n");
				continue;
			}
			else {			//영어면 숫자로
				bw.write(pokemonNames.get(question) + "\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
