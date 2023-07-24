import java.util.*;

public class HW_20June {

    public Map<Set<Character>, List<String>> sameset(List<String> lst){
        Map<Set<Character>, List<String>> mapp = new HashMap<>();
        for (String s : lst) {
            Set<Character> charset = new HashSet<>();
            for (int j = 0; j < s.length(); j++) {
                charset.add(s.charAt(j));
            }
            if (mapp.containsKey(charset)) {
                mapp.get(charset).add(s);
            } else if (!mapp.containsKey(charset)) {
                List<String> tmp = new ArrayList<>();
                tmp.add(s);
                mapp.put(charset, tmp);
            }
        }
        return mapp;
    }


    public static void main(String[] args) {
        HW_20June hw = new HW_20June();
        List<String> lst = new ArrayList<>(List.of("may", "student", "students", "dog", "studentssess", "god", "cat", "act",
                "tab", "bat", "flow", "wolf", "lambs", "amy", "yam", "balms", "looped", "poodle", "tac"));
        Map<Set<Character>, List<String>> megamap = hw.sameset(lst);
        System.out.println(megamap);
        System.out.println("Wow");
    }
}
