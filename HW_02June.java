import java.util.Scanner;

public class HW_02June {

    public void concat(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first string: ");

        String a = input.nextLine();

        System.out.print("Enter second string: ");
        String b = input.nextLine();

        System.out.print("Enter third string: ");
        String c = input.nextLine();

        System.out.println("The concatenated strings are: "+a+b+c);
    }

    public int floop(){
        int sum=0;
        for(int i=1; i<=100; i++) {
            sum+=i;
            System.out.print(i+' ');
        }
        return sum;
    }

    public void arr(){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter size of array: ");

        int size = in.nextInt();
        int[] arr = new int[size];
        int sum=0;
        for(int i=0; i<size; i++){
            arr[i]=in.nextInt();
            sum+=arr[i];
        }
        System.out.println("Sum is: "+sum);
        for(int i=0; i<size; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void main(String[] args) {
        HW_02June hw1 = new HW_02June();

//        hw1.concat();
//        System.out.println("\nSum is: "+hw1.floop());
//        hw1.arr();
        System.out.println(8+4+'A'+4+4+'A'-8-4-4-4-'A');
        System.out.println('A');
        System.out.println('A'-' '+' ');
        System.out.println('A'+' '-' ');
        System.out.println('A'+0);
        System.out.println(0+'A');
        System.out.println("A"+0);
        System.out.println(0+"A");
    }

}



// why can't direct input and output array without using loops

// nextLine vs next means nextline includes line breaks as inputs and both accept strings


// '' char
// '' can be taken as an ascii val
// " " string

// 10+"a" means 10a as string

// "asdf" + 'a' means asdfa

// 15+'a' means 97+15


// 'i'+i means

// why can't we go 10%num == num if not then 100%num==num until 10^n==num then go back


// forever loop return vs break statements
