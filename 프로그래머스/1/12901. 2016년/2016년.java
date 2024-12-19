import java.time.*;

class Solution {
    public String solution(int a, int b) {
        
        String weeks[] = {"","MON","TUE","WED","THU","FRI","SAT","SUN"};
        
        LocalDate date = LocalDate.of(2016,a,b);
        
        int week = date.getDayOfWeek().getValue();
        
        return weeks[week];
    }
}