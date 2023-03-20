import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // A, B 개수, 결과
    public static int A, B, result;
    // A, B 배열
    public static int[] Aarr, Barr;

    // 탐색
    static void search(int target) {
        int start = 0;
        int end = Barr.length-1;
        int idx = -1;

        // 마지막 인덱스가 첫 인덱스를 넘지 않을 때까지 반복
        while(start<=end) {
            // 중간 인덱스 구하기
            int mid = (start+end)/2;

            // A의 원소가 더 클 경우
            if(target>Barr[mid]) {
                idx = mid;
                start = mid+1;
            }
            // A의 원소와 같거나,더 작을 경우
            else {
                end = mid-1;
            }
        }

        // 근접한 인덱스를 기준으로 개수 더하기
        result += idx+1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            // A, B 정보 입력
            Aarr = new int[A];
            st = new StringTokenizer(br.readLine());
            for(int a=0; a<A; a++)
                Aarr[a] = Integer.parseInt(st.nextToken());
            Barr = new int[B];
            st = new StringTokenizer(br.readLine());
            for(int b=0; b<B; b++)
                Barr[b] = Integer.parseInt(st.nextToken());

            // A, B 정렬
            Arrays.sort(Aarr);
            Arrays.sort(Barr);

            // 범위 탐색
            result = 0;
            for(int e=0; e<Aarr.length; e++) {
                search(Aarr[e]);
            }

            // 결과 출력
            System.out.println(result);
        }
    }
}
