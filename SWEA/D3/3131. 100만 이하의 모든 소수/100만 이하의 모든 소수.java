public class Solution {
    public static void main(String[] args) throws Exception{
        StringBuilder sb = new StringBuilder();

        boolean prime[] = new boolean[1000001];

        for(int a=2; a*a<=1000000; a++) {
            if(!prime[a]) {
                for(int b=a+a; b<=1000000; b+=a)
                    prime[b] = true;
            }
        }

        for(int n=2; n<=1000000; n++) {
            if(!prime[n])
                sb.append(n+" ");
        }
        

        // 결과 출력
        System.out.println(sb.toString());
    }
}