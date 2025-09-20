import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 도시 클래스
class City {
    int end;
    int weight;

    City(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}

public class Main {

    // 최대 비용
    public static final int MAX_VALUE = (int)1e9;

    // 도시 개수, 버스 개수
    public static int cityCount, busCount;

    // 연결 정보 리스트
    public static ArrayList<ArrayList<City>> relations;

    // 거리
    public static long[] path;

    // 거리 확인 메서드
    public static boolean solve() {

        // 시작 지점 처리
        path[1] = 0;

        // 갱신 여부
        boolean update = false;

        // 거리 확인 (도시 - 1)
        for(int count=1; count<cityCount; count++) {

            // 갱신 여부
            update = false;

            // 연결 정보 확인
            for(int index=1; index<=cityCount; index++) {
                for(City connectedCity: relations.get(index)) {

                    // 경로가 없는 경우
                    if(path[index] == MAX_VALUE) break;

                    // 최단 거리인 경우
                    if(path[connectedCity.end] > path[index] + connectedCity.weight) {
                        path[connectedCity.end] = path[index] + connectedCity.weight;
                        update = true;
                    }
                }
            }

            // 갱신이 일어나지 않은 경우
            if(!update) break;
        }

        // 음수 사이클 확인
        if(update) {
            for(int city=1; city<=cityCount; city++) {
                for(City connectedCity : relations.get(city)) {

                    // 경로가 없는 경우
                    if(path[city] == MAX_VALUE) break;

                    // 최단 거리인 경우
                    if(path[connectedCity.end] > path[city] + connectedCity.weight) return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 도시 개수, 버스 개수 입력
        st = new StringTokenizer(br.readLine());
        cityCount = Integer.parseInt(st.nextToken());
        busCount = Integer.parseInt(st.nextToken());

        // 연결 정보 리스트 생성
        relations = new ArrayList<>();
        for(int index=0; index<=cityCount; index++) {
            relations.add(new ArrayList<>());
        }

        // 거리 배열 생성
        path = new long[cityCount+1];
        Arrays.fill(path, MAX_VALUE);

        // 버스 정보 입력
        for(int bus=0; bus<busCount; bus++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            relations.get(from).add(new City(to, cost));
        }

        // 경로가 없는 경우
        if(solve()) sb.append(-1).append("\n");

        // 경로가 있는 경우
        else {
            for(int city=2; city<=cityCount; city++) {
                if(path[city] == MAX_VALUE) sb.append(-1).append("\n");
                else sb.append(path[city]).append("\n");
            }
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}