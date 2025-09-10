import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseCount = Integer.parseInt(br.readLine());

        // 케이스 수행
        for(int caseNum=0; caseNum<caseCount; caseNum++) {

            // 일관성 여부
            String possible = "YES";

            // 번호 개수 입력
            int count = Integer.parseInt(br.readLine());

            // 문자열 배열 생성
            String[] numbers = new String[count];

            // 문자열 정보 입력
            for(int index=0; index<count; index++) {
                numbers[index] = br.readLine();
            }

            // 정렬
            Arrays.sort(numbers);

            // 확인
            for(int index=0; index<numbers.length-1; index++) {
                if(numbers[index].length() > numbers[index+1].length()) continue;
                if(numbers[index].equals(numbers[index+1].substring(0, numbers[index].length()))) {
                    possible = "NO";
                    break;
                }
            }

            // 결과 저장
            sb.append(possible).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}