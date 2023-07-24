import java.util.ArrayList;

public class HW_07June {
    boolean isPalindrome(int n){
        int count=0;
        String nums=""+n;
        int len=nums.length();
        if(len%2==0){
            for(int i=0;i<len/2;i++){
                if(nums.charAt(i)==nums.charAt(len-i-1)){
                    count+=2;
                }else {
                    return false;
                }
            }
            if(count==len){
                return true;
            }
            return false;
        }
        else if(len%2!=0){
            for(int i=0;i<=len/2;i++){
                if(nums.charAt(i)==nums.charAt(len-i-1)){
                    count+=2;
                }else {
                    return false;
                }
            }
            if(count-1==len){
                return true;
            }
            return false;
        }
        return false;

    }
    boolean isPrime(int n) {
        ArrayList<Integer> prime = new ArrayList<>();
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to sqrt(n)
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0){
                return false;
            }
            else{
                prime.add(i);
            }

        return true;
    }
    public int primePalindrome(int n) {

        HW_07June t=new HW_07June();
        int k=n;
        while(k>=n){
            if (10_000_000 < k && k < 100_000_000){
                k=10_000_000;
            }
            if(t.isPrime(k)&& t.isPalindrome(k)){
                break;
            }
            else{
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        System.out.println("Bababooey");
    }
}