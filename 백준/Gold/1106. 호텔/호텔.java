import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 도시 클래스
class City {

    int value;
    int count;

    public City(int value, int count) {
        this.value = value;
        this.count = count;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 목표 고객, 도시 개수 입력
        st = new StringTokenizer(br.readLine());
        int goalClientCount = Integer.parseInt(st.nextToken());
        int cityCount = Integer.parseInt(st.nextToken());

        // 도시 정보 배열 생성
        City cities[] = new City[cityCount];

        // 도시 정보 입력
        for(int index=0; index<cityCount; index++) {
            st = new StringTokenizer(br.readLine());
            int value = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            cities[index] = new City(value,count);
        }

        // 비용 배열 생성
        int DP[] = new int[2001];
        Arrays.fill(DP,(int)1e9);
        DP[0] = 0;

        // 확인
        for(int index=0; index<cityCount; index++) {

            // 대상 도시
            City city = cities[index];

            // 인원 수 차례로 확인
            for(int client=city.count; client<2001; client++) {
                if(DP[client-city.count]!=(int)1e9);
                    DP[client] = Math.min(DP[client],DP[client-city.count]+city.value);
            }
        }

        // 결과 저장
        int answer = (int)1e9;
        for(int index=goalClientCount; index<2001; index++) {
            answer = Math.min(answer,DP[index]);
        }

        // 결과 출력
        System.out.println(answer);
    }
}