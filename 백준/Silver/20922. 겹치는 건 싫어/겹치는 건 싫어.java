import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N, K 입력
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 정수 배열 생성
        int nums[] = new int[N];

        // 정수 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        // 정수 개수 배열
        int cnt[] = new int[100001];

        // 결과
        int answer = 0;

        // 연숙 부분 수열 확인
        int start = 0;
        int point = 0;

       while(true) {

           // 종료 조건
           if(point==N) break;
           
           // 범위 확장
           while(point<N && cnt[nums[point]]+1<=K) {
               cnt[nums[point]]++;
               point++;
           }

           // 길이 갱신
           answer = Math.max(answer,point-start);

           // 제거 숫자 찾기 및 제거
           cnt[nums[start]]--;
           start++;
       } 
       
       // 결과 출력
       System.out.println(answer);
    }
}