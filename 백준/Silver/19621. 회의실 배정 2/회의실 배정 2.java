import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 회의 클래스
class Meeting implements Comparable<Meeting> {
	int start;
	int end;
	int memberCnt;
	
	public Meeting(int start, int  end, int memberCnt) {
		this.start = start;
		this.end = end;
		this.memberCnt = memberCnt;
	}
	
	public int compareTo(Meeting other) {
		if(this.start < other.start)
			return -1;
		
		return 1;
	}
}

public class Main {
	
	// 회의 개수, 결과
	public static int meetingCnt, result;
	// 미팅 정보 배열
	public static Meeting[] meetings;
	
	// 회의 배정하기
	static void solve(int idx, int time, int member) {
		
		// 회의 시간 확인하기
		for(int m=idx; m<meetingCnt; m++) {
			if(meetings[m].start>=time)
				solve(m+1,meetings[m].end,member+meetings[m].memberCnt);
		}
		
		// 최대 값 갱신
		result = Math.max(result, member);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 회의 개수
		meetingCnt = Integer.parseInt(br.readLine());
		
		// 미팅 정보 배열
		meetings = new Meeting[meetingCnt];
		
		// 회의 정보 입력
		for(int i=0; i<meetingCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int memberCnt = Integer.parseInt(st.nextToken());
			meetings[i] = new Meeting(start,end,memberCnt);
		}
		
		// 시작 시간 기준으로 정렬
		Arrays.sort(meetings);
		
		// 회의 배정하기
		result = 0;
		solve(0,0,0);
		
		// 결과 출력
		System.out.println(result);
	}
}