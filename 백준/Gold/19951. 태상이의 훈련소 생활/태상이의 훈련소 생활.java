import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 장소 크기, 조교 수
    public static int areaSize, saramCount;

    // 장소, 작업, 결과 배열
    public static int[] area, jobs, answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 장소 크기, 조교 수 입력
        st = new StringTokenizer(br.readLine());
        areaSize = Integer.parseInt(st.nextToken());
        saramCount = Integer.parseInt(st.nextToken());

        // 배열 생성
        area = new int[areaSize+1];
        jobs = new int[areaSize+2];
        answer = new int[areaSize+1];

        // 장소 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int index=1; index<=areaSize; index++) {
            area[index] = Integer.parseInt(st.nextToken());
        }

        // 조교 지시 정보 입력
        for(int index=0; index<saramCount; index++) {
            st = new StringTokenizer(br.readLine());
            int startIndex = Integer.parseInt(st.nextToken());
            int endIndex = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            jobs[startIndex] += height;
            jobs[endIndex+1] += -height;
        }

        // 작업 수행
        int currentHeight = 0;
        for(int index=1; index<=areaSize; index++) {

            // 지시가 있는 구간인 경우
            if(jobs[index]!=Integer.MAX_VALUE) {
                currentHeight += jobs[index];
            }

            // 작업 수행
            answer[index] = area[index]+currentHeight;
        }

        // 결과 출력
        for(int index=1; index<=areaSize; index++) {
            sb.append(answer[index]).append(" ");
        }
        System.out.println(sb.toString());
    }
}