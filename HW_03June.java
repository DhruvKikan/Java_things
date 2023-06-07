import java.util.Scanner;

public class HW_03June {
    public void ascii(){
        System.out.println("ASCII: Character");
        for(int i=0; i<=127; i++){ //can go to any limit (0-255 is default IG, 127 taken for simplicity)
            System.out.println(i+": "+((char) i));
        }
    }

    public String all_dig(int num){

        String s=new String();
        while(num!=0){
            s=num%10+s;
            num/=10;
        }
        return s;
    }

    public String bin(int num){

        String s=new String();
        while(num!=0){
            s=num%2+s;
            num/=2;
        }
        return s;
    }

    public String oct(int num){

        String s=new String();
        while(num!=0){
            s=num%8+s;
            num/=8;
        }
        return s;
    }



    public void Armstronk(){
        for(int i=1; i<=1000; i++){
            int sum=0;
            int j=i;
            while(j!=0){
                //int rem=j%10;
                //sum+=(rem*rem*rem);
                sum+=((j%10)*(j%10)*(j%10));
                j/=10;
            }
            if(i==sum){
                System.out.println((i+" is an Armstrong number"));
            } else{
                continue;
            }
        }
    }

    public void pytha(){
        int count =0;
        for(int i=1; i<=100; i++){
            for(int j=i; j<=100; j++){
                for(int k=i; k<=100; k++){
                    if(((i*i)+(j*j))==(k*k)){
                        count+=1;
                        System.out.println(count+". "+i +", "+j+" and "+k+" are Pythagorean Triplets");
                    }
                }
            }
        };
    }

    public void opt_pytha(){
        int count=0;
        for(int i=1; i<=100; i++){
            for(int j=i; j<=100; j++){
                int something=(int) Math.sqrt((i*i)+(j*j));
                if((i*i)+(j*j)==(something*something)) {
                    if (something <= 100) {
                        count += 1;
                        System.out.println(count + ". " + i + ", " + j + " and " + (something) + " are Pythagorean Triplets");

                    }
                }
            }
        }
    }


    public void sod(){
        for(int i=1; i<=100; i++){
            int s=0;
            int j=i;
            while(j!=0){
                s+=j%10;
                j/=10;
            }
            System.out.println("Sum of digits of "+i+" is "+s);
        }
    }

    public static void main(String[] args) {
        HW_03June hw = new HW_03June();

        Scanner input = new Scanner(System.in);

        hw.ascii();

        System.out.print("Enter number: ");
        int num=input.nextInt();

        System.out.println("Digits are: "+hw.all_dig(num));
        System.out.println();

        //System.out.println("Binary is: "+hw.bin(num));
        System.out.println();

        //System.out.println("Octal is: "+hw.oct(num));
        System.out.println();
        
        //hw.Armstronk();
        System.out.println();

        //hw.pytha();

        System.out.println();
        //hw.sod();

        //hw.opt_pytha();
    }
}

// List<Integer> l = new ArrayList<>();

