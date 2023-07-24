import java.util.Arrays;

import static java.util.Arrays.stream;

public class HW_02July {

    public int[] indices(int[][] matrix, int val){
        int[] coordinates = new int[2];
        int x = matrix[0].length;
        int y = matrix.length;
        // use binsearch, top right corner to check upper bound then go down and search along that x to look for number
        return coordinates;
    } // not implemented yet

    /*
    public void spiraltrav(int[][] matrix) {
        System.out.println("Spiral: ");

        int hstart = 0;
        int vstart = 0;
        int hend=matrix[0].length-1;
        int vend=matrix.length-1;

        while ((hstart<=hend)||(vstart<=vend)) { // Why no change when changing || to &&

            // Top-left -> Top-right
            for (int i=hstart; i<=hend; i++) {
                System.out.print(matrix[vstart][i] + " ");
            }
            vstart += 1;

            // Top-right -> Bottom-right
            for (int i = vstart; i <= vend; i++) {
                System.out.print(matrix[i][hend] + " ");
            }
            hend -= 1;

            if (vstart <= vend) { // Check if there are more rows to print

                // Bottom-right -> Bottom-left
                for (int i = hend; i >= hstart; i--) {
                    System.out.print(matrix[vend][i] + " ");
                }
                vend -= 1;
            }

            if (hstart <= hend) { // Check if there are more columns to print

                // Bottom-left -> Top-left
                for (int i = vend; i >= vstart; i--) {
                    System.out.print(matrix[i][hstart] + " ");
                }
                hstart += 1;
            }
        }
    }

    public void print2D(int[][] mat){
        System.out.println("Matrix: ");
        for(int i=0; i< mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        } // Basic printing
        System.out.println();
    }

    public int triangfromarr(int[] lens){
        int count=0;
        Arrays.sort(lens);
        int min=lens[0];
        int max=lens[lens.length-1];
        int i=0;
        while(i<=lens.length-1){
            for(int j=i+1; j<lens.length-1; j++){
                if(lens[i]+lens[j]>lens[j+1]){
                    if((lens[i]+lens[j+1]>lens[j])&&(lens[j]+lens[j+1]>lens[i])){
                        count++;
                    }
                }
            }
            i++;
        }
        return count;
    }
    */

    public String shiftop(String str){
        for(int i=0; i<str.length(); i++){
            System.out.println(str);
            str=str.substring(1)+str.charAt(0);
        }

        return str;
    }

    public String flipop(String str, int at){
        StringBuilder nstr = new StringBuilder(str);
        if(nstr.charAt(at)=='1'){
            nstr.replace(at, at, "0");
        } else if(nstr.charAt(at)=='0'){
            nstr.replace(at, at, "1");
        }
        str=nstr.toString();
        return str;
    }

    public int zmoreor1(String str){
        int z=0; int o=0;
        for(Character c:str.toCharArray()){
            if(c=='0'){ o++;}
            else if(c=='1'){ z++; }
        }
        return z-o; // if 0s more than 1s then +ve; if 0s less than 1s then -ve; when equal then 0;
    } // if 0s more than 1s then +ve; if 0s less than 1s then -ve; when equal then 0;

    public int zposes(String str){
        HW_02July hw = new HW_02July();
        int oddeve=0; // 1 means odd position for 0; 0 mean even position for 0

        if((str.length()%2==1)){
            if(!(hw.zmoreor1(str)>0)){ oddeve=1;}
        }
        return oddeve;
    } // 1 means odd position for 0; 0 mean even position for 0

    public int flipcounter(String binanum){ // do count then len or len then count???
        int count=0;

        return count;
    }

    public static void main(String[] args) {
        HW_02July hw = new HW_02July();
        /*
        int[][] mat1 = new int[][]{
                {10, 11, 12},
                {13, 14, 15},
                {16, 17, 18},
                {19, 20, 21},
                {22, 23, 24},
                {25, 26, 27}
        };

        int[][] mat2 = new int[][]{
                {10, 11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20, 21},
                {22, 23, 24, 25, 26, 27}
        };

        {4, 6, 3, 7} => 3
        {10, 21, 22, 100, 101, 200, 300} => 6
        {1, 5, 2, 8, 7, 7, 7, 9, 5, 0, 2, 3, 6, 4, 5} => 12

        int[] arr = new int[]{10, 21, 22, 100, 101, 200, 300};
        hw.print2D(mat1);
        hw.spiraltrav(mat1);
        System.out.println(hw.triangfromarr(arr));
         */
        System.out.println(hw.flipop("00110011", 5));
        System.out.println(hw.shiftop("01001001101"));
    }
}

/*
// Even len means same no. of 0 and 1
01010101
10101010

// Odd len means diff no. of 0 and 1
1010101
0101010
 */





/*
Search in rows and columnise sorted 2D matrix
More uses of Comparable and Comparator
Use of Inner Classes
Minimum number of flips required to make a binary string alternate.
Next greater in a fixed window (Maximum in sliding window)

Lintcode.com

String search algorithms
    - Needle in a haystack
        - Check if a string is a substring of another string (Time Complexity) -> (O(m*n))
 */