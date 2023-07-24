import java.lang.reflect.Array;
import java.util.Objects;

public class HW_09June {

    public int single_occur(int[] k){
        int y=0;
        for(int i=0; i<k.length; i++){
            System.out.print(k[i]+" ");
        }
        return y;
    }

    public int str_to_num(String s){
        int num=0;
        int sig=1;
        if(Objects.equals(s.charAt(0), '-')){
            s=s.substring(1);
            sig*=-1;
        }
        //System.out.println(s);
        for(int i=s.length()-1; i>=0; i--){
            num+=((int)s.charAt(i) - 48)*Math.pow(10, s.length()-1-i);
        }
        //System.out.println(num);
        return sig*num;
    }

    public int str_mult(String s1, String s2){
        int n1=str_to_num(s1);
        int n2=str_to_num(s2);
        return n1*n2;
    }

    public static void main(String[] args) {
        HW_09June hw = new HW_09June();
        int[] nums={1, 2, 0, 4, 3, 0, 5, 0};

        /*
        int[] arr={1, 2, 3, 4, 5, 5, 6, 7, 8};
        hw.single_occur(arr);
        System.out.println("Nice");
        String a="-10";
        String b="-0";
        System.out.println(a+" * "+b+" = "+hw.str_mult(a, b));
        */
    }
}
