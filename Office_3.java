import java.util.*;
import java.util.concurrent.*;
import java.lang.*;
import java.util.random.RandomGenerator;

public class Office_3 {

    public void task1_trial1(){

        class threadll implements Runnable{
            public int data;

            public threadll next;

            public threadll(){
                this.data=0;
                this.next=null;
            }

            public threadll(int val){
                this.data=val;
                this.next=null;
            }

            @Override
            public void run(){
                threadll iter = this;
                while(iter.next!=null){
                    System.out.print(iter.data+" -> ");
                    iter=iter.next;
                }
                System.out.println(iter.data);
            }
            public threadll addvalatstart(int num){
                threadll iter = new threadll(num);
                iter.next = this;
                return iter;
            }

            public threadll addvalatend(int num){
                threadll iter = this;
                while(iter.next!=null){
                    iter=iter.next;
                }
                iter.next = new threadll(num);
                return this;
            }
        }

        ExecutorService pool = Executors.newFixedThreadPool(3);//creating a pool of 5 threads
        // ThreadPoolExecutor threadpoolexec = new ThreadPoolExecutor();
        // Runnable rarr = new threadll();

        threadll[] rarr = new threadll[13];

        for(int i=0; i<9; i++){
            rarr[i] = new threadll();
            for(int j=10; j<17; j++){
                if(i%2==0) {
                    rarr[i].addvalatend(j);
                }else{
                    rarr[i].addvalatstart(j);
                }
            }
            System.out.println("Something "+(i+1));
            pool.execute(rarr[i]);
        }

        pool.shutdown();
        int i=0;
        while (!pool.isTerminated()) {
            i++;
        }

        System.out.println("Finished all threads "+i); // Random number generator?!
    }

    public void task1_trial2(){
        Office_3 wrk = new Office_3();
        Scanner input = new Scanner(System.in);

        class idk implements Runnable{
            @Override
            public void run(){
                System.out.println();
            }
        }
        
    }

    public void task1_trial3() throws InterruptedException {
        Executor executor = Executors.newSingleThreadExecutor();
        Scanner input = new Scanner(System.in);
        final String[] str = {""};
        Runnable lambda_funct_as_var = ()->{
            System.out.print("Huh?!");
            str[0] =input.next();
            System.out.println(str[0]);
        };
        // executor.execute(lambda_funct_as_var); // takes a Runnable class object.
        // Lambda functions are classified as runnable class

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = (Future<String>)executorService.submit(lambda_funct_as_var);
        executorService.submit(lambda_funct_as_var);

        while(!future.isDone()){
            future.wait(2147483647);
            executorService.wait(2147483647);
        }
        if(future.isDone()) {
            String res = future.resultNow();
            System.out.println("future.resultNow(): "+res);
        }


    }

    public int[] task1_trial4() {
        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        // Explicit typecasting required

        Scanner input = new Scanner(System.in);

        int[] val = new int[15];
        RandomGenerator rand = new Random();
        Runnable runner = new Runnable() {@Override
            public void run() {for (int i = 0; i < 5; i++){
                System.out.print("Try inputting: "+(i+1)+" -> ");
                val[i] = input.nextInt();}
            }
        };

        threadPoolExecutor.execute(runner);

        System.out.println("Idk man: "+val[rand.nextInt(15)]);

        return val;
    }

    public void task1_trail5(){
        class abcd implements Executor{
            @Override
            public void execute(Runnable r){
                r.run();
            }
        }

    }

    public void task1_trial6() throws InterruptedException {
        // In new class, either 'implement Runnable' OR 'extend Threads'
        // If runnable implemented, create new object of Thread

        // Interface objname = new class_constructor();

        BlockingQueue bq = new ArrayBlockingQueue(5);
        bq.put("hnn");
        bq.put(42);
        System.out.println(bq);
        Object o1 = bq.take();
        Object o2 = bq.take();

        
        System.out.println(o1);
        System.out.println(o2);
        class trialobj implements Runnable{
            public int objno;

            public trialobj(int num){
                this.objno=num;
            }

            public trialobj(){
                this.objno=-42;
            }

            @Override
            public void run(){
                for(int i=5; i<12; i++){
                    System.out.println("Thread: "+objno+", i= "+i);
                }

                try{Thread.sleep(500000);}
                catch(Exception e){}
            }
        }

        for(int i=0; i<3; i++){
            trialobj nobj = new trialobj(i);
            Thread thread = new Thread(nobj);
            thread.start();
        }

    }


    public static void main(String[] args) throws InterruptedException {
        Office_3 wrk = new Office_3();
        wrk.task1_trial6();
        System.out.println("Wow");
    }
}


/*
Question 1:
Write a Java program to implement a custom thread pool. The thread pool should have a fixed number of worker threads
and should be able to accept tasks and execute them concurrently.

Question 2:
Implement a multithreaded Java program that simulates a bank with multiple branches. Each branch should have multiple
tellers serving customers. Use synchronization and locks to ensure proper access to shared resources such as customer
accounts.

Question 3:
Write a Java program to implement a concurrent hash map. The concurrent hash map should support multiple threads
accessing and modifying the map concurrently while maintaining thread safety.

Question 4:
Design a Java class for a binary search tree. Implement methods to insert and delete nodes, search for a specific
value, and perform an in-order traversal of the tree.

Question 5:
Implement a Java program that demonstrates the use of Java Reflection API. The program should dynamically load a
class, create an instance, and invoke methods at runtime using reflection.

Question 6:
Write a Java program that uses Java Generics to create a generic stack implementation. The stack should support push
and pop operations for any type of object.

Question 7:
Design a Java program that implements a producer-consumer pattern using the BlockingQueue interface from the
java.util.concurrent package. The program should have multiple producers and consumers interacting with the shared
queue.

Question 8:
Implement a Java program that performs parallel sorting of a large array using the Fork/Join framework. Divide the
array into subarrays, sort them concurrently using multiple threads, and then merge the sorted subarrays to obtain
the final sorted array.

Question 9:
Write a Java program that demonstrates the use of Java annotations. Define custom annotations and use them to annotate
classes, methods, and fields in the program.

Question 10:
Design a Java program that uses JavaFX to create a graphical user interface (GUI) for a simple calculator. The
calculator should support basic arithmetic operations such as addition, subtraction, multiplication, and division.
 */
