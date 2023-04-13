import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 가로, 세로 크기 입력
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        // 구름 정보 입력
        int groom[][] = new int[row][col];
        for(int a=0; a<row; a++) {
            String letters = br.readLine();
            for(int b=0; b<letters.length(); b++) {
                if(letters.charAt(b)=='c')
                    groom[a][b] = 0;
                else
                    groom[a][b] = -1;
            }
        }

        // 구름 이동
        int timeCheck = 0;
        while(true) {
            // 시간 경과
            timeCheck += 1;
            // 종료 조건
            if(timeCheck==col)
                break;
            for(int a=0; a<row; a++) {
                for(int b=col-1; b>0; b--) {
                    if(groom[a][b-1]>=0 && groom[a][b]==-1)
                        groom[a][b] = timeCheck;
                }
            }
        }

        // 구름 출력
        for(int a=0; a<row; a++) {
            for(int b=0; b<col; b++)
                System.out.print(groom[a][b]+" ");
            System.out.println();
        }
    }
}