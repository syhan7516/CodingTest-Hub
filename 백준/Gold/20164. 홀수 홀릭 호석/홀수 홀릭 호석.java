import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // 결과
    public static int minCount, maxCount;

    // 홀수 개수 구하기 메서드
    public static int getOddCount(String num) {

        // 홀수 개수
        int oddCount = 0;

        // 숫자 확인
        for(int numIndex=0; numIndex<num.length(); numIndex++) {
            if((num.charAt(numIndex)-'0')%2==1) {
                oddCount++;
            }
        }

        return oddCount;
    }

    // 연산 수행 메서드
    public static void solve(String num, int oddCount) {

        // 숫자 길이
        int numLen = num.length();

        // 홀수 개수 확인
        int currentOddCount = oddCount+getOddCount(num);

        // 길이가 1인 경우
        if(numLen==1) {
            minCount = Math.min(minCount,currentOddCount);
            maxCount = Math.max(maxCount,currentOddCount);
            return;
        }

        // 길이가 2인 경우
        if(numLen==2) {
            
            // 각 자리 수 더하기
            String sum = String.valueOf((num.charAt(0)-'0')+(num.charAt(1)-'0'));
            solve(sum,currentOddCount);
        }

        // 길이가 3이상인 경우
        else {
            
            // 자를 수 있는 위치 2곳 지정
            for(int firstCutIndex=1; firstCutIndex<numLen-1; firstCutIndex++) {
                for(int secondCutIndex=firstCutIndex+1; secondCutIndex<numLen; secondCutIndex++) {
                    
                    // 자른 숫자 확인
                    int firstNum = Integer.parseInt(num.substring(0,firstCutIndex));
                    int secondNum = Integer.parseInt(num.substring(firstCutIndex,secondCutIndex));
                    int thirdNum = Integer.parseInt(num.substring(secondCutIndex));
                    
                    // 자른 숫자 더하기
                    String sum = String.valueOf(firstNum+secondNum+thirdNum);
                    solve(sum,currentOddCount);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 숫자 입력
        String num = br.readLine();

        // 연산 수행
        minCount = Integer.MAX_VALUE;
        maxCount = Integer.MIN_VALUE;
        solve(num,0);

        // 결과 출력
        System.out.println(minCount+" "+maxCount);
    }
}