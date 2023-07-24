import java.util.Arrays;

public class HW_15June {

    public int[] bad_evenfinder(int[] nums){
        int t=0;
        int a=0; int b;
        for(int i=0; i<nums.length; i++){
            t=t^nums[i];
            a=t^nums[i];
        }
        //System.out.println(t);
        System.out.println(a+", "+(t^a));
        int[] out={a, t^a};
        return out;
    }

    public int[] oddfinder(int[] nums){
        int t=0;
        int a=0;
        for(int i=0; i<nums.length; i++){
            t=t^nums[i];
            a=a^t;
        }
        //System.out.println(t);
        System.out.println(a+", "+(t^a));
        int[] out = {a, t^a};
        return out;
    }

    public void outputter(int[] arrs){

        HW_15June hw = new HW_15June();

        System.out.print("Bad_EvenFinder: "+hw.bad_evenfinder(arrs));
        System.out.println();
        System.out.print("OddFinder: "+hw.oddfinder(arrs));
    }

    public void p1(int d){
        System.out.println();
        System.out.println("Pattern 1: ");
        for(int i=0; i<d; i++){
            for(int j=0; j<=i; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public void p2(int d){
        System.out.println();
        System.out.println("Pattern 2: ");
        for(int i=0; i<=d; i++){
            for(int j=0; j<=d; j++){
                if(j>i){
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

    public void p3(int d){
        System.out.println();
        System.out.println("Pattern 3: ");
        for(int i=0; i<d; i++){
            for(int j=0; j<d; j++){
                if(i>j){
                    System.out.print("  ");
                }else{
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

    public void p4(int d){
        System.out.println();
        System.out.println("Pattern 4: ");
        for(int i=0; i<d; i++){
            for(int j=0; j<d; j++){
                if(i>j){
                    System.out.print(" ");
                }else{
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }

    public void binsub(String s1, String s2){
        System.out.println("Wow");
    }

    public static void main(String[] args) {

        HW_15June hw = new HW_15June();

        int[] arr = {4, 3, 6, 2, 4, 2, 3, 4, 3, 3}; // {3, 5, 2, 5, 4, 4} might pose problem
        // {4, 2, 4, 5, 2, 3, 3, 1}

        hw.outputter(arr);
        System.out.println();
        int[] narr={3, 5, 2, 5, 4, 4};
        hw.outputter(narr);
        /*
        hw.p1(5);
        hw.p2(5);
        hw.p3(5);
        hw.p4(5);
        */
    }
}


// EXTREMELY IMPORTANT TIP
/*

a^b = t;

a^t = b;

If A xor B = K. Then, A xor K = B

 */