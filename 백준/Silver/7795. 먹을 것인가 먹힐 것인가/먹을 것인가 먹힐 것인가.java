import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 쌍 구하기
    static int solve(int number, int B[]) {

        // 범위 설정
        int start = 0;
        int end = B.length-1;
        int idx = -1;

        while(start<=end) {

            int mid = (start+end)/2;

            if(number<=B[mid]) {
                end = mid-1;
            }

            else {
                idx = mid;
                start = mid+1;
            }
        }

        return idx;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수 만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // A, B 배열 크기 입력
            st = new StringTokenizer(br.readLine());
            int Acnt = Integer.parseInt(st.nextToken());
            int Bcnt = Integer.parseInt(st.nextToken());

            // 배열 생성
            int A[] = new int[Acnt];
            int B[] = new int[Bcnt];

            // 배열 정보 입력
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<Acnt; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<Bcnt; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            // 정렬
            Arrays.sort(B);

            // 쌍 확인
            int cnt = 0;
            for(int i=0; i<Acnt; i++) {
                int current = solve(A[i],B);

                if(current>-1) {
                    cnt += (current+1);
                }
            }

            // 결과 저장
            sb.append(cnt).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}