import java.util.*;
import java.io.*;

public class Main {
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 돌 개수 입력
        int stoneCount = Integer.parseInt(br.readLine());
        
        // 승리자 저장 배열 생성
        int winner[] = new int[1001];
        
        // 초기 설정
        winner[1] = 1;
        winner[2] = -1;
        winner[3] = 1;
        
        // 승리자 확인
        for(int index=4; index<1001; index++) {
            winner[index] = winner[index-1] * -1;
        }
        
        // 결과 출력
        if(winner[stoneCount]==1) System.out.println("SK");
        else System.out.println("CY");
    }
}