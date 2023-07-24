import java.util.*;
import java.util.stream.Stream;

public class HW_24June {
    public int basic_sumsub(int[] array, int size){
        int ans=0;
        int j = size-1;
        while(j<array.length){
            int sum=0;
            for(int i=j-size+1; i<=j; i++){
                sum+=array[i];
            }
            if(sum>ans){
                ans=sum;
            }
            j++;
        }
        return ans;
    }

    public int opt_sumsub(int[] array, int size){
        int isum=0;
        for(int i=0; i<size; i++){
            isum+=array[i];
        }
        int ans=isum;
        int i=0; int j=size-1;
        while(j< array.length){
            isum=isum+array[j]-array[i];
            if(ans<isum){
                ans=isum;
            }
            i++; j++;
        }
        return ans;
    }

    public int kadane(int[] array){
        int ans=0; int sum=0;
        int start=0; int end=0; int t=0;

        for(int i=0; i<array.length; i++){
            sum+=array[i];
            if(ans<sum){
                ans=sum;
                start=t; end=i;
            }
            if(sum<0){
                ans=0;
                sum=0;
                t=i;
            }
        }
        System.out.println("Kadane algo start: "+start);
        System.out.println("Kadane algo end: "+end);
        System.out.println("Kadane algo len: "+(end-start+1));
        return sum;
    }

    public ArrayList<Integer> selec_min(ArrayList<Integer> array){
        System.out.println("Unsorted: "+array);
        for(int i=0; i<array.size(); i++){
            int min=Integer.MAX_VALUE;
            int mini=0;
            for(int j=i; j<array.size(); j++){
                if(array.get(j)<min){
                    min=array.get(j);
                    mini=j;
                }
            }
            int temp=array.get(i);
            array.set(i, min);
            array.set(mini, temp);
        }
        return array;
    }

    public ArrayList<Integer> selec_max(ArrayList<Integer> array){
        // System.out.println("Unsorted: "+array);
        for(int i=array.size()-1; i>0; i--){
            int max=-Integer.MAX_VALUE;
            int maxi=0;
            for(int j=0; j<i; j++){
                if(array.get(j)>max){
                    max=array.get(j);
                    maxi=j;
                }
            }
            int temp=array.get(i);
            array.set(i, max);
            array.set(maxi, temp);
        }
        return array;
    } // Not wrking

    public ArrayList<Integer> insort(ArrayList<Integer> array){
        int n = array.size();
        for (int i = 1; i < n; ++i) {
            int key = array.get(i);
            int j = i - 1;
            // Shifter portion
            while (j >= 0 && array.get(j) > key) {
                array.set(j+1, array.get(j));
                j = j - 1;
            }
            array.set(j+1, key);
        }
        return array;
    }

    public void arrayprintr(int[] arr){
        System.out.print("[");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+", ");
        }
        System.out.println("\b\b]");
    }
    public int[] nxt_gr8_freq(int[] intarr){
        int[] freq = new int[intarr.length];
        Arrays.fill(freq, -1);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i=0; i< intarr.length; i++){
            if(map.containsKey(intarr[i])){
                map.put(intarr[i], map.get(intarr[i])+1);
            } else if (!map.containsKey(intarr[i])) {
                map.put(intarr[i], 1);
            }
        }
        for(int i=0; i<intarr.length; i++){
            for(int j=i; j< intarr.length; j++){
                if((map.get(intarr[i]))<(map.get(intarr[j]))){
                    freq[i]=intarr[j];
                    i++;
                    j++;
                }
            }
        }
        return freq;
    } // Almost wroks

    public static void main(String[] args) {
        HW_24June hw = new HW_24June();

        int[] arr = {1, 1, 2, 3, 4, 2, 1};
        int[] kad = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        /*
        System.out.println("Basic: "+hw.basic_sumsub(arr, 6));
        System.out.println("Opt: "+hw.opt_sumsub(arr, 6));
        System.out.println("Kadane: "+hw.kadane(arr));

        ArrayList<Integer> intlst = new ArrayList<>();
        for(int i=0; i<arr.length; i++){
            intlst.add(arr[i]);
        }
        System.out.println("Sorted: "+hw.selec_min(intlst));
        // System.out.println("Sorted: "+hw.selec_max(intlst));

        hw.arrayprintr(arr);
        hw.arrayprintr(hw.nxt_gr8_freq(arr));
         */
        System.out.println("Kadane: "+hw.kadane(kad));

    }
}



/*
5. Bubble Sort
6. Quick Sort
 */
