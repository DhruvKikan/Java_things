import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class PrimePali {
    /*
    public boolean ispali1(int n){
        int comp = 0;
        int t = n;
        while (t != 0) {
            comp = (comp * 10) + (t % 10);
            t/=10;
        }
        return(comp == n);
    }

    public ArrayList<Integer> primer(int lim){
        boolean[] bprim = new boolean[lim+1];
        ArrayList<Integer> primes = new ArrayList<>();

        Arrays.fill(bprim, true);
        bprim[0]=false;
        bprim[1]=false;

        for(int i=2; i<lim; i++){
            if(bprim[i]){
                for(int j=i; i*j<lim; j+=1){
                    bprim[i*j]=false;
                }
                if(ispali1(i)){
                    primes.add(i);
                }
            }
        }
        return primes;
    }

    public int primePalind(int n){ // Want to return prime palindrome greater than/equal to n
        PrimePali trial = new PrimePali();

        ArrayList<Integer> primepalis = trial.primer((int)Math.pow(10, 7));
        int k=n;
        for(int i=0; i<primepalis.size(); i++){
            if(primepalis.get(i)<k){
                continue;
            }else{
                k=primepalis.get(i);
                break;
            }
        }
        return k;
    }


    public static void main(String[] args) {
        PrimePali trial = new PrimePali();
        Scanner input = new Scanner(System.in);
        int num=0;
        System.out.print("Input retuired number: ");
        num= input.nextInt();

        System.out.println(trial.primePalind(num));
    }
    */

    /*
    public int primePalindrome(int n){
        int k=n;
        if(n%2==0){
            k+=1;
        }
        int i=0;
        int len=(int)Math.log10(k);
        while(k>n&&i<len){ // (int)Math.log10(num) provides length of number 'num' starting at 0
            boolean pali_check=false;
            boolean prim_chek=true;
            if(((int)((k/Math.pow(10, len-i))%10))==((int)((k/Math.pow(10, i))%10))){ // Digit-wise palindrome condition?
                pali_check=true;
                i++;

                // Checking for prime?
                for(int j=2; i<=((int) Math.sqrt(k))+1; j++){
                    if(k%i==0){
                        prim_chek=false;
                    }
                }
            }
            if(k>=n&&((i<len)==false)){
                k+=2;
            }
            if(pali_check&&prim_chek){
                break;
            }
        }
        return k;
    }

    public boolean check_palicheker(int n) {
        int k = n;
        if (n % 2 == 0) {
            k += 1;
        }
        int i = 0;
        int len = (int) Math.log10(k);
        boolean pali_check = false;
        while (k >= n && i < len) { // (int)Math.log10(num) provides length of number 'num' starting at 0
            pali_check = false;
            boolean prim_chek = true;
            if (((int) ((k / Math.pow(10, len - i)) % 10)) == ((int) ((k / Math.pow(10, i)) % 10))) { // Digit-wise palindrome condition?
                pali_check = true;
                i++;
            }
            if(k>=n&&((i<len)==false)&&pali_check==false){
                k+=2;
            }
            for(int j=2; i<=((int) Math.sqrt(k))+1; j++){
                if(k%i==0){
                    prim_chek=false;
                }
            }
            if(pali_check&&prim_chek){
                System.out.println(k);
            }
        }
        System.out.println(k);
        return (pali_check);
    }

    // Implement optimized palindrome checker (int (a/Math.pow(10, i-1))%10)
    // Implement optimized prime checker (Math.sqrt(n))

     */


    public boolean ispali(int num){
        int k=0;
        int test=num;
        while(test!=0){
            int rem=test%10;
            k=k*10+rem;
            test=test/10;
        }
        return k==num;
    }

    public boolean isprime(int num){
        boolean primeor = true;
        int k=num;
        for(int j=3; j<((int)Math.sqrt(k))+1; j+=2){
            if(k%j==0){
                primeor=false;
            }
        }
        return primeor;
    }

    public int primePalindrome(int n) {
        int k=n;
        while(k>=n){
            //System.out.println(k+".len("+((int)Math.log10(k)+1)+") "+k+".isprime("+isprime(k));
            if(k==1){
                return 2;
            }
            if(k%2==0&&k!=2){
                k+=1;
            }

            if(((int)Math.log10(k)+1)==4){
                k=10000+1;
            } else if(((int)Math.log10(k)+1)==6){
                k=1000000+1;
            } else if(((int)Math.log10(k)+1)==8){
                k=100000000+1;
            }
//            else if(((int)Math.log10(k)+1)==10){
//                k=10000000000-1;
//            } else if(((int)Math.log10(k)+1)==12){
//                k=1000000000000-1;
//            } else if(((int)Math.log10(k)+1)==14){
//                k=100000000000000-1;
//            }
            if(isprime(k)&&ispali(k)){
                break;
            } else{
                k+=2;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        PrimePali test = new PrimePali();

        System.out.println(test.primePalindrome(9999800));
        //System.out.println(test.check_palicheker(8));
        System.out.println("Wow!");
    }
}


/*
class Solution {

    public boolean isPali(int num){
        int k=0;
        int t=n;
        while(t!=0){
            k*=10;
            k+=t%10;
            t/=10;
        }
        return k==n;
    }

    public ArrayList<Integer> primes(int n){
        boolean[] prims=new boolean[n];
        ArrayList<Integer> allprime = new ArrayList<>();

        Arrays.fill(prims, Boolean.TRUE);
        prims[0]=false;
        prims[1]=false;

        for(int i=2; i<n; i++){
            if(prims[i]){
                for(int j=i; i*j<n; j+=1){
                    prims[i*j]=false;
                }
            }
            if(prims[i]&&isPali){
                allprime.add(i);
            }
        }
        return allprime;
    }

    public int primePalindrome(int n) {
        int k=0;
        int val=0;
        while(val<=n){

        }
        return k;
    }
}
 */
