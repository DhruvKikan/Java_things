import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HW_20July {

    // find all possible decodings and count for characters pertaining to keypad phone chars by nums
    public int decoding(String msg, ArrayList<String> out, HashMap<Character, List<Character>> m){
        int count=0;
        if(msg.length()==0){
            System.out.println(" ");
        }
        for(Character c : msg.toCharArray()){if(m.containsKey(c)){count++;}}

        return count;
    }

    public HashMap<Character, List<Character>> buttonphonelayout(){
        HashMap<Character, List<Character>> m = new HashMap<>();
        m.put('2', List.of('a', 'b', 'c'));
        m.put('3', List.of('d', 'e', 'f'));
        m.put('4', List.of('g', 'h', 'i'));
        m.put('5', List.of('j', 'k', 'l'));
        m.put('6', List.of('m', 'n', 'o'));
        m.put('7', List.of('p', 'q', 'r', 's'));
        m.put('8', List.of('t', 'u', 'v'));
        m.put('9', List.of('w', 'x', 'y', 'z'));
        return m;
    }

    public static void main(String[] args) {
        HW_20July hw = new HW_20July();
        HashMap<Character, List<Character>> buttonmap = hw.buttonphonelayout();

        String message="123456";
        ArrayList<String> possiblecombos = new ArrayList<>();


        hw.decoding(message, possiblecombos, buttonmap);


        System.out.println("Wow");
    }
}
