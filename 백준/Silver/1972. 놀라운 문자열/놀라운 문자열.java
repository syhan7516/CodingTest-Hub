import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    // 문자열 확인 메서드
    public static boolean solve(String letters) {

        // 문자열 쌍 확인 - 거리
        for(int distance=1; distance<letters.length(); distance++) {

            // 문자열 개수 저장 해시 맵 생성
            HashMap<String, Boolean> map = new HashMap<>();

            // 문자열 쌍 확인 - 문자
            for(int index=0; index+distance<=letters.length()-1; index++) {
                String pair = " "+letters.charAt(index) + letters.charAt(index + distance);
                
                // 존재하는 경우
                if(map.containsKey(pair)) {
                    return false;
                }

                // 저장
                map.put(pair, true);
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String letters;

        // 케이스 수행
        while(!(letters = br.readLine()).equals("*")) {

            // 문자열 확인
            sb.append(letters).append(" is ");
            if(!solve(letters)) {
                sb.append("NOT ");
            }

            sb.append("surprising.").append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}