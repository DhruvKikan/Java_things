
import java.util.*;


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

    public static void main(String[] args) {
        test a = new test();
        String[] words = {"may", "student", "students", "dog",
                "studentssess", "god", "cat", "act",
                "tab", "bat", "flow", "wolf", "lambs",
                "amy", "yam", "balms", "looped",
                "poodle"};

        a.groupCharset(words);
//        int[] ar={12,35,1,10,34,1};
//        System.out.println(a.print2largest(ar,6));
//        long[] a1 = {12, 34, 11, 9, 3};
//        long[] a2 = {2, 1, 3, 5};
//        System.out.println(a.isSubset(a1, a2, 4, 5));
    }
}