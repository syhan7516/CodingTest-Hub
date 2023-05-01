import java.util.*;

class Solution {
    
    // 각 번호 위치
    public static int dx[] = {-1,0,1,2,0,1,2,0,1,2,0,1,2};
    public static int dy[] = {-1,0,0,0,1,1,1,2,2,2,3,3,3};
    
    // 거리 확인 함수
    static int distCheck(int point, int row, int col) {
        
        int curRow = dy[point];
        int curCol = dx[point];
        
        return Math.abs(curRow-row)+Math.abs(curCol-col);
    }
    
    public String solution(int[] numbers, String hand) {
        
        // 결과
        String answer = "";
        
        // 손 위치
        int left = 10;
        int right = 12;
        
        for(int n=0; n<numbers.length; n++) {
            
            // 누를 번호
            int curNum = numbers[n];
            if(curNum==0) curNum = 11; 
            
            // 왼쪽 방향
            if(curNum==1 || curNum==4 || curNum==7 || curNum==10) {
                left = curNum;
                answer += 'L';
            }
            
            // 오른쪽 방향
            else if(curNum==3 || curNum==6 || curNum==9 || curNum==12) {
                right = curNum;
                answer += 'R';
            }
            
            // 중간
            else {
                int row = dy[curNum];
                int col = dx[curNum];
                
                int leftResult = distCheck(left,row,col);
                int rightResult = distCheck(right,row,col);
                
                // 왼쪽이 더 가까울 경우
                if(leftResult<rightResult) {
                    left = curNum;
                    answer += 'L';
                }
                
                // 오른쪽이 더 가까울 경우
                else if(leftResult>rightResult) {
                    right = curNum;
                    answer += 'R';
                }
                
                // 같을 경우
                else {
                    if(hand.equals("right")) {
                        right = curNum;
                        answer += 'R';
                    }
                    else {
                        left = curNum;
                        answer += 'L';
                    }
                }
            }
        }
        
        return answer;
    }
}