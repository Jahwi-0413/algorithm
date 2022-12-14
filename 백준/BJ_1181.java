import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//단어 정렬
public class BJ_1181 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int arrSize = Integer.parseInt(br.readLine());
		String[] words = new String[arrSize];
		
		for(int i=0; i<arrSize; i++) {
			words[i] = br.readLine();
			for(int j=0; j<i; j++) {
				if(words[i].length() < words[j].length()) {		//입력된 단어가 이전에 입력된 단어보다 길이가 짧다
					String tmp = words[i];
					words[i] = words[j];
					words[j] = tmp;
				}
				else if(words[i].length() == words[j].length()) {	//같을땐 사전순	
					if(words[i].compareTo(words[j])<0) {
						String tmp = words[i];
						words[i] = words[j];
						words[j] = tmp;
					}
				}
			}
		}
		String string="";
		for(String s : words) {
			if(string.equals(s))
				continue;
			string = s;
			bw.write(s + "\n");
		}
		bw.flush();
		bw.close();
	}
}

/*
 * s1.compareTo(s2)
 * s1 > s2 --- 음수
 * s1 < s2 --- 양수
 * s1 == s2 --- 0
 */