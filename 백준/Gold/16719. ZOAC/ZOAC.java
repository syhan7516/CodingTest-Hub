import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    // 문자열
    public static String line;
    // 문자 사용 여부
    public static boolean visited[];
    // 결과 저장
    public static StringBuilder sb;

    // 문자열 확인 함수
    static void solve(int start, int end) {

        // 종료 조건
        if(start>end)
            return;

        // 가장 작은 알파벳 찾기
        int idx=start;
        for(int a=start; a<=end; a++) {
            // 더 작은 알파벳 발견한 경우
            if(line.charAt(idx)>line.charAt(a)) {
                idx = a;
            }
        }

        // 가장 작은 알파벳 방문 처리
        visited[idx] = true;

        // 출력
        for(int a=0; a<line.length(); a++) {
            if(visited[a]) sb.append(line.charAt(a));
        }
        sb.append("\n");

        // solve
        solve(idx+1,end);
        solve(start,idx-1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        // 문자열 입력
        line = br.readLine();

        // 문자 방문 여부
        visited = new boolean[line.length()];

        // 문자열 확인
        int start = 0;
        int end = line.length()-1;
        solve(start,end);

        // 결과 출력
        System.out.println(sb.toString());
    }
}