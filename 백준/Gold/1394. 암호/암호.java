import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    // 모듈러
    public static final int MOD = 900528;

    // 결과
    public static long answer;

    // 문자 위치 저장 해시
    public static HashMap<Character, Integer> characterIndexes;

    // 문자열, 비밀번호
    public static String letters, password;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // 문자 위치 저장 해시 생성
        characterIndexes = new HashMap<>();

        // 사용 가능한 문자 목록 입력
        letters = bufferedReader.readLine();

        // 비밀번호 입력
        password = bufferedReader.readLine();

        // 문자 위치 저장
        for(int index=0; index<letters.length(); index++) {
            characterIndexes.put(letters.charAt(index), index + 1);
        }

        // 길이
        int len = letters.length();

        // 순서 계산
        for(int index=0; index<password.length(); index++) {

            // 비밀번호 문자
            char currentCharacter = password.charAt(index);

            // 해당 문자 위치
            int currentCharacterIndex = characterIndexes.get(currentCharacter);

            // 순서
            // answer * len -> 앞자리의 순서 설정
            // currentCharacterIndex -> 해당 자리의 순서
            answer = (answer * len + currentCharacterIndex) % MOD;
        }

        // 결과 출력
        System.out.println(answer);
    }
}