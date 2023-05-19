import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    // 구슬 개수, 측정 수
    public static int beadCnt, measureCnt;
    // 구슬 관계 정보 리스트
    public static ArrayList<ArrayList<Integer>> heavyBead;
    public static ArrayList<ArrayList<Integer>> lightBead;
    // 구슬 개수 저장 배열
    public static boolean compareBead[];
    // 구슬 비교 결과 배열
    public static int hbv[];
    public static int lbv[];

    // 구슬 개수 확인 함수
    static void heavyBeadDfs(ArrayList<ArrayList<Integer>> beads, int firBead, int secBead) {
        for(int a=0; a<beads.get(firBead).size(); a++) {
            int curBead = beads.get(firBead).get(a);
            if(!compareBead[curBead]) {
                compareBead[curBead] = true;
                hbv[secBead]++;
                heavyBeadDfs(beads, curBead, secBead);
            }
        }
    }

    static void lightBeadDfs(ArrayList<ArrayList<Integer>> beads, int firBead, int secBead) {
        for(int a=0; a<beads.get(firBead).size(); a++) {
            int curBead = beads.get(firBead).get(a);
            if(!compareBead[curBead]) {
                compareBead[curBead] = true;
                lbv[secBead]++;
                lightBeadDfs(beads, curBead, secBead);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 구슬 개수, 측정 수 입력
        st = new StringTokenizer(br.readLine());
        beadCnt = Integer.parseInt(st.nextToken());
        measureCnt = Integer.parseInt(st.nextToken());

        // 관계 정보 만들기
        heavyBead = new ArrayList<>();
        lightBead = new ArrayList<>();
        for(int b=0; b<=beadCnt; b++) {
            heavyBead.add(new ArrayList<>());
            lightBead.add(new ArrayList<>());
        }

        // 관계 정보 입력
        for(int m=0; m<measureCnt; m++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            heavyBead.get(h).add(l);
            lightBead.get(l).add(h);
        }

        // 자기보다 무거운 구슬, 가벼운 구슬 개수 확인
        hbv = new int[beadCnt+1];
        for(int h=1; h<=beadCnt; h++) {
            compareBead = new boolean[beadCnt+1];
            compareBead[h] = true;
            heavyBeadDfs(heavyBead,h,h);
        }

        lbv = new int[beadCnt+1];
        for(int h=1; h<=beadCnt; h++) {
            compareBead = new boolean[beadCnt+1];
            compareBead[h] = true;
            lightBeadDfs(lightBead,h,h);
        }

        // 결과 출력
        int result = 0;
        for(int b=1; b<=beadCnt; b++) {
            if(hbv[b]>=(beadCnt+1)/2 || lbv[b]>=(beadCnt+1)/2)
                result++;
        }

        // 결과 출력
        System.out.println(result);
    }
}