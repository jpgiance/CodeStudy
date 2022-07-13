public class MedianOfTwoSortedArrays {
        public static void main(String[] args) {
        int[] arr1 = { 1, 3 };
        int[] arr2 = { 2 };

        System.out.print(bruteForce(arr1, arr2));
    }

    private static double answer(int[] arr1, int[] arr2) {
        double median = 0;

        return median;
    }

    private static double bruteForce(int[] arr1, int[] arr2) {
        double median = 0;
        int[] merged = new int[arr1.length+arr2.length];

        int indexL = 0;
        int indexR = 0;

        for (int i = 0; i < merged.length; i++) {
            if(indexL < arr1.length && indexR < arr2.length){

                if (arr1[indexL] < arr2[indexR]) {
                    merged[i] = arr1[indexL];
                    indexL++;
                }else{
                    merged[i] = arr2[indexR];
                    indexR++;
                }
            }else if (indexL < arr1.length ) {
                merged[i] = arr1[indexL];
                indexL++;
            } else {
                merged[i] = arr2[indexR];
                indexR++;
            }
            
        }

        if (merged.length % 2 != 0) {
            int mid = (int) Math.ceil(merged.length/2);
            return merged[mid];
        } else {
            int mid = (merged.length/2)-1;
            median = (merged[mid]+merged[mid+1])/2.0;
            return  median;
        }

    }
}
