public class HW_15July {


    public boolean groupSum(int start, int[] nums, int target) {
        System.out.println("Benigging: ");
        if(target==0){
            return true;
        }
        if(start == nums.length){
            return false;
        }
        if(groupSum(start+1, nums, target)){
            return true;
        }
        if(groupSum(start+1, nums, target-nums[start])){
            return true;
        }else{
            return false;
        }
    }

    public boolean groupSum5(int start, int[] nums, int target) {
        if(target<=0){
            return target==0;
        }
        if(start>=nums.length-1){
            return target==0;
        }
        if(nums[start]%5==0){
            if(nums[start+1]==1){
                if(nums.length-start<1){
                    return false;
                }
                groupSum5(start+2, nums, target-nums[start]);
            }
            if(groupSum5(start+1, nums, target-nums[start])){return true;}
        }
        if(groupSum5(start+1, nums, target-nums[start])){return true;}
        if(groupSum5(start+1, nums, target)){return true;}
        return false;
    }



    public boolean grpSum(int start, int[] array, int target){
        if(target==0){
            return true;
        }
        if(start==array.length) {
            return target==0;
        }
        return (grpSum(start+1, array, target-array[start]))||(grpSum(start+1, array, target));
    }

    public boolean grpSum5(int start, int[] array, int target){
        if(start==array.length){
            return target==0;
        }
        if(array[start]%5==0){
            if(start<=array.length-2){
                if(array[start+1]==1){
                    return target==0;
                }
                return grpSum5(start+2, array, target-array[start]);
            }
            return grpSum5(start+1, array, target-array[start]);
        }

        return ((grpSum5(start+1, array, target))||(grpSum5(start+1, array, target-array[start])));
    }

    public String xyrepl(String str){
        StringBuilder st = new StringBuilder(str);
        return xy(st, 0);
    }

    public String xy(StringBuilder str, int ind){
        if(ind==str.length()){
            return str.toString();
        }
        if(str.charAt(ind)=='x'){
            str.setCharAt(ind, 'y');
            return xy(str, ind+1);
        }
        return xy(str, ind+1);
    }

    public static void main(String[] args) {
        HW_15July hw = new HW_15July();

        int[] arr = new int[5];
        arr[0]=2;
        arr[1]=5;
        arr[2]=10;
        arr[3]=4;
        arr[4]=2;

        System.out.println(hw.grpSum5(0, arr, 7));
    }
}
