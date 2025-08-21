import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 위치 클래스
class Point {
    int y;
    int x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {

    // 결과
    public static long answer;

    // 가로, 세로 크기, 별의 개수
    public static int rowSize, colSize, starCount;

    // 위치
    public static int myStartY, myStartX, myEndY, myEndX;
    public static int yourStartY, yourStartX, yourEndY, yourEndX;

    // 하늘 배열
    public static int[][] sky;

    // 그룹별 위치 개수 저장 배열
    public static int[] myGroups, yourGroups;

    // 방향 벡터
    public static int[] dy = {0,1,0,-1};
    public static int[] dx = {1,0,-1,0};

    // 탐색 메서드
    public static void solve(int row, int col, int group) {

        // 위치 저장 큐 생성
        Queue<Point> queue = new LinkedList<>();

        // 시작 지점 처리
        sky[row][col] = group;
        queue.offer(new Point(row, col));

        // 탐색 수행
        while(!queue.isEmpty()) {

            // 현재 위치
            Point point = queue.poll();

            // 이동 방향 확인
            for(int dir=0; dir<4; dir++) {
                int nextY = point.y + dy[dir];
                int nextX = point.x + dx[dir];

                // 범위 확인
                if(nextY<1 || nextY>rowSize || nextX<1 || nextX>colSize) continue;

                // 이미 방문했거나, 별자리인 경우
                if(sky[nextY][nextX] != 0) continue;

                // 이동 위치 추가
                sky[nextY][nextX] = group;
                queue.offer(new Point(nextY, nextX));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 가로, 세로 크기, 별의 개수 입력
        st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());
        starCount = Integer.parseInt(st.nextToken());

        // 하늘 배열 생성
        sky = new int[rowSize+1][colSize+1];

        // 별의 위치 입력
        for(int index=0; index<starCount; index++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            sky[row][col] = -1;
        }

        // 위치 입력
        st = new StringTokenizer(br.readLine());
        myStartY = Integer.parseInt(st.nextToken());
        myStartX = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        myEndY = Integer.parseInt(st.nextToken());
        myEndX = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        yourStartY = Integer.parseInt(st.nextToken());
        yourStartX = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        yourEndY = Integer.parseInt(st.nextToken());
        yourEndX = Integer.parseInt(st.nextToken());

        // 탐색
        int group = 1;
        for(int rowIndex=1; rowIndex<=rowSize; rowIndex++) {
            for(int colIndex=1; colIndex<=colSize; colIndex++) {
                if(sky[rowIndex][colIndex] == 0) {
                    solve(rowIndex,colIndex, group);
                    group++;
                }
            }
        }

        //  그룹별 위치 개수 저장 배열 생성
        myGroups = new int[group];
        yourGroups = new int[group];

        // 그룹 확인
        for(int rowIndex=Math.min(myStartY, myEndY); rowIndex<=Math.max(myStartY, myEndY); rowIndex++) {
            for(int colIndex=Math.min(myStartX, myEndX); colIndex<=Math.max(myStartX, myEndX); colIndex++) {
                if(sky[rowIndex][colIndex] > 0) {
                    myGroups[sky[rowIndex][colIndex]]++;
                }
            }
        }

        for(int rowIndex=Math.min(yourStartY, yourEndY); rowIndex<=Math.max(yourStartY, yourEndY); rowIndex++) {
            for(int colIndex=Math.min(yourStartX, yourEndX); colIndex<=Math.max(yourStartX, yourEndX); colIndex++) {
                if(sky[rowIndex][colIndex] > 0) {
                    yourGroups[sky[rowIndex][colIndex]]++;
                }
            }
        }

        // 결과 저장
        answer = 0;
        for(int index=1; index<group; index++) {
            answer += (long)myGroups[index] * yourGroups[index];
        }

        // 결과 출력
        System.out.println(answer);
    }
}