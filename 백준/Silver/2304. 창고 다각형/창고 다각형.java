import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 기둥 개수 입력
        int block = Integer.parseInt(br.readLine());
        
        // 기둥 배열 생성
        int blocks[] = new int[1001];
        
        // 처음과 끝 셋팅
        int start = Integer.MAX_VALUE;
        int end = 0;
        
        // 기둥 정보 입력
        for (int b = 0; b < block; b++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int point = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            blocks[point] = height;
            start = Math.min(point, start);
            end = Math.max(point, end);
        }
        
        // 기둥 비교하기
        Stack<Integer> stack = new Stack<>();
        
        // 왼쪽 비교
        int stock = blocks[start];
        for (int l=start+1; l<=end; l++) {
            if(blocks[l]<stock)  {
                stack.push(l);
            }
            else {
                while (!stack.isEmpty()) {
                    int h = stack.pop();
                    blocks[h] = stock;
                }
                stock = blocks[l];
            }
        }
        stack.clear();
        
        //오른쪽 비교
        stock=blocks[end];
        for(int r=end-1; r>=start; r--){
            if(blocks[r]<stock) stack.push(r);
            else {
                while (!stack.isEmpty()) {
                    int h = stack.pop();
                    blocks[h]=stock;
                }
                stock=blocks[r];
            }
        }

        // 결과 저장
        int result = 0;
        for (int area = start; area <= end; area++) {
            result += blocks[area];
        }
        sb.append(result).append("\n");
        
        // 결과 출력
        System.out.print(sb);
    }
}