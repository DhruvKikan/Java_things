import java.util.ArrayList;
import java.util.Scanner;

public class Bert_Ernie {

    public boolean all1s(String hmm){
        boolean res=true;
        for(int i=0; i<hmm.length(); i++){
            if(hmm.charAt(i)=='0'){
                res=false;
            }
        }
        return res;
    }

    public boolean isSpecial(String hmm){
        int i=0; int j=hmm.length()-1;
        boolean yesorno=true;
        while(i<=j){
            if((hmm.charAt(i))!=(hmm.charAt(j))){
                yesorno=false;
                break;
            }
            i++;
            j--;
        }
        return yesorno;
    }

    public String modif(String hmm){
        StringBuilder newhmm = new StringBuilder(hmm);
        for(int i=0; i<hmm.length(); i++){
            if(hmm.charAt(i)=='0'){
                newhmm.setCharAt(i, '1');
                break;
            }
        }
        hmm = newhmm.toString();
        return hmm;
    }

    public String upside(String hmm){
        StringBuilder newhmm = new StringBuilder(hmm);
        newhmm.reverse();
        hmm= newhmm.toString();
        return hmm;
    }

    public String singgameres(String str){
        Bert_Ernie bernie = new Bert_Ernie();
        int ernimone=0;
        int bertmone=0;
        int turn=0; // even for Ernie, odd for Bert
        int lastop=0; // Default (no action)

        while(!bernie.all1s(str)) {
            if(turn==0){ // Start with Ernie
                ernimone-=1;
                str=bernie.modif(str);
                lastop=1; // 1 or Odd for modification action performed and 0 or Even for upside action performed
                turn++;
            }
            if(turn%2==1){ // Bert's turn
                if((!bernie.isSpecial(str))&&(lastop==1)){
                    str=bernie.upside(str);
                    lastop=0;
                }else{
                    str=bernie.modif(str);
                    bertmone-=1;
                    lastop=1;
                }
                turn++;
            }else if((turn%2==0)&&(turn!=0)){ // Ernie's turn
                if((!bernie.isSpecial(str))&&(lastop==1)){
                    str=bernie.upside(str);
                    lastop=0;
                }else{
                    str=bernie.modif(str);
                    ernimone-=1;
                    lastop=1;
                }
                turn++;
            }
        }

        if(ernimone<bertmone){
            return "BERT";
        }
        if(bertmone>ernimone){
            return "ERNIE";
        }
        return "TIE";
    }

    public ArrayList<String> gameres(int games, ArrayList<String> bins){
        Bert_Ernie bertnie = new Bert_Ernie();
        ArrayList<String> results = new ArrayList<>();

        for(int i=0; i<bins.size(); i++){
            results.add(bertnie.singgameres(bins.get(i)));
        }
        return results;
    }

    public static void main(String[] args) {
        Bert_Ernie ber = new Bert_Ernie();
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of games: ");
        int no = input.nextInt();
        System.out.println();

        ArrayList<String> vals = new ArrayList<>();
        for(int i=0; i<no; i++){
            System.out.print("Enter binary for game no. "+(i+1)+": ");
            vals.add(input.next());
            System.out.println();
        }

        System.out.println(ber.gameres(no, vals));
    }
}
