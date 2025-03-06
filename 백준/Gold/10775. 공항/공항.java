import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // 결과, 게이트 수, 비행기 수
    public static int answer, gateCount, airCount;

    // 대표 번호 배열
    public static int parent[];

    // union
    public static void union(int a, int b) {

        a = find(a);
        b = find(b);

        if(a>b) parent[a] = b;
        else parent[b] = a;
    }

    // find
    public static int find(int gate) {

        if(parent[gate]==gate)
            return gate;

        return parent[gate] = find(parent[gate]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 결과
        answer = 0;

        // 게이트 수 입력
        gateCount = Integer.parseInt(br.readLine());

        // 비행기 수 입력
        airCount = Integer.parseInt(br.readLine());

        // 대표 번호 배열 생성
        parent = new int[gateCount+1];
        for(int index=1; index<=gateCount; index++) {
            parent[index] = index;
        }

        // 도킹 정보 입력
        for(int index=0; index<airCount; index++) {

            // 게이트 정보 입력
            int point = Integer.parseInt(br.readLine());

            // 게이트 상태 및 빈 위치
            int gateState = find(point);

            // 게이트가 닫힌 경우
            if(gateState==0) break;

            // 아닌 경우
            answer++;
            union(gateState,gateState-1);
        }

        // 결과 출력
        System.out.println(answer);
    }
}