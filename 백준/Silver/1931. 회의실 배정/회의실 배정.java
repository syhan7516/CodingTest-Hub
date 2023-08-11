import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 회의 클래스
class Meeting {
	int start;
	int end;
	
	public Meeting(int start, int  end) {
		this.start = start;
		this.end = end;
	}
}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 회의 개수
		int meetingCnt = Integer.parseInt(br.readLine());
		
		// 우선 순위 큐
		PriorityQueue<Meeting> priQ = new PriorityQueue<>((o1, o2) -> {
			if(o1.end < o2.end)
				return -1;
			else if(o1.end == o2.end) {
				if(o1.start < o2.end)
					return -1;
				return 1;
			}
			return 1;
		});
		
		// 회의 정보 입력
		for(int i=0; i<meetingCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			priQ.offer(new Meeting(start,end));
		}
		
		// 회의실 배정하기
		int result = 0;
		
		// 첫  회의 수행
		Meeting curMeeting = priQ.poll();
		int curStart = curMeeting.start;
		int curEnd = curMeeting.end;
		result++;
		
		while(!priQ.isEmpty()) {
			
			// 회의 정보 하나 가져오기
			curMeeting = priQ.poll();
			
			// 가져온 회의 시작 시간과 이전 회의 종료 시간이 같거나 클 경우
			if(curMeeting.start>=curEnd) {
				curStart = curMeeting.start;
				curEnd = curMeeting.end;
				result++;
			}
		}
		
		// 결과 출력
		System.out.println(result);
	}
}