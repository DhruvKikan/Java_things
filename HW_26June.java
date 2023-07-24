import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class HW_26June {
    public boolean disj(int[] s1, int[] s2){
        boolean var=true;
        for(Integer i:s1){
            int j=0;
            while(j<s2.length) {
                if (i == s2[j]) {
                    var = false;
                    System.out.println("Cause: "+i);
                    break;
                } else {
                    j++;
                }
            }
        }
        System.out.println("Disjoints? ");
        return var;
    }

    public boolean arreq(int[] A, int[] B){
        AtomicBoolean equality= new AtomicBoolean(true);
        Map<Integer, Integer> mapA = new HashMap<>();
        Map<Integer, Integer> mapB = new HashMap<>();
        int i=0; int j=0;

        // Constructing maps in single loop (utilizes Labels and exception handling)
        while((i<A.length)||(j<B.length)) {
            Amap: // Mapping A
            {
                try {
                    if (mapA.containsKey(A[i])) {
                        mapA.put(A[i], mapA.get(A[i]) + 1);
                        i++;
                    }
                    if (!mapA.containsKey(A[i])) {
                        mapA.put(A[i], 1);
                        i++;
                    }
                } catch (Exception e) {
                    break Amap;
                }
            }
            Bmap:
            {
                try {
                    if (mapB.containsKey(B[j])) {
                        mapB.put(B[j], mapB.get(B[j]) + 1);
                        j++;
                    }
                    if (!mapB.containsKey(B[j])) {
                        mapB.put(B[j], 1);
                        j++;
                    }
                }
                catch (Exception e){
                    break Bmap;
                }
            } // Mapping B
        }

        // Checking maps
        // Simply returning (map1.equals(map2)) should also have sufficed
        if(mapA.keySet().equals(mapB.keySet())){
            mapA.keySet().stream().forEach(key->{
                if((mapA.get(key))!=(mapB.get(key))){
                    equality.set(false);
                }
            });
        }

        return equality.get();
    }

    public static void main(String[] args) {
        HW_26June hw = new HW_26June();
        int[] set1 = {12, 34, 11, 9, 3};
        int[] set2 = {2, 4, 5, 0, 1, 1, 2};

        System.out.println(hw.disj(set1, set2));
        System.out.println(hw.arreq(set1, set2));
    }
}
