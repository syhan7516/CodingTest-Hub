import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    // 접시 수, 종류 수, 연속 수, 쿠폰 번호
    public static int dishCnt, kinds, k, coupon;
    // 해시 셋
    public static HashSet<Integer> set;
    // 회전 벨트 배열
    public static int belt[];
    // 초밥 개수 배열
    public static int cnt[];
    // 결과
    public static int result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 접시 수, 종류 수, 연속 수, 쿠폰 번호 입력
        st = new StringTokenizer(br.readLine());
        dishCnt = Integer.parseInt(st.nextToken());
        kinds = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        coupon = Integer.parseInt(st.nextToken());

        // 초밥 벨트 채우기
        belt = new int[dishCnt];

        for(int d=0; d<dishCnt; d++) {
            belt[d] = Integer.parseInt(br.readLine());
        }

        // 초기 셋팅
        result = -1;
        set = new HashSet<>();
        cnt = new int[kinds+1];

        for(int d=0; d<k; d++) {
            set.add(belt[d]);
            cnt[belt[d]]++;
        }

        // 쿠폰 초밥이 존재하는 경우
        if(cnt[coupon]>0) {
            result = Math.max(result,set.size());
        }
        else {
            result = Math.max(result,set.size()+1);
        }

        // 초밥 확인
        for(int d=1; d<dishCnt; d++) {

            // 범위 설정
            int start = d;
            int end = d+k-1;

            // 끝 범위가 벗어나는 경우
            if(end>=dishCnt) end -= dishCnt;

            // 종류 확인 - 삭제
            cnt[belt[start-1]]--;
            if(cnt[belt[start-1]]==0) set.remove(belt[start-1]);

            // 종류 확인 - 추가
            set.add(belt[end]);
            cnt[belt[end]]++;

            // 쿠폰 초밥이 존재하는 경우
            if(cnt[coupon]>0) {
                result = Math.max(result,set.size());
            }
            else {
                result = Math.max(result,set.size()+1);
            }
        }

        // 결과 출력
        System.out.println(result);
    }
}