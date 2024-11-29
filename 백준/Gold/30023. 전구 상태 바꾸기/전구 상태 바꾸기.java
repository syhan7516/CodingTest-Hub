import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public final static int MAX = 900000;

    // 결과, 전구 개수
    public static int answer, bulbCount;

    // 전구 정보 배열
    public static char[] lights;

    // 전구 켜기 메서드
    public static int lightsOn() {

        // 전구 정보
        char lightsCopy[] = Arrays.copyOf(lights,bulbCount);

        // 색 변경 횟수
        int count = 0;
        
        for(int i=2; i<bulbCount-1; i++) {
            while(lightsCopy[0] != lightsCopy[i-1]) {
                change(lightsCopy, i);
                count++;
            }
        }

        for(int i=1; i<bulbCount; i++) {
            if(lightsCopy[0] != lightsCopy[i]) {
                count = MAX;
                break;
            }
        }

        return count;
    }

    // 전구 변경 메서드
    public static void change(char[] lightsCopy, int idx) {
        
        for(int i=idx-1; i<=idx+1; i++) {
            
            switch(lightsCopy[i]) {
                case 'R':
                    lightsCopy[i] = 'G';
                    break;
                case 'G':
                    lightsCopy[i] = 'B';
                    break;
                case 'B':
                    lightsCopy[i] = 'R';
                    break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 전구 개수 입력
        bulbCount = Integer.parseInt(br.readLine());

        // 전구 정보 입력
        lights = br.readLine().toCharArray();
        
        int firstLight = lightsOn();
        change(lights,1);
        
        int secondLight = lightsOn()+1;
        change(lights,1);
        
        int thirdLigth = lightsOn()+2;
        
        int minLights = Math.min(firstLight, Math.min(secondLight, thirdLigth));

        // 결과 저장
        answer = minLights==MAX ? -1 : minLights;

        // 결과 출력
        System.out.println(answer);
    }
}