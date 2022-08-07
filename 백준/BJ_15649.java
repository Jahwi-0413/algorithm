import java.io.IOException;
import java.util.Scanner;

//N과 M(1)
public class BJ_15649 {

	static int[] arr;
	static boolean[] isSelected;

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		arr = new int[M];
		isSelected = new boolean[N + 1];

		perm(0, N, M);
	}

	static void perm(int cnt, int N, int M) {
		if (cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print((arr[i]) + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (isSelected[i]) continue;
			arr[cnt] = i;
			isSelected[i] = true;
			
			perm(cnt+1, N, M);
			isSelected[i] = false;
		}
	}

}
