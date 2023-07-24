public class HW_14june {


    // Use circular shifts to find (not working now)
    public boolean checkif_all_set(int n){
        int x=n>>1;
        int y=n<<(int) Math.floor((Math.log10(n))/Math.log10(2));
        int out = x|y;
        return (out==n);
    }

    public int bad_count_set(int n){
        int count=0;
        while(n!=1){
            count+=n&1; // Operates on lsb
            n>>=1; // Left shifts the number (reduces no. of bits by 1)
        }
        return count+1;
    }

    public int opt_count_set(int n){
        int count=0;
        while(n>0){
            n&=n-1;
            count++;
        }
        return count;
    } // V. V. V. imp


    public int count_total_set(int rang){ // Defines range from 1-rang
        int count=0;
        for(int i=1; i<=rang; i++){
            count+=bad_count_set(i);
        }
        return count;
    }

    public static void main(String[] args) {
        HW_14june hw = new HW_14june();

        System.out.println(hw.checkif_all_set(7));
        //System.out.println(hw.count_set(8));
        System.out.println(hw.count_total_set(4));
    }
}
