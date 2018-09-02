package com.abin.lee.algorithm.nowcoder;

/**
 * Created by abin on 2018/7/19.
 */
public class StrToInt {

    public int StrToInt(String str) {
        if(str.equals("") || str == null)
            return 0;
        int index = 0 ;
        int symbol = 1;
        String one = str.substring(0, 1);
        if(one.equals("-")){
            index = 1;
            symbol = -1;
        }
        if(one.equals("+")){
            index = 1;
        }
        int result = 0;
        for (;index<str.length();index++){
            if(str.charAt(index)<'0' || str.charAt(index) > '9')
                return 0;
            int temp = str.charAt(index) - '0';
            result = result*10 + temp;
        }
        return result*symbol;
    }

    public int StrToInt2(String str)
    {
        if (str.equals("") || str.length() == 0)
            return 0;
        char[] a = str.toCharArray();
        int fuhao = 0;
        if (a[0] == '-')
            fuhao = 1;
        int sum = 0;
        for (int i = fuhao; i < a.length; i++)
        {
            if (a[i] == '+')
                continue;
            if (a[i] < 48 || a[i] > 57)
                return 0;
            sum = sum * 10 + a[i] - 48;
        }
        return fuhao == 0 ? sum : sum * -1;
    }

    public static void main(String[] args) {
        String param = "-123";
        int result = new StrToInt().StrToInt(param);
        System.out.println("result="+result);
    }



}
