class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        
        // 결과
        int answer = 0;
        
        // 주어진 시간 초로 변환
        s1 = (60*h1*60)+(60*m1)+s1;
        s2 = (60*h2*60)+(60*m2)+s2;
        
        // 종료 시간에 대해 12시를 가리키는 횟수 - 시작 시간에 대해 12시를 가리키는 횟수
        answer = s2 * 59/3600 + s2 * 719/43200 - s1 * 59/3600 - s1 * 719/43200;
        
        // 12시 넘은 경우
        if(s1>=43200) 
            answer += 1;
        
        if(s2>=43200)
            answer -= 1;
        
        // 12시
        if(s1*59%3600 == 0 || s1*719%43200 == 0) {
            answer += 1;
        }
        
        return answer;
    }
}