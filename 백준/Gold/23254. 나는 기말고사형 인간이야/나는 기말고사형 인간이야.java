import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 점수 클래스
class Score implements Comparable<Score> {
    int rest;
    int rate;

    public Score(int rest, int rate) {
        this.rest = rest;
        this.rate = rate;
    }

    @Override
    public int compareTo(Score other) {
        return other.rate - this.rate;
    }
}

public class Main {

    // 결과, 시간, 과목 수
    public static int answer, time, subjectCount;

    // 점수 우선 순위 큐
    public static PriorityQueue<Score> queue;

    // 초기 점수, 시간당 점수 저장 배열
    public static int[] basicScores, timePerScores;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 시간, 과목 수 입력
        st = new StringTokenizer(br.readLine());
        time = Integer.parseInt(st.nextToken()) * 24;
        subjectCount = Integer.parseInt(st.nextToken());

        // 점수 우선 순위 큐 생성
        queue = new PriorityQueue<>();

        // 초기 점수, 시간당 점수 저장 배열 생성
        basicScores = new int[subjectCount];
        timePerScores = new int[subjectCount];

        // 초기 점수 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int index=0; index<subjectCount; index++) {
            basicScores[index] = Integer.parseInt(st.nextToken());
            answer += basicScores[index];
        }

        // 시간당 점수 입력
        st = new StringTokenizer(br.readLine());
        for(int index=0; index<subjectCount; index++) {
            timePerScores[index] = Integer.parseInt(st.nextToken());
        }

        // 과목 정보 저장
        for(int index=0; index<subjectCount; index++) {
            queue.add(new Score(100 - basicScores[index], timePerScores[index]));
        }

        // 학습 수행
        while(!queue.isEmpty() && time > 0) {

            // 현재 과목
            Score score = queue.poll();

            // 학습 - 주어진 시간 안에 학습 가능한 경우
            if(time >= score.rest / score.rate) {
                time -= score.rest / score.rate;
                answer += (score.rest / score.rate) * score.rate;

                // 추가 학습이 필요한 경우
                if(score.rest % score.rate != 0) {
                    int restScore = score.rest % score.rate;
                    queue.offer(new Score(restScore, restScore));
                }
            }

            // 학습이 불가능한 경우
            else {
                answer += time * score.rate;
                time = 0;
            }
        }

        // 결과 출력
        System.out.println(answer);
    }
}