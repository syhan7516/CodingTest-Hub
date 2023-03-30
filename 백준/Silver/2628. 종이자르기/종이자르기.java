import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int WIDTH = Integer.parseInt(st.nextToken());
		int HEIGTH = Integer.parseInt(st.nextToken());

		// boolean 배열은 기본적으로 false로 초기화 됨.
		// 잘린 점선인지 판단할 boolean 배열
		boolean widthArr[] = new boolean[WIDTH];
		boolean heigthArr[] = new boolean[HEIGTH];

		int n = Integer.parseInt(bf.readLine());

		while (n > 0) {
			st = new StringTokenizer(bf.readLine());
			int wh = Integer.parseInt(st.nextToken());
			int index = Integer.parseInt(st.nextToken());
			if (wh == 0) {
				heigthArr[index] = true;
			}
			if (wh == 1) {
				widthArr[index] = true;
			}
			n--;
		}

		int max_width = 0;
		int tmp = 0;
		for (int i = 0; i < widthArr.length; i++) {
			if (widthArr[i]) {
				max_width = Math.max(max_width, tmp);
				tmp = 1;
			} else
				tmp++;
		}
		max_width = Math.max(max_width, tmp);

		tmp = 0;
		int max_heigth = 0;
		for (int i = 0; i < heigthArr.length; i++) {
			if (heigthArr[i]) {
				max_heigth = Math.max(max_heigth, tmp);
				tmp = 1;
			} else
				tmp++;
		}
		max_heigth = Math.max(max_heigth, tmp);

		System.out.println(max_width * max_heigth);

	}

}