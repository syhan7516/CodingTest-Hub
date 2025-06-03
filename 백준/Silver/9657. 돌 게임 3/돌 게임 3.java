import java.util.*;
import java.io.*;

public class Main {
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 돌 개수 입력
        int stoneCount = Integer.parseInt(br.readLine());
        
        // 승리자 확인
        String winner = (stoneCount%7==0 || stoneCount%7==2) ? "CY" : "SK";
        
        // 결과 출력
        System.out.println(winner);
    }
}