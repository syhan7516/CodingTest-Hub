import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    // 목표 값, 배열 크기
    public static int target, aSize, bSize;

    // 결과
    public static long answer;

    // 배열
    public static long a[], b[];

    // 부배열 저장 해시
    public static HashMap<Long,Integer> aMap, bMap;
    
    // 찾기 메서드
    static void solve() {

        // A 부배열 구하기
        for (int i=0; i<aSize; i++) {
            long sum = a[i];
            for (int j=i+1; j<aSize; j++) {
                sum += a[j];
                aMap.put(sum,aMap.getOrDefault(sum,0)+1);
            }
        }

        // B 부배열 구하기
        for (int i=0; i<bSize; i++) {
            long sum = b[i];
            for (int j=i+1; j<bSize; j++) {
                sum += b[j];
                bMap.put(sum,bMap.getOrDefault(sum,0)+1);
            }
        }

        // 개수 구하기
        for(long value: aMap.keySet()) {
            long aCnt = aMap.get(value);
            long bCnt = bMap.get(target-value) == null ? 0 : bMap.get(target-value);
            answer += (aCnt*bCnt);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 목표 값 입력
        target = Integer.parseInt(br.readLine());

        // 배열 크기 입력 & 생성
        aMap = new HashMap<>();
        aSize = Integer.parseInt(br.readLine());
        a = new long[aSize];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<aSize; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            aMap.put(a[i],aMap.getOrDefault(a[i],0)+1);
        }

        // 배열 크기 입력 & 생성
        bMap = new HashMap<>();
        bSize = Integer.parseInt(br.readLine());
        b = new long[bSize];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<bSize; i++) {
            b[i] = Integer.parseInt(st.nextToken());
            bMap.put(b[i],bMap.getOrDefault(b[i],0)+1);
        }

        // 찾기
        answer = 0;
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}