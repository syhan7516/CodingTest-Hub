import java.util.*;

class Solution {
    
    // 비트 차이 확인 메서드
    public static Long solve(long number) {
        
        StringBuilder sb = new StringBuilder();
        
        // 비트 분해
        char bit[] = Long.toBinaryString(number).toCharArray();
        
        // 비트 확인
        boolean flag = false;
        int index = bit.length-1;
        
        // 뒤에서 시작하여 비트 확인
        while(index>=0 && !flag) {
            
            // 비트가 0인 경우
            if(bit[index]=='0') {
                
                // 비트 변경, 변경 여부 갱신
                bit[index] = '1';
                flag = true;
                break;
            }
            
            // 다음 비트
            index--;
        }
        
        // 시작 위치 조정
        index++;
        
        // 0비트가 없는 경우
        if(!flag) {
            sb.append(1);
            flag = true;
        }
        
        // 끝난 다음 지점부터 비트 확인
        while(index<bit.length && flag) {
            
            // 비트가 1인 경우
            if(bit[index]=='1') {
                
                // 비트 변경, 변경 여부 갱신
                bit[index] = '0';
                flag = false;
                break;
            }
            
            // 다음 비트
            index++;
        }
        
        // 비트 저장
        for(int point=0; point<bit.length; point++)
            sb.append(bit[point]);
        
        // 10진수 변환
        return Long.parseLong(sb.toString(),2);
    }
    
    public long[] solution(long[] numbers) {
        
        // 결과 배열 생성
        long answer[] = new long[numbers.length];
        
        // 확인 수 순회
        for(int index=0; index<numbers.length; index++)
            answer[index] = solve(numbers[index]);
        
        return answer;
    }
}