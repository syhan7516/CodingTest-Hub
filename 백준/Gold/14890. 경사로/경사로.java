import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 결과, 길의 크기, 경사로 길이
    public static int answer, roadSize, roadLen;

    // 길 배열
    public static int road[][];

    // 경사로 놓인 구간
    public static boolean visited[];

    // 길 확인 메서드
    static void rowCheckRoad(int rowIndex, int colIndex) {

        // 경사로 위치
        visited = new boolean[roadSize];

        // 길 확인
        for(int index=colIndex; index<roadSize-1; index++) {

            // 바로 앞 길이 높이가 다른 경우
            if(road[rowIndex][index]!=road[rowIndex][index+1]) {

                // 각 높이 저장
                int currentValue = road[rowIndex][index];
                int nextValue = road[rowIndex][index+1];

                // 높이 차이가 1이 아닌 경우
                if(Math.abs(currentValue-nextValue)!=1)
                    return;

                // 앞의 길이 현재 높이보다 작을 경우
                if(road[rowIndex][index]>road[rowIndex][index+1]) {

                    // 경사로 크기만큼 앞쪽 확인
                    for(int point=index+1; point<=index+roadLen; point++) {

                        // 높이가 같지 않거나 길을 벗어난 경우
                        if(point>roadSize-1 || road[rowIndex][point]!=nextValue || visited[point])
                            return;

                        // 경사로 놓기
                        visited[point] = true;
                    }
                }

                // 앞의 길이 현재 높이보다 클 경우
                else {

                    // 경사로 크기만큼 뒷쪽 확인
                    for(int point=index; point>=index-roadLen+1; point--) {

                        // 높이가 같지 않거나 길을 벗어난 경우
                        if(point<0 || road[rowIndex][point]!=currentValue || visited[point])
                            return;

                        // 경사로 놓기
                        visited[point] = true;
                    }
                }
            }
        }

        // 길 추가
        answer++;
    }

    static void colCheckRoad(int rowIndex, int colIndex) {

        // 경사로 위치
        visited = new boolean[roadSize];

        // 길 확인
        for(int index=rowIndex; index<roadSize-1; index++) {

            // 바로 앞 길이 높이가 다른 경우
            if(road[index][colIndex]!=road[index+1][colIndex]) {

                // 각 높이 저장
                int currentValue = road[index][colIndex];
                int nextValue = road[index+1][colIndex];

                // 높이 차이가 1이 아닌 경우
                if(Math.abs(currentValue-nextValue)!=1)
                    return;

                // 앞의 길이 현재 높이보다 작을 경우
                if(road[index][colIndex]>road[index+1][colIndex]) {

                    // 경사로 크기만큼 앞쪽 확인
                    for(int point=index+1; point<=index+roadLen; point++) {

                        // 높이가 같지 않거나 길을 벗어난 경우
                        if(point>roadSize-1 || road[point][colIndex]!=nextValue || visited[point])
                            return;

                        // 경사로 놓기
                        visited[point] = true;
                    }
                }

                // 앞의 길이 현재 높이보다 클 경우
                else {

                    // 경사로 크기만큼 뒷쪽 확인
                    for(int point=index; point>=index-roadLen+1; point--) {
                        // 높이가 같지 않거나 길을 벗어난 경우
                        if(point<0 || road[point][colIndex]!=currentValue || visited[point])
                            return;

                        // 경사로 놓기
                        visited[point] = true;
                    }
                }
            }
        }

        // 길 추가
        answer++;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 길의 크기, 경사로 길이 입력
        st = new StringTokenizer(br.readLine());
        roadSize = Integer.parseInt(st.nextToken());
        roadLen = Integer.parseInt(st.nextToken());

        // 길 만들기
        road = new int[roadSize][roadSize];

        // 길 정보 입력
        for(int rowIndex=0; rowIndex<roadSize; rowIndex++) {
            st = new StringTokenizer(br.readLine());
            for(int colIndex=0; colIndex<roadSize; colIndex++) {
                road[rowIndex][colIndex] = Integer.parseInt(st.nextToken());
            }
        }

        // 길 확인
        answer = 0;
        for(int index=0; index<roadSize; index++) {
            rowCheckRoad(index,0);
            colCheckRoad(0,index);
        }

        // 결과 출력
        System.out.println(answer);
    }
}