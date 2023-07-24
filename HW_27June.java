import java.util.*;
import java.util.stream.IntStream;


public class HW_27June {

    public int minxor(int val1, int val2){
        HW_27June t= new HW_27June();

        ArrayList<Integer> b1 = t.trubina(val1);
        ArrayList<Integer> b2 = t.trubina(val2);
        ArrayList<Integer> ans = new ArrayList<>();

        int count=0;
        int tmp=val2;
        while(tmp!=0){
            count++;
            tmp&=tmp-1;
        }


        for(int i=0; i<b1.size(); i++){
            if(count>0) {
                if (b1.get(i) == 1) {
                    ans.add(1);
                    count--;
                }else{
                    ans.add(0);
                }
            }else {
                ans.add(0);
            }
        }
        if(ans.size()==1) {
            while (count > 0) {
                ans.add(1);
                count--;
            }
        }else{
            int i=ans.size()-1;
            while(count>0){
                if(ans.get(i)==1){
                    i--;
                }else{
                    ans.set(i, 1);
                    count--;
                    i--;
                }
            }
        }
        return unsigval(ans);
    } // Half done // Many test cases fail, len equalizer might be needed

    public ArrayList<Integer> trubina(int num){

        ArrayList<Integer> bina = new ArrayList<>();

        int tmp=num; // To count length of number
        while(tmp!=0){
            if ((tmp&1)==1) {bina.add(1);}
            else if ((tmp&1)!=1) {bina.add(0);}
            tmp=tmp>>1;
        }
        Collections.reverse(bina);
        return bina;
    }

    public int unsigval(ArrayList<Integer> bin){
        int val=0;
        for(int i=0; i<bin.size(); i++){
            val+=(bin.get(i))*(Math.pow(2, bin.size()-i-1));
        }
        return val;
    }

    public String DI(String DIstr){
        String nums = new String();
        ArrayList vals = new ArrayList();
        Stack<Integer> sta = new Stack<>();
        sta.push(1);
        for(int i=0; i<DIstr.length(); i++){
            if(DIstr.charAt(i)=='I'){
                if(sta.isEmpty()){
                    sta.push(i+1);
                }
                vals.add(sta.pop());
            }
            if(DIstr.charAt(i)=='D'){
                sta.push(i+1);
            }
        }
        while(!sta.isEmpty()) {
            vals.add(sta.pop());
        }
        nums+=vals;
        return nums;
    }

    public static void main(String[] args) {
        HW_27June hw = new HW_27June();
        //System.out.println(hw.DI("")); // I means n[i]<n[i+1] and D means n[i]>n[i+1]
        System.out.println(hw.DI("IIIDIDDD"));
        /*
        System.out.println(hw.trubina(346));
        System.out.println(hw.unsigval(hw.trubina(42)));
        System.out.println(hw.minxor(1, 12)); // Ans should be 3
        System.out.println(hw.minxor(65, 84)); // Ans should be 67
        System.out.println(hw.minxor(346, 6654));
        */
    }
}
