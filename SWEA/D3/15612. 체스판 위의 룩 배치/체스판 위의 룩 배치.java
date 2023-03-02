import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
class rookNode {
    private int y;
    private int x;
 
    public rookNode(int y, int x) {
        this.y = y;
        this.x = x;
    }
 
    public int getY() {
        return this.y;
    }
 
    public int getX() {
        return this.x;
    }
}
 
public class Solution {
 
    public static char board[][];
    public static boolean gameCheck;
    public static Queue<rookNode> queue;
 
    static void getCheckRook() {
        while(!queue.isEmpty()){
            rookNode curNode = queue.poll();
            int curRow = curNode.getY();
            int curCol = curNode.getX();
 
            board[curRow][curCol] = '.';
            for(int idx=0; idx<8; idx++) {
                if(board[curRow][idx]=='O' || board[idx][curCol]=='O') {
                    gameCheck = false;
                    return;
                }
            }
 
            board[curRow][curCol] = 'O';
        }
    }
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        // 케이스 수 입력
        int caseNum = Integer.parseInt(st.nextToken());
        // 케이스 수만큼 작업 반복
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {
            // 체스판 만들기
            board = new char[8][8];
            gameCheck = true;
            queue = new LinkedList<>();
            for(int row=0; row<8; row++) {
                st = new StringTokenizer(br.readLine());
                String letters = st.nextToken();
                for(int col=0; col<8; col++) {
                    board[row][col] = letters.charAt(col);
                    if(board[row][col]=='O')
                        // 룩 위치 큐에 넣기
                        queue.offer(new rookNode(row,col));
                }
            }
 
            // 룩 확인
            if(queue.size()==8)
                getCheckRook();
            else
                gameCheck=false;
 
            // 결과 확인
            System.out.print("#"+(caseIdx+1)+ " ");
            if(gameCheck==true)
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}