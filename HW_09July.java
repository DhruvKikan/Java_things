public class HW_09July {

    public int[][] maketrans(int[][] mat1){
        int m=mat1.length;
        int n=mat1[0].length;

        int[][] trans = new int[n][m];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                trans[j][i]=mat1[i][j];
            }
        }
        return trans;
    }

    public void matprint(int[][] mat){
        for(int i=0; i<mat.length; i++){
            for(int j=0; j<mat[0].length; j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }

    public int[][] matmult(int[][] mat1, int[][] mat2){
        int m=mat1.length; int n=mat1[0].length;
        int o=mat2.length; int p=mat2[0].length;

        // n=o for success


        int[][] ans = new int[m][p];
        return ans;
    }

    public static void main(String[] args) {
        HW_09July hw = new HW_09July();
        int[][] matrix={
                {10, 11, 12, 13}, {14, 15, 16, 17},
                {18, 19, 20, 21}, {22, 23, 24, 25},
                {26, 27, 28, 29}, {30, 31, 32, 33} };

        System.out.println("OG matrix: ");
        hw.matprint(matrix);

        System.out.println();

        System.out.println("Transpose: ");
        hw.matprint(hw.maketrans(matrix));

    }
}



/*
- [ ] Game of Nim
Homework
- [ ] Multiply 2 Matrices
- [ ] Check if a 2D matrix is an identity matrix or not
 */
