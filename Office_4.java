import java.util.concurrent.*;
import java.util.*;

public class Office_4 {

    public void ques1_trial1(){

        class CustomThreadPool {

            private int numThreads;

            private WorkerThread[] threads;

            private BlockingQueue<Runnable> taskQueue;

            public CustomThreadPool(int numThreads) {
                this.numThreads = numThreads;
                this.threads = new WorkerThread[numThreads];
                this.taskQueue = new LinkedBlockingQueue<>();

                for (int i = 0; i < numThreads; i++) {
                    threads[i] = new WorkerThread();
                    threads[i].start();
                }
            }

            public void submit(Runnable task) {
                try {
                    taskQueue.put(task);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


            private class WorkerThread extends Thread {
                @Override
                public void run() {
                    while(true){
                        try {
                            Runnable task = taskQueue.take();
                            task.run();
                        } catch (InterruptedException e) {
                            //e.printStackTrace();
                        }
                    }
                }
            }

            public void shutdown() {
                for (int i = 0; i < numThreads; i++) {
                    threads[i].interrupt();
                }
            }


        }

        // Driver code
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of threads: ");
        int threads= input.nextInt();


        System.out.print("Enter number of tasks: ");
        int tasks= input.nextInt();

        CustomThreadPool threadPool = new CustomThreadPool(threads);

        // Submit tasks to the thread pool
        for (int i = 1; i <= tasks; i++) {
            int taskId = i;
            threadPool.submit(() -> {
                System.out.println("Task " + taskId + " executed by thread " + Thread.currentThread().getName());
            });
        }
        // Shutdown the thread pool after submitting all tasks
        threadPool.shutdown();
    }


    public void ques1_trial2(){

        class CustomThreadPool {

            private int numThreads;
            private ExecutorService executor;
            private BlockingQueue<Runnable> taskQueue;

            public CustomThreadPool(int numThreads) {
                this.numThreads = numThreads;
                this.executor = Executors.newFixedThreadPool(numThreads);
                this.taskQueue = new LinkedBlockingQueue<>();

                for (int i = 0; i < numThreads; i++) {
                    executor.execute(new WorkerThread());
                }
            }

            public void submit(Runnable task) {
                try {
                    taskQueue.put(task);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            private class WorkerThread implements Runnable {
                @Override
                public void run() {
                    while (!Thread.currentThread().isInterrupted()) {
                        try {
                            Runnable task = taskQueue.take();
                            task.run();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
            }

            public void shutdown() {
                executor.shutdown();
            }
        }


        // Driver code
        CustomThreadPool threadPool = new CustomThreadPool(5);

        // Submit tasks to the thread pool
        for (int i = 1; i <= 10; i++) {
            int taskId = i;
            threadPool.submit(() -> {
                System.out.println("Task " + taskId + " executed by thread " + Thread.currentThread().getName());
            });
        }

        // Shutdown the thread pool after submitting all tasks
        threadPool.shutdown();

    }

    public void ques1_trial3(){
        class CustomThreadPool {

            private int numThreads;
            private WorkerThread[] threads;
            private BlockingQueue<Runnable> taskQueue;

            // Constructor
            public CustomThreadPool(int numThreads) {
                this.numThreads = numThreads;
                this.threads = new WorkerThread[numThreads];
                this.taskQueue = new LinkedBlockingQueue<>();

                for (int i = 0; i < numThreads; i++) {
                    threads[i] = new WorkerThread();
                    threads[i].start();
                }
            }

            // Custom thread implementation
            private class WorkerThread extends Thread {
                @Override
                public void run() {
                    while (!isInterrupted()) {
                        try {
                            Runnable task = taskQueue.take();
                            task.run();
                        } catch (InterruptedException e) {
                            // Thread interrupted, exit the loop and terminate
                            break;
                        }
                    }
                }
            }

            public void submit(Runnable task) {
                try {
                    taskQueue.put(task);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            public void shutdown() {
                for (int i = 0; i < numThreads; i++) {
                    threads[i].interrupt();
                }
            }
        }

        class FibonacciTask implements Runnable {
            private int n;
            private int[] memo;

            public FibonacciTask(int lim) {
                this.n = lim;
                this.memo = new int[n + 1];
            }

            @Override
            public void run() {
                int result = calculateFibonacci(n);
                System.out.println("Fibonacci(" + n + ") = " + result + " (Executed by thread " + Thread.currentThread().getName() + ")");
            }

            private int calculateFibonacci(int n) {
                if (n <= 1){return n;}

                if (memo[n] == 0) {
                    memo[n] = calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
                }

                return memo[n];
            }
        }

        class FactorialTask implements Runnable {
            private int n;

            public FactorialTask(int val) {
                this.n = val;
            }

            @Override
            public void run() {
                long result = calculateFactorial(n);
                System.out.println("Factorial(" + n + ") = " + result + " (Executed by thread " + Thread.currentThread().getName() + ")");
            }

            private long calculateFactorial(int n) {
                if (n == 0 || n == 1)
                    return 1;
                return n * calculateFactorial(n - 1);
            }
        }

        class PermutationTask implements Runnable {
            private String str;
            private HashSet<String> permutations;

            public PermutationTask(String str) {
                this.str = str;
                this.permutations = new HashSet<>();
            }

            @Override
            public void run() {
                generatePermutations("", str);
                System.out.println("Permutations of " + str + ": " + permutations + " (Executed by thread " + Thread.currentThread().getName() + ")");
            }

            private void generatePermutations(String prefix, String remaining) {
                int n = remaining.length();
                if (n == 0) {
                    permutations.add(prefix);
                } else {
                    for (int i = 0; i < n; i++) {
                        generatePermutations(prefix + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i + 1));
                    }
                }
            }
        }

        // Driver code
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of threads: ");
        int threads = input.nextInt();

        System.out.print("Enter number of tasks: ");
        int tasks = input.nextInt();

        System.out.print("Enter string for which permutations need to be found: ");
        String str = input.next();

        System.out.print("Enter number for which factorial is to be calculated: ");
        int numfact = input.nextInt();

        System.out.print("Enter number for which fibonacci is to be calculated: ");
        int numfib = input.nextInt();


        CustomThreadPool threadPool = new CustomThreadPool(threads);

        // Submit tasks to the thread pool
        for (int i = 1; i <= tasks; i++) {
            threadPool.submit(new FibonacciTask(numfib));
            threadPool.submit(new FactorialTask(numfact));
            threadPool.submit(new PermutationTask(str));
        }

        // Shutdown the thread pool after submitting all tasks
        threadPool.shutdown();
    }


    public static void main(String[] args) {
        Office_4 wrk = new Office_4();


        wrk.ques1_trial3();
        System.out.println("Wow");
    }
}

