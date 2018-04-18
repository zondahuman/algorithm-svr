package com.qunar.des.algorithm.basic.string.common;

import com.google.common.primitives.Ints;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by abin on 2017/12/8 2017/12/8.
 * algorithm-svr
 * com.qunar.des.algorithm.basic.string.common
 */
public class StringToInteger {

    public static void main(String[] args) {
        String param = "-10234";
        Integer result = atoi(param);
        System.out.println("result="+result);
        Integer result1 = transferToInt(param);
        System.out.println("result1="+result1);

        Integer result2 = Integer.parseInt(param);
        System.out.println("result2="+result2);
        Integer result3 = Ints.tryParse(param);
        System.out.println("result3="+result3);
    }

    public static Integer transferToInt(String param){
        if(StringUtils.isBlank(param))
            return 0;
        param = param.trim();
        if(param.length() == 0)
            return 0;
        int sign = 1;
        int index = 0;
        if (param.charAt(index) == '+'){
            index++;
        }else if(param.charAt(index) == '-'){
            sign = -1;
            index++;
        }
        int num = 0;
        for(;index<param.length();index++){
            if(param.charAt(index)<'0' || param.charAt(index)>'9')
                break;
            num = num*10 + (param.charAt(index) - '0');
            if(num >Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
        }
        if(num*sign > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if(num*sign <Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return sign*num;
    }



















    public static int atoi(String str) {
        if(str==null){
            return 0;
        }
        str = str.trim();
        if(str.length()==0){
            return 0;
        }

        int sign = 1; //正负
        int index = 0;
        if(str.charAt(index)=='+'){
            index++;
        }else if(str.charAt(index)=='-'){
            sign = -1;
            index++;
        }

        long num = 0;
        for( ; index<str.length(); index++){
            if(str.charAt(index)<'0' || str.charAt(index)>'9'){
                break;
            }
            num = num*10 + (str.charAt(index)-'0');
            if(num>Integer.MAX_VALUE){
                break;
            }
        }

        if(num*sign >= Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        if(num*sign <= Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }

        return (int)num*sign;
    }
}
