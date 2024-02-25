import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    // 자리 찾기 메서드
    static int binarySearch(int target, int idx, int DP[]) {
        
        // 탐색 범위 설정
        int start = 1;
        int end = idx;

        // 삽입 자리
        int insertIdx = -1;

        // 탐색 수행
        while(start<=end) {

            // 중간 범위 설정
            int mid = (start+end)/2;

            // 설정 값 비교
            if(DP[mid]==target)
                return 0;

            else if(DP[mid]<target)
                start = mid+1;

            else {
                insertIdx = mid;
                end = mid-1;
            }
        }

        return insertIdx;
    }


    // 포트 연결 수행
    static int solve(int portCnt, int port[], int DP[]) {

        // 초기 셋팅
        int idx = 1;
        DP[1] = port[1];

        // 모든 포트 연결 정보 확인
        for(int p=2; p<=portCnt; p++) {

            // 맨 앞보다 작을 경우
            if(DP[1]>port[p])
                DP[1] = port[p];

            // 맨 뒤보다 클 경우
            else if(DP[idx]<port[p])
                DP[++idx] = port[p];

            // 아닐 경우
            else {
                int point = binarySearch(port[p],idx,DP);
                if(point!=0) DP[point] = port[p];
            }
        }

        return idx;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 포트 수 입력
        int portCnt = Integer.parseInt(br.readLine());

        // 포트 정보 저장 배열 생성
        int port[] = new int[portCnt+1];

        // 포트 연결 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=portCnt; i++)
            port[i] = Integer.parseInt(st.nextToken());

        // 개수 저장 배열 생성
        int DP[] = new int[portCnt+1];

        // 포트 연결 수행
        int answer = solve(portCnt,port,DP);

        // 결과 출력
        System.out.println(answer);
    }
}