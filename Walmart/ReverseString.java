package Walmart;

/**
 *  Leetcode 344
 * 
 *  https://leetcode.com/problems/reverse-string/
 */

public class ReverseString {

    public static void main(String[] args) {

        char[] s = {'h','e','l','l','o'};
        System.out.println("init");

        for (char c:reverse(s)) {
            System.out.print(c+" ");

        }
    }

    private static char[] reverse(char[] s) {
        int i = 0;
        while(i < s.length-i-1) {
            char c = s[i];
            s[i] = s[s.length-i-1];
            s[s.length-i-1] = c;
            i++;
        }

        return s;
    }


}
