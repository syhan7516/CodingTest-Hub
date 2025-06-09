import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // 결과, 0,1 그룹 개수
    public static int answer, zeroGroupCount, oneGroupCount;

    // 그룹 카운드 메서드
    public static void groupCount(char findGroup) {
        if(findGroup-'0'==0) zeroGroupCount++;
        else oneGroupCount++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문자열 입력
        String letter = br.readLine();

        // 확인 그룹
        char findGroup = letter.charAt(0);
        groupCount(findGroup);

        // 문자열 확인
        for(int letterIndex=0; letterIndex<letter.length(); letterIndex++) {

            // 그룹
            char group = letter.charAt(letterIndex);

            // 확인
            if(findGroup!=group) {
                findGroup = group;
                groupCount(findGroup);
            }
        }

        // 결과 저장
        answer = Math.min(zeroGroupCount,oneGroupCount);

        // 결과 출력
        System.out.println(answer);
    }
}