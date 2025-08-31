import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 숫자 클래스
class Num {
    int number;
    int count;

    public Num(int number, int count) {
        this.number = number;
        this.count = count;
    }
}

public class Main {

    // 결과, 숫자, 길이, 교환 횟수
    public static int answer, startNum, numLen, changeCount;

    // 방문 여부 배열
    public static boolean[][] visited;

    // 숫자 길이 구하기 메서드
    public static int getNumLen(int num) {
        int len = 0;

        while(num != 0) {
            num /= 10;
            len++;
        }

        return len;
    }

    // 자리 변경 메서드
    public static String changePosition(String stringNum, int position1, int position2) {
        StringBuilder sb = new StringBuilder(stringNum);
        int mockPosition = position2;
        sb.setCharAt(position2, stringNum.charAt(position1));
        sb.setCharAt(position1, stringNum.charAt(mockPosition));

        return sb.toString();
    }

    // 자리 바꾸기 메서드
    public static void solve() {

        // 방문 여부 배열 생성
        visited = new boolean[changeCount+1][1000001];

        // 큐 생성
        Queue<Num> queue = new LinkedList<>();

        // 시작 숫자 처리
        visited[0][startNum] = true;
        queue.offer(new Num(startNum, 0));

        // 탐색
        while(!queue.isEmpty()) {

            // 현재 숫자
            Num currentNum = queue.poll();

            // 교환 횟수를 다 채운 경우
            if(currentNum.count == changeCount) {
                answer = Math.max(answer, currentNum.number);
                continue;
            }

            // 숫자 문자열로 변환
            String currentStringNum = String.valueOf(currentNum.number);

            // 자리 바꾸기
            for(int a=0; a<currentStringNum.length(); a++) {
                for(int b=0; b<currentStringNum.length(); b++) {

                    if(a == b) continue;

                    String changeStringNum
                            = changePosition(currentStringNum, a, b);

                    // 숫자로 변환
                    int changeNum = Integer.parseInt(changeStringNum);

                    // 앞자리가 0인 경우
                    if(getNumLen(changeNum) != numLen) continue;

                    // 범위 확인
                    if(changeNum > 1000000) continue;

                    // 방문 여부 확인
                    if(visited[currentNum.count+1][changeNum]) continue;

                    // 탐색 대상 추가
                    visited[currentNum.count+1][changeNum] = true;
                    queue.offer(new Num(changeNum, currentNum.count+1));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 숫자, 교환 횟수 입력
        st = new StringTokenizer(br.readLine());
        startNum = Integer.parseInt(st.nextToken());
        numLen = getNumLen(startNum);
        changeCount = Integer.parseInt(st.nextToken());

        // 자리 바꾸기
        answer = -1;
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}