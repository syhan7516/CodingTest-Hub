import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 길이, 선택 개수
    public static int len, selectedCount;

    // 결과 저장 빌더
    public static StringBuilder sb;

    // 선택된 수 저장 배열
    public static int arr[];

    // 수열 구하기 메서드
    public static void solve(int count) {

        // 모두 선택된 경우
        if(count==selectedCount) {

            // 저장
            for(int index=0; index<arr.length; index++)
                sb.append(arr[index]).append(" ");
            sb.append("\n");
            return;
        }

        // 선택하기
        for(int num=1; num<=len; num++) {
            arr[count] = num;
            solve(count+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 길이, 선택 개수 입력
        st = new StringTokenizer(br.readLine());
        len = Integer.parseInt(st.nextToken());
        selectedCount = Integer.parseInt(st.nextToken());

        // 선택된 수 저장 배열 생성
        arr = new int[selectedCount];

        // 수열 구하기
        sb = new StringBuilder();
        solve(0);

        // 결과 출력
        System.out.println(sb.toString());
    }
}