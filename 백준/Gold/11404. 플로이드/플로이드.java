import java.util.Scanner;

public class Main {

    public static int cityCount;
    public static int busCount;
    public static int road[][];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 도시 수 & 버스 수
        cityCount = scanner.nextInt();
        busCount = scanner.nextInt();

        // 경로 초기화 (자기자신)
        road = new int[cityCount+1][cityCount+1];
        for(int a=1; a<=cityCount; a++) {
            for(int b=1; b<=cityCount; b++) {
                road[a][b] = 0;
            }
        }

        // 경로 초기화 (경로)
        for(int idx=0; idx<busCount; idx++) {
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            int value = scanner.nextInt();
            // 초기화된 값이거나, 이전 노선의 입력 값보다 현재 노선 입력 값이 더 작은 경우
            if(road[row][col]==0 || road[row][col]>value)
                road[row][col] = value;
        }

        // 최단 경로 업데이트
        // a-경로, b-출발, c-도착
        for(int a=1; a<=cityCount; a++) {
            for(int b=1; b<=cityCount; b++) {
                for(int c=1; c<=cityCount; c++) {
                    if(b!=c && road[b][a]!=0 && road[a][c]!=0) {
                        if(road[b][c]==0)
                            road[b][c]=road[b][a]+road[a][c];
                        else
                            road[b][c] = Math.min(road[b][c],road[b][a]+road[a][c]);
                    }
                }
            }
        }

        // 결과 출력
        for(int a=1; a<=cityCount; a++) {
            for(int b=1; b<=cityCount; b++) {
                System.out.print(road[a][b]+" ");
            }
            System.out.println();
        }
    }
}
