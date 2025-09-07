import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 문자열 입력
        String letter = br.readLine();
        int letterLen = letter.length();

        // 개수 배열 생성
        int[][] count = new int[letterLen][26];
        count[0][letter.charAt(0) - 'a']++;

        // 초기화
        for(int position=1; position<letterLen; position++) {
            for(int alpha=0; alpha<26; alpha++) {
                count[position][alpha] = count[position-1][alpha];
            }

            count[position][letter.charAt(position) - 'a']++;
        }

        // 질의 수 입력
        int orderCount = Integer.parseInt(br.readLine());

        // 질의 정보 입력
        for(int order=0; order<orderCount; order++) {

            // 알파벳, 구간 입력
            st = new StringTokenizer(br.readLine());
            int alpha = st.nextToken().charAt(0) - 'a';
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // 첫 위치인 경우
            if(start == 0) sb.append(count[end][alpha]);

            // 아닌 경우
            else sb.append(count[end][alpha] - count[start - 1][alpha]);
            
            sb.append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}