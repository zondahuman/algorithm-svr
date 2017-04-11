package com.qunar.des.algorithm.basic.string.find;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 15-4-23 上午3:55
 */
public class FindCommonString {
    public static void main(String[] args) {
        String str1 = "abcdefgh";
        String str2 = "cdefghijk";
        String result = getMaxString(str1,str2);
        System.out.println(result);
    }

    public static String getMaxString(String str1, String str2) {
        String max = (str1.length() > str2.length() ? str1 : str2);
        String min = (max.equals(str1) ? str2 : str1);
        for (int i = 0; i < min.length()-1; i++) {
            for (int start = 0, end = min.length() - i;end !=min.length()+1 ; start++, end++) {
                System.out.println("start="+start + " end="+end);
                String common = min.substring(start, end);
                if(max.contains(common))
                      return common;
            }
        }
        return null;
    }
}
