import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 문자열 클래스
class Letter {
    String l;
    int r;
    int c;

    public Letter(String l, int r, int c) {
        this.l = l;
        this.r = r;
        this.c = c;
    }
}

public class Main {

    // 가로, 세로, 문자열 개수
    public static int row, col, K;

    // 문자 보드판
    public static char board[][];

    // 문자열 완성 개수 해시
    public static HashMap<String,Integer> map;

    // 문자열 저장 배열
    public static String answer[];

    // 방향 벡터
    public static int dy[] = {0,1,1,1,0,-1,-1,-1};
    public static int dx[] = {1,1,0,-1,-1,-1,0,1};

    // 문자열 만들기 메서드
    static void solve(int r, int c) {

        // 만든 문자열 저장 큐 생성
        Queue<Letter> queue = new LinkedList<>();

        // 첫 문자 삽입
        queue.offer(new Letter(board[r][c]+"",r,c));

        // 문자열 제작 시도
        while(!queue.isEmpty()) {

            // 기준 문자열
            Letter current = queue.poll();

            // 문자열 길이 확인
            if(current.l.length()>5) return;

            // 문자열 확인
            if(map.containsKey(current.l))
                map.put(current.l,map.get(current.l)+1);

            // 문자 더하기
            for(int d=0; d<8; d++) {
                int ny = current.r + dy[d];
                int nx = current.c + dx[d];
                if(ny>row-1) ny = 0;
                if(ny<0) ny = row-1;
                if(nx>col-1) nx = 0;
                if(nx<0) nx = col-1;

                queue.offer(new Letter(current.l+board[ny][nx],ny,nx));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 가로, 세로, 문자열 개수 입력
        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 문자열 완성 개수 해시 생성
        map = new HashMap<>();

        // 문자 보드판 생성
        board = new char[row][col];

        // 문자 입력
        for(int i=0; i<row; i++) {
            String line = br.readLine();
            for(int j=0; j<col; j++)
                board[i][j] = line.charAt(j);
        }

        // 문자열 저장 배열 생성
        answer = new String[K];

        // 문자열 입력
        for(int i=0; i<K; i++) {
            String voca = br.readLine();
            map.put(voca,0);
            answer[i] = voca;
        }

        // 문자열 만들기
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++)
                solve(i,j);
        }

        // 결과 출력
        for(int i=0; i<K; i++)
            sb.append(map.get(answer[i])).append("\n");
        System.out.println(sb.toString());
    }
}