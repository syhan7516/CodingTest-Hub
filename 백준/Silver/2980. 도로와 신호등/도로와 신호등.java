import java.util.*;
import java.io.*;

class roadNode {
    private int red;
    private int green;

    public roadNode(int red, int green) {
        this.red = red;
        this.green = green;
    }

    public int getRed() {
        return this.red;
    }

    public int getGreen() {
        return this.green;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 신호등 개수, 도로의 길이 입력, 시간
        int totalTime = 0;
        int signalCnt = Integer.parseInt(st.nextToken());
        int roadLen = Integer.parseInt(st.nextToken());

        // 도로 생성
        ArrayList<ArrayList<roadNode>> roadStatus = new ArrayList<ArrayList<roadNode>>();
        for(int idx=0; idx<=roadLen; idx++) {
            roadStatus.add(new ArrayList<>());
        }

        // 신호등 위치, 지속 시간 입력
        for(int idx=0; idx<signalCnt; idx++) {
            st = new StringTokenizer(br.readLine());
            int signalPoint = Integer.parseInt(st.nextToken());
            int redTime = Integer.parseInt(st.nextToken());
            int greenTime = Integer.parseInt(st.nextToken());
            roadStatus.get(signalPoint).add(new roadNode(redTime,greenTime));
        }

        // 주행 시작
        for(int idx=0; idx<roadStatus.size(); idx++) {
            // 신호등이 있는 경우
            if(!roadStatus.get(idx).isEmpty()) {
                roadNode curNode = roadStatus.get(idx).get(0);
                int curRed = curNode.getRed();
                int curGreen = curNode.getGreen();

                int waitTime = totalTime % (curRed + curGreen);
                if(waitTime < curRed) {
                    totalTime += curRed - waitTime;
                }
            }
            totalTime += 1;
        }

        // 결과 출력
        System.out.println(totalTime-1);
    }
}