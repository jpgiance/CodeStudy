class BinarySearch{
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 5, 7, 10, 30, 200, 400, 2123 };
        int target = 2123;
        
        System.out.print(search(nums, target));
    }

    private static int search(int[] nums, int target) {

        int right = nums.length - 1;
        int left = 0;
        int pivot;

        while (right >= left) {
            pivot = left + (right - left)/2;

            if (nums[pivot] == target) {
                return pivot;
            } else if (nums[pivot] > target) {
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return -1;
    }


}