import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        
        // 결과
        int[] answer = new int[2];
        
        // 번호, 횟수
        int turn = 1;
        int time = 1;
        
        Stack<String> done = new Stack<>();
        boolean ispass = true;
        done.add(words[0]);
        
        // 끝말잇기
        for (int i = 1; i < words.length; i++) {
            String word = words[i];
             if (turn == n) {
                turn = 1;
                time++;
            } else {
                turn++;
            }
            
            if (done.contains(word)){
               ispass = false;
                break;
            }
            
            char[] beforeWord = done.peek().toCharArray();
            int size = beforeWord.length;
            char[] nowWord = word.toCharArray();
            if (beforeWord[size-1] != nowWord[0]){
                ispass = false;
                break;
            } 
            done.add(word);
           
        }
        
        if (ispass) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = turn;
            answer[1] = time;
        }

        return answer;
    }
}