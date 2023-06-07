import java.util.Scanner;

public class Calculator {

    public void add(float x, float y){
        System.out.println(x+y);
    }

    public void sub(float x, float y){
        System.out.println(x-y);
    }

    public void mult(float x, float y){
        System.out.println(x*y);
    }

    public void div(float x, float y) { System.out.println(x/y); }

    public void rem(float x, float y) { System.out.println(x%y); }

    public void pow(float x, float y) { System.out.println(Math.pow(x, y)); }
    public static void main(String[] args) {

        Calculator c = new Calculator();
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first number: ");
        float a = input.nextFloat();
        System.out.print("Enter second number: ");
        float b = input.nextFloat();

        System.out.println("Select any one of these: ");
        System.out.println("Addition (0): ");
        System.out.println("Subtraction (1): ");
        System.out.println("Multiplication (2): ");
        System.out.println("Division (3): ");
        System.out.println("Remainder (4): ");
        System.out.println("Power (5): ");

        int choice = input.nextInt();

        if (choice==0){
            c.add(a, b);
        } else if (choice==1){
            c.sub(a, b);
        } else if (choice==2){
            c. mult(a, b);
        } else if (choice==3){
            c.div(a, b);
        } else if (choice==4){
            c.rem(a, b);
        } else if (choice==5){
            c.pow(a, b);
        } else{
            System.out.println("Wrong Choice!\nExecution Aborted");
        }

    }
}
