import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // 비교 문자열
    public static String firstLetter, secondLetter, thirdLetter;

    // LCS 배열
    public static int[][][] LCS;

    // LCS 길이 구하기 메서드
    public static int solve() {

        // LCS 배열 생성
        LCS = new int[firstLetter.length()+1][secondLetter.length()+1][thirdLetter.length()+1];

        // 문자열 확인
        for(int firstIndex=1; firstIndex<=firstLetter.length(); firstIndex++) {
            for(int secondIndex=1; secondIndex<=secondLetter.length(); secondIndex++) {
                for(int thirdIndex=1; thirdIndex<=thirdLetter.length(); thirdIndex++) {

                    // 세 문자
                    char firstWord = firstLetter.charAt(firstIndex-1);
                    char secondWord = secondLetter.charAt(secondIndex-1);
                    char thirdWord = thirdLetter.charAt(thirdIndex-1);

                    // 세 문자가 동일한 경우
                    if(firstWord==secondWord && secondWord==thirdWord) {
                        LCS[firstIndex][secondIndex][thirdIndex] = LCS[firstIndex-1][secondIndex-1][thirdIndex-1]+1;
                    }

                    // 다른 경우
                    else {
                        LCS[firstIndex][secondIndex][thirdIndex]
                                = Math.max(LCS[firstIndex-1][secondIndex][thirdIndex],
                                Math.max(LCS[firstIndex][secondIndex-1][thirdIndex],LCS[firstIndex][secondIndex][thirdIndex-1]));
                    }
                }
            }
        }

        // LCS 반환
        return LCS[firstLetter.length()][secondLetter.length()][thirdLetter.length()];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자열 입력
        firstLetter = br.readLine();
        secondLetter = br.readLine();
        thirdLetter = br.readLine();

        // LCS 길이 구하기
        System.out.println(solve());
    }
}