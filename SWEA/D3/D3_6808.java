package ws0809;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class Person {
	int[] cards = new int[9];
	int winCnt = 0;
	int loseCnt = 0;
}

//규영이와 인영이의 카드게임
public class D3_6808 {
	static Person gyu = new Person();
	static Person in = new Person();

	static int[] selectInYeongCard = new int[9]; // 인영이가 고른 카드 순서
	static boolean[] isSelected = new boolean[9];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			String[] inputCard = br.readLine().split(" ");
			gyu.winCnt = 0;
			gyu.loseCnt = 0;

			int[] gyuCardTmp = new int[9];
			for (int n = 0; n < 9; n++) { // input으로 들어온 규영이의 카드 순서
				int c = Integer.parseInt(inputCard[n]);
				gyu.cards[n] = c;
				gyuCardTmp[n] = c;
			}

			Arrays.sort(gyuCardTmp);
			int num = 1;
			int inIndex = 0;
			int gyuIndex = 0;
			while (num <= 18) { // 인영이 카드
				if (gyuCardTmp[gyuIndex] == num) {
					num++;
					if (gyuIndex < 8)
						gyuIndex++;
					continue;
				}
				in.cards[inIndex++] = num;
				num++;
			}

			perm(0);

			bw.write("#" + t + " " + gyu.winCnt + " " + gyu.loseCnt + "\n");
		}
		bw.flush();
		bw.close();
	}

	static void perm(int cnt) {
		if (cnt == 9) {
			int gyuP = 0;
			int inP = 0;

			for (int i = 0; i < 9; i++) {
				int gyuC = gyu.cards[i];
				int inC = selectInYeongCard[i];

				if (gyuC > inC)
					gyuP = gyuP + gyuC + inC;
				else
					inP = inP + gyuC + inC;
			}

			if (gyuP > inP)
				gyu.winCnt++;
			else
				gyu.loseCnt++;
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (isSelected[i])
				continue;
			selectInYeongCard[cnt] = in.cards[i];
			isSelected[i] = true;
			perm(cnt + 1);
			isSelected[i] = false;
		}
	}
}
