public class HW_08June {

    public int rec_hcf(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        } else {
            return rec_hcf(n2, n1 % n2);
        }
    }

    public void prime_sq(int rang){
        String nums="Numbers with EXACTLY 3 factors: ";
        for(int i=2; i<=Math.ceil(Math.sqrt(rang)); i++){
            boolean isprim=true;
            int j=2;
            while(j<i&&isprim){
                if(i%j==0&&isprim&&i!=j){
                    isprim=false;
                }else if(i%j==0&&isprim&&i==j){
                    isprim=true;
                }
                j+=1;
            }if(isprim&&Math.pow(i, 2)<=rang){
                nums+=(int)(Math.pow(i, 2))+" ";
            }
        }
        System.out.println(nums);
    }

    public String len_equalizer(String s1, String s2){
        HW_08June hw = new HW_08June();
        int l1=s1.length();
        int l2=s2.length();
        String s3="";
        if(l1>l2){
            int dif=l1-l2;
            for(int i=0; i<dif; i++){
                s3+="0";
            }
            s3+=s2;
        }else if(l1<l2){
            int dif=l2-l1;
            for(int i=0; i<dif; i++){
                s3+="0";
            }
            s3+=s1;
        }
        return s3;
    }

    public void char_add(String s1, String s2){
        System.out.print(s1+" + "+s2+" = ");
        if(s1.length()>s2.length()){
            s2=len_equalizer(s1, s2);
        }else if(s1.length()<s2.length()){
            s1=len_equalizer(s1, s2);
        }
        int carry=0;
        int f_sum=0;
        int size=s1.length();
        for(int i=size-1; i>=0; i--){
            int sum=(int)s1.charAt(i) + (int)s2.charAt(i)-96+carry;
            //System.out.print(s1.charAt(i) + "+" + s2.charAt(i)+": ");
            carry=sum/10;
            sum=sum%10;
            f_sum+=sum*Math.pow(10, size-1-i);
        }
        System.out.println(f_sum);
    }

    public static void main(String[] args) {

        HW_08June hw = new HW_08June();
        /*s
        int range=100000;
        System.out.println(hw.rec_hcf(48, 18));
        hw.prime_sq(range);
        String s1="123";
        String s2="456789";
        hw.char_add(s1, s2);
         */
    }
}
