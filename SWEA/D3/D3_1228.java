package ws0808;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//암호문 1
public class D3_1228 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int tc = 10;
		for(int t=1; t<=tc; t++) {
			int N = Integer.parseInt(br.readLine());
			String[] initialCmd = br.readLine().split(" ");	//초기 암호문
			List<String> commands = new ArrayList<>();
			Collections.addAll(commands, initialCmd);
			int N2 = Integer.parseInt(br.readLine());
			
			String[] cmds = br.readLine().split("I ");
			for(int i=1; i<=N2; i++) {						//명령어 처리
				String[] cmd = cmds[i].split(" ");
				int index = Integer.parseInt(cmd[0]);
				int length = Integer.parseInt(cmd[1]);
				
				List<String> tmp = new ArrayList<>();
				String[] addCmd = Arrays.copyOfRange(cmd, 2, 2 + length);	//암호문에 넣을 명령어
				tmp.addAll(commands.subList(0, index));
				Collections.addAll(tmp, addCmd);
				
				List<String> lastCmd = commands.subList(index, commands.size()); //암호문의 남은 부분
				tmp.addAll(lastCmd);
				commands = tmp;
			}
			
			bw.write("#" + t + " ");
			for(int i=0; i<10; i++) {
				bw.write(commands.get(i) + " ");
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}
