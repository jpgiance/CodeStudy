public class Search2DMatrix {
    
    public static void main(String[] args) {
        int[][] nums = { {1,3,5,7},{10,11,16,20},{23,30,34,60} };
        int target = 2;
        
        System.out.print(search(nums, target));
    }

    private static boolean search(int[][] nums, int target) {
        int pivot;
        int left = 0;
        int right = nums.length - 1;
        int row = -1;

        while (right >= left) {
            pivot = left + (right - left)/2;

            if (target >= nums[pivot][0] && target <= nums[pivot][nums[pivot].length-1]) {
                row = pivot;
                break;
                
            } else if(target < nums[pivot][0]){
                right = pivot - 1;
            }else{
                left = pivot + 1;
            }

        }

        
        if(row == -1){
            return false;
        }else{
            left = 0;
            right = nums[row].length - 1;
        } 

        while (right >= left) {
            pivot = left + (right - left)/2;

            if (target == nums[row][pivot]) {
                return true;
            } else if(target < nums[row][pivot]){
                right = pivot - 1;
            }else{
                left = pivot + 1;
            }
        }

        return false;
    }
}
