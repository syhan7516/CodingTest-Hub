import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    //웅덩이 정보 관련 클래스
    static class Info implements Comparable<Info>{
        int s, e;	//s : 시작값, e : 끝 값
        //기본 생성자
        public Info(int s, int e){
            this.s = s;
            this.e = e;
        }

        //시작값 기준 오름차순 정렬
        //시작값 같으면 끝 값 내림차순 정렬
        @Override
        public int compareTo(Info o) {
            if(this.s == o.s)
                return o.e - this.e;
            return this.s - o.s;
        }
    }
    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());	//웅덩이 개수
        int L = Integer.parseInt(st.nextToken());	//널빤지 길이
        PriorityQueue<Info> pq = new PriorityQueue<>();	//정렬하여 사용할 PriorityQueue
        //웅덩이 정보 저장 및 정렬
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pq.offer(new Info(s, e));
        }
        int result = 0;	//널빤지 개수
        int fill = 0;	//널빤지를 덮은 최대 위치
        //널빤지로 다리 만들기 진행
        while(!pq.isEmpty()){
            Info cur = pq.poll();	//현재 웅덩이
            //현재 웅덩이가 이미 널빤지로 채워진 경우
            if(cur.e < fill)
                continue;

            if(fill < cur.s)	//현재 웅덩이 시작 위치 기준 최대 위치로 변경
                fill = cur.s;

            int remain = (cur.e - fill) % L;	//널빤지 범위 넘어가는 값 구하기
            result += (cur.e - fill) / L;	//사용할 널빤지 개수 구하기
            fill = cur.e;
            //널빤지 범위 넘어갈 때
            if(remain != 0) {
                result++;
                fill += L - remain;
            }

        }
        bw.write(String.valueOf(result));	//널빤지 개수 BufferedWriter 저장
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
}