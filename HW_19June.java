import java.util.Arrays;

public class HW_19June {

    // Counting sort variants of different data-types
    public int[] intcoun_sort(int[] array){
        int min=+2000000000;
        int max=-2000000000;

        for(int i=0; i<array.length; i++){
            if(array[i]>max){
                max=array[i];
            }
            if(array[i]<min){
                min=array[i];
            }
        }

        // Setting up of array to store counts
        int[] counts=new int[max-min+1];
        for(int i=0; i<array.length; i++){
            counts[(array[i]-min)]+=1;
        }

        int j=0; // used as index for og array
        // re-creating og array
        for(int i=0; i<counts.length; i+=0){
            //System.out.print(counts[i]+" "); // Outputs the count array
            if(counts[i]==0){
                i++;
            } else if(counts[i]!=0){
                counts[i]-=1;
                array[j]=i+min;
                j++;
            }
        }
        return array;
    }

    public String strcoun_sort(String string){
        StringBuilder str = new StringBuilder(string);
        int min=Integer.MIN_VALUE;
        int max=Integer.MAX_VALUE;
        for(int i=0; i<str.length(); i++){
            if((int)str.charAt(i)>max){
                max=(int)str.charAt(i);
            }
            if((int)str.charAt(i)<min){
                min=(int)str.charAt(i);
            }
        }
        // Min is offset (tells which alphabet is present)
        // Len will tell till what value present
        int[] counter = new int[max-min+1];

        for(int i=0; i<str.length(); i++){
            counter[((int)str.charAt(i))-min]+=1;
        }

        int j=0; // used as index for og array
        // re-creating og array
        for(int i=0; i<counter.length; i+=0){
            //System.out.print(counts[i]+" "); // Outputs the count array
            if(counter[i]==0){
                i++;
            } else if(counter[i]!=0){
                counter[i]-=1;
                str.setCharAt(j, ((char) (i+min)));
                j++;
            }
        }
        string=str.toString();
        return string;
    }

    public static void main(String[] args) {
        HW_19June hw = new HW_19June();
        int[] array={4, 5, 8, 6, 4, 2, 3, 3, 9, 10, 9, 15, 13, 12};

        // Integer sorter
        for(int i=0; i<array.length; i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
        int[] wow = hw.intcoun_sort(array);
        for(int i=0; i<wow.length; i++){
            System.out.print(wow[i]+" ");
        }

        System.out.println();
        /*
        System.out.println((char) 97); // ASCII -> char
        System.out.println('a'+' '-' '); // Same as System.out.println('a'+'>'-'>');
        System.out.println((int) 'a'); // char -> ASCII
        //System.out.println("('a'+' '-' ')==((int) 'a') is : "+(('a'+' '-' ')==((int) 'a')));
        */
        String teststr = "Garv Aditya Verma";
        System.out.println(teststr);
        System.out.println(hw.strcoun_sort(teststr));
    }
}
