import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// 줄 클래스
class Line {
    int start;
    int end;

    public Line(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Main {

    // 결과, 줄 개수
    public static int answer, lineCount;

    // 줄 저장 리스트
    public static ArrayList<Line> lines;

    // 선 확인 메서드
    public static void solve() {

        // 끝 점 기준 배열 생성
        int ends[] = new int[lineCount];

        // 끝 점 수 입력
        for(int index=0; index<lines.size(); index++)
            ends[index] = lines.get(index).end;

        // DP 생성
        int DP[] = new int[lineCount];

        // LIS
        for(int index=0; index<lineCount; index++) {

            // 초기 설정
            int maxCount = 1;

            for(int end=index-1; end>=0; end--) {

                // 수가 더 작은 경우
                if(ends[end]<ends[index])
                    maxCount = Math.max(maxCount,DP[end]+1);
            }

            // 결과 갱신
            DP[index] = maxCount;
            answer = Math.max(answer,maxCount);
        }
        
        // 결과 저장
        answer = lineCount-answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 줄 개수 입력
        lineCount = Integer.parseInt(br.readLine());

        // 줄 저장 리스트 생성
        lines = new ArrayList<>();

        // 줄 정보 입력
        for(int index=0; index<lineCount; index++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lines.add(new Line(start, end));
        }

        // 시작 선 기준 정렬
        Collections.sort(lines, (a,b) -> a.start - b.start);

        // 선 확인
        answer = 0;
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}