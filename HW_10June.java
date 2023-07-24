public class HW_10June {

    public void bad_shift0(int[] arr){
        int i=0; int j=arr.length-1;
        while(i<=arr.length-1||j>=0){
            if(arr[i]!=0&&i<=arr.length-1){
                i+=1;
            }
            if(arr[j]==0&&j>=0){
                j-=1;
            }
            if(arr[i]==0&&arr[j]!=0){
                int t=arr[i];
                arr[i]=arr[j];
                arr[j]=t;
                if(i<=arr.length-1){
                    i+=1;
                }
                if(j>=0){
                    j-=1;
                }
            }
            if(i>=j){
                break;
            }
        }
    }

    public void good_shift0(int[] arr){
        int t_ind=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]!=0){
                arr[t_ind]=arr[i];
                t_ind++;
            }
        }

        for(int i=t_ind; i<arr.length; i++){
            arr[i]=0;
        }

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }


    public static void main(String[] args) {
        HW_10June hw = new HW_10June();
        int[] a={1, 2, 0, 4, 3, 0, 5, 0};

        //hw.bad_shift0(a);
        hw.good_shift0(a);

    }
}
