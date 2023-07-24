import java.util.ArrayList;
import java.util.HashMap;

public class HW_03July {

    public ArrayList<Integer> suba(int[] arr){
        ArrayList<Integer> subarr = new ArrayList<>();
        int sum=0;
        // 2 pointer approach
        int i=0; int j= arr.length-1;
        for(i=0; i<j; i++){
            sum+=arr[i];
            subarr.add(arr[i]);
        }
        i=0;
        return subarr;
    } // LIERAL SHIT

    /*
    public int[] cumusummer(int[] arr){
        int[] cumusum = new int[arr.length+1];

        // Making array of cumulative sum
        for(int i=0; i<cumusum.length-1; i++){
            cumusum[i+1]=cumusum[i]+arr[i];
        }
        return cumusum;
    }
    public HashMap<Integer, Integer> uniquemap(int[] array){
        HashMap<Integer, Integer> unicmap = new HashMap<>();

        // Making {Value=Frequency} map of the cumulative sums
        for(int i=0; i< array.length; i++){
            if(unicmap.containsKey(array[i])){
                unicmap.put(array[i], unicmap.get(array[i])+1);
            }else{
                unicmap.put(array[i], 1);
            }
        }
        return unicmap;
    }
    public int countsum0(int[] arr){
        HW_03July hw = new HW_03July();
        int count=0;
        int[] cumulativesum = hw.cumusummer(arr);
        HashMap<Integer, Integer> cumusumfreqs = hw.uniquemap(cumulativesum);
        for(int iter=0; iter<cumulativesum.length; iter++){
            int i=cumulativesum[iter];
            if(cumusumfreqs.get(i)>1){
                while(cumusumfreqs.get(i)!=1){
                    count+=(cumusumfreqs.get(i))-1;
                    cumusumfreqs.put(i, cumusumfreqs.get(i)-1);
                }
            }
        }
        return count;
    }
    */

    public HashMap<Character, Integer> permsubstr(String str, String substr){
        HashMap<Character, Integer> ogmap = new HashMap<>();
        HashMap<Character, Integer> submap = new HashMap<>();

        for(char c:substr.toCharArray()){
            submap.put(c, submap.getOrDefault(c, 0)+1);
        }
        int i=0; int j=0;
        int beg=0;
        int end=str.length();
        while((i<str.length())&&(j<str.length())){
            ogmap.put(str.charAt(j), ogmap.getOrDefault(str.charAt(j), 0)+1);
            // Issue when some chars in str no exist in substr
            if((ogmap.keySet().containsAll(submap.keySet()))&&(ogmap.get(str.charAt(i))>=submap.get(str.charAt(i)))){ // String has f which is nowhere present in substring
                ogmap.put(str.charAt(i), ogmap.get(str.charAt(i))-1);
                if(j-i<end-beg){
                    beg=i;
                    end=j;
                }
                i++;
            }else{
                j++;
            }
        }

        System.out.print("Substring: ");
        for(int k=beg; k<end; k++){
            System.out.print(str.charAt(k)+" ");
        }
        System.out.println();
        System.out.println("Haystack map: "+ogmap);
        return submap;
    }


    public static void main(String[] args) {
        HW_03July hw = new HW_03July();
        int[] narr = {2, 8, -3, -5, 2, -4, 6, 1, 2, 1, -3, 4, -9};
        System.out.println();

        // System.out.println(hw.countsum0(narr));
        System.out.println("Needle Map: "+hw.permsubstr("affabcdeafgbdcbabc", "abbcdc"));
    }
}


/*
- [x] Largest subarray of 0 sum
- [x] Largest array length with equal number of 0 and 1
- [x] s1 of len l1 and s2 of len l2. Find min window substr of s1 which contains all characters of s2(duplicates included)
- [x] Largest subarray of k sum
- [x] Count subarrays with k sum
- [x] Longest substring without repeating characters
 */