import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnagSum {
    // creates a {Character=Frequency} map of given string
    public HashMap<Character, Integer> strmapper(String str){
        HashMap<Character, Integer> no1 = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (no1.containsKey(c)) {
                no1.put(c, no1.get(c) + 1);
            } else {
                no1.put(c, 1);
            }
        }
        return no1;
    }

    // class digit stores numerical value, word representing number and {character=frequency} map of any given number
    static class digit{

        String asword=""; // stores word

        Character identifier=0; // stores unique identifier (hard-coded and identified by analyzing asword)

        int value;

        int len; // unnecessary

        HashMap<Character, Integer> freqs = new HashMap<>();

        AnagSum anasu = new AnagSum();

        public digit(String word, Character unique, int val){
            this.asword+=word;
            this.identifier=unique;
            this.value=val;
            this.len = word.length();
            this.freqs = anasu.strmapper(word);
        }

        public void print(digit d){
            System.out.println("Value: "+d.value);
            System.out.println("Number: "+d.asword);
            System.out.println("Unique char: "+d.identifier);
            System.out.println("Character Frequency Map: "+d.freqs);
            System.out.println();
        }
    }

    // function to solve question
    public int summmer(String jumb){
        int sum=0;
        digit[] nums = new digit[10];
        ArrayList<String> arr = new ArrayList<>(List.of("zero", "one", "two",
                "three", "four", "five", "six", "seven", "eight", "nine"));
        ArrayList<Character> uni = new ArrayList<>(List.of('z', 'o', 'w', 't', 'u', 'f', 'x', 's', 'g', 'i')); // Stores identifying alphabets of numbers 0-9
        // ArrayList<Character> uni = new ArrayList<>(List.of('z', 'o', 'w', 't/h/r', 'u', 'f', 'x', 's/v', 'g', 'i/n/e'));

        /* Can also do
        ArrayList<String> numbers = new ArrayList<>(List.of("zero", "two", "four", "six",
                                    "eight", "one", "three", "five", "seven", "nine"));
                                    // This approach better
        ArrayList<Character> uniq = new ArrayList<>(List.of('z', 'w', 'u', 'x', 'g', 'o', 't', 'f', 's', 'i'));
        ArrayList<Character> vals = new ArrayList<>(List.of(0, 2, 4, 6, 8, 1, 3, 5, 7, 9));
        then loop once for(int i=0; i<10; i++){ and go through uniq to check and vals to increment
         */

        for(int i=0; i<arr.size(); i++){
            nums[i]= new digit(arr.get(i), uni.get(i), i); // initialises array of class digit where nums[number] = properties of number
            // nums[i].print(nums[i]); // for printing
        }

        HashMap<Character, Integer> jumbmap = strmapper(jumb);

        // Checks for truly unique identifiers (even numbers have unique alphabets in their asword string)
        for(int ind=0; ind<10; ind++) { // can also do int ind=0; ind<10; ind+=2){
            if ((jumbmap.containsKey(uni.get(ind)))&&(ind%2==0)) {
                while (jumbmap.get(uni.get(ind)) != 0) {
                    for (Character k : nums[ind].freqs.keySet()) {
                        jumbmap.put(k, jumbmap.get(k) - nums[ind].freqs.get(k));
                    }
                    sum += ind;
                }
            }
        }

        // Checks for remaining identifiers (odd numbers are unique after even numbers are eliminated)
        for(int ind=0; ind<10; ind++) { // can also do for(int ind=1; ind<10; ind+=2){
            if ((jumbmap.containsKey(uni.get(ind)))&&(ind%2==1)) {
                while (jumbmap.get(uni.get(ind)) != 0) {
                    for (Character k : nums[ind].freqs.keySet()) {
                        jumbmap.put(k, jumbmap.get(k) - nums[ind].freqs.get(k));
                    }
                    sum += ind;
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        AnagSum anasu = new AnagSum();

        System.out.println(anasu.summmer("hheeiittgg"));
    }
}