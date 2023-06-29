import java.io.*;
import java.util.*;

class Solution {
    
    // 컴퓨터 대표 번호 지정 배열
    public static int parent[];
    
    // 대표 번호 확인 함수
    static int find(int number) {
        
        // 대표 번호가 자신을 경우
        if(parent[number]==number) 
            return number;
        
        // 대표 번호 갱신
        return parent[number] = find(parent[number]);
    }
    
    public int solution(int n, int[][] computers) {
        
        // 컴퓨터 대표 번호 저장 배열 만들기
        parent = new int[n];
        
        // 초기 대표 번호 지정
        for (int p=0; p<n; p++) {
            parent[p] = p;
        }
        
        // 연결 정보 확인
        for (int a=0; a<n; a++) {
            for (int b=0; b<n; b++) {
                
                // 각 컴퓨터 연결 정보 확인
                if (a!=b && computers[a][b]==1) {
                    
                    // 각 컴퓨터 대표 번호 확인
                    int firCom = find(a);
                    int secCom = find(b);
                    
                    // 대표 번호 갱신
                    parent[secCom] = firCom;      
                }     
            }
        }
        
        // 각 컴퓨터 네트워크 재확인
        for(int net=0; net<n; net++) {
            find(net);
        }
        
        // 네트워크 저장 해시셋
        HashSet<Integer> cnt = new HashSet();
        
        // 각 컴퓨터 네트워크 확인
        for (int net=0; net<n; net++) {
            cnt.add(parent[net]);
        }
        
        // 네트워크 개수 저장
        int answer = cnt.size();
        
        return answer;
    }
}