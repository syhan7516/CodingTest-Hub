import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 결과
        int answer[] = {Integer.MAX_VALUE, Integer.MAX_VALUE};

        // 장애물 길이, 높이 입력
        st = new StringTokenizer(br.readLine());
        int caveLen = Integer.parseInt(st.nextToken());
        int caveHeight = Integer.parseInt(st.nextToken());

        // 종류석, 석순 높이 정보 배열 생성
        int bottomStoneCount[] = new int[caveHeight + 1];
        int ceilingStoneCount[] = new int[caveHeight + 1];

        // 종류석, 석순 높이 정보 입력
        for (int stone = 1; stone <= caveLen; stone++) {

            // 높이 입력
            int height = Integer.parseInt(br.readLine());

            // 짝수일 경우 석순 위치에 높이 개수 증가
            if (stone % 2 == 0) ceilingStoneCount[height]++;

                // 홀수일 경우 종류석 위치에 높이 개수 증가
            else bottomStoneCount[height]++;
        }

        // 높이에 따른 장애물 누적합 구하기
        for (int height = caveHeight - 1; height > 0; height--) {
            bottomStoneCount[height] += bottomStoneCount[height + 1];
            ceilingStoneCount[height] += ceilingStoneCount[height + 1];
        }

        // 장애물 파괴 횟수 구하기
        for (int height = 1; height <= caveHeight; height++) {

            // 장애물 파괴 수
            int stoneCount = bottomStoneCount[height] + ceilingStoneCount[caveHeight - height + 1];

            // 비교
            if (stoneCount < answer[0]) {
                answer[0] = stoneCount;
                answer[1] = 1;
            } else {
                if (stoneCount == answer[0])
                    answer[1]++;
            }
        }

        // 결과 출력
        System.out.println(answer[0] + " " + answer[1]);
    }
}