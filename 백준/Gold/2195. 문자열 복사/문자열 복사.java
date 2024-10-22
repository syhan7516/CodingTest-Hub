import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    // 결과
    public static int answer;

    // 문자열 S, P
    public static String S, P;

    // 문자열 만들기 메서드
    public static void solve() {

        // 찾을 문자 시작점
        int startIndex = 0;

        // P 문자열 순회하기
        for(int letterIndex=0; letterIndex<P.length(); letterIndex++) {

            // 찾을 대상 문자열
            String subLetters = P.substring(startIndex,letterIndex+1);

            // S 문자열에서 찾기
            if(S.indexOf(subLetters)==-1) {
                
                // 문자열이 없는 경우 끊고 시작점 갱신
                startIndex = letterIndex;
                answer++;
            }
        }
        
        // 무조건 찾는 조건으로 복사 횟수 한 번 추가
        answer++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자열 S 입력
        S = br.readLine();

        // 문자열 P 입력
        P = br.readLine();

        // 문자열 만들기
        answer = 0;
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}