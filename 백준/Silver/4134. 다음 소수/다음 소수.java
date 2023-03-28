import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static StringBuilder sb = new StringBuilder();

	public static void find(long n) {
		long check = 0;

		while (true) {

			if (n < 2) {
				sb.append(2 + "\n");
				break;
			}

			for (long i = 2; i * i <= n; i++) {
				if (n % i == 0) {
					check = 1;
					break;
				}
			}
			if (check == 0) {
				sb.append(n + "\n");
				break;
			}
			check = 0;
			n++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		long T = Long.valueOf(br.readLine());

		for (long i = 0; i < T; i++) {
			find(Long.valueOf(br.readLine()));
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}