import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자열 입력
        String firstLetters = br.readLine();
        String secondLetters = br.readLine();

        // 길이
        int firstLettersLen = firstLetters.length();
        int secondLettersLen = secondLetters.length();

        // DP 배열 생성
        int[][] DP = new int[firstLettersLen+1][secondLettersLen+1];

        // 확인
        for(int firstIndex=0; firstIndex<firstLettersLen; firstIndex++) {
            for(int secondIndex=0; secondIndex<secondLettersLen; secondIndex++) {

                // 동일한 경우
                if(firstLetters.charAt(firstIndex) == secondLetters.charAt(secondIndex)) {
                    DP[firstIndex+1][secondIndex+1] = DP[firstIndex][secondIndex] + 1;
                }

                // 다른 경우
                else {
                    DP[firstIndex+1][secondIndex+1] = Math.max(DP[firstIndex+1][secondIndex], DP[firstIndex][secondIndex+1]);
                }
            }
        }
        
        // 결과 출력
        System.out.print(DP[firstLettersLen][secondLettersLen]);
    }
}