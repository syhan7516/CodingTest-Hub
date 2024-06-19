import java.util.*;

// 단어 클래스
class Word {
    String letter;
    int cnt;
    
    public Word(String letter, int cnt) {
        this.letter = letter;
        this.cnt = cnt;
    }
}

class Solution {

    // 결과
    public static int answer;
    
    // 방문 여부 배열
    public static boolean visited[];
    
    // 단어 차이 확인 메서드
    static boolean diffLetter(String a, String b) {
        
        // 차이 개수
        int cnt = 0;
        
        // 두 단어 확인
        for(int i=0; i<a.length(); i++) {
            
            // 다른 경우 개수 증가
            if(a.charAt(i)!=b.charAt(i))
                cnt++;
            
            // 2개 이상 차이나는 경우
            if(cnt>=2)
                return true;
        }
        
        return false;
    }
    
    // 단어 변환하기 메서드
    static void solve(String begin, String target, String[] words) {
        
        // 변환한 단어 관리하는 큐 생성
        Queue<Word> queue = new LinkedList<>();
        
        // 방문 여부 배열 생성
        visited = new boolean[words.length];
        
        // 첫 단어 삽입
        queue.offer(new Word(begin,0));
        
        // 큐 확인
        while(!queue.isEmpty()) {
            
            // 현재 단어
            Word current = queue.poll();
            
            // 단어가 같은 경우
            if(current.letter.equals(target)) {
                answer = current.cnt;
                return;
            }
            
            // 단어 확인
            for(int i=0; i<words.length; i++) {
                
                // 이미 방문한 경우
                if(visited[i]) continue;
                
                // 알파벳 2개 이상 다른 경우
                if(diffLetter(current.letter,words[i])) continue;
                
                // 변환 수행
                visited[i] = true;
                queue.offer(new Word(words[i],current.cnt+1));
            }
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        
        // 단어 변환하기
        answer = 0;
        solve(begin,target,words);
        
        return answer;
    }
}