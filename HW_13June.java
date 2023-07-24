import java.util.ArrayList;
import java.util.Collections;

public class HW_13June {

    //to count how many primes less than given number
    public int count(boolean[] barr, int n){
        int counter=0;
        for(int i=0; i<n; i++){
            if(barr[i]==true){
                counter++;
            }
        }
        return counter;
    }

    public int[] closPrim(ArrayList<Integer> iarr, int n1, int n2){
        int i1=0; int i2=0;
        int[] out={i1, i2};
        return out;
    }

    public boolean[] seiveprimer(int lim){
        boolean[] isP = new boolean[lim];
        for(int i=0; i<lim; i++){
            isP[i]=true;
        }
        isP[0]=false;
        isP[1]=false;

        for(int i=2; i*i<(lim); i++){
            if(isP[i]==true){
                //int j=i*i; j<=lim; j+=2*i ||int j=i; i*j<lim; j+=1
                for(int j=i; i*j<lim; j+=1){
                    isP[i*j]=false;
                }
            }
        }
        return isP;
    }

    public boolean isPali(int num){
        int k=0;
        int t=num;
        while(t!=0){
            k*=10;
            k+=t%10;
            t/=10;
        }
        return k==num;
    }

    public boolean newPali(int num){
        for(int i=0; i<(int)Math.log(num); i++){
        }
        return false;
    }

    public int primepali(ArrayList<Integer> parr, int val){
        int k=0;
        for(int i=0; i<parr.size(); i++){
            if(isPali(parr.get(i))){
                k=parr.get(i);
            }
        }
        return k;
    }


    public static void main(String[] args) {

        HW_13June hw = new HW_13June();

        boolean[] arePrimes = hw.seiveprimer(50);
        ArrayList<Integer> primes = new ArrayList<>();

        for(int i=0; i<arePrimes.length; i++){
            //System.out.println(i+" : "+arePrimes[i]);
            if(arePrimes[i]){
                primes.add(i);
            }
        }

        int k=hw.primepali(primes, 50);
        System.out.println(k);
    }
}

