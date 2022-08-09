package ws0809;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//사칙연산 유효성 검사

public class D4_1233 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int tc = 10;

		for (int t = 1; t <= tc; t++) {
			int N = Integer.parseInt(br.readLine());
			boolean isSuccess = true;

			for (int n = 0; n < N; n++) {
				String[] line = br.readLine().split(" ");
				if (line.length == 4) {
					if (!line[1].matches("[^0-9]")) {
						isSuccess = false;
					}
				}
			}
			bw.write("#" + t + " ");
			if(isSuccess)
				bw.write(1 + "\n");
			else
				bw.write(0 + "\n");
		}
		bw.flush();
		bw.close();
	}
}
