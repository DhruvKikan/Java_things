import java.util.*;
import java.util.stream.IntStream;
import org.json.*;
import javax.lang.model.type.NullType;
import com.fasterxml.jackson.core.*;

class test {


    public String isSubset(long a1[], long a2[], long n, long m) {
        Map<Long, Integer> t = new HashMap<>();
        if (n >= m) {
            for (int i = 0; i < n; i++) {
                if (t.containsKey(a2[i])) {
                    t.put(a2[i], t.get(a2[i]) + 1);
                } else {
                    t.put(a2[i], 1);
                }

            }
            long count = 0;
            for (int i = 0; i < m; i++) {
                if (t.containsKey(a1[i])) {
                    count++;
                }
            }
            if (count == m) {
                return "Yes";
            }
            else return "No";
        } else if (n < m) {
            for (int i = 0; i < m; i++) {
                if (t.containsKey(a1[i])) {
                    t.put(a1[i], t.get(a1[i]) + 1);
                } else {
                    t.put(a1[i], 1);
                }

            }
            long count = 0;
            for (int i = 0; i < n; i++) {
                if (t.containsKey(a2[i])) {
                    count++;
                }
            }
            if (count == n) {
                return "Yes";
            } else return "No";
        } else return "No";

    }

    public boolean checkCharset(String str1, String str2) {
        Map<Character, Integer> m1 = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            if (m1.containsKey(str1.charAt(i))) {
                m1.put(str1.charAt(i), m1.get(str1.charAt(i)) + 1);
            } else {
                m1.put(str1.charAt(i), 1);
            }
        }

