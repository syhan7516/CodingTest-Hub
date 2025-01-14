import java.io.*;
import java.util.*;

public class Main {

    // 빌딩 개수, 가장 많이 보이는 빌딩
    public static int buildingCount, maxheight;

    // 빌딩 배열
    public static int buildings[];

    // 빌딩 확인 메서드
    public static int solve(int building) {

        // 개수
        int count = 0;

        // 이전 기울기
        double preLine = 0;

        // <-
        for(int index=building-1; index>=0; index--) {

            // 현재 기울기
            double currentLine = (double)(buildings[building]-buildings[index])/(building-index);

            // 기존보다 작은 경우
            if(index==building-1 || preLine>currentLine) {
                count++;
                preLine = currentLine;
            }
        }

        // ->
        for(int index=building+1; index<buildingCount; index++) {

            // 현재 기울기
            double currentLine = (double)(buildings[building]-buildings[index])/(building-index);

            // 기존보다 큰 경우
            if(index==building+1 || preLine<currentLine) {
                count++;
                preLine = currentLine;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 빌딩 개수 입력
        buildingCount = Integer.parseInt(br.readLine());

        // 빌딩 배열 생성
        buildings = new int[buildingCount];

        // 빌딩 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int index=0; index<buildingCount; index++)
            buildings[index] = Integer.parseInt(st.nextToken());

        // 가장 높은 건물 확인
        maxheight = 0;
        for (int index=0; index<buildingCount; index++) {
            maxheight = Math.max(maxheight,solve(index));
        }

        // 결과 출력
        System.out.println(maxheight);
    }
}