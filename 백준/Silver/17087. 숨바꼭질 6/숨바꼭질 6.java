import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 최대공약수 함수
    static long gcd(long firNum, long secNum) {

        // 종료 조건
        if(firNum%secNum==0)
            return secNum;

        return gcd(secNum,firNum%secNum);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 동생의 수, 나의 위치 입력
        int broCnt = Integer.parseInt(st.nextToken());
        long myPoint = Integer.parseInt(st.nextToken());

        // 동생들 위치 입력
        long points[] = new long[broCnt+1];
        points[0] = myPoint;

        st = new StringTokenizer(br.readLine());
        for(int p=1; p<=broCnt; p++) {
            points[p] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(points);

        // 결과 저장 변수
        long result = points[1]-points[0];

        // 동생이 한 명 이상일 경우
        if(points.length>2) {

            // 각 점의 거리 확인
            long dist[] = new long[broCnt];
            for(int d=0; d<=broCnt-1; d++)
                dist[d] = points[d+1] - points[d];

            // 거리들의 최대공약수 구하기
            result = dist[0];
            for(int d=1; d<dist.length; d++) {
                result = gcd(dist[d],result);
            }
        }

        // 결과 출력
        System.out.println(result);
    }
}