        Map<Character, Integer> m2 = new HashMap<>();
        for (int i = 0; i < str2.length(); i++) {
            if (m2.containsKey(str2.charAt(i))) {
                m2.put(str2.charAt(i), m2.get(str2.charAt(i)) + 1);
            } else {
                m2.put(str2.charAt(i), 1);
            }

        }
        if (m1.equals(m2)) {
            return true;
        }
        return false;

    }

    public void groupCharset(String[] arr) {
        test t = new test();
        for (int i = 0; i < arr.length; i++) {
            String out = arr[i];
            for (int j = i+1; j < arr.length; j++) {
                if (t.checkCharset(arr[i], arr[j])) {
                    out += " " + arr[j];
                }
            }
            System.out.println(out);
            out="";
        }

    }

    public boolean isDisjoint(int arr1[], int arr2[]) {
        // code here
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if (arr1[0] > arr2[arr2.length - 1]) {
            return true;
        } else if (arr2[0] > arr1[arr1.length - 1]) {
            return true;
        } else return false;

    }


    // New methods
    public void lamb_stream(int k){
        // Lambda and Streams implementation
        ArrayList<String> srlst = new ArrayList<>();
        ArrayList<Integer> inlst = new ArrayList<>();
        Map<String, Integer> mmap = new HashMap<>();
        IntStream.range(0, 17).forEach(i -> {srlst.add(i+"->"+((int)Math.sqrt(i))); inlst.add(i*i);});
        IntStream.range(0, 17).forEach(i->{mmap.put(srlst.get(i), inlst.get(i));});

        System.out.println("Default map: "+mmap);
        System.out.println("Implementation: ");
        mmap.forEach((s, e)-> System.out.println(s+" maps to: "+e));

        System.out.println();
        System.out.println("Basic implementations: ");
        srlst.stream().forEach(s -> {System.out.println(s);} );
        System.out.println();
        inlst.stream().forEach(i -> {System.out.print(i+" ");});
        System.out.println(); System.out.println();

        // Prints multiples of 3
        inlst.stream().filter(x->x%3==0).forEach(s->{System.out.println(s);} );
        srlst.stream().forEach(i->{inlst.stream().filter(j->j%3==0).forEach(j-> System.out.println(i+" "+j));});
    }

    public void json1(int n){
        System.out.println("Funct1: ");
        JSONObject obj = new JSONObject();
        obj.put("Name", "Boi");
        obj.put("Rno.", n);
        obj.put("Address", "C-57 Indra Enclave");
        System.out.println(obj);
    }

    public JSONObject json2(String s){
        System.out.println("Funct2: ");
        Map<Character, Integer> m = new HashMap();

        for(int i=0; i<s.length(); i++){
            m.put(s.charAt(i), (m.getOrDefault(s.charAt(i), 0))+1);
        }
        JSONObject job = new JSONObject(m);
        System.out.println("JSONObject: "+job);
        System.out.println("Map: "+m);
        return job;
    }

    public JSONStringer json3(NullType k){
        System.out.println("Funct3: ");
        JSONStringer jstr = new JSONStringer();
        Map m = new HashMap();
        m.put("abc", 123);
        m.put("def", 456);
        m.put("ghi", 789);
        jstr.object().key("abc").value(123).key("def").value(456).key("ghi").value(789).endObject();
        System.out.println("Map 2: "+m);
        System.out.println("JSONStringer : "+jstr);
        return jstr;
    }

    public void json4(NullType p){
        System.out.println("Funct4: ");
        Map m = new HashMap();
        m.put('a', 123);
        m.put('b', 456);
        m.put('c', 789);
        JSONObject jstr = new JSONObject();
        //jstr.object().key("a").value(123).key("b").value(456).key("c").value(789).endObject();
        System.out.println("Map 2: "+m);
        System.out.println("JSONStringer : "+jstr);
    }

    public void json5(int k){
        System.out.println("Funct5: ");
        ArrayList<Integer> arr = new ArrayList();
        JSONArray jar1 = new JSONArray();
        JSONArray jar2 = new JSONArray(arr);
        HashMap<Integer, JSONArray> m = new HashMap<Integer, JSONArray>();
        IntStream.rangeClosed(0, 17).forEach(i->{
            arr.add(i);
            jar2.put(arr);
            m.put(i, jar2);
            jar1.put(m); // simply using jar1.put(m.put(i, jar2); wouldn't work
        });
        System.out.println("ArrayList: "+arr);
        System.out.println("JSONArray1: "+jar1);
        System.out.println("JSONArray2: "+jar2);
    }

    public void json6(NullType nil){
        System.out.println("Funct6:");
        JSONArray jar = new JSONArray();
        IntStream.range(0, 14).forEach(i->{
            jar.put(i);
        });
        System.out.println(jar);
    }

    public JSONArray json7(int l, int r){
        System.out.println("Funct7:");
        JSONArray jar1 = new JSONArray();
        IntStream.range(l, r).forEach(i->jar1.put(i));
        return jar1;
    }

    public JSONArray json8(int l, int r){
        System.out.println("Funct8: ");
        JSONArray jar = new JSONArray();
        IntStream.rangeClosed(l, r).forEach(i->jar.put(i));
        return jar;
    }

    public HashMap json9(int k, Integer v){
        System.out.println("Funct9: ");
        HashMap<Integer, Integer> m = new HashMap();
        IntStream.rangeClosed(k, v).filter(i->i%3==0).forEach(i->m.put(i, i));
        JSONObject jar = new JSONObject(m);
        System.out.println("JSONArray: "+jar);
        return m;
    }

    public JSONObject json10(ArrayList<String> srlst){
        System.out.println("Funct10: ");
        JSONObject job = new JSONObject();
        srlst.forEach(s->{
            Set<Character> chars = new HashSet<>();
            IntStream.range(0, s.length()).forEach(i->{
                chars.add(s.charAt(i));
            });
            job.accumulate(chars.toString(), s);
        });
        System.out.println("JSONObject: "+job);
        System.out.println();
        return job;
    }

    public JSONArray json11(JSONObject job, Set<String> s){
        System.out.println("Funct11: ");
        JSONArray njar = new JSONArray();

        s.forEach(v->{
            njar.put(job.getJSONArray(v));
        });
        System.out.println("JSONArray: "+njar);

//        s.forEach(v->{
//            JSONObject njob = new JSONObject(job.getJSONObject(v));
//            System.out.println(job.getJSONObject(v));
//            njob.put(job.getJSONObject(v).toString(), job.get(v));
//            System.out.println("JSONObject: "+njob);
//        });
        System.out.println();
        return njar;
    }

    public void json12(JSONArray jar){
        System.out.println("Funct12: ");
        System.out.println("JSONArrays: ");
        IntStream.range(0, jar.length()).forEach(i->{
            System.out.println(jar.getJSONArray(i));
        });

//        System.out.println("JSONObjects: ");
//        IntStream.range(1, jar.length()).forEach(i->{
//            System.out.println(jar.getJSONObject(i));
//        });
    }


    public static void main(String[] args) {
        test t = new test();

        System.out.println();
        t.json1(42);
        System.out.println();

        t.json2("AbracaDABra");
        System.out.println();

        t.json3(null);
        System.out.println();

        t.json4(null);
        System.out.println();

        t.json5(42);
        System.out.println();

        t.json6(null);
        System.out.println();
        System.out.println(t.json7(12, 18));
        System.out.println();
        System.out.println(t.json8(12, 18));
        System.out.println();

        System.out.println("Map: "+t.json9(11, 18));
        System.out.println();

        ArrayList<String> lst = new ArrayList<>(List.of("may", "student", "students", "dog", "studentssess",
                "god", "cat", "act", "tab", "bat", "flow", "wolf", "lambs", "amy", "yam", "balms", "looped", "poodle", "tac"));

        t.json12(t.json11(t.json10(lst), t.json10(lst).keySet()));



        test a = new test();
        String[] words = {"may", "student", "students", "dog", "studentssess", "god", "cat", "act",
                "tab", "bat", "flow", "wolf", "lambs", "amy", "yam", "balms", "looped", "poodle"};
        a.groupCharset(words);
        int[] ar={12,35,1,10,34,1};
        long[] a1 = {12, 34, 11, 9, 3};
        long[] a2 = {2, 1, 3, 5};
        //System.out.println(a.isSubset(a1, a2, 4, 5));
    }
}
