import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 이모티콘 클래스
class Eimoticon {

    int display;
    int board;
    int count;

    public Eimoticon(int display, int board, int count) {
        this.display = display;
        this.board = board;
        this.count = count;
    }

    public boolean isTarget(int target) {
        return display==target;
    }

    public Eimoticon pasteDisplayToBoard() {
        return new Eimoticon(display,display,count+1);
    }

    public Eimoticon addBoardToDisplay() {
        return new Eimoticon(display+board,board,count+1);
    }

    public Eimoticon removeOneDisplay() {
        return new Eimoticon(display-1,board,count+1);
    }

    public boolean isBoardThanZero() {
        return board>0;
    }

    public boolean isNotDisplayThanTarget(int target) {
        return display<=target;
    }

    public boolean isDisplayThanZero() {
        return display>0;
    }
}

public class Main {

    // 이모티콘 연산하기 메서드
    public static int solve(int target) {

        // 연산 정보 저장 큐 생성
        Queue<Eimoticon> queue = new LinkedList<>();

        // 결과 방문 여부 배열 생성
        boolean visited[][] = new boolean[1001][1001];

        // 초기 설정
        queue.offer(new Eimoticon(1,0,0));
        visited[1][0] = true;

        // 이모티콘 연산 수행
        while(!queue.isEmpty()) {

            // 현재 이모티콘 정보
            Eimoticon eimoticon = queue.poll();

            // 이모티콘 개수에 도달한 경우
            if(eimoticon.isTarget(target))
                return eimoticon.count;

            // 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장
            Eimoticon paste = eimoticon.pasteDisplayToBoard();
            if(!visited[paste.display][paste.board]) {
                queue.offer(paste);
                visited[paste.display][paste.board] = true;
            }

            // 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기
            Eimoticon add = eimoticon.addBoardToDisplay();
            if(eimoticon.isBoardThanZero() && add.isNotDisplayThanTarget(target) && !visited[add.display][add.board]) {
                queue.offer(add);
                visited[add.display][add.board] = true;
            }

            // 화면에 있는 이모티콘 중 하나를 삭제
            Eimoticon remove = eimoticon.removeOneDisplay();
            if(eimoticon.isDisplayThanZero() && !visited[remove.display][remove.board]) {
                queue.offer(remove);
                visited[remove.display][remove.board] = true;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 이모티콘 개수 입력
        int emoticonCount = Integer.parseInt(br.readLine());

        // 이모티콘 연산하기
        int answer = solve(emoticonCount);

        // 결과 출력
        System.out.println(answer);
    }
}