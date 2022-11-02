package java;

public class MedianOfTwoSortedArrays {
        public static void main(String[] args) {
        int[] arr3 = { 1, 3 };
        int[] arr4 = { 2 };
        int[] arr1 = { 1, 2, 3, 8, 9, 10, 15 };
        int[] arr2 = { 2, 4, 11, 12, 20 };

        System.out.println(answer(arr3, arr4));
        System.out.println(bruteForce(arr3, arr4));
    }

    private static double answer(int[] arr1, int[] arr2) {

        if(arr2.length < arr1.length) return answer(arr2, arr1);

        int total = arr1.length + arr2.length;

        int l = 0;
        int r = arr1.length-1;

        double median = 0.0;

        while (true) {

            int indexA = (int) Math.floor((r + l)/2.0);
            int indexB = total/2 - indexA - 2;

            int Aleft = indexA >= 0 ? arr1[indexA] : Integer.MIN_VALUE;
            int Aright = (indexA + 1) < arr1.length ? arr1[indexA + 1] : Integer.MAX_VALUE;
            int Bleft = indexB >= 0 ? arr2[indexB] : Integer.MIN_VALUE;
            int Bright = (indexB + 1) < arr2.length ? arr2[indexB + 1] : Integer.MAX_VALUE;

            // partition is correct
            if (Aleft <= Bright && Bleft <= Aright) {
                // odd
                if (total % 2 != 0) {
                    median =  Math.min(Aright, Bright);
                } else {
                    median = (Math.max(Aleft, Bleft) + Math.min(Aright, Bright)) / 2.0;
                }
                break;
            } else if (Aleft > Bright) {
                r = indexA - 1;
            } else {
                l = indexA + 1;
            }
            
        }

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
