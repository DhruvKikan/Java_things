import java.util.Arrays;
import java.util.Scanner;

public class HW_01July { // Merge overlaping intervals trains and meetings and find no. of platforms/meeting rooms

    public static class interview implements Comparable<interview>{
        int start;
        int end;
        public interview(int s, int e){
            this.start=s;
            this.end=e;
        }

        public void printsch(interview this){
            System.out.println("Interview Start time: "+this.start);
            System.out.println("Interview End time: "+this.end);
        }

        @Override
        public int compareTo(interview other) {
            if(this.start!=other.start){
                return (this.start-other.start);
            }else{
                return (this.end- other.end);
            }
        }
    }

    public interview[] maker(){
        Scanner intput = new Scanner(System.in);

        System.out.println();
        System.out.print("Input the number of interviews: ");

        int inters = intput.nextInt();

        interview[] schedule = new interview[inters];

        for(int i=0; i<inters; i++){
            System.out.println("Interview no. "+(i+1)+": ");
            System.out.print("Start: ");
            int st = intput.nextInt();
            System.out.print("End: ");
            int en = intput.nextInt();
            schedule[i]=new interview(st, en);
            System.out.println();
        }
        return schedule;
    }

    public static int collisions(interview[] intervs){
        Arrays.sort(intervs);
        int coli=0;
        for(int i=0; i< intervs.length-1; i++){
            if(intervs[i].end>=intervs[i+1].start){
                coli++;
            }
        }
        return coli;
    }

    public static void main(String[] args) {
        HW_01July hw = new HW_01July();
        interview[] schedule = hw.maker();
        System.out.println("Interview Rooms required: "+collisions(schedule));
        System.out.println("Wow");
    }
}
