import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 케이스 수 입력
        int caseNum = scanner.nextInt();
        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {
            // 결과
            String result[] = new String[3];
            // 현재 시간 입력
            String beforeTime[] = scanner.next().split(":");
            // 약속 시간 입력
            String afterTime[] = scanner.next().split(":");

            // 남은 약속 시간 확인
            int beforeTimeSec = 0;
            int afterTimeSec = 0;
            for(int idx=0; idx<2; idx++) {
                beforeTimeSec += Integer.parseInt(beforeTime[idx]) * Math.pow(60,2-idx);
                afterTimeSec += Integer.parseInt(afterTime[idx]) * Math.pow(60,2-idx);
            }
            beforeTimeSec += Integer.parseInt(beforeTime[2]);
            afterTimeSec += Integer.parseInt(afterTime[2]);

            // 약속 시간이 더 빠른 경우
            if(beforeTimeSec>afterTimeSec)
                afterTimeSec += 86400;
            
            // 남은 시간 초 계산
            int diffTime = afterTimeSec-beforeTimeSec;
            
            // 시, 분, 초 환산
            result[2] = Integer.toString(diffTime%60);
            result[1] = Integer.toString((diffTime/60)%60);
            result[0] = Integer.toString(diffTime/60/60);
            
            // 시간 자리 수 맞추기
            for(int idx=0; idx<3; idx++) {
                if(result[idx].length()==1)
                    result[idx] = "0"+result[idx];
            }

            // 결과 출력
            System.out.println("#"+(caseIdx+1)+" "+String.join(":",result));
        }
        scanner.close();
    }
}