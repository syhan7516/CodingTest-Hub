import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 숫자 개수, 선택 개수
    public static int numCount, selectedCount;

    // 방문 여부 배열
    public static boolean visited[];

    // 숫자 배열
    public static int arr[];

    // 결과 저장 빌더
    public static StringBuilder sb;

    // 수열 구하기 메서드
    public static void solve(int count) {

        // 모두 선택한 경우
        if(count==selectedCount) {
            for(int index=0;index<selectedCount;index++)
                sb.append(arr[index]+" ");
            sb.append("\n");
            return;
        }

        // 선택하기
        for(int index=1; index<=numCount; index++) {
            if(!visited[index]) {
                visited[index] = true;
                arr[count] = index;
                solve(count+1);
                visited[index] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 숫자 개수, 선택 개수 입력
        st = new StringTokenizer(br.readLine());
        numCount = Integer.parseInt(st.nextToken());
        selectedCount = Integer.parseInt(st.nextToken());

        // 방문 여부 배열 생성
        visited = new boolean[numCount+1];

        // 숫자 배열 생성
        arr = new int[numCount];

        // 수열 구하기
        sb = new StringBuilder();
        solve(0);

        // 결과 출력
        System.out.println(sb.toString());
    }
}