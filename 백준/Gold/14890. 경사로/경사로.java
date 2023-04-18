import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 길의 크기, 경사로 길이, 결과
    public static int roadSize, slipWayLen, result;
    // 길
    public static int road[][];
    // 경사로 놓인 구간
    public static boolean visited[];

    // 길 확인 함수
    static void rowCheckRoad(int row, int col) {

        // 경사로 위치
        visited = new boolean[roadSize];

        for(int a=col; a<roadSize-1; a++) {

            // 바로 앞 길이 높이가 다른 경우
            if(road[row][a]!=road[row][a+1]) {
                int curValue = road[row][a];
                int nextValue = road[row][a+1];

                // 높이 차이가 1이 아닌 경우
                if(Math.abs(curValue-nextValue)!=1)
                    return;

                // 앞의 길이 현재 높이보다 작을 경우
                if(road[row][a]>road[row][a+1]) {
                    for(int c=a+1; c<=a+slipWayLen; c++) {

                        // 높이가 같지 않거나 길을 벗어난 경우
                        if(c>roadSize-1 || road[row][c]!=nextValue || visited[c])
                            return;

                        // 경사로 놓기
                        visited[c] = true;
                    }
                }

                // 앞의 길이 현재 높이보다 클 경우
                else {
                    for(int c=a; c>=a-slipWayLen+1; c--) {

                        // 높이가 같지 않거나 길을 벗어난 경우
                        if(c<0 || road[row][c]!=curValue || visited[c])
                            return;

                        // 경사로 놓기
                        visited[c] = true;
                    }
                }
            }
        }

        // 길 추가
        result += 1;
    }

    static void colCheckRoad(int row, int col) {

        // 경사로 위치
        visited = new boolean[roadSize];

        for(int a=row; a<roadSize-1; a++) {

            // 바로 앞 길이 높이가 다른 경우
            if(road[a][col]!=road[a+1][col]) {
                int curValue = road[a][col];
                int nextValue = road[a+1][col];

                // 높이 차이가 1이 아닌 경우
                if(Math.abs(curValue-nextValue)!=1)
                    return;

                // 앞의 길이 현재 높이보다 작을 경우
                if(road[a][col]>road[a+1][col]) {
                    for(int r=a+1; r<=a+slipWayLen; r++) {

                        // 높이가 같지 않거나 길을 벗어난 경우
                        if(r>roadSize-1 || road[r][col]!=nextValue || visited[r])
                            return;

                        // 경사로 놓기
                        visited[r] = true;
                    }
                }

                // 앞의 길이 현재 높이보다 클 경우
                else {
                    for(int r=a; r>=a-slipWayLen+1; r--) {
                        // 높이가 같지 않거나 길을 벗어난 경우
                        if(r<0 || road[r][col]!=curValue || visited[r])
                            return;

                        // 경사로 놓기
                        visited[r] = true;
                    }
                }
            }
        }

        // 길 추가
        result += 1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 길의 크기, 경사로 길이 입력
        st = new StringTokenizer(br.readLine());
        roadSize = Integer.parseInt(st.nextToken());
        slipWayLen = Integer.parseInt(st.nextToken());

        // 길 만들기
        road = new int[roadSize][roadSize];

        // 길 정보 입력
        for(int a=0; a<roadSize; a++) {
            st = new StringTokenizer(br.readLine());
            for(int b=0; b<roadSize; b++) {
                road[a][b] = Integer.parseInt(st.nextToken());
            }
        }

        // 길 확인
        result = 0;
        for(int idx=0; idx<roadSize; idx++) {
            rowCheckRoad(idx,0);
            colCheckRoad(0,idx);
        }

        // 결과 출력
        System.out.println(result);
    }
}