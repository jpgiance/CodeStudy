package mjavacode;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = { 312884470 };
        int h = 968709470;
        
        System.out.print(search(piles, h));
    }

    private static int search(int[] piles, int h) {
        int max = 0;
        long sum = 0;
        int left, right, pivot = 0;
        int result;

        
        for (int i : piles) {
            if(max < i) max = i;
            sum += i;
        }

        if(h == piles.length) return max;

        result = max;
        right = max;
        left = (int) sum/h;
        if(left < 1) left = 1;

        while (right >= left) {
            pivot = left + (right - left)/2;

            if (1 == tryK(piles, h, pivot)) {
                left = pivot + 1;
            } else{
                //if (pivot == 1 || 1 == tryK(piles, h, pivot-1)) return pivot;
                result = Math.min(result, pivot);
                right = pivot - 1;
            }

        }


        return result;
    }

    private static int tryK(int[] piles, int h, int k) {
        int hPassed = 0;

        for (int i : piles) {
            hPassed += Math.ceil(i/k);
        }

        if (hPassed == h) {
            return 0;
        }else if (hPassed > h) {
            return 1;
        } else {
            return -1;
        }

    }
}
