import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 문자열의 개수를 나타내는 정수 T
        int T = Integer.parseInt(st.nextToken());
        // 문자열을담는 배열
        String[] arr = new String[T];
        String str = "";

        //문자열 입력받은 후 배열에 저장
        for (int i = 0; i < T; i++) {
            str = br.readLine();
            System.out.println(palindrome(0, str.length()- 1, str, 0));
        }
    }

    // 로직
    private static int palindrome(int start, int end, String s, int check) {
        // 문자 삭제를 2번이상 할 경우 바로 2를 반환
        if (check >= 2) {
            return 2;
        }

        // start 포인터와 end 포인터가 만나거나 지나치기 전까지 반복
        while (start < end) {
						// 같을 경우 포인터 한칸 진행
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
                // ex) abbab 같은 경우 두 경우를 비교해 더 작은 수를 반환
                return Math.min(palindrome(start + 1, end, s, check + 1), palindrome(start, end - 1, s, check + 1));
            }
        }
        return check;
    }
}