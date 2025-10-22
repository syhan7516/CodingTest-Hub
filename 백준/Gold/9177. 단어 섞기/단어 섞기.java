import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 집합 개수 입력
        int setCount = Integer.parseInt(br.readLine());

        // 집합 정보 입력
        for(int setIndex=1; setIndex<=setCount; setIndex++) {

            // 단어 입력
            st = new StringTokenizer(br.readLine());
            char[] firstWord = st.nextToken().toCharArray();
            char[] secondWord = st.nextToken().toCharArray();
            char[] thirdWord = st.nextToken().toCharArray();

            // 길이
            int firstWordLen = firstWord.length;
            int secondWordLen = secondWord.length;

            // DP 배열 생성
            boolean[][] DP = new boolean[firstWordLen+1][secondWordLen+1];
            DP[0][0] = true;

            // 확인
            for(int index=1; index<=firstWordLen; index++) {
                DP[index][0] = DP[index-1][0] && firstWord[index-1] == thirdWord[index-1];
            }

            for(int index=1; index<=secondWordLen; index++) {
                DP[0][index] = DP[0][index-1] && secondWord[index-1] == thirdWord[index-1];
            }
            
            for(int firstIndex=1; firstIndex<=firstWordLen; firstIndex++) {
                for(int secondIndex=1; secondIndex<=secondWordLen; secondIndex++) {
                    DP[firstIndex][secondIndex] = (DP[firstIndex-1][secondIndex] && firstWord[firstIndex-1] == thirdWord[firstIndex+secondIndex-1])
                            || (DP[firstIndex][secondIndex-1] && secondWord[secondIndex-1] == thirdWord[firstIndex+secondIndex-1]);
                }
            }

            // 결과 저장
            String answer = DP[firstWordLen][secondWordLen] ? "yes" : "no";
            sb.append("Data set ").append(setIndex).append(": ").append(answer).append("\n");
        }

        // 결과 출력
        System.out.print(sb.toString());
    }
}