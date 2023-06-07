import java.util.*;

public class HW_05June {
    // Character-related
    public Map<Character, Integer> char_mapper(char[] arr){
        Map<Character, Integer> m = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            if(!m.containsKey(arr[i])){
                m.put(arr[i], 1);
            }else{
                m.put(arr[i], m.get(arr[i])+1);
            }
        }
        return m;
    }

    public void rep(Map<Character, Integer> map){
        System.out.print("Repeated characters: ");
        for(Character k : map.keySet()){
            if(map.get(k)!=1){
                System.out.print(k+ " ");
            }
        }
        System.out.println();
    }

    public void non_rep(Map<Character, Integer> map){
        System.out.print("Non-repeated characters: ");
        for(Character k : map.keySet()){
            if(map.get(k)==1){
                System.out.print(k+ " ");
            }
        }
        System.out.println();
    }

    public void f_rep(char[] arr){
        Map<Character, Integer> m = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            if(!m.containsKey(arr[i])){
                m.put(arr[i], 1);
            }else{
                m.put(arr[i], m.get(arr[i])+1);
                System.out.println("First repeating character is: "+arr[i]);
                break;
            }
        }
    }

    public void f_non_rep(Map<Character, Integer> map, char[] arr){
        for(int i=0; i<arr.length; i++){
            if(map.get(arr[i])==1){
                System.out.println("First non-repeating character is: "+arr[i]);
                break;
            }
        }
    }



    // Integer-related
    public Map<Integer, Integer> int_mapper(int[] arr){
        Map<Integer, Integer> m = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            if(!m.containsKey(arr[i])){
                m.put(arr[i], 1);
            }else{
                m.put(arr[i], m.get(arr[i])+1);
            }
        }
        return m;
    }

    //not working
    public static int count_sum(Map<Integer, Integer> map, int sum){
        int count=0;
        Iterator<Integer> iter = map.keySet().iterator();
        for(Integer val:map.keySet()){
            int occ=map.get(val);
            while(occ!=0){
                if(map.containsKey(sum-val)){
                    count+=1;
                    occ-=1;
                }
            }
        }
        return count/2;
    } // works as intended only for unique elements

    public int max_freq(Map<Integer, Integer> map){
        int max=0;
        int k=0;
        for(Integer val:map.keySet()){
            if(map.get(val)>max){
                k=val;
                max=map.get(val);
            }
        }
        return k;
    }

    public void disj(Map<Integer, Integer> m1, Map<Integer, Integer> m2){
        if(m1.keySet().equals(m2.keySet())){
            System.out.println("Not at all");
        }else{
            System.out.println("IDK. Maybe");
        }
    } // make another hash table which is by combining 2, iff counts are same across tables, all ok




    // String-related

    public void same_alpha(Map<String, Map<Character, Integer>> mapmap){
        List<String> visited = new ArrayList<>();

        for(String key1:mapmap.keySet()){
            String out=key1;
            for(String key2:mapmap.keySet()){
                if(key1!=key2&&!visited.contains(key2)){
                    if(mapmap.get(key1).keySet().equals(mapmap.get(key2).keySet())){
                        out+=(", "+key2);
                        visited.add(key2);
                    }
                }
                //visited.add(key1);
            }
            System.out.println(out);
        }
    } // Almost works completely

    public static void main(String[] args) {

        HW_05June hw = new HW_05June();
        Scanner input = new Scanner(System.in);

        char[] carr = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'a', 'c', 'c', 'e', 'f', 'f', 'f', 'b'};
        Map<Character, Integer> char_m = hw.char_mapper(carr); // Creates map of characters

        // Text code Runners
        /*
        //System.out.println("Array: "+carr);
        //System.out.println("Map: "+char_m);
        //hw.rep(char_m);
        //hw.non_rep(char_m);
        //hw.f_non_rep(char_m, carr);
        //hw.f_rep(carr);
        */




        int[] iarr={10, 20, 10, 20, 30, 20, 20};
        Map<Integer, Integer> int_m = hw.int_mapper(iarr); // Creates map of integers
        //System.out.println("Count is: "+count_sum(int_m, 6));
        //System.out.println("Value with maximum occurrence is: "+hw.max_freq(int_m));


        String s_arr[]={ "may", "student", "students", "dog", "studentssess", "god", "cat", "act",
                "tab", "bat", "flow", "wolf", "lambs", "amy", "yam", "balms", "looped", "poodle"};

        Map<String, Map<Character, Integer>> dem = new HashMap<>();
        for(int i=0; i< s_arr.length; i++){
            dem.put(s_arr[i], hw.char_mapper(s_arr[i].toCharArray()));
        }
        hw.same_alpha(dem);

        int[] a1 = {12, 34, 11, 5, 3};
        int[] a2 = {7, 2, 1, 5};
        Map<Integer, Integer> m1 = hw.int_mapper(a1);
        Map<Integer, Integer> m2 = hw.int_mapper(a2);
        //hw.disj(m1, m2);

    }
}

