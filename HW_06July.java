public class HW_06July {

    public boolean goodornot(int[] nums, int val){
        // j-i>=1 to account for size
        // j<nums.length-1;
        // Sliding window => sum-=arr[i] or sum+=arr[j]
        
        int i=0; int j=1;
        boolean res=false;
        res=nums.length==val;
        return res;
    }




    public static void main(String[] args) {
        HW_06July hw = new HW_06July();


        Object obj = new Object();

        System.out.println(obj.hashCode());
        System.out.println(obj);
        System.out.println();
    }
}